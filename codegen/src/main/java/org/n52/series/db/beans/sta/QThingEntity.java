package org.n52.series.db.beans.sta;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QThingEntity is a Querydsl query type for ThingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QThingEntity extends EntityPathBase<ThingEntity> {

    private static final long serialVersionUID = 1604997138L;

    public static final QThingEntity thingEntity = new QThingEntity("thingEntity");

    public final QAbstractStaEntity _super = new QAbstractStaEntity(this);

    public final StringPath description = createString("description");

    public final SetPath<HistoricalLocationEntity, QHistoricalLocationEntity> historicalLocationEntities = this.<HistoricalLocationEntity, QHistoricalLocationEntity>createSet("historicalLocationEntities", HistoricalLocationEntity.class, QHistoricalLocationEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<LocationEntity, QLocationEntity> locationEntities = this.<LocationEntity, QLocationEntity>createSet("locationEntities", LocationEntity.class, QLocationEntity.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath properties = createString("properties");

    public QThingEntity(String variable) {
        super(ThingEntity.class, forVariable(variable));
    }

    public QThingEntity(Path<? extends ThingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QThingEntity(PathMetadata metadata) {
        super(ThingEntity.class, metadata);
    }

}

