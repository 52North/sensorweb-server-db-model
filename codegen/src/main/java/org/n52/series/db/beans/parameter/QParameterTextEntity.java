package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QParameterTextEntity is a Querydsl query type for ParameterTextEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterTextEntity extends EntityPathBase<ParameterTextEntity> {

    private static final long serialVersionUID = 201946211L;

    public static final QParameterTextEntity parameterTextEntity = new QParameterTextEntity("parameterTextEntity");

    public final QParameterEntity _super = new QParameterEntity(this);

    //inherited
    public final StringPath domain = _super.domain;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> lastUpdate = _super.lastUpdate;

    //inherited
    public final StringPath name = _super.name;

    public final SimplePath<Object> value = createSimple("value", Object.class);

    public QParameterTextEntity(String variable) {
        super(ParameterTextEntity.class, forVariable(variable));
    }

    public QParameterTextEntity(Path<? extends ParameterTextEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParameterTextEntity(PathMetadata metadata) {
        super(ParameterTextEntity.class, metadata);
    }

}

