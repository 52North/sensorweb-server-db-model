/*
 * Copyright 2015-2018 52°North Initiative for Geospatial Open Source
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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
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
import org.hibernate.spatial.dialect.h2geodb.GeoDBDialect;
import org.hibernate.spatial.dialect.mysql.MySQL56SpatialDialect;
import org.hibernate.spatial.dialect.postgis.PostgisPG95Dialect;
import org.hibernate.spatial.dialect.sqlserver.SqlServer2008SpatialDialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.n52.hibernate.spatial.dialect.h2geodb.TimestampWithTimeZoneGeoDBDialect;
import org.n52.hibernate.spatial.dialect.oracle.TimestampWithTimeZoneOracleSpatial10gDialect;
import org.n52.hibernate.spatial.dialect.postgis.TimestampWithTimeZonePostgisPG95Dialect;
import org.n52.hibernate.spatial.dialect.sqlserver.TimestampWithTimeZoneSqlServer2008SpatialDialect;
import org.n52.hibernate.type.SmallBooleanType;

//import hibernate.spatial.dialect.oracle.OracleSpatial10gDoubleFloatDialect;

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
public class SQLScriptGenerator {

    private SQLScriptGenerator() {

    }

    private Dialect getDialect(DialectSelector selection) throws Exception {
        switch (selection) {
        case POSTGIS:
            return new TimestampWithTimeZonePostgisPG95Dialect();
        case ORACLE:
            // try {
            //   return new TimestampWithTimeZoneOracleSpatial10gDialect();
            // } catch (ExceptionInInitializerError eiie) {
            // printToScreen("The Oracle JDBC driver is missing!");
            // printToScreen("To execute the SQL script generator for Oracle you have to uncomment the
            // dependency in the pom.xml.");
            // printToScreen("If the Oracle JDBC driver is not installed in your local Maven repository, ");
            // printToScreen("follow the first steps describes here: ");
            // printToScreen("https://wiki.52north.org/bin/view/SensorWeb/SensorObservationServiceIVDocumentation#Oracle_support.");
            // throw new MissingDriverException();
            // }

        case GEODB:
            return new TimestampWithTimeZoneGeoDBDialect();
        case MY_SQL_SPATIAL_5:
            return new MySQL56SpatialDialect();
        case SQL_SERVER_2008:
            return new TimestampWithTimeZoneSqlServer2008SpatialDialect();
        default:
            throw new Exception("The entered value is invalid: " + selection);
        }
    }

    private void setDirectoriesForModelSelection(Concept concept, Configuration configuration,
            MetadataSources metadataSources) throws Exception {
        List<File> files = new LinkedList<>();
         files.add(getDirectory("/hbm/core"));
//         files.add(getDirectory("/hbm/feature"));
//         files.add(getDirectory("/hbm/extension"));
        for (File file : files) {
            if (configuration != null) {
                configuration.addDirectory(file);
            }
            if (metadataSources != null) {
                metadataSources.addDirectory(file);
            }
        }
        addConceptDirectories(concept, configuration, metadataSources);
    }

    private void addConceptDirectories(Concept concept, Configuration configuration, MetadataSources metadataSources)
            throws Exception {
        switch (concept) {
        case DEFAULT:
            if (configuration != null) {
                configuration.addDirectory(getDirectory("/hbm/dataset"));
            }
            if (metadataSources != null) {
                metadataSources.addDirectory(getDirectory("/hbm/dataset"));
            }
            break;
        case E_REPORTING:
            if (configuration != null) {
                configuration.addDirectory(getDirectory("/hbm/ereporting"));
            }
            if (metadataSources != null) {
                metadataSources.addDirectory(getDirectory("/hbm/ereporting"));
            }
            break;
        case SAMPLING:
            if (configuration != null) {
                configuration.addDirectory(getDirectory("/hbm/sampling"));
            }
            if (metadataSources != null) {
                metadataSources.addDirectory(getDirectory("/hbm/sampling"));
            }
            break;
        default:
            throw new Exception("The entered value is invalid: " + concept);
        }
    }

    private static File getDirectory(String path) throws URISyntaxException {
        return new File(SQLScriptGenerator.class.getResource(path)
                                                .toURI());
    }

    private int getSelection() throws IOException {
        printToScreen("Create a all or a single selected script:");
        printToScreen("1   all");
        printToScreen("2   Select script");
        printToScreen("3   table documentation (core, pg)");
        printToScreen("");
        printToScreen("Enter your selection: ");

        return readSelectionFromStdIo();
    }

    private int getDialectSelection() throws IOException {
        printToScreen("This SQL script generator supports:");
        printToScreen("0   PostgreSQL/PostGIS");
        printToScreen("1   Oracle");
        printToScreen("2   H2/GeoDB");
        printToScreen("3   MySQL");
        printToScreen("4   SQL Server");
        printToScreen("");
        printToScreen("Enter your selection: ");

        return readSelectionFromStdIo();
    }

    private int readSelectionFromStdIo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
        String selection = br.readLine();
        return (selection != null && !selection.isEmpty())
                ? Integer.parseInt(selection)
                : -1;
    }

    // private int getModelSelection() throws IOException {
    // printToScreen("Which database model should be created:");
    // printToScreen("1 Core");
    // printToScreen("2 Transcational");
    // printToScreen("3 All");
    // printToScreen("");
    // printToScreen("Enter your selection: ");
    //
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    // String selection = null;
    // selection = br.readLine();
    // return Integer.parseInt(selection);
    // }

    private int getConceptSelection() throws IOException {
        printToScreen("Which observation concept should be created:");
        printToScreen("0   series");
        printToScreen("1   ereporting");
        printToScreen("2   sampling");
        printToScreen("");
        printToScreen("Enter your selection: ");

        return readSelectionFromStdIo();
    }

    private int getGenerationType() throws IOException {
        printToScreen("Which information should be created:");
        printToScreen("0   sql script");
        printToScreen("1   table documentation");
        printToScreen("");
        printToScreen("Enter your selection: ");

        return readSelectionFromStdIo();
    }

    private String getSchema() throws IOException {
        printToScreen("For which schema should the database model be created?");
        printToScreen("No schema is also valid!");
        printToScreen("");
        printToScreen("Enter your selection: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
        String selection = null;
        selection = br.readLine();
        return selection;
    }

    public static void printToScreen(String lineToPrint) {
        System.out.println(lineToPrint);
    }

    private Set<String> checkSchema(Dialect dia, String[] create) {
        String hexStringToCheck = new StringBuilder("FK").append(Integer.toHexString("observationHasOffering".hashCode())
                                                                        .toUpperCase())
                                                         .toString();
        boolean duplicate = false;
        List<String> checkedSchema = new LinkedList<>();
        for (String string : create) {
            if (string.contains(hexStringToCheck)) {
                if (!duplicate) {
                    checkedSchema.add(string);
                    duplicate = true;
                }
            } else {
                checkedSchema.add(string);
            }
        }
        return new LinkedHashSet<>(checkedSchema);
    }

    public static void main(String[] args) {
        try {
            SQLScriptGenerator sqlScriptGenerator = new SQLScriptGenerator();
            int select = sqlScriptGenerator.getSelection();
            if (select == 1) {
                String schema = "public";
                // dialectSelection
                for (int i = 0; i < 5; i++) {
                    schema = sqlScriptGenerator.getSchema(i);
                    // modelSelection
                    // for (int j = 1; j < 4; j++) {
                    // concept
                    for (int k = 0; k < 2; k++) {
                        try {
                            // execute(sqlScriptGenerator, i, j, k, schema);
                            sqlScriptGenerator.execute(sqlScriptGenerator, i, -1, k, 0, schema);
                        } catch (Exception e) {
                            printToScreen("ERROR: " + e.getMessage());
                            e.printStackTrace();
                            System.exit(1);
                        }
                    }
                    // }
                }
            } else if (select == 2) {
                try {
                    int dialectSelection = sqlScriptGenerator.getDialectSelection();
                    // int modelSelection = sqlScriptGenerator.getModelSelection();
                    int modelSelection = -1;
                    int concept = sqlScriptGenerator.getConceptSelection();
                    String schema = sqlScriptGenerator.getSchema();
                    int generationType = sqlScriptGenerator.getGenerationType();
                    sqlScriptGenerator.execute(sqlScriptGenerator, dialectSelection, modelSelection, concept, generationType, schema);
                } catch (IOException ioe) {
                    printToScreen("ERROR: IO error trying to read your input!");
                    System.exit(1);
                } catch (Exception e) {
                    printToScreen("ERROR: " + e.getMessage());
                    e.printStackTrace();
                    System.exit(1);
                }
            } else {
                try {
                    sqlScriptGenerator.execute(sqlScriptGenerator, 0, -1, 0, 1, "");
                } catch (Exception e) {
                    printToScreen("ERROR: " + e.getMessage());
                    e.printStackTrace();
                    System.exit(1);
                }
            }

        } catch (IOException ioe) {
            printToScreen("ERROR: IO error trying to read your input!");
            System.exit(1);
        }
    }

    private String getSchema(int i) {
        switch (i) {
        case 1:
            return "public";
        case 2:
            return "oracle";
        case 3:
            return null;
        case 4:
            return "sos";
        case 5:
            return "dbo";
        default:
            return null;
        }
    }

    private void execute(SQLScriptGenerator sqlScriptGenerator,
                                int dialectSelection,
                                int modelSelection,
                                int conceptSelection,
                                int generationType,
                                String schema)
            throws Exception {
            Concept concept = Concept.values()[conceptSelection];
            Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
            DialectSelector dialect = DialectSelector.values()[dialectSelection];
            Dialect dia = sqlScriptGenerator.getDialect(dialect);
            Properties p = new Properties();
            p.put("hibernate.dialect", dia.getClass().getName());
            String fileNameCreate = "target/" + dialect + "_" + concept + "_create.sql";
            String fileNameDrop = "target/" + dialect + "_" + concept + "_drop.sql";
            Files.deleteIfExists(Paths.get(fileNameCreate));
            Files.deleteIfExists(Paths.get(fileNameDrop));
            if (schema != null && !schema.isEmpty()) {
                p.put("hibernate.default_schema", schema);
            }
            configuration.addProperties(p);
            sqlScriptGenerator.setDirectoriesForModelSelection(concept, configuration, null);
            configuration.registerTypeOverride(SmallBooleanType.INSTANCE);

            configuration.buildSessionFactory();
            StandardServiceRegistry serviceRegistry = configuration.getStandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            sqlScriptGenerator.setDirectoriesForModelSelection(concept, null, metadataSources);
            Metadata metadata = metadataSources.buildMetadata();

            if (generationType == 0) {
              // create script
              SchemaExport schemaExport = new SchemaExport();
              EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.SCRIPT, TargetType.STDOUT);
              schemaExport.setDelimiter(";").setFormat(true).setOutputFile(fileNameCreate).setHaltOnError(false);
              schemaExport.execute(targetTypes, SchemaExport.Action.CREATE, metadata);
              printToScreen("Finished! Check for file: " + fileNameCreate + "\n");
              // create drop
              schemaExport.setOutputFile(fileNameDrop);
              schemaExport.execute(targetTypes, SchemaExport.Action.DROP, metadata);
              printToScreen("Finished! Check for file: " + fileNameDrop + "\n");
            } else {
                sqlScriptGenerator.exportTableColumnMetadata(metadata, dia);
            }

    }

    private void exportTableColumnMetadata(Metadata metadata, Dialect dia) throws IOException {
        Path path = Paths.get("target/TableMetadata.md");
        Files.deleteIfExists(path);
        SortedMap<String, TableMetadata> map = extractTableMetadata(metadata, dia);
        List<String> result = new LinkedList<>();
        result.add("# Database table/column description");
        result.add("This page describes the tables and columns in the database.");
        result.add("The *SQL type* column in the tables is generated for Hibernate dialect: *" + dia.getClass().getSimpleName() + "*");
        result.add("");
        result.add("## Tables");
        map.keySet().forEach(k -> result.add("- [" + k + "](#" + k + ")"));
        result.add("");
        result.addAll(map.values().stream().map(v -> v.toMarkdown()).collect(Collectors.toList()));
        result.add("");
        result.add("*Creation date: " +  DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss ZZ").print(DateTime.now()) + "*");
        System.out.println("The generated file was written to: " + Files.write(path,result).toAbsolutePath());
    }

    private SortedMap<String, TableMetadata> extractTableMetadata(Metadata metadata, Dialect dia) {
        SortedMap<String, TableMetadata> map = new TreeMap<>();
        for (PersistentClass entity : metadata.getEntityBindings()) {
            Table table = entity.getTable();
            TableMetadata tm = processTable(table, map, dia, metadata);
            processJoins((Iterator<Join>) entity.getJoinClosureIterator(), map, dia, metadata);
            // from Property
            Iterator<Property> propertyIterator = entity.getPropertyIterator();
            while (propertyIterator.hasNext()) {
                Property property = (Property) propertyIterator.next();
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

    private void processCollection(org.hibernate.mapping.Collection collection, SortedMap<String, TableMetadata> map, Dialect dia, Metadata metadata) {
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

    private TableMetadata processTable(Table table, SortedMap<String, TableMetadata> map, Dialect dia, Metadata metadata) {
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

    enum DialectSelector {
        POSTGIS,
        ORACLE,
        GEODB,
        MY_SQL_SPATIAL_5,
        SQL_SERVER_2008;

        @Override
        public String toString() {
            return name().replaceAll("_", "-")
                         .toLowerCase();
        }
    }

    enum Concept {
        DEFAULT,
        E_REPORTING,
        SAMPLING;

        @Override
        public String toString() {
            return name().replaceAll("_", "-")
                         .toLowerCase();
        }
    }

    public interface Meta {

        default String check(String origin, String current) {
            return (origin != null && !origin.isEmpty()) ? origin : (current != null && !current.isEmpty()) ? current : null;
        }

    }

    public static class TableMetadata implements Meta {
        private final String name;
        private final String comment;
        private Map<String, ColumnMetadata> columns = new LinkedHashMap<>();

        public TableMetadata(String name, String comment) {
            this.name = name;
            this.comment = comment;
        }

        public String getName() {
            return name;
        }

        public String getComment() {
            return comment;
        }

        public Map<String, ColumnMetadata> getColumns() {
            return columns;
        }

        public void setColumns(Map<String, ColumnMetadata> columns) {
            this.columns = columns;
        }

        public String toMarkdown() {
            StringBuilder builder = new StringBuilder();
            builder.append("### ").append(getName()).append("\n");
            builder.append("**Description**: ").append(checkForNullOrEmpty(getComment())).append("\n");
            builder.append("\n");
            builder.append("| column | comment | NOT-NULL | default | SQL type | Java type |").append("\n");
            builder.append("| --- | --- | --- | --- | --- | --- |").append("\n");
            for (ColumnMetadata cm : columns.values()) {
                builder.append("| ").append(cm.getName()).append(" | ");
                builder.append(checkForNullOrEmpty(cm.getComment())).append(" | ");
                builder.append(cm.getNotNull()).append(" | ");
                builder.append(checkForNullOrEmpty(cm.getDefaultValue())).append(" | ");
                builder.append(cm.getSqlType()).append(" | ");
                builder.append(cm.getType()).append(" | ").append("\n");
            }
            builder.append("\n[top](#Tables)\n");
            return builder.toString();
        }

        private String checkForNullOrEmpty(String value) {
            return value != null && !value.isEmpty() ? value : "-";
        }

    }

    public static class ColumnMetadata implements Meta {
        private final String name;
        private String comment;
        private String sqlType;
        private String type;
        private String defaultValue;
        private String notNull;

        public ColumnMetadata(String name) {
           this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = check(this.comment, comment);
        }

        public String getSqlType() {
            return sqlType;
        }

        public void setSqlType(String sqlType) {
            this.sqlType = check(this.sqlType, sqlType);
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = check(this.type, type);
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(String defaultValue) {
            this.defaultValue = check(this.defaultValue, defaultValue);
        }

        public String getNotNull() {
            return notNull;
        }

        public void setNotNull(String notNull) {
            this.notNull = check(this.notNull, notNull);
        }

    }
}
