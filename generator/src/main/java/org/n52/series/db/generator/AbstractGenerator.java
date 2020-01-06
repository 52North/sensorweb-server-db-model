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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.n52.hibernate.spatial.dialect.TimestampWithTimeZoneGeoDBDialectNoComments;
import org.n52.hibernate.spatial.dialect.TimestampWithTimeZonePostgisPG95DialectNoComments;
import org.n52.hibernate.spatial.dialect.TimestampWithTimeZoneSqlServer2008SpatialDialectNoComments;
import org.n52.hibernate.spatial.dialect.h2geodb.TimestampWithTimeZoneGeoDBDialect;
import org.n52.hibernate.spatial.dialect.postgis.TimestampWithTimeZonePostgisPG95Dialect;
import org.n52.hibernate.spatial.dialect.sqlserver.TimestampWithTimeZoneSqlServer2008SpatialDialect;

public abstract class AbstractGenerator {

    protected Dialect getDialect(DialectSelector selection, boolean comments) throws Exception {
        switch (selection) {
        case POSTGIS:
            return comments ? new TimestampWithTimeZonePostgisPG95Dialect()
                    : new TimestampWithTimeZonePostgisPG95DialectNoComments();
        case ORACLE:
            // try {
            // return comments ? new TimestampWithTimeZoneOracleSpatial10gDialect() : new TimestampWithTimeZoneOracleSpatial10gDialectNoComments();
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
            return comments ? new TimestampWithTimeZoneGeoDBDialect()
                    : new TimestampWithTimeZoneGeoDBDialectNoComments();
        case MY_SQL_SPATIAL_5:
            return comments ? new TimestampWithTimeZoneSqlServer2008SpatialDialect()
                    : new TimestampWithTimeZoneSqlServer2008SpatialDialectNoComments();
        case SQL_SERVER_2008:
            return comments ? new TimestampWithTimeZoneSqlServer2008SpatialDialect()
                    : new TimestampWithTimeZoneSqlServer2008SpatialDialectNoComments();
        default:
            throw new Exception("The entered value is invalid: " + selection);
        }
    }

    protected void setDirectoriesForModelSelection(Concept concept, Profile profile, Configuration configuration,
            MetadataSources metadataSources) throws Exception {
        List<File> files = new LinkedList<>();
        for (File file : files) {
            if (configuration != null) {
                configuration.addDirectory(file);
            }
            if (metadataSources != null) {
                metadataSources.addDirectory(file);
            }
        }
        addConceptDirectories(concept, profile, configuration, metadataSources);
    }

    protected void addConceptDirectories(Concept concept, Profile profile, Configuration configuration, MetadataSources metadataSources)
            throws Exception {
        List<String> paths = new LinkedList<>();
        switch (concept) {
        case SIMPLE:
            paths.addAll(getProfileDirectories("/hbm/simple", profile));
            break;
        case E_REPORTING:
            paths.addAll(getProfileDirectories("/hbm/ereporting", Profile.DEFAULT));
            break;
        case TRANSACTIONAL:
            paths.addAll(getProfileDirectories("/hbm/transactional", profile));
            break;
        case PROXY:
            paths.addAll(getProfileDirectories("/hbm/proxy", profile));
            break;
        default:
            throw new Exception("The entered value is invalid: " + concept);
        }
        for (String path : paths) {
            if (configuration != null) {
                configuration.addDirectory(getDirectory(path));
            }
            if (metadataSources != null) {
                metadataSources.addDirectory(getDirectory(path));
            }
        }
    }

    protected Collection<String> getProfileDirectories(String p, Profile profile) {
        List<String> paths = new LinkedList<>();
        paths.add(p + "/core");
        switch (profile) {
        case DEFAULT:
            paths.add(p + "/dataset");
            break;
        case SAMPLING:
            paths.add(p + "/sampling");
            break;
        default:
            break;
        }
        return paths;
    }

    protected static File getDirectory(String path) throws URISyntaxException {
        return new File(AbstractGenerator.class.getResource(path).toURI());
    }

    public static void printToScreen(String lineToPrint) {
        System.out.println(lineToPrint);
    }

    protected int readSelectionFromStdIo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
        String selection = br.readLine();
        return (selection != null && !selection.isEmpty())
                ? Integer.parseInt(selection)
                : 0;
    }

    protected int readSelectionFromStdIoWithDefault(int defaultValue) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
        String selection = br.readLine();
        return (selection != null && !selection.isEmpty())
                ? Integer.parseInt(selection)
                : defaultValue;
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
        SIMPLE,
        TRANSACTIONAL,
        E_REPORTING,
        PROXY;

        @Override
        public String toString() {
            return name().replaceAll("_", "-")
                         .toLowerCase();
        }
    }

    enum Profile {
        DEFAULT,
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
