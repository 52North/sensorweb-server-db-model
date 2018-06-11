
package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QParameterCategory is a Querydsl query type for ParameterCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterCategory extends EntityPathBase<ParameterCategory> {

    private static final long serialVersionUID = 1193349809L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParameterCategory parameterCategory = new QParameterCategory("parameterCategory");

    public final QParameter _super = new QParameter(this);

    //inherited
    public final StringPath domain = _super.domain;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> lastUpdate = _super.lastUpdate;

    //inherited
    public final StringPath name = _super.name;

    public final org.n52.series.db.beans.QUnitEntity unit;

    public final SimplePath<Object> value = createSimple("value", Object.class);

    public QParameterCategory(String variable) {
        this(ParameterCategory.class, forVariable(variable), INITS);
    }

    public QParameterCategory(Path< ? extends ParameterCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParameterCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParameterCategory(PathMetadata metadata, PathInits inits) {
        this(ParameterCategory.class, metadata, inits);
    }

    public QParameterCategory(Class< ? extends ParameterCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.unit = inits.isInitialized("unit")
                ? new org.n52.series.db.beans.QUnitEntity(forProperty("unit"))
                : null;
    }

}
