package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QParameterBoolean is a Querydsl query type for ParameterBoolean
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterBoolean extends EntityPathBase<ParameterBoolean> {

    private static final long serialVersionUID = 378672149L;

    public static final QParameterBoolean parameterBoolean = new QParameterBoolean("parameterBoolean");

    public final QParameter _super = new QParameter(this);

    //inherited
    public final StringPath domain = _super.domain;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> lastUpdate = _super.lastUpdate;

    //inherited
    public final StringPath name = _super.name;

    public final SimplePath<Object> value = createSimple("value", Object.class);

    public QParameterBoolean(String variable) {
        super(ParameterBoolean.class, forVariable(variable));
    }

    public QParameterBoolean(Path<? extends ParameterBoolean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParameterBoolean(PathMetadata metadata) {
        super(ParameterBoolean.class, metadata);
    }

}

