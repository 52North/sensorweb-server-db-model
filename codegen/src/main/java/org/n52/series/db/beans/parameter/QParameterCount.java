package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QParameterCount is a Querydsl query type for ParameterCount
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterCount extends EntityPathBase<ParameterCount> {

    private static final long serialVersionUID = -70184900L;

    public static final QParameterCount parameterCount = new QParameterCount("parameterCount");

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

    public QParameterCount(String variable) {
        super(ParameterCount.class, forVariable(variable));
    }

    public QParameterCount(Path<? extends ParameterCount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParameterCount(PathMetadata metadata) {
        super(ParameterCount.class, metadata);
    }

}

