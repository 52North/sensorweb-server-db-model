package org.n52.series.db.beans.feature.gmd;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoleEntity is a Querydsl query type for RoleEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoleEntity extends EntityPathBase<RoleEntity> {

    private static final long serialVersionUID = -510737838L;

    public static final QRoleEntity roleEntity = new QRoleEntity("roleEntity");

    public final org.n52.series.db.beans.feature.QNilReasonEntity _super = new org.n52.series.db.beans.feature.QNilReasonEntity(this);

    public final StringPath codeList = createString("codeList");

    public final StringPath codeListValue = createString("codeListValue");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QRoleEntity(String variable) {
        super(RoleEntity.class, forVariable(variable));
    }

    public QRoleEntity(Path<? extends RoleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoleEntity(PathMetadata metadata) {
        super(RoleEntity.class, metadata);
    }

}

