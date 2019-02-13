package org.n52.series.db.beans.sampling;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMeasuringProgramEntity is a Querydsl query type for MeasuringProgramEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMeasuringProgramEntity extends EntityPathBase<MeasuringProgramEntity> {

    private static final long serialVersionUID = 1919682882L;

    public static final QMeasuringProgramEntity measuringProgramEntity = new QMeasuringProgramEntity("measuringProgramEntity");

    public final org.n52.series.db.beans.QDescribableEntity _super = new org.n52.series.db.beans.QDescribableEntity(this);

    public final SetPath<org.n52.series.db.beans.DatasetEntity, org.n52.series.db.beans.QDatasetEntity> datasets = this.<org.n52.series.db.beans.DatasetEntity, org.n52.series.db.beans.QDatasetEntity>createSet("datasets", org.n52.series.db.beans.DatasetEntity.class, org.n52.series.db.beans.QDatasetEntity.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final DateTimePath<java.util.Date> measuringTimeEnd = createDateTime("measuringTimeEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> measuringTimeStart = createDateTime("measuringTimeStart", java.util.Date.class);

    public final StringPath name = createString("name");

    public final StringPath producer = createString("producer");

    public final SetPath<SamplingEntity, QSamplingEntity> samplings = this.<SamplingEntity, QSamplingEntity>createSet("samplings", SamplingEntity.class, QSamplingEntity.class, PathInits.DIRECT2);

    public final SetPath<org.n52.series.db.beans.i18n.I18nMeasuringProgramEntity, org.n52.series.db.beans.i18n.QI18nMeasuringProgramEntity> translations = this.<org.n52.series.db.beans.i18n.I18nMeasuringProgramEntity, org.n52.series.db.beans.i18n.QI18nMeasuringProgramEntity>createSet("translations", org.n52.series.db.beans.i18n.I18nMeasuringProgramEntity.class, org.n52.series.db.beans.i18n.QI18nMeasuringProgramEntity.class, PathInits.DIRECT2);

    public QMeasuringProgramEntity(String variable) {
        super(MeasuringProgramEntity.class, forVariable(variable));
    }

    public QMeasuringProgramEntity(Path<? extends MeasuringProgramEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMeasuringProgramEntity(PathMetadata metadata) {
        super(MeasuringProgramEntity.class, metadata);
    }

}

