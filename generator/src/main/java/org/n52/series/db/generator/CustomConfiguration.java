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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.IdentifierGeneratorAggregator;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.internal.util.StringHelper;
import org.hibernate.internal.util.collections.ArrayHelper;
import org.hibernate.mapping.AuxiliaryDatabaseObject;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.ForeignKey;
import org.hibernate.mapping.IdentifierCollection;
import org.hibernate.mapping.Index;
import org.hibernate.mapping.KeyValue;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.RootClass;
import org.hibernate.mapping.Table;
import org.hibernate.mapping.UniqueKey;
import org.hibernate.tool.hbm2ddl.IndexMetadata;
import org.hibernate.tool.hbm2ddl.UniqueConstraintSchemaUpdateStrategy;

/**
 * @author <a href="mailto:c.autermann@52north.org">Christian Autermann</a>
 * @since 1.0.0
 */
public class CustomConfiguration extends Configuration {
    private static final long serialVersionUID = 149360549522727961L;

//    @Override
//    @SuppressWarnings({
//        "unchecked"
//    })
//    public String[] generateSchemaCreationScript(Dialect dialect) throws HibernateException {
//        secondPassCompile();
//
//        ArrayList<String> script = new ArrayList<String>(50);
//        String defaultCatalog = getProperties().getProperty(Environment.DEFAULT_CATALOG);
//        String defaultSchema = getProperties().getProperty(Environment.DEFAULT_SCHEMA);
//
//        Iterator<Table> iter = getTableMappings();
//        while (iter.hasNext()) {
//            Table table = iter.next();
//            if (table.isPhysicalTable()) {
//                script.add(table.sqlCreateString(dialect, mappingCC, defaultCatalog, defaultSchema));
//                Iterator<String> comments = table.sqlCommentStrings(dialect, defaultCatalog, defaultSchema);
//                while (comments.hasNext()) {
//                    script.add(comments.next());
//                }
//            }
//        }
//
//        iter = getTableMappings();
//        while (iter.hasNext()) {
//            Table table = iter.next();
//            if (table.isPhysicalTable()) {
//
//                Iterator<UniqueKey> subIterUK = table.getUniqueKeyIterator();
//                while (subIterUK.hasNext()) {
//                    UniqueKey uk = subIterUK.next();
//                    String constraintString = uk.sqlCreateString(dialect, mappingCC, defaultCatalog, defaultSchema);
//                    if (constraintString != null) {
//                        script.add(constraintString);
//                    }
//                }
//
//                Iterator<Index> subIterIdx = table.getIndexIterator();
//                while (subIterIdx.hasNext()) {
//                    Index index = subIterIdx.next();
//                    if (!checkIndexForGeometry(index, dialect)) {
//                        script.add(index.sqlCreateString(dialect, mappingCC, defaultCatalog, defaultSchema));
////                    } else {
//                        // if (dialect instanceof SpatialIndexDialect) {
//                        // script.add((((SpatialIndexDialect)dialect).buildSqlCreateSpatialIndexString(index,
//                        // defaultCatalog, defaultSchema)));
//                        // }
//                    }
//                }
//            }
//        }
//
//        // Foreign keys must be created *after* unique keys for numerous DBs.
//        // See HH-8390.
//        iter = getTableMappings();
//        while (iter.hasNext()) {
//            Table table = iter.next();
//            if (table.isPhysicalTable()) {
//
//                if (dialect.hasAlterTable()) {
//                    Iterator<ForeignKey> subIterFK = table.getForeignKeyIterator();
//                    while (subIterFK.hasNext()) {
//                        ForeignKey fk = subIterFK.next();
//                        if (fk.isPhysicalConstraint()) {
//                            script.add(fk.sqlCreateString(dialect, mappingCC, defaultCatalog, defaultSchema));
//                        }
//                    }
//                }
//
//            }
//        }
//
//        Iterator<IdentifierGenerator> iterG = iterateGenerators(dialect);
//        while (iterG.hasNext()) {
//            String[] lines = ((PersistentIdentifierGenerator) iterG.next()).sqlCreateStrings(dialect);
//            script.addAll(Arrays.asList(lines));
//        }
//
//        for (AuxiliaryDatabaseObject auxiliaryDatabaseObject : auxiliaryDatabaseObjects) {
//            if (auxiliaryDatabaseObject.appliesToDialect(dialect)) {
//                script.add(auxiliaryDatabaseObject.sqlCreateString(dialect, mappingCC, defaultCatalog, defaultSchema));
//            }
//        }
//
//        return ArrayHelper.toStringArray(script);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<SchemaUpdateScript> generateSchemaUpdateScriptList(Dialect dialect, DatabaseMetadata databaseMetadata)
//            throws HibernateException {
//        secondPassCompile();
//
//        String defaultCatalog = getProperties().getProperty(Environment.DEFAULT_CATALOG);
//        String defaultSchema = getProperties().getProperty(Environment.DEFAULT_SCHEMA);
//        UniqueConstraintSchemaUpdateStrategy constraintMethod = getContraintMethod();
//
//        List<SchemaUpdateScript> scripts = new ArrayList<SchemaUpdateScript>();
//
//        Iterator<Table> iter = getTableMappings();
//        while (iter.hasNext()) {
//            Table table = iter.next();
//            String tableSchema = (table.getSchema() == null)
//                    ? defaultSchema
//                    : table.getSchema();
//            String tableCatalog = (table.getCatalog() == null)
//                    ? defaultCatalog
//                    : table.getCatalog();
//            if (table.isPhysicalTable()) {
//
//                TableMetadata tableInfo = databaseMetadata.getTableMetadata(table.getName(),
//                                                                            tableSchema,
//                                                                            tableCatalog,
//                                                                            table.isQuoted());
//                if (tableInfo == null) {
//                    scripts.add(new SchemaUpdateScript(table.sqlCreateString(dialect,
//                                                                             mappingCC,
//                                                                             tableCatalog,
//                                                                             tableSchema),
//                                                       false));
//                } else {
//                    Iterator<String> subiter = table.sqlAlterStrings(dialect,
//                                                                     mappingCC,
//                                                                     tableInfo,
//                                                                     tableCatalog,
//                                                                     tableSchema);
//                    while (subiter.hasNext()) {
//                        scripts.add(new SchemaUpdateScript(subiter.next(), false));
//                    }
//                }
//
//                Iterator<String> comments = table.sqlCommentStrings(dialect, defaultCatalog, defaultSchema);
//                while (comments.hasNext()) {
//                    scripts.add(new SchemaUpdateScript(comments.next(), false));
//                }
//
//            }
//        }
//
//        iter = getTableMappings();
//        while (iter.hasNext()) {
//            Table table = iter.next();
//            String tableSchema = (table.getSchema() == null)
//                    ? defaultSchema
//                    : table.getSchema();
//            String tableCatalog = (table.getCatalog() == null)
//                    ? defaultCatalog
//                    : table.getCatalog();
//            if (table.isPhysicalTable()) {
//
//                TableMetadata tableInfo = databaseMetadata.getTableMetadata(table.getName(),
//                                                                            tableSchema,
//                                                                            tableCatalog,
//                                                                            table.isQuoted());
//
//                if (!constraintMethod.equals(UniqueConstraintSchemaUpdateStrategy.SKIP)) {
//                    Iterator<UniqueKey> uniqueIter = table.getUniqueKeyIterator();
//                    while (uniqueIter.hasNext()) {
//                        final UniqueKey uniqueKey = uniqueIter.next();
//                        // Skip if index already exists. Most of the time, this
//                        // won't work since most Dialects use Constraints.
//                        // However,
//                        // keep it for the few that do use Indexes.
//                        if (tableInfo != null && StringHelper.isNotEmpty(uniqueKey.getName())) {
//                            final IndexMetadata meta = tableInfo.getIndexMetadata(uniqueKey.getName());
//                            if (meta != null) {
//                                continue;
//                            }
//                        }
//                        String constraintString = uniqueKey.sqlCreateString(dialect,
//                                                                            mappingCC,
//                                                                            tableCatalog,
//                                                                            tableSchema);
//                        if (constraintString != null && !constraintString.isEmpty()) {
//                            if (constraintMethod.equals(UniqueConstraintSchemaUpdateStrategy.DROP_RECREATE_QUIETLY)) {
//                                String constraintDropString = uniqueKey.sqlDropString(dialect,
//                                                                                      tableCatalog,
//                                                                                      tableSchema);
//                                scripts.add(new SchemaUpdateScript(constraintDropString, true));
//                            }
//                        }
//                        scripts.add(new SchemaUpdateScript(constraintString, true));
//                    }
//                }
//
//                Iterator<Index> subIter = table.getIndexIterator();
//                while (subIter.hasNext()) {
//                    final Index index = subIter.next();
//                    // Skip if index already exists
//                    if (tableInfo != null && StringHelper.isNotEmpty(index.getName())) {
//                        final IndexMetadata meta = tableInfo.getIndexMetadata(index.getName());
//                        if (meta != null) {
//                            continue;
//                        }
//                    }
//                    if (!checkIndexForGeometry(index, dialect)) {
//                        scripts.add(new SchemaUpdateScript(index.sqlCreateString(dialect,
//                                                                                 mappingCC,
//                                                                                 tableCatalog,
//                                                                                 tableSchema),
//                                                           false));
////                    } else {
//                        // if (dialect instanceof SpatialIndexDialect) {
//                        // scripts.add(new SchemaUpdateScript(((SpatialIndexDialect) dialect)
//                        // .buildSqlCreateSpatialIndexString(index, tableCatalog, tableSchema),
//                        // false));
//                        // }
//
//                    }
//                }
//            }
//        }
//
//        // Foreign keys must be created *after* unique keys for numerous DBs.
//        // See HH-8390.
//        iter = getTableMappings();
//        while (iter.hasNext()) {
//            Table table = iter.next();
//            String tableSchema = (table.getSchema() == null)
//                    ? defaultSchema
//                    : table.getSchema();
//            String tableCatalog = (table.getCatalog() == null)
//                    ? defaultCatalog
//                    : table.getCatalog();
//            if (table.isPhysicalTable()) {
//
//                TableMetadata tableInfo = databaseMetadata.getTableMetadata(table.getName(),
//                                                                            tableSchema,
//                                                                            tableCatalog,
//                                                                            table.isQuoted());
//
//                if (dialect.hasAlterTable()) {
//                    Iterator<ForeignKey> subIter = table.getForeignKeyIterator();
//                    while (subIter.hasNext()) {
//                        ForeignKey fk = subIter.next();
//                        if (fk.isPhysicalConstraint()) {
//                            boolean create = tableInfo == null || (tableInfo.getForeignKeyMetadata(fk) == null && (
//                            // Icky workaround for MySQL bug:
//                            !(dialect instanceof MySQLDialect) || tableInfo.getIndexMetadata(fk.getName()) == null));
//                            if (create) {
//                                scripts.add(new SchemaUpdateScript(fk.sqlCreateString(dialect,
//                                                                                      mappingCC,
//                                                                                      tableCatalog,
//                                                                                      tableSchema),
//                                                                   false));
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        Iterator<IdentifierGenerator> iterG = iterateGenerators(dialect);
//        while (iterG.hasNext()) {
//            PersistentIdentifierGenerator generator = (PersistentIdentifierGenerator) iterG.next();
//            Object key = generator.generatorKey();
//            if (!databaseMetadata.isSequence(key) && !databaseMetadata.isTable(key)) {
//                String[] lines = generator.sqlCreateStrings(dialect);
//                scripts.addAll(SchemaUpdateScript.fromStringArray(lines, false));
//            }
//        }
//
//        return scripts;
//    }
//
//    private UniqueConstraintSchemaUpdateStrategy getContraintMethod() {
//        Object property = getProperties().get(Environment.UNIQUE_CONSTRAINT_SCHEMA_UPDATE_STRATEGY);
//        return UniqueConstraintSchemaUpdateStrategy.interpret(property);
//    }
//
//    private boolean checkIndexForGeometry(Index index, Dialect dialect) {
//        if (index.getColumnSpan() == 1) {
//            Iterator<Column> columnIterator = index.getColumnIterator();
//            while (columnIterator.hasNext()) {
//                Column column = columnIterator.next();
//                if (column.getSqlTypeCode(mappingCC) == 3000) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    /**
//     * Based on {@link org.hibernate.cfg.Configuration#generateDropSchemaScript(Dialect)} . Rewritten to only
//     * create drop commands for existing tables/sequences.
//     *
//     * @param d the dialect
//     * @param m the database metadata
//     * @return SQL script to drop schema as String array
//     * @throws HibernateException in case of database failure
//     */
//    public String[] generateDropSchemaScript(final Dialect d, final DatabaseMetadata m) throws HibernateException {
//        secondPassCompile();
//        final String c = getProperties().getProperty(Environment.DEFAULT_CATALOG);
//        final String s = getProperties().getProperty(Environment.DEFAULT_SCHEMA);
//        final List<String> script = new LinkedList<String>();
//        script.addAll(generateAuxiliaryDatabaseObjectDropScript(d, c, s));
//        if (d.dropConstraints()) {
//            script.addAll(generateConstraintDropScript(d, c, s, m));
//        }
//        script.addAll(generateTableDropScript(d, c, s, m));
//        script.addAll(generateIdentifierGeneratorDropScript(d, c, s, m));
//        return ArrayHelper.toStringArray(script);
//    }
//
//    /**
//     * Copied from {@link org.hibernate.cfg.Configuration#iterateGenerators(Dialect)}.
//     */
//    private Iterator<PersistentIdentifierGenerator> iterateGenerators(final Dialect d, final String c, final String s)
//            throws MappingException {
//        final TreeMap<Object, PersistentIdentifierGenerator> generators = new TreeMap<>();
//        for (final PersistentClass pc : classes.values()) {
//            if (!pc.isInherited()) {
//                KeyValue identifier = pc.getIdentifier();
//                final IdentifierGenerator ig = identifier.createIdentifierGenerator(getIdentifierGeneratorFactory(),
//                                                                                    d,
//                                                                                    c,
//                                                                                    s,
//                                                                                    (RootClass) pc);
//                if (ig instanceof PersistentIdentifierGenerator) {
//                    final PersistentIdentifierGenerator pig = (PersistentIdentifierGenerator) ig;
//                    generators.put(pig.generatorKey(), pig);
//                } else if (ig instanceof IdentifierGeneratorAggregator) {
//                    ((IdentifierGeneratorAggregator) ig).registerPersistentGenerators(generators);
//                }
//            }
//        }
//        for (final Collection collection : collections.values()) {
//            if (collection.isIdentified()) {
//                KeyValue identifier = ((IdentifierCollection) collection).getIdentifier();
//                final IdentifierGenerator ig = identifier.createIdentifierGenerator(getIdentifierGeneratorFactory(),
//                                                                                    d,
//                                                                                    c,
//                                                                                    s,
//                                                                                    null);
//                if (ig instanceof PersistentIdentifierGenerator) {
//                    final PersistentIdentifierGenerator pig = (PersistentIdentifierGenerator) ig;
//                    generators.put(pig.generatorKey(), pig);
//                }
//            }
//        }
//
//        return generators.values()
//                         .iterator();
//    }
//
//    protected List<String> generateConstraintDropScript(final Dialect d,
//                                                        final String c,
//                                                        final String s,
//                                                        final DatabaseMetadata m)
//            throws HibernateException {
//        final List<String> script = new LinkedList<String>();
//        final Iterator<Table> itr = getTableMappings();
//        while (itr.hasNext()) {
//            final Table table = itr.next();
//            // TODO remove because fails if table definition is quoted
//            // final String tableName = table.getQualifiedName(d, c, s);
//            if (checkTable(table, m)) {
//                @SuppressWarnings("unchecked")
//                final Iterator<ForeignKey> subItr = table.getForeignKeyIterator();
//                final TableMetadata tableMeta = m.getTableMetadata(table.getName(), s, c, table.isQuoted());
//                while (subItr.hasNext()) {
//                    final ForeignKey fk = subItr.next();
//                    if (fk.isPhysicalConstraint() && tableMeta.getForeignKeyMetadata(fk) != null) {
//                        script.add(fk.sqlDropString(d, c, s));
//                    }
//                }
//            }
//        }
//        return script;
//    }
//
//    protected List<String> generateTableDropScript(final Dialect d,
//                                                   final String c,
//                                                   final String s,
//                                                   final DatabaseMetadata m)
//            throws HibernateException {
//        final List<String> script = new LinkedList<String>();
//        final Iterator<Table> itr = getTableMappings();
//        while (itr.hasNext()) {
//            final Table table = itr.next();
//            // TODO remove because fails if table definition is quoted
//            // final String tableName = table.getQualifiedName(d, c, s);
//            if (checkTable(table, m)) {
//                script.add(table.sqlDropString(d, c, s));
//            }
//        }
//        return script;
//    }
//
//    protected boolean checkTable(Table table, DatabaseMetadata m) {
//        return table.isPhysicalTable() && m.isTable(table.getQuotedName());
//    }
//
//    protected List<String> generateAuxiliaryDatabaseObjectDropScript(final Dialect d, final String c, final String s) {
//        final List<String> script = new LinkedList<String>();
//        int auxSize = auxiliaryDatabaseObjects.size();
//        final ListIterator<AuxiliaryDatabaseObject> itr = auxiliaryDatabaseObjects.listIterator(auxSize);
//        while (itr.hasPrevious()) {
//            // FIXME how to check if ADO exists?
//            final AuxiliaryDatabaseObject object = itr.previous();
//            if (object.appliesToDialect(d)) {
//                script.add(object.sqlDropString(d, c, s));
//            }
//        }
//        return script;
//    }
//
//    protected List<String> generateIdentifierGeneratorDropScript(final Dialect d,
//                                                                 final String c,
//                                                                 final String s,
//                                                                 final DatabaseMetadata m)
//            throws MappingException, HibernateException {
//        final List<String> script = new LinkedList<String>();
//        final Iterator<PersistentIdentifierGenerator> itr = iterateGenerators(d, c, s);
//        while (itr.hasNext()) {
//            final PersistentIdentifierGenerator pig = itr.next();
//            if (pig instanceof SequenceGenerator) {
//                final SequenceGenerator sg = (SequenceGenerator) pig;
//                if (!m.isSequence(sg.getSequenceName())) {
//                    continue;
//                }
//            }
//            script.addAll(Arrays.asList(pig.sqlDropStrings(d)));
//        }
//        return script;
//    }
}
