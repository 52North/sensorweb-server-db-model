package org.n52.series.db.beans.feature;

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
 * QAbstractMonitoringFeature is a Querydsl query type for AbstractMonitoringFeature
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractMonitoringFeature extends EntityPathBase<AbstractMonitoringFeature> {

    private static final long serialVersionUID = 1486478147L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAbstractMonitoringFeature abstractMonitoringFeature = new QAbstractMonitoringFeature("abstractMonitoringFeature");

    public final org.n52.series.db.beans.QFeatureEntity _super;

    //inherited
    public final SetPath<org.n52.series.db.beans.AbstractFeatureEntity<?>, org.n52.series.db.beans.QAbstractFeatureEntity> children;

    //inherited
    public final StringPath description;

    // inherited
    public final org.n52.series.db.beans.QFormatEntity featureType;

    // inherited
    public final org.n52.series.db.beans.QGeometryEntity geometryEntity;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath identifier;

    // inherited
    public final org.n52.series.db.beans.QCodespaceEntity identifierCodespace;

    //inherited
    public final StringPath name;

    // inherited
    public final org.n52.series.db.beans.QCodespaceEntity nameCodespace;

    //inherited
    public final SetPath<org.n52.series.db.beans.parameter.Parameter<?>, org.n52.series.db.beans.parameter.QParameter> parameters;

    //inherited
    public final SetPath<org.n52.series.db.beans.AbstractFeatureEntity<?>, org.n52.series.db.beans.QAbstractFeatureEntity> parents;

    //inherited
    public final SetPath<org.n52.series.db.beans.i18n.I18nFeatureEntity, org.n52.series.db.beans.i18n.QI18nFeatureEntity> translations;

    //inherited
    public final StringPath url;

    //inherited
    public final StringPath xml;

    public QAbstractMonitoringFeature(String variable) {
        this(AbstractMonitoringFeature.class, forVariable(variable), INITS);
    }

    public QAbstractMonitoringFeature(Path<? extends AbstractMonitoringFeature> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAbstractMonitoringFeature(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAbstractMonitoringFeature(PathMetadata metadata, PathInits inits) {
        this(AbstractMonitoringFeature.class, metadata, inits);
    }

    public QAbstractMonitoringFeature(Class<? extends AbstractMonitoringFeature> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new org.n52.series.db.beans.QFeatureEntity(type, metadata, inits);
        this.children = _super.children;
        this.description = _super.description;
        this.featureType = _super.featureType;
        this.geometryEntity = _super.geometryEntity;
        this.id = _super.id;
        this.identifier = _super.identifier;
        this.identifierCodespace = _super.identifierCodespace;
        this.name = _super.name;
        this.nameCodespace = _super.nameCodespace;
        this.parameters = _super.parameters;
        this.parents = _super.parents;
        this.translations = _super.translations;
        this.url = _super.url;
        this.xml = _super.xml;
    }

}

