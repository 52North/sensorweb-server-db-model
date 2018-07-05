package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCodespaceEntity is a Querydsl query type for CodespaceEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCodespaceEntity extends EntityPathBase<CodespaceEntity> {

    private static final long serialVersionUID = -1220189973L;

    public static final QCodespaceEntity codespaceEntity = new QCodespaceEntity("codespaceEntity");

    public final QIdEntity _super = new QIdEntity(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QCodespaceEntity(String variable) {
        super(CodespaceEntity.class, forVariable(variable));
    }

    public QCodespaceEntity(Path<? extends CodespaceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCodespaceEntity(PathMetadata metadata) {
        super(CodespaceEntity.class, metadata);
    }

}

