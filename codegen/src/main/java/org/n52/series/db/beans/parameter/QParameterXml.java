package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QParameterXml is a Querydsl query type for ParameterXml
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterXml extends EntityPathBase<ParameterXml> {

    private static final long serialVersionUID = -1912899964L;

    public static final QParameterXml parameterXml = new QParameterXml("parameterXml");

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

    public QParameterXml(String variable) {
        super(ParameterXml.class, forVariable(variable));
    }

    public QParameterXml(Path<? extends ParameterXml> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParameterXml(PathMetadata metadata) {
        super(ParameterXml.class, metadata);
    }

}

