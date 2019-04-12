package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDataArrayDataEntity is a Querydsl query type for DataArrayDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDataArrayDataEntity extends EntityPathBase<DataArrayDataEntity> {

    private static final long serialVersionUID = -1592988853L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDataArrayDataEntity dataArrayDataEntity = new QDataArrayDataEntity("dataArrayDataEntity");

    public final QCompositeDataEntity _super;

    // inherited
    public final QDatasetEntity dataset;

    //inherited
    public final BooleanPath deleted;

    //inherited
    public final StringPath description;

    public final StringPath encoding = createString("encoding");

    // inherited
    public final org.n52.series.db.beans.ereporting.QEReportingProfileDataEntity ereportingProfile;

    // inherited
    public final QGeometryEntity geometryEntity;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath identifier;

    // inherited
    public final QCodespaceEntity identifierCodespace;

    //inherited
    public final StringPath name;

    // inherited
    public final QCodespaceEntity nameCodespace;

    //inherited
    public final SetPath<org.n52.series.db.beans.parameter.ParameterEntity<?>, org.n52.series.db.beans.parameter.QParameterEntity> parameters;

    //inherited
    public final NumberPath<Long> parent;

    //inherited
    public final SetPath<RelatedDataEntity, QRelatedDataEntity> relatedObservations;

    //inherited
    public final DateTimePath<java.util.Date> resultTime;

    // inherited
    public final org.n52.series.db.beans.sampling.QSamplingProfileDataEntity samplingProfile;

    //inherited
    public final DateTimePath<java.util.Date> samplingTimeEnd;

    //inherited
    public final DateTimePath<java.util.Date> samplingTimeStart;

    public final StringPath structure = createString("structure");

    //inherited
    public final SetPath<org.n52.series.db.beans.i18n.I18nDataEntity, org.n52.series.db.beans.i18n.QI18nDataEntity> translations;

    //inherited
    public final DateTimePath<java.util.Date> validTimeEnd;

    //inherited
    public final DateTimePath<java.util.Date> validTimeStart;

    public final SetPath<DataEntity<?>, QDataEntity> value = this.<DataEntity<?>, QDataEntity>createSet("value", DataEntity.class, QDataEntity.class, PathInits.DIRECT2);

    //inherited
    public final StringPath valueDescription;

    //inherited
    public final StringPath valueIdentifier;

    //inherited
    public final StringPath valueName;

    //inherited
    public final NumberPath<java.math.BigDecimal> verticalFrom;

    //inherited
    public final NumberPath<java.math.BigDecimal> verticalTo;

    public QDataArrayDataEntity(String variable) {
        this(DataArrayDataEntity.class, forVariable(variable), INITS);
    }

    public QDataArrayDataEntity(Path<? extends DataArrayDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDataArrayDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDataArrayDataEntity(PathMetadata metadata, PathInits inits) {
        this(DataArrayDataEntity.class, metadata, inits);
    }

    public QDataArrayDataEntity(Class<? extends DataArrayDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QCompositeDataEntity(type, metadata, inits);
        this.dataset = _super.dataset;
        this.deleted = _super.deleted;
        this.description = _super.description;
        this.ereportingProfile = _super.ereportingProfile;
        this.geometryEntity = _super.geometryEntity;
        this.id = _super.id;
        this.identifier = _super.identifier;
        this.identifierCodespace = _super.identifierCodespace;
        this.name = _super.name;
        this.nameCodespace = _super.nameCodespace;
        this.parameters = _super.parameters;
        this.parent = _super.parent;
        this.relatedObservations = _super.relatedObservations;
        this.resultTime = _super.resultTime;
        this.samplingProfile = _super.samplingProfile;
        this.samplingTimeEnd = _super.samplingTimeEnd;
        this.samplingTimeStart = _super.samplingTimeStart;
        this.translations = _super.translations;
        this.validTimeEnd = _super.validTimeEnd;
        this.validTimeStart = _super.validTimeStart;
        this.valueDescription = _super.valueDescription;
        this.valueIdentifier = _super.valueIdentifier;
        this.valueName = _super.valueName;
        this.verticalFrom = _super.verticalFrom;
        this.verticalTo = _super.verticalTo;
    }

}

