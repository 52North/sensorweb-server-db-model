package org.n52.series.db.beans.sampling;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSamplingProfileDataEntity is a Querydsl query type for SamplingProfileDataEntity
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSamplingProfileDataEntity extends BeanPath<SamplingProfileDataEntity> {

    private static final long serialVersionUID = -1631609543L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSamplingProfileDataEntity samplingProfileDataEntity = new QSamplingProfileDataEntity("samplingProfileDataEntity");

    public final QDetectionLimitEntity detectionLimit;

    public final QSamplingEntity sampling;

    public QSamplingProfileDataEntity(String variable) {
        this(SamplingProfileDataEntity.class, forVariable(variable), INITS);
    }

    public QSamplingProfileDataEntity(Path<? extends SamplingProfileDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSamplingProfileDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSamplingProfileDataEntity(PathMetadata metadata, PathInits inits) {
        this(SamplingProfileDataEntity.class, metadata, inits);
    }

    public QSamplingProfileDataEntity(Class<? extends SamplingProfileDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.detectionLimit = inits.isInitialized("detectionLimit") ? new QDetectionLimitEntity(forProperty("detectionLimit")) : null;
        this.sampling = inits.isInitialized("sampling") ? new QSamplingEntity(forProperty("sampling"), inits.get("sampling")) : null;
    }

}

