package org.n52.series.db.beans.feature.gmd;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QExExtentEntity is a Querydsl query type for ExExtentEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExExtentEntity extends EntityPathBase<ExExtentEntity> {

    private static final long serialVersionUID = 289096153L;

    public static final QExExtentEntity exExtentEntity = new QExExtentEntity("exExtentEntity");

    public final QAbstractCiEntity _super = new QAbstractCiEntity(this);

    public final StringPath description = createString("description");

    public final StringPath gmdid = createString("gmdid");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath uuid = createString("uuid");

    public final SetPath<ExVerticalExtentEntity, QExVerticalExtentEntity> verticalExtent = this.<ExVerticalExtentEntity, QExVerticalExtentEntity>createSet("verticalExtent", ExVerticalExtentEntity.class, QExVerticalExtentEntity.class, PathInits.DIRECT2);

    public QExExtentEntity(String variable) {
        super(ExExtentEntity.class, forVariable(variable));
    }

    public QExExtentEntity(Path<? extends ExExtentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExExtentEntity(PathMetadata metadata) {
        super(ExExtentEntity.class, metadata);
    }

}

