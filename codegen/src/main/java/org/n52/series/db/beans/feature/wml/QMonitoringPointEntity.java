
package org.n52.series.db.beans.feature.wml;

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
 * QMonitoringPointEntity is a Querydsl query type for MonitoringPointEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMonitoringPointEntity extends EntityPathBase<MonitoringPointEntity> {

    private static final long serialVersionUID = -1995475382L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMonitoringPointEntity monitoringPointEntity =
            new QMonitoringPointEntity("monitoringPointEntity");

    public final org.n52.series.db.beans.feature.QAbstractMonitoringFeature _super;

    //inherited
    public final SetPath<org.n52.series.db.beans.AbstractFeatureEntity< ? >, org.n52.series.db.beans.QAbstractFeatureEntity> children;

    public final org.n52.series.db.beans.feature.QMonitoringPointContent content;

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
    public final SetPath<org.n52.series.db.beans.parameter.Parameter< ? >, org.n52.series.db.beans.parameter.QParameter> parameters;

    //inherited
    public final SetPath<org.n52.series.db.beans.AbstractFeatureEntity< ? >, org.n52.series.db.beans.QAbstractFeatureEntity> parents;

    //inherited
    public final SetPath<org.n52.series.db.beans.i18n.I18nFeatureEntity, org.n52.series.db.beans.i18n.QI18nFeatureEntity> translations;

    //inherited
    public final StringPath url;

    //inherited
    public final StringPath xml;

    public QMonitoringPointEntity(String variable) {
        this(MonitoringPointEntity.class, forVariable(variable), INITS);
    }

    public QMonitoringPointEntity(Path< ? extends MonitoringPointEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMonitoringPointEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMonitoringPointEntity(PathMetadata metadata, PathInits inits) {
        this(MonitoringPointEntity.class, metadata, inits);
    }

    public QMonitoringPointEntity(Class< ? extends MonitoringPointEntity> type,
                                  PathMetadata metadata,
                                  PathInits inits) {
        super(type, metadata, inits);
        this._super = new org.n52.series.db.beans.feature.QAbstractMonitoringFeature(type, metadata, inits);
        this.children = _super.children;
        this.content = inits.isInitialized("content")
                ? new org.n52.series.db.beans.feature.QMonitoringPointContent(forProperty("content"))
                : null;
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
