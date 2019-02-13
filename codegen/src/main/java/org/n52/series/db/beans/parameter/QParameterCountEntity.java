package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QParameterCountEntity is a Querydsl query type for ParameterCountEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterCountEntity extends EntityPathBase<ParameterCountEntity> {

    private static final long serialVersionUID = 1623049023L;

    public static final QParameterCountEntity parameterCountEntity = new QParameterCountEntity("parameterCountEntity");

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

    public QParameterCountEntity(String variable) {
        super(ParameterCountEntity.class, forVariable(variable));
    }

    public QParameterCountEntity(Path<? extends ParameterCountEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParameterCountEntity(PathMetadata metadata) {
        super(ParameterCountEntity.class, metadata);
    }

}

