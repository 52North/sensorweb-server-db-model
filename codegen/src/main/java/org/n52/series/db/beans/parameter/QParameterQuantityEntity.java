package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParameterQuantityEntity is a Querydsl query type for ParameterQuantityEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterQuantityEntity extends EntityPathBase<ParameterQuantityEntity> {

    private static final long serialVersionUID = 1306026945L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParameterQuantityEntity parameterQuantityEntity = new QParameterQuantityEntity("parameterQuantityEntity");

    public final QParameterEntity _super = new QParameterEntity(this);

    //inherited
    public final StringPath domain = _super.domain;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> lastUpdate = _super.lastUpdate;

    //inherited
    public final StringPath name = _super.name;

    public final org.n52.series.db.beans.QUnitEntity unit;

    public final SimplePath<Object> value = createSimple("value", Object.class);

    public QParameterQuantityEntity(String variable) {
        this(ParameterQuantityEntity.class, forVariable(variable), INITS);
    }

    public QParameterQuantityEntity(Path<? extends ParameterQuantityEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParameterQuantityEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParameterQuantityEntity(PathMetadata metadata, PathInits inits) {
        this(ParameterQuantityEntity.class, metadata, inits);
    }

    public QParameterQuantityEntity(Class<? extends ParameterQuantityEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.unit = inits.isInitialized("unit") ? new org.n52.series.db.beans.QUnitEntity(forProperty("unit")) : null;
    }

}

