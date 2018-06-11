
package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QParameterText is a Querydsl query type for ParameterText
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterText extends EntityPathBase<ParameterText> {

    private static final long serialVersionUID = 829516896L;

    public static final QParameterText parameterText = new QParameterText("parameterText");

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

    public QParameterText(String variable) {
        super(ParameterText.class, forVariable(variable));
    }

    public QParameterText(Path< ? extends ParameterText> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParameterText(PathMetadata metadata) {
        super(ParameterText.class, metadata);
    }

}
