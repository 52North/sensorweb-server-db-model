package org.n52.series.db.beans.sta;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHistoricalLocationEntity is a Querydsl query type for HistoricalLocationEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHistoricalLocationEntity extends EntityPathBase<HistoricalLocationEntity> {

    private static final long serialVersionUID = 1353571169L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHistoricalLocationEntity historicalLocationEntity = new QHistoricalLocationEntity("historicalLocationEntity");

    public final QAbstractStaEntity _super = new QAbstractStaEntity(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLocationEntity locationEntity;

    public final DateTimePath<java.util.Date> time = createDateTime("time", java.util.Date.class);

    public QHistoricalLocationEntity(String variable) {
        this(HistoricalLocationEntity.class, forVariable(variable), INITS);
    }

    public QHistoricalLocationEntity(Path<? extends HistoricalLocationEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHistoricalLocationEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHistoricalLocationEntity(PathMetadata metadata, PathInits inits) {
        this(HistoricalLocationEntity.class, metadata, inits);
    }

    public QHistoricalLocationEntity(Class<? extends HistoricalLocationEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.locationEntity = inits.isInitialized("locationEntity") ? new QLocationEntity(forProperty("locationEntity"), inits.get("locationEntity")) : null;
    }

}

