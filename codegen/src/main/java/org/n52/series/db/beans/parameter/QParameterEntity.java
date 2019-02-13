package org.n52.series.db.beans.parameter;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QParameterEntity is a Querydsl query type for ParameterEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParameterEntity extends EntityPathBase<ParameterEntity<?>> {

    private static final long serialVersionUID = -2119431594L;

    public static final QParameterEntity parameterEntity = new QParameterEntity("parameterEntity");

    public final org.n52.series.db.beans.QIdEntity _super = new org.n52.series.db.beans.QIdEntity(this);

    public final StringPath domain = createString("domain");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> lastUpdate = createDateTime("lastUpdate", java.util.Date.class);

    public final StringPath name = createString("name");

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QParameterEntity(String variable) {
        super((Class) ParameterEntity.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QParameterEntity(Path<? extends ParameterEntity> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QParameterEntity(PathMetadata metadata) {
        super((Class) ParameterEntity.class, metadata);
    }

}

