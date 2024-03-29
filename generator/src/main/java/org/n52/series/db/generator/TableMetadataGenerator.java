/*
 * Copyright (C) 2015-2023 52°North Spatial Information Research GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.series.db.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Join;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.Table;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.n52.hibernate.type.SmallBooleanType;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Class to generate the create and drop scripts for different databases. Currently supported spatial
 * databases to create scripts
 * <ul>
 * <li>PostgreSQL/PostGIS</li>
 * <li>Oracle</li>
 * <li>MySQL</li>
 * <li>SQL Server</li>
 * <li>H2/GeoDB</li>
 * </ul>
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
@SuppressWarnings("uncommentedmain")
public final class TableMetadataGenerator extends AbstractGenerator {

    private TableMetadataGenerator() {
        super();
    }

    private int getSelection() throws IOException {
        printToScreen("Create a all or a single table metadata file:");
        printToScreen("0   Select table metadata");
        printToScreen("1   all");
        printToScreen("");
        printEnterYourSelection();

        return readSelectionFromStdIo();
    }

    private String createFileName(Enum... values) {
        return createFileName("metadata/TableMetadata_", ".md", values);
    }

    private void exportTableColumnMetadata(Metadata metadata, Dialect dia, DialectSelector dialect, Concept concept,
            Profile profile, Feature feature) throws IOException {
        Path path = createFile(Paths.get(createFileName(dialect, concept, profile, feature)));
        SortedMap<String, TableMetadata> map = extractTableMetadata(metadata, dia);
        List<String> result = new LinkedList<>();
        result.add("# Database table/column description");
        result.add("This page describes the tables and columns in the database.");
        result.add("The *SQL type* column in the tables is generated for Hibernate dialect: *"
                + dia.getClass().getSimpleName() + "*");
        result.add("");
        result.add("## Tables");
        map.keySet().forEach(k -> result.add("- [" + k + "](#" + k + ")"));
        result.add("");
        result.addAll(map.values().stream().map(v -> v.toMarkdown()).collect(Collectors.toList()));
        result.add("");
        result.add(
                "*Creation date: " + DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss ZZ").print(DateTime.now()) + "*");
        System.out.println("The generated file was written to: " + Files.write(path, result).toAbsolutePath());
    }

    @SuppressFBWarnings
    private Path createFile(Path path) throws IOException {
        Files.deleteIfExists(path);
        Files.createDirectories(path.getParent());
        return Files.createFile(path);
    }

    private SortedMap<String, TableMetadata> extractTableMetadata(Metadata metadata, Dialect dia) {
        SortedMap<String, TableMetadata> map = new TreeMap<>();
        for (PersistentClass entity : metadata.getEntityBindings()) {
            Table table = entity.getTable();
            TableMetadata tm = processTable(table, map, dia, metadata);
            processJoins(entity.getJoinClosureIterator(), map, dia, metadata);
            // from Property
            Iterator<Property> propertyIterator = entity.getPropertyIterator();
            while (propertyIterator.hasNext()) {
                Property property = propertyIterator.next();
                if (property.getValue() instanceof org.hibernate.mapping.Collection) {
                    processCollection((org.hibernate.mapping.Collection) property.getValue(), map, dia, metadata);
                }
                processColumns(property.getColumnIterator(), tm.getColumns(), dia, metadata);
            }
            // from Identifier
            processColumns(entity.getIdentifier().getColumnIterator(), tm.getColumns(), dia, metadata);
        }
        return map;

    }

    private void processJoins(Iterator<Join> ji, SortedMap<String, TableMetadata> map, Dialect dia,
            Metadata metadata) {
        if (ji != null) {
            while (ji.hasNext()) {
                processTable(ji.next().getTable(), map, dia, metadata);
            }
        }
    }

    private void processCollection(org.hibernate.mapping.Collection collection, SortedMap<String, TableMetadata> map,
            Dialect dia, Metadata metadata) {
        Table table = collection.getCollectionTable();
        if (table != null) {
            if (!map.containsKey(table.getName())) {
                map.put(table.getName(), new TableMetadata(table.getName(), table.getComment()));
            }
            TableMetadata tm = map.get(table.getName());
            Map<String, ColumnMetadata> columns = tm.getColumns();
            // from Table
            processColumns(table.getColumnIterator(), columns, dia, metadata);
        }
    }

    private TableMetadata processTable(Table table, SortedMap<String, TableMetadata> map, Dialect dia,
            Metadata metadata) {
        if (!map.containsKey(table.getName())) {
            map.put(table.getName(), new TableMetadata(table.getName(), table.getComment()));
        }
        TableMetadata tm = map.get(table.getName());
        Map<String, ColumnMetadata> columns = tm.getColumns();
        // from Table
        processColumns(table.getColumnIterator(), columns, dia, metadata);
        return tm;
    }

    private void processColumns(Iterator<?> ci, Map<String, ColumnMetadata> columns, Dialect dia, Metadata metadata) {
        while (ci.hasNext()) {
            Object n = ci.next();
            if (n instanceof Column) {
                Column next = (Column) n;
                if (!columns.containsKey(next.getName())) {
                    columns.put(next.getName(), new ColumnMetadata(next.getName()));
                }
                ColumnMetadata cm = columns.get(next.getName());
                cm.setComment(next.getComment());
                cm.setSqlType(next.getSqlType(dia, metadata));
                cm.setType(next.getValue().getType().getName());
                cm.setDefaultValue(next.getDefaultValue());
                cm.setNotNull(Boolean.toString(!next.isNullable()));
            }
        }
    }

    private void execute(int dialectSelection, int profileSelection, int conceptSelection, int featureSelection)
            throws Exception {
        Concept concept = Concept.values()[conceptSelection];
        Profile profile = Profile.values()[profileSelection];
        Feature feature = Feature.values()[featureSelection];
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        DialectSelector dialect = DialectSelector.values()[dialectSelection];
        Dialect dia = getDialect(dialect, true);
        Properties p = new Properties();
        p.put("hibernate.dialect", dia.getClass().getName());
        configuration.addProperties(p);
        setDirectoriesForModelSelection(concept, profile, feature, configuration, null);
        configuration.registerTypeOverride(SmallBooleanType.INSTANCE);

        configuration.buildSessionFactory();
        StandardServiceRegistry serviceRegistry =
                configuration.getStandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        setDirectoriesForModelSelection(concept, profile, feature, null, metadataSources);
        Metadata metadata = metadataSources.buildMetadata();

        exportTableColumnMetadata(metadata, dia, dialect, concept, profile, feature);
    }

    protected boolean execute(Integer selection) throws Exception {
        int select = selection != null ? selection : getSelection();
        if (select == 1) {
            // dialectSelection
            for (int i = 0; i < 4; i++) {
                // modelSelection/profile
                for (int j = 0; j < 2; j++) {
                    // concept
                    for (int k = 0; k < 4; k++) {
                        // feature
                        for (int l = 0; l < 2; l++) {
                            // execute(i, j, k, l);
                            execute(i, j, k, l);
                        }

                    }
                }
            }
            return true;
        } else {
            int dialectSelection = getDialectSelection();
            int concept = getConceptSelection();
            int modelSelection = getModelSelection();
            int feature = getFeatureConceptSelection();
            execute(dialectSelection, modelSelection, concept, feature);
            return true;
        }
    }

    protected static TableMetadataGenerator getInstance() {
        return new TableMetadataGenerator();
    }

    public static void main(String[] args) {
        try {
            getInstance().execute(args != null && args.length == 1 ? Integer.parseInt(args[0]) : null);
        } catch (IOException ioe) {
            printToScreen("ERROR: IO error trying to read your input!");
            ioe.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            printToScreen("ERROR: Could not generate for unknown reasons!");
            e.printStackTrace();
            System.exit(1);
        }

    }

}
