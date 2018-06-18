package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QServiceEntity is a Querydsl query type for ServiceEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QServiceEntity extends EntityPathBase<ServiceEntity> {

    private static final long serialVersionUID = -39519449L;

    public static final QServiceEntity serviceEntity = new QServiceEntity("serviceEntity");

    public final QDescribableEntity _super = new QDescribableEntity(this);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath type = createString("type");

    public final StringPath url = createString("url");

    public final StringPath version = createString("version");

    public QServiceEntity(String variable) {
        super(ServiceEntity.class, forVariable(variable));
    }

    public QServiceEntity(Path<? extends ServiceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QServiceEntity(PathMetadata metadata) {
        super(ServiceEntity.class, metadata);
    }

}

