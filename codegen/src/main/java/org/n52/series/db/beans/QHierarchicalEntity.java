package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHierarchicalEntity is a Querydsl query type for HierarchicalEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QHierarchicalEntity extends EntityPathBase<HierarchicalEntity<PhenomenonEntity>> {

    private static final long serialVersionUID = -800290307L;

    public static final QHierarchicalEntity hierarchicalEntity = new QHierarchicalEntity("hierarchicalEntity");

    public final QDescribableEntity _super = new QDescribableEntity(this);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QHierarchicalEntity(String variable) {
        super((Class) HierarchicalEntity.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QHierarchicalEntity(Path<? extends HierarchicalEntity> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QHierarchicalEntity(PathMetadata metadata) {
        super((Class) HierarchicalEntity.class, metadata);
    }

}

