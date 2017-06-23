/*
 * Copyright 2015-2017 52°North Initiative for Geospatial Open Source
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.hibernate.spatial.dialect.h2geodb.GeoDBDialect;
import org.hibernate.spatial.dialect.mysql.MySQLSpatial5InnoDBDialect;
import org.hibernate.spatial.dialect.postgis.PostgisDialect;
import org.hibernate.spatial.dialect.sqlserver.SqlServer2008SpatialDialect;

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

    private Dialect getDialect(int selection) throws Exception {
        switch (selection) {
        case 1:
            return new PostgisDialect();
        case 2:
            // try {
            // return new OracleSpatial10gDoubleFloatDialect();
            // } catch (ExceptionInInitializerError eiie) {
            // printToScreen("The Oracle JDBC driver is missing!");
            // printToScreen("To execute the SQL script generator for Oracle you have to uncomment the
            // dependency in the pom.xml.");
            // printToScreen("If the Oracle JDBC driver is not installed in your local Maven repository, ");
            // printToScreen("follow the first steps describes here: ");
            // printToScreen("https://wiki.52north.org/bin/view/SensorWeb/SensorObservationServiceIVDocumentation#Oracle_support.");
            // throw new MissingDriverException();
            // }

        case 3:
            return new GeoDBDialect();
        case 4:
            return new MySQLSpatial5InnoDBDialect();
        case 5:
            return new SqlServer2008SpatialDialect();
        default:
            throw new Exception("The entered value is invalid!");
        }
    }

    private void setDirectoriesForModelSelection(int selection, int concept, Configuration configuration)
            throws Exception {
        // switch (selection) {
        // case 1:
        // configuration.addDirectory(new
        // File(SQLScriptGenerator.class.getResource("/hbm/sos/core").toURI()));
        // configuration.addDirectory(new File(SQLScriptGenerator.class.getResource("/hbm/sos/fea").toURI()));
        // break;
        // case 2:
        // configuration.addDirectory(new
        // File(SQLScriptGenerator.class.getResource("/hbm/sos/core").toURI()));
        // configuration
        // .addDirectory(new File(SQLScriptGenerator.class.getResource("/hbm/sos/transactional").toURI()));
        // configuration.addDirectory(new
        // File(SQLScriptGenerator.class.getResource("/hbm/sos/parameter").toURI()));
        // break;
        // case 3:
        configuration.addDirectory(getDirectory("/hbm/sos/core"));
        configuration.addDirectory(getDirectory("/hbm/sos/feature"));
        // break;
        // default:
        // throw new Exception("The entered value is invalid!");
        // }
        addConceptDirectories(concept, configuration);
    }

    private void addConceptDirectories(int concept, Configuration configuration) throws Exception {
        switch (concept) {
        case 1:
            break;
        case 2:
            configuration.addDirectory(getDirectory("/hbm/sos/ereporting"));
            break;
        default:
            throw new Exception("The entered value is invalid!");
        }
    }

    private File getDirectory(String path) throws URISyntaxException {
        return new File(SQLScriptGenerator.class.getResource(path).toURI());
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
        printToScreen("1   PostgreSQL/PostGIS");
        printToScreen("2   Oracle");
        printToScreen("3   H2/GeoDB");
        printToScreen("4   MySQL");
        printToScreen("5   SQL Server");
        printToScreen("");
        printToScreen("Enter your selection: ");

        return readSelectionFromStdIo();
    }

    private int readSelectionFromStdIo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
        String selection = br.readLine();
        return selection != null
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
        printToScreen("1   series");
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
                for (int i = 1; i < 6; i++) {
                    schema = getSchema(i);
                    // modelSelection
                    for (int j = 1; j < 4; j++) {
                        // concept
                        for (int k = 1; k < 4; k++) {
                            try {
                                execute(sqlScriptGenerator, i, j, k, schema);
                            } catch (MissingDriverException mde) {
                                System.exit(1);
                            } catch (Exception e) {
                                printToScreen("ERROR: " + e.getMessage());
                                System.exit(1);
                            }
                        }
                    }
                }
            } else {
                try {
                    int dialectSelection = sqlScriptGenerator.getDialectSelection();
                    // int modelSelection = sqlScriptGenerator.getModelSelection();
                    int modelSelection = 0;
                    int concept = sqlScriptGenerator.getConceptSelection();
                    String schema = sqlScriptGenerator.getSchema();
                    execute(sqlScriptGenerator, dialectSelection, modelSelection, concept, schema);
                } catch (IOException ioe) {
                    printToScreen("ERROR: IO error trying to read your input!");
                    System.exit(1);
                } catch (MissingDriverException mde) {
                    System.exit(1);
                } catch (Exception e) {
                    printToScreen("ERROR: " + e.getMessage());
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
                                int concept,
                                String schema)
            throws Exception {
        Writer writer = null;
        try {
            Configuration configuration = new CustomConfiguration().configure("/hibernate.cfg.xml");
            Dialect dia = sqlScriptGenerator.getDialect(dialectSelection);
            String fileName = "target/" + dialectSelection + "_" + modelSelection + "_" + concept + ".sql";
            writer = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("UTF-8"));
            if (schema != null && !schema.isEmpty()) {
                Properties p = new Properties();
                p.put("hibernate.default_schema", schema);
                configuration.addProperties(p);
            }
            sqlScriptGenerator.setDirectoriesForModelSelection(modelSelection, concept, configuration);
            // create script
            String[] create = configuration.generateSchemaCreationScript(dia);
            Set<String> checkedSchema = sqlScriptGenerator.checkSchema(dia, create);
            writeln("Scripts are created for: " + dia.toString(), writer);
            writeSection("Create-Script", checkedSchema, writer);

            // drop script
            String[] drop = configuration.generateDropSchemaScript(dia);
            Set<String> checkedDrop = sqlScriptGenerator.checkSchema(dia, drop);
            writeSection("Drop-Script", checkedDrop, writer);

            printToScreen("Finished! Check for file: " + fileName + "\n");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    private static void writeSection(String header, Set<String> entries, Writer writer) throws IOException {
        writeEmpty(writer);
        writeln("#######################################\n", writer);
        writeln("## \t" + header, writer);
        writeEmpty(writer);
        for (String e : entries) {
            writeln(e + ";", writer);
        }
    }

    private static void writeEmpty(Writer writer) throws IOException {
        writer.write("\n");
    }


    private static void writeln(String line, Writer writer) throws IOException {
        writer.write(line + "\n");
    }

    private static class MissingDriverException extends Exception {

        private static final long serialVersionUID = -5681526838468633998L;

        MissingDriverException() {
            super();
        }

    }
}
