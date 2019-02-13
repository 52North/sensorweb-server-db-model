package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParameterCategoryEntity is a Querydsl query type for ParameterCategoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterCategoryEntity extends EntityPathBase<ParameterCategoryEntity> {

    private static final long serialVersionUID = -373466636L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParameterCategoryEntity parameterCategoryEntity = new QParameterCategoryEntity("parameterCategoryEntity");

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

    public QParameterCategoryEntity(String variable) {
        this(ParameterCategoryEntity.class, forVariable(variable), INITS);
    }

    public QParameterCategoryEntity(Path<? extends ParameterCategoryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParameterCategoryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParameterCategoryEntity(PathMetadata metadata, PathInits inits) {
        this(ParameterCategoryEntity.class, metadata, inits);
    }

    public QParameterCategoryEntity(Class<? extends ParameterCategoryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.unit = inits.isInitialized("unit") ? new org.n52.series.db.beans.QUnitEntity(forProperty("unit")) : null;
    }

}

