package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QIdEntity is a Querydsl query type for IdEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QIdEntity extends EntityPathBase<IdEntity> {

    private static final long serialVersionUID = -980894897L;

    public static final QIdEntity idEntity = new QIdEntity("idEntity");

    public QIdEntity(String variable) {
        super(IdEntity.class, forVariable(variable));
    }

    public QIdEntity(Path<? extends IdEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIdEntity(PathMetadata metadata) {
        super(IdEntity.class, metadata);
    }

}

