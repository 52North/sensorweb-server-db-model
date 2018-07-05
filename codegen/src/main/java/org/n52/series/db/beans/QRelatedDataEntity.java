package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRelatedDataEntity is a Querydsl query type for RelatedDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRelatedDataEntity extends EntityPathBase<RelatedDataEntity> {

    private static final long serialVersionUID = -1301829785L;

    public static final QRelatedDataEntity relatedDataEntity = new QRelatedDataEntity("relatedDataEntity");

    public final QAbstractRelationEntity _super = new QAbstractRelationEntity(this);

    public final StringPath relatedUrl = createString("relatedUrl");

    public final StringPath role = createString("role");

    public QRelatedDataEntity(String variable) {
        super(RelatedDataEntity.class, forVariable(variable));
    }

    public QRelatedDataEntity(Path<? extends RelatedDataEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRelatedDataEntity(PathMetadata metadata) {
        super(RelatedDataEntity.class, metadata);
    }

}

