package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractRelationEntity is a Querydsl query type for AbstractRelationEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractRelationEntity extends EntityPathBase<AbstractRelationEntity<DataEntity<?>>> {

    private static final long serialVersionUID = -1318847886L;

    public static final QAbstractRelationEntity abstractRelationEntity = new QAbstractRelationEntity("abstractRelationEntity");

    public final QIdEntity _super = new QIdEntity(this);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAbstractRelationEntity(String variable) {
        super((Class) AbstractRelationEntity.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAbstractRelationEntity(Path<? extends AbstractRelationEntity> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAbstractRelationEntity(PathMetadata metadata) {
        super((Class) AbstractRelationEntity.class, metadata);
    }

}

