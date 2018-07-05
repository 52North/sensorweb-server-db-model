
package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QRelatedDatasetEntity is a Querydsl query type for RelatedDatasetEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRelatedDatasetEntity extends EntityPathBase<RelatedDatasetEntity> {

    private static final long serialVersionUID = -336627455L;

    public static final QRelatedDatasetEntity relatedDatasetEntity = new QRelatedDatasetEntity("relatedDatasetEntity");

    public final QAbstractRelationEntity _super = new QAbstractRelationEntity(this);

    public final StringPath relatedUrl = createString("relatedUrl");

    public final StringPath role = createString("role");

    public QRelatedDatasetEntity(String variable) {
        super(RelatedDatasetEntity.class, forVariable(variable));
    }

    public QRelatedDatasetEntity(Path< ? extends RelatedDatasetEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRelatedDatasetEntity(PathMetadata metadata) {
        super(RelatedDatasetEntity.class, metadata);
    }

}
