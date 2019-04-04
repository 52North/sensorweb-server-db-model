/*
 * Copyright 2015-2019 52°North Initiative for Geospatial Open Source
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.Properties;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
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
public class SQLScriptGenerator extends AbstractGenerator{

    private SQLScriptGenerator() {

    }

    private int getSelection() throws IOException {
        printToScreen("Create a all or a single selected script:");
        printToScreen("0   Select script");
        printToScreen("1   all");
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

    private int getModelSelection() throws IOException {
        printToScreen("Which database model should be created:");
        printToScreen("0 default");
        printToScreen("1 sampling");
        printToScreen("");
        printToScreen("Enter your selection: ");

        return readSelectionFromStdIo();
    }

    private int getConceptSelection() throws IOException {
        printToScreen("Which observation concept should be created:");
        printToScreen("0   simple");
        printToScreen("1   transactional");
        printToScreen("2   ereporting");
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

    public static void main(String[] args) {
        try {
            SQLScriptGenerator sqlScriptGenerator = new SQLScriptGenerator();
            int select = sqlScriptGenerator.getSelection();
            if (select == 1) {
                String schema = "public";
                // dialectSelection
                for (int i = 0; i < 5; i++) {
                    schema = sqlScriptGenerator.getSchema(i);
                    // modelSelection/profile
                    for (int j = 0; j < 2; j++) {
                        // concept
                        for (int k = 0; k < 4; k++) {
                            try {
                                // execute(sqlScriptGenerator, i, j, k, schema);
                                sqlScriptGenerator.execute(sqlScriptGenerator, i, j, k, schema, true);
                            } catch (Exception e) {
                                printToScreen("ERROR: " + e.getMessage());
                                e.printStackTrace();
                                System.exit(1);
                            }
                        }
                    }
                }
            } else {
                try {
                    boolean addComments = sqlScriptGenerator.getAddComments();
                    int dialectSelection = sqlScriptGenerator.getDialectSelection();
                    int concept = sqlScriptGenerator.getConceptSelection();
                    String schema = sqlScriptGenerator.getSchema();
                    int modelSelection = sqlScriptGenerator.getModelSelection();
                    sqlScriptGenerator.execute(sqlScriptGenerator, dialectSelection, modelSelection, concept, schema, addComments);
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

    private boolean getAddComments() throws IOException {
        printToScreen("Should comments be added to the script (default=true):");
        printToScreen("0   false");
        printToScreen("1   true");
        printToScreen("");
        printToScreen("Enter your selection: ");

        return readSelectionFromStdIoWithDefault(1) == 1 ? true : false;
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
                                int profileSelection,
                                int conceptSelection,
                                String schema,
                                boolean comments)
            throws Exception {
        Concept concept = Concept.values()[conceptSelection];
        Profile profile = Profile.values()[profileSelection];
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        DialectSelector dialect = DialectSelector.values()[dialectSelection];
        Dialect dia = sqlScriptGenerator.getDialect(dialect, comments);
        Properties p = new Properties();
        p.put("hibernate.dialect", dia.getClass().getName());
        String fileNameCreate = "target/" + dialect + "_" + concept + "_" + profile + "_create.sql";
        String fileNameDrop = "target/" + dialect + "_" + concept + "_" + profile + "_drop.sql";
        Files.deleteIfExists(Paths.get(fileNameCreate));
        Files.deleteIfExists(Paths.get(fileNameDrop));
        if (schema != null && !schema.isEmpty()) {
            p.put("hibernate.default_schema", schema);
        }
        configuration.addProperties(p);
        sqlScriptGenerator.setDirectoriesForModelSelection(concept, profile, configuration, null);
        configuration.registerTypeOverride(SmallBooleanType.INSTANCE);

        configuration.buildSessionFactory();
        StandardServiceRegistry serviceRegistry =
                configuration.getStandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        sqlScriptGenerator.setDirectoriesForModelSelection(concept, profile, null, metadataSources);
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
