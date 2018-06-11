
package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QRelatedFeatureEntity is a Querydsl query type for RelatedFeatureEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRelatedFeatureEntity extends EntityPathBase<RelatedFeatureEntity> {

    private static final long serialVersionUID = 1370548479L;

    public static final QRelatedFeatureEntity relatedFeatureEntity = new QRelatedFeatureEntity("relatedFeatureEntity");

    public final QIdEntity _super = new QIdEntity(this);

    // custom
    public final QAbstractFeatureEntity feature = new QAbstractFeatureEntity(forProperty("feature"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<OfferingEntity, QOfferingEntity> offerings =
            this.<OfferingEntity, QOfferingEntity> createSet("offerings",
                                                             OfferingEntity.class,
                                                             QOfferingEntity.class,
                                                             PathInits.DIRECT2);

    public final StringPath role = createString("role");

    public QRelatedFeatureEntity(String variable) {
        super(RelatedFeatureEntity.class, forVariable(variable));
    }

    public QRelatedFeatureEntity(Path< ? extends RelatedFeatureEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRelatedFeatureEntity(PathMetadata metadata) {
        super(RelatedFeatureEntity.class, metadata);
    }

}
