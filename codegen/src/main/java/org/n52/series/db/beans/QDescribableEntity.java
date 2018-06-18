package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDescribableEntity is a Querydsl query type for DescribableEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QDescribableEntity extends EntityPathBase<DescribableEntity> {

    private static final long serialVersionUID = 1861609190L;

    public static final QDescribableEntity describableEntity = new QDescribableEntity("describableEntity");

    public final QIdEntity _super = new QIdEntity(this);

    public QDescribableEntity(String variable) {
        super(DescribableEntity.class, forVariable(variable));
    }

    public QDescribableEntity(Path<? extends DescribableEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDescribableEntity(PathMetadata metadata) {
        super(DescribableEntity.class, metadata);
    }

}

