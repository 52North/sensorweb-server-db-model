package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFeatureEntity is a Querydsl query type for FeatureEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFeatureEntity extends EntityPathBase<FeatureEntity> {

    private static final long serialVersionUID = 513915560L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFeatureEntity featureEntity = new QFeatureEntity("featureEntity");

    public final QAbstractFeatureEntity _super;

    //inherited
    public final SetPath<AbstractFeatureEntity<?>, QAbstractFeatureEntity> children;

    //inherited
    public final StringPath description;

    // inherited
    public final QGeometryEntity geometryEntity;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath identifier;

    //inherited
    public final StringPath name;

    //inherited
    public final SetPath<org.n52.series.db.beans.parameter.ParameterEntity<?>, org.n52.series.db.beans.parameter.QParameterEntity> parameters;

    //inherited
    public final SetPath<AbstractFeatureEntity<?>, QAbstractFeatureEntity> parents;

    //inherited
    public final SetPath<org.n52.series.db.beans.i18n.I18nFeatureEntity, org.n52.series.db.beans.i18n.QI18nFeatureEntity> translations;

    public QFeatureEntity(String variable) {
        this(FeatureEntity.class, forVariable(variable), INITS);
    }

    public QFeatureEntity(Path<? extends FeatureEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFeatureEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFeatureEntity(PathMetadata metadata, PathInits inits) {
        this(FeatureEntity.class, metadata, inits);
    }

    public QFeatureEntity(Class<? extends FeatureEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QAbstractFeatureEntity(type, metadata, inits);
        this.description = _super.description;
        this.geometryEntity = _super.geometryEntity;
        this.id = _super.id;
        this.identifier = _super.identifier;
        this.name = _super.name;
        this.translations = _super.translations;
    }

}

