package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDataEntity is a Querydsl query type for DataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDataEntity extends EntityPathBase<DataEntity<?>> {

    private static final long serialVersionUID = 381902430L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDataEntity dataEntity = new QDataEntity("dataEntity");

    public final QDescribableEntity _super = new QDescribableEntity(this);

    public final QDatasetEntity dataset;

    public final BooleanPath deleted = createBoolean("deleted");

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.ereporting.QEReportingProfileDataEntity ereportingProfile;

    public final QGeometryEntity geometryEntity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final QCodespaceEntity identifierCodespace;

    public final StringPath name = createString("name");

    public final QCodespaceEntity nameCodespace;

    public final SetPath<org.n52.series.db.beans.parameter.ParameterEntity<?>, org.n52.series.db.beans.parameter.QParameterEntity> parameters = this.<org.n52.series.db.beans.parameter.ParameterEntity<?>, org.n52.series.db.beans.parameter.QParameterEntity>createSet("parameters", org.n52.series.db.beans.parameter.ParameterEntity.class, org.n52.series.db.beans.parameter.QParameterEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> parent = createNumber("parent", Long.class);

    public final SetPath<RelatedDataEntity, QRelatedDataEntity> relatedObservations = this.<RelatedDataEntity, QRelatedDataEntity>createSet("relatedObservations", RelatedDataEntity.class, QRelatedDataEntity.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> resultTime = createDateTime("resultTime", java.util.Date.class);

    public final org.n52.series.db.beans.sampling.QSamplingProfileDataEntity samplingProfile;

    public final DateTimePath<java.util.Date> samplingTimeEnd = createDateTime("samplingTimeEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> samplingTimeStart = createDateTime("samplingTimeStart", java.util.Date.class);

    public final SetPath<org.n52.series.db.beans.i18n.I18nDataEntity, org.n52.series.db.beans.i18n.QI18nDataEntity> translations = this.<org.n52.series.db.beans.i18n.I18nDataEntity, org.n52.series.db.beans.i18n.QI18nDataEntity>createSet("translations", org.n52.series.db.beans.i18n.I18nDataEntity.class, org.n52.series.db.beans.i18n.QI18nDataEntity.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> validTimeEnd = createDateTime("validTimeEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> validTimeStart = createDateTime("validTimeStart", java.util.Date.class);

    public final StringPath valueDescription = createString("valueDescription");

    public final StringPath valueIdentifier = createString("valueIdentifier");

    public final StringPath valueName = createString("valueName");

    public final NumberPath<java.math.BigDecimal> verticalFrom = createNumber("verticalFrom", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> verticalTo = createNumber("verticalTo", java.math.BigDecimal.class);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QDataEntity(String variable) {
        this((Class) DataEntity.class, forVariable(variable), INITS);
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QDataEntity(Path<? extends DataEntity> path) {
        this((Class) path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QDataEntity(PathMetadata metadata, PathInits inits) {
        this((Class) DataEntity.class, metadata, inits);
    }

    public QDataEntity(Class<? extends DataEntity<?>> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dataset = inits.isInitialized("dataset") ? new QDatasetEntity(forProperty("dataset"), inits.get("dataset")) : null;
        this.ereportingProfile = inits.isInitialized("ereportingProfile") ? new org.n52.series.db.beans.ereporting.QEReportingProfileDataEntity(forProperty("ereportingProfile")) : null;
        this.geometryEntity = inits.isInitialized("geometryEntity") ? new QGeometryEntity(forProperty("geometryEntity")) : null;
        this.identifierCodespace = inits.isInitialized("identifierCodespace") ? new QCodespaceEntity(forProperty("identifierCodespace")) : null;
        this.nameCodespace = inits.isInitialized("nameCodespace") ? new QCodespaceEntity(forProperty("nameCodespace")) : null;
        this.samplingProfile = inits.isInitialized("samplingProfile") ? new org.n52.series.db.beans.sampling.QSamplingProfileDataEntity(forProperty("samplingProfile"), inits.get("samplingProfile")) : null;
    }

}

