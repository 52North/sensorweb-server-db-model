
package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QParameterJson is a Querydsl query type for ParameterJson
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterJson extends EntityPathBase<ParameterJson> {

    private static final long serialVersionUID = 829232155L;

    public static final QParameterJson parameterJson = new QParameterJson("parameterJson");

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

    public QParameterJson(String variable) {
        super(ParameterJson.class, forVariable(variable));
    }

    public QParameterJson(Path< ? extends ParameterJson> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParameterJson(PathMetadata metadata) {
        super(ParameterJson.class, metadata);
    }

}
