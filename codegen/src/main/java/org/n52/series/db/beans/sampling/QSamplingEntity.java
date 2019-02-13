package org.n52.series.db.beans.sampling;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSamplingEntity is a Querydsl query type for SamplingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSamplingEntity extends EntityPathBase<SamplingEntity> {

    private static final long serialVersionUID = 1171863872L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSamplingEntity samplingEntity = new QSamplingEntity("samplingEntity");

    public final org.n52.series.db.beans.QDescribableEntity _super = new org.n52.series.db.beans.QDescribableEntity(this);

    public final SetPath<org.n52.series.db.beans.DatasetEntity, org.n52.series.db.beans.QDatasetEntity> datasets = this.<org.n52.series.db.beans.DatasetEntity, org.n52.series.db.beans.QDatasetEntity>createSet("datasets", org.n52.series.db.beans.DatasetEntity.class, org.n52.series.db.beans.QDatasetEntity.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final StringPath environmentalConditions = createString("environmentalConditions");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final QMeasuringProgramEntity measuringProgram;

    public final StringPath name = createString("name");

    public final SetPath<org.n52.series.db.beans.DataEntity<?>, org.n52.series.db.beans.QDataEntity> observations = this.<org.n52.series.db.beans.DataEntity<?>, org.n52.series.db.beans.QDataEntity>createSet("observations", org.n52.series.db.beans.DataEntity.class, org.n52.series.db.beans.QDataEntity.class, PathInits.DIRECT2);

    public final StringPath sampler = createString("sampler");

    public final StringPath samplingMethod = createString("samplingMethod");

    public final DateTimePath<java.util.Date> samplingTimeEnd = createDateTime("samplingTimeEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> samplingTimeStart = createDateTime("samplingTimeStart", java.util.Date.class);

    public final SetPath<org.n52.series.db.beans.i18n.I18nSamplingEntity, org.n52.series.db.beans.i18n.QI18nSamplingEntity> translations = this.<org.n52.series.db.beans.i18n.I18nSamplingEntity, org.n52.series.db.beans.i18n.QI18nSamplingEntity>createSet("translations", org.n52.series.db.beans.i18n.I18nSamplingEntity.class, org.n52.series.db.beans.i18n.QI18nSamplingEntity.class, PathInits.DIRECT2);

    public QSamplingEntity(String variable) {
        this(SamplingEntity.class, forVariable(variable), INITS);
    }

    public QSamplingEntity(Path<? extends SamplingEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSamplingEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSamplingEntity(PathMetadata metadata, PathInits inits) {
        this(SamplingEntity.class, metadata, inits);
    }

    public QSamplingEntity(Class<? extends SamplingEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.measuringProgram = inits.isInitialized("measuringProgram") ? new QMeasuringProgramEntity(forProperty("measuringProgram")) : null;
    }

}

