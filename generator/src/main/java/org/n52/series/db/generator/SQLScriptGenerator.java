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
import org.hibernate.cfg.AvailableSettings;
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
@SuppressWarnings("uncommentedmain")
public final class SQLScriptGenerator extends AbstractGenerator {

    private static final String PUBLIC = "public";

    private SQLScriptGenerator(boolean print) {
        super(print);
    }

    private int getSelection() throws IOException {
        printToScreen("Create a all or a single selected script:");
        printToScreen("0   Select script");
        printToScreen("1   all");
        printToScreen("");
        printEnterYourSelection();

        return readSelectionFromStdIo();
    }

    private String getSchema() throws IOException {
        printToScreen("For which schema should the database model be created?");
        printToScreen("No schema is also valid!");
        printToScreen("");
        printEnterYourSelection();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
        String selection = null;
        selection = br.readLine();
        return selection;
    }

    private String getSchema(int i) {
        switch (i) {
            case 1:
                return PUBLIC;
            case 2:
                return null;
            case 3:
                return "sos";
            case 4:
                return "dbo";
            case 5:
                return "oracle";
            default:
                return PUBLIC;
        }
    }

    private boolean getAddComments() throws IOException {
        printToScreen("Should comments be added to the script (default=true):");
        printToScreen("0   false");
        printToScreen("1   true");
        printToScreen("");
        printEnterYourSelection();

        return readSelectionFromStdIoWithDefault(1) == 1;
    }

    private void printFinished(String fileName) {
        printToSysout("Finished! Check for file: " + fileName + NEW_LINE);
    }

    private String createFileName(String ending, Enum... values) {
        return createFileName("sql/", ending, values);
    }

    private void execute(int dialectSelection, int profileSelection, int conceptSelection, int featureSelection,
            String schema, boolean comments, boolean consoleLog) throws Exception {
        Concept concept = Concept.values()[conceptSelection];
        Profile profile = Profile.values()[profileSelection];
        Feature feature = Feature.values()[featureSelection];
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        DialectSelector dialect = DialectSelector.values()[dialectSelection];
        System.out.println(String.format("EXECUTING sql generation for %s - %s - %s - %s!", dialect.name(),
                concept.name(), profile.name(), feature.name()));
        Dialect dia = getDialect(dialect, comments);
        Properties p = new Properties();
        p.put(AvailableSettings.DIALECT, dia.getClass().getName());
        String fileNameCreate = createFileName("_create.sql", dialect, concept, profile, feature);
        String fileNameDrop = createFileName("_drop.sql", dialect, concept, profile, feature);
        Files.deleteIfExists(Paths.get(fileNameCreate));
        Files.deleteIfExists(Paths.get(fileNameDrop));
        if (schema != null && !schema.isEmpty()) {
            p.put(AvailableSettings.DEFAULT_SCHEMA, schema);

        }
        if (dialect.equals(DialectSelector.POSTGIS) && (schema == null || schema.isEmpty())) {
            p.put(AvailableSettings.DEFAULT_SCHEMA, PUBLIC);
        }
        configuration.addProperties(p);
        setDirectoriesForModelSelection(concept, profile, feature, configuration, null);
        configuration.registerTypeOverride(SmallBooleanType.INSTANCE);

        configuration.buildSessionFactory();
        StandardServiceRegistry serviceRegistry =
                configuration.getStandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        setDirectoriesForModelSelection(concept, profile, feature, null, metadataSources);
        Metadata metadata = metadataSources.buildMetadata();

        // create script
        SchemaExport schemaExport = new SchemaExport();
        EnumSet<TargetType> targetTypes =
                consoleLog ? EnumSet.of(TargetType.SCRIPT, TargetType.STDOUT) : EnumSet.of(TargetType.SCRIPT);
        schemaExport.setDelimiter(";").setFormat(true).setOutputFile(fileNameCreate).setHaltOnError(false);
        schemaExport.execute(targetTypes, SchemaExport.Action.CREATE, metadata);
        printFinished(fileNameCreate);
        // create drop
        schemaExport.setOutputFile(fileNameDrop);
        schemaExport.execute(targetTypes, SchemaExport.Action.DROP, metadata);
        printFinished(fileNameDrop);
    }

    protected boolean execute(Integer selection) throws Exception {
        int select = selection != null ? selection : getSelection();
        if (select == 1) {
            String schema = PUBLIC;
            // dialectSelection
            for (int i = 0; i < 5; i++) {
                if (i != 1) {
                    schema = getSchema(i);
                    // modelSelection/profile
                    for (int j = 0; j < 3; j++) {
                        // concept
                        for (int k = 0; k < 4; k++) {
                            // feature
                            for (int l = 0; l < 2; l++) {
                                // execute(sqlScriptGenerator, i, j, k, l, schema);
                                execute(i, j, k, l, schema, true, false);
                            }
                        }
                    }
                }
            }
            return true;
        } else {
            boolean addComments = getAddComments();
            int dialectSelection = getDialectSelection();
            int concept = getConceptSelection();
            int feature = getFeatureConceptSelection();
            String schema = getSchema();
            int modelSelection = getModelSelection();
            execute(dialectSelection, modelSelection, concept, feature, schema, addComments, true);
            return true;
        }
    }

    protected static SQLScriptGenerator getInstance(boolean print) {
        return new SQLScriptGenerator(print);
    }

    public static void main(String[] args) {
        try {
            getInstance(true).execute(args != null && args.length == 1 ? Integer.parseInt(args[0]) : null);
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
