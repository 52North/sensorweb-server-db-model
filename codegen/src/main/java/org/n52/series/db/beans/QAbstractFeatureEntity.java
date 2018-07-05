
package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.SetPath;
import com.querydsl.core.types.dsl.StringPath;

/**
 * QAbstractFeatureEntity is a Querydsl query type for AbstractFeatureEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAbstractFeatureEntity extends EntityPathBase<AbstractFeatureEntity< ? >> {

    private static final long serialVersionUID = 933372582L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAbstractFeatureEntity abstractFeatureEntity =
            new QAbstractFeatureEntity("abstractFeatureEntity");

    public final QHierarchicalEntity _super = new QHierarchicalEntity(this);

    public final SetPath<AbstractFeatureEntity< ? >, QAbstractFeatureEntity> children =
            this.<AbstractFeatureEntity< ? >, QAbstractFeatureEntity> createSet("children",
                                                                                AbstractFeatureEntity.class,
                                                                                QAbstractFeatureEntity.class,
                                                                                PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final QFormatEntity featureType;

    public final QGeometryEntity geometryEntity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final QCodespaceEntity identifierCodespace;

    public final StringPath name = createString("name");

    public final QCodespaceEntity nameCodespace;

    public final SetPath<org.n52.series.db.beans.parameter.Parameter< ? >, org.n52.series.db.beans.parameter.QParameter> parameters =
            this.<org.n52.series.db.beans.parameter.Parameter< ? >, org.n52.series.db.beans.parameter.QParameter> createSet("parameters",
                                                                                                                            org.n52.series.db.beans.parameter.Parameter.class,
                                                                                                                            org.n52.series.db.beans.parameter.QParameter.class,
                                                                                                                            PathInits.DIRECT2);

    public final SetPath<AbstractFeatureEntity< ? >, QAbstractFeatureEntity> parents =
            this.<AbstractFeatureEntity< ? >, QAbstractFeatureEntity> createSet("parents",
                                                                                AbstractFeatureEntity.class,
                                                                                QAbstractFeatureEntity.class,
                                                                                PathInits.DIRECT2);

    public final SetPath<org.n52.series.db.beans.i18n.I18nFeatureEntity, org.n52.series.db.beans.i18n.QI18nFeatureEntity> translations =
            this.<org.n52.series.db.beans.i18n.I18nFeatureEntity, org.n52.series.db.beans.i18n.QI18nFeatureEntity> createSet("translations",
                                                                                                                             org.n52.series.db.beans.i18n.I18nFeatureEntity.class,
                                                                                                                             org.n52.series.db.beans.i18n.QI18nFeatureEntity.class,
                                                                                                                             PathInits.DIRECT2);

    public final StringPath url = createString("url");

    public final StringPath xml = createString("xml");

    @SuppressWarnings({
        "all",
        "rawtypes",
        "unchecked"
    })
    public QAbstractFeatureEntity(String variable) {
        this((Class) AbstractFeatureEntity.class, forVariable(variable), INITS);
    }

    @SuppressWarnings({
        "all",
        "rawtypes",
        "unchecked"
    })
    public QAbstractFeatureEntity(Path< ? extends AbstractFeatureEntity> path) {
        this((Class) path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAbstractFeatureEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    @SuppressWarnings({
        "all",
        "rawtypes",
        "unchecked"
    })
    public QAbstractFeatureEntity(PathMetadata metadata, PathInits inits) {
        this((Class) AbstractFeatureEntity.class, metadata, inits);
    }

    public QAbstractFeatureEntity(Class< ? extends AbstractFeatureEntity< ? >> type,
                                  PathMetadata metadata,
                                  PathInits inits) {
        super(type, metadata, inits);
        this.featureType = inits.isInitialized("featureType")
                ? new QFormatEntity(forProperty("featureType"))
                : null;
        this.geometryEntity = inits.isInitialized("geometryEntity")
                ? new QGeometryEntity(forProperty("geometryEntity"))
                : null;
        this.identifierCodespace = inits.isInitialized("identifierCodespace")
                ? new QCodespaceEntity(forProperty("identifierCodespace"))
                : null;
        this.nameCodespace = inits.isInitialized("nameCodespace")
                ? new QCodespaceEntity(forProperty("nameCodespace"))
                : null;
    }

}
