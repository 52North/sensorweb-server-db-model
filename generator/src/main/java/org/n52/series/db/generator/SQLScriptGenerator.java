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
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.hibernate.spatial.dialect.h2geodb.GeoDBDialect;
import org.hibernate.spatial.dialect.mysql.MySQL56SpatialDialect;
import org.hibernate.spatial.dialect.postgis.PostgisPG95Dialect;
import org.hibernate.spatial.dialect.sqlserver.SqlServer2008SpatialDialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
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

    private Dialect getDialect(DialectSelector selection) throws Exception {
        switch (selection) {
        case POSTGIS:
            return new PostgisPG95Dialect();
        case ORACLE:
            // try {
            //   return new OracleSpatial10gDialect();
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
            return new GeoDBDialect();
        case MY_SQL_SPATIAL_5:
            return new MySQL56SpatialDialect();
        case SQL_SERVER_2008:
            return new SqlServer2008SpatialDialect();
        default:
            throw new Exception("The entered value is invalid: " + selection);
        }
    }

    private void setDirectoriesForModelSelection(Concept concept, Configuration configuration,
            MetadataSources metadataSources) throws Exception {
        List<File> files = new LinkedList<>();
//        files.add(getDirectory("/hbm/core/Codespace.hbm.xml"));
//        files.add(getDirectory("/hbm/core/ProcedureDescriptionFormat.hbm.xml"));
//        files.add(getDirectory("/hbm/core/ProcedureResource.hbm.xml"));
//        files.add(getDirectory("/hbm/core/ProcedureHistory.hbm.xml"));
         files.add(getDirectory("/hbm/core"));
         files.add(getDirectory("/hbm/dataset"));
         files.add(getDirectory("/hbm/sta"));
//         files.add(getDirectory("/hbm/feature"));
//         files.add(getDirectory("/hbm/extension"));
        for (File file : files) {
            if (configuration != null) {
//                configuration.addFile(file);
                configuration.addDirectory(file);
            }
            if (metadataSources != null) {
//                metadataSources.addFile(file);
                metadataSources.addDirectory(file);
            }
        }
        addConceptDirectories(concept, configuration, metadataSources);
    }

    enum Concept {
        DEFAULT,
        E_REPORTING;

        @Override
        public String toString() {
            return name().replaceAll("_", "-")
                         .toLowerCase();
        }
    }

    private void addConceptDirectories(Concept concept, Configuration configuration, MetadataSources metadataSources)
            throws Exception {
        switch (concept) {
        case DEFAULT:
            break;
        case E_REPORTING:

            if (configuration != null) {
                configuration.addDirectory(getDirectory("/hbm/sos/ereporting"));
            }
            if (metadataSources != null) {
                metadataSources.addDirectory(getDirectory("/hbm/sos/ereporting"));
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
                    schema = getSchema(i);
                    // modelSelection
                    // for (int j = 1; j < 4; j++) {
                    // concept
                    for (int k = 0; k < 2; k++) {
                        try {
                            // execute(sqlScriptGenerator, i, j, k, schema);
                            execute(sqlScriptGenerator, i, -1, k, schema);
                        } catch (Exception e) {
                            printToScreen("ERROR: " + e.getMessage());
                            e.printStackTrace();
                            System.exit(1);
                        }
                    }
                    // }
                }
            } else {
                try {
                    int dialectSelection = sqlScriptGenerator.getDialectSelection();
                    // int modelSelection = sqlScriptGenerator.getModelSelection();
                    int modelSelection = -1;
                    int concept = sqlScriptGenerator.getConceptSelection();
                    String schema = sqlScriptGenerator.getSchema();
                    execute(sqlScriptGenerator, dialectSelection, modelSelection, concept, schema);
                } catch (IOException ioe) {
                    printToScreen("ERROR: IO error trying to read your input!");
                    System.exit(1);
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

    private static String getSchema(int i) {
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

    private static void execute(SQLScriptGenerator sqlScriptGenerator,
                                int dialectSelection,
                                int modelSelection,
                                int conceptSelection,
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
    }

}
