package org.n52.series.db.beans.sta;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocationEntity is a Querydsl query type for LocationEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocationEntity extends EntityPathBase<LocationEntity> {

    private static final long serialVersionUID = -1821491529L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocationEntity locationEntity = new QLocationEntity("locationEntity");

    public final QAbstractStaEntity _super = new QAbstractStaEntity(this);

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.QGeometryEntity geometryEntity;

    public final SetPath<HistoricalLocationEntity, QHistoricalLocationEntity> historicalLocationEntities = this.<HistoricalLocationEntity, QHistoricalLocationEntity>createSet("historicalLocationEntities", HistoricalLocationEntity.class, QHistoricalLocationEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath location = createString("location");

    public final QLocationEncodingEntity locationEncoding;

    public final StringPath name = createString("name");

    public final SetPath<ThingEntity, QThingEntity> thingEntities = this.<ThingEntity, QThingEntity>createSet("thingEntities", ThingEntity.class, QThingEntity.class, PathInits.DIRECT2);

    public QLocationEntity(String variable) {
        this(LocationEntity.class, forVariable(variable), INITS);
    }

    public QLocationEntity(Path<? extends LocationEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocationEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocationEntity(PathMetadata metadata, PathInits inits) {
        this(LocationEntity.class, metadata, inits);
    }

    public QLocationEntity(Class<? extends LocationEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.geometryEntity = inits.isInitialized("geometryEntity") ? new org.n52.series.db.beans.QGeometryEntity(forProperty("geometryEntity")) : null;
        this.locationEncoding = inits.isInitialized("locationEncoding") ? new QLocationEncodingEntity(forProperty("locationEncoding")) : null;
    }

}

