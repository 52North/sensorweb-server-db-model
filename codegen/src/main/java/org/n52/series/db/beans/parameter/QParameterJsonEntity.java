package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QParameterJsonEntity is a Querydsl query type for ParameterJsonEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterJsonEntity extends EntityPathBase<ParameterJsonEntity> {

    private static final long serialVersionUID = -1197923362L;

    public static final QParameterJsonEntity parameterJsonEntity = new QParameterJsonEntity("parameterJsonEntity");

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

    public QParameterJsonEntity(String variable) {
        super(ParameterJsonEntity.class, forVariable(variable));
    }

    public QParameterJsonEntity(Path<? extends ParameterJsonEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParameterJsonEntity(PathMetadata metadata) {
        super(ParameterJsonEntity.class, metadata);
    }

}

