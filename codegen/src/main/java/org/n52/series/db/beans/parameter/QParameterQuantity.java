package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParameterQuantity is a Querydsl query type for ParameterQuantity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterQuantity extends EntityPathBase<ParameterQuantity> {

    private static final long serialVersionUID = -142165442L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParameterQuantity parameterQuantity = new QParameterQuantity("parameterQuantity");

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

    public QParameterQuantity(String variable) {
        this(ParameterQuantity.class, forVariable(variable), INITS);
    }

    public QParameterQuantity(Path<? extends ParameterQuantity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParameterQuantity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParameterQuantity(PathMetadata metadata, PathInits inits) {
        this(ParameterQuantity.class, metadata, inits);
    }

    public QParameterQuantity(Class<? extends ParameterQuantity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.unit = inits.isInitialized("unit") ? new org.n52.series.db.beans.QUnitEntity(forProperty("unit")) : null;
    }

}

