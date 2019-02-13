package org.n52.series.db.beans.sampling;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSamplingProfileDatasetEntity is a Querydsl query type for SamplingProfileDatasetEntity
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSamplingProfileDatasetEntity extends BeanPath<SamplingProfileDatasetEntity> {

    private static final long serialVersionUID = 2079775215L;

    public static final QSamplingProfileDatasetEntity samplingProfileDatasetEntity = new QSamplingProfileDatasetEntity("samplingProfileDatasetEntity");

    public final SetPath<MeasuringProgramEntity, QMeasuringProgramEntity> measuringPrograms = this.<MeasuringProgramEntity, QMeasuringProgramEntity>createSet("measuringPrograms", MeasuringProgramEntity.class, QMeasuringProgramEntity.class, PathInits.DIRECT2);

    public final SetPath<SamplingEntity, QSamplingEntity> samplings = this.<SamplingEntity, QSamplingEntity>createSet("samplings", SamplingEntity.class, QSamplingEntity.class, PathInits.DIRECT2);

    public QSamplingProfileDatasetEntity(String variable) {
        super(SamplingProfileDatasetEntity.class, forVariable(variable));
    }

    public QSamplingProfileDatasetEntity(Path<? extends SamplingProfileDatasetEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSamplingProfileDatasetEntity(PathMetadata metadata) {
        super(SamplingProfileDatasetEntity.class, metadata);
    }

}

