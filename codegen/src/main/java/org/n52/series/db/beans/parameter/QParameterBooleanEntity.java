package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QParameterBooleanEntity is a Querydsl query type for ParameterBooleanEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterBooleanEntity extends EntityPathBase<ParameterBooleanEntity> {

    private static final long serialVersionUID = 815317080L;

    public static final QParameterBooleanEntity parameterBooleanEntity = new QParameterBooleanEntity("parameterBooleanEntity");

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

    public QParameterBooleanEntity(String variable) {
        super(ParameterBooleanEntity.class, forVariable(variable));
    }

    public QParameterBooleanEntity(Path<? extends ParameterBooleanEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParameterBooleanEntity(PathMetadata metadata) {
        super(ParameterBooleanEntity.class, metadata);
    }

}

