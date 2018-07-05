package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QParameter is a Querydsl query type for Parameter
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameter extends EntityPathBase<Parameter<?>> {

    private static final long serialVersionUID = 1651258515L;

    public static final QParameter parameter = new QParameter("parameter");

    public final org.n52.series.db.beans.QIdEntity _super = new org.n52.series.db.beans.QIdEntity(this);

    public final StringPath domain = createString("domain");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> lastUpdate = createDateTime("lastUpdate", java.util.Date.class);

    public final StringPath name = createString("name");

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QParameter(String variable) {
        super((Class) Parameter.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QParameter(Path<? extends Parameter> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QParameter(PathMetadata metadata) {
        super((Class) Parameter.class, metadata);
    }

}

