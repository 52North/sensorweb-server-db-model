package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSamplingGeometryEntity is a Querydsl query type for SamplingGeometryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSamplingGeometryEntity extends EntityPathBase<SamplingGeometryEntity> {

    private static final long serialVersionUID = 1781676909L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSamplingGeometryEntity samplingGeometryEntity = new QSamplingGeometryEntity("samplingGeometryEntity");

    public final QIdEntity _super = new QIdEntity(this);

    public final SimplePath<org.n52.series.db.beans.dataset.Dataset> dataset = createSimple("dataset", org.n52.series.db.beans.dataset.Dataset.class);

    public final QGeometryEntity geometryEntity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> timestamp = createDateTime("timestamp", java.util.Date.class);

    public QSamplingGeometryEntity(String variable) {
        this(SamplingGeometryEntity.class, forVariable(variable), INITS);
    }

    public QSamplingGeometryEntity(Path<? extends SamplingGeometryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSamplingGeometryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSamplingGeometryEntity(PathMetadata metadata, PathInits inits) {
        this(SamplingGeometryEntity.class, metadata, inits);
    }

    public QSamplingGeometryEntity(Class<? extends SamplingGeometryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.geometryEntity = inits.isInitialized("geometryEntity") ? new QGeometryEntity(forProperty("geometryEntity")) : null;
    }

}

