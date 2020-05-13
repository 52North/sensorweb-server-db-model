/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
 * Software GmbH
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

/**
 * Class to generate the create and drop scripts for different databases.
 * Currently supported spatial databases to create scripts
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

    private int getDialectSelection() throws IOException {
        printToScreen("This table metadata generator supports:");
        printToScreen("0   PostgreSQL/PostGIS");
        printToScreen("1   Oracle");
        printToScreen("2   H2/GeoDB");
        printToScreen("3   MySQL");
        printToScreen("4   SQL Server");
        printToScreen("");
        printEnterYourSelection();

        return readSelectionFromStdIo();
    }

    private int getModelSelection() throws IOException {
        printToScreen("Which database model should be used:");
        printToScreen("0 default");
        printToScreen("1 sampling");
        printToScreen("");
        printEnterYourSelection();

        return readSelectionFromStdIo();
    }

    private int getConceptSelection() throws IOException {
        printToScreen("Which observation concept should be used:");
        printToScreen("0   simple");
        printToScreen("1   transactional");
        printToScreen("2   ereporting");
        printToScreen("");
        printEnterYourSelection();

        return readSelectionFromStdIo();
    }

    private String createFileName(Enum... values) {
        return createFileName("metadata/TableMetadata_", ".md", values);
    }

    private void exportTableColumnMetadata(Metadata metadata, Dialect dia, DialectSelector dialect, Concept concept,
            Profile profile) throws IOException {
        Path path = Paths.get(createFileName(dialect, concept, profile));
        Files.deleteIfExists(path);
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

    private void processJoins(Iterator<Join> ji, SortedMap<String, TableMetadata> map, Dialect dia, Metadata metadata) {
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

    private void execute(int dialectSelection, int profileSelection, int conceptSelection) throws Exception {
        Concept concept = Concept.values()[conceptSelection];
        Profile profile = Profile.values()[profileSelection];
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        DialectSelector dialect = DialectSelector.values()[dialectSelection];
        Dialect dia = getDialect(dialect, true);
        Properties p = new Properties();
        p.put("hibernate.dialect", dia.getClass().getName());
        configuration.addProperties(p);
        setDirectoriesForModelSelection(concept, profile, configuration, null);
        configuration.registerTypeOverride(SmallBooleanType.INSTANCE);

        configuration.buildSessionFactory();
        StandardServiceRegistry serviceRegistry = configuration.getStandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        setDirectoriesForModelSelection(concept, profile, null, metadataSources);
        Metadata metadata = metadataSources.buildMetadata();

        exportTableColumnMetadata(metadata, dia, dialect, concept, profile);
    }

    protected boolean execute(Integer selection) throws Exception {
        int select = selection != null ? selection : getSelection();
        if (select == 1) {
            // dialectSelection
            for (int i = 0; i < 5; i++) {
                // modelSelection/profile
                for (int j = 0; j < 2; j++) {
                    // concept
                    for (int k = 0; k < 4; k++) {
                        // execute(sqlScriptGenerator, i, j, k, schema);
                        execute(i, j, k);
                    }
                }
            }
            return true;
        } else {
            int dialectSelection = getDialectSelection();
            int concept = getConceptSelection();
            int modelSelection = getModelSelection();
            execute(dialectSelection, modelSelection, concept);
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

    // public static void main(String[] args) {
    // try {
    // TableMetadataGenerator tableMetadataGenerator = new TableMetadataGenerator();
    // int select = tableMetadataGenerator.getSelection();
    // if (select == 1) {
    // // dialectSelection
    // for (int i = 0; i < 5; i++) {
    // // modelSelection/profile
    // for (int j = 0; j < 2; j++) {
    // // concept
    // for (int k = 0; k < 4; k++) {
    // // execute(sqlScriptGenerator, i, j, k, schema);
    // tableMetadataGenerator.execute(tableMetadataGenerator, i, j, k);
    // }
    // }
    // }
    // } else {
    // int dialectSelection = tableMetadataGenerator.getDialectSelection();
    // int concept = tableMetadataGenerator.getConceptSelection();
    // int modelSelection = tableMetadataGenerator.getModelSelection();
    // tableMetadataGenerator.execute(tableMetadataGenerator, dialectSelection,
    // modelSelection, concept);
    // }
    //
    // } catch (IOException ioe) {
    // printToScreen("ERROR: IO error trying to read your input!");
    // System.exit(1);
    // } catch (Exception e) {
    // printToScreen("ERROR: " + e.getMessage());
    // e.printStackTrace();
    // System.exit(1);
    // }
    // }

}
