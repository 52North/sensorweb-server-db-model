package org.n52.series.db.beans.sta;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractStaEntity is a Querydsl query type for AbstractStaEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractStaEntity extends EntityPathBase<AbstractStaEntity> {

    private static final long serialVersionUID = 610538754L;

    public static final QAbstractStaEntity abstractStaEntity = new QAbstractStaEntity("abstractStaEntity");

    public final org.n52.series.db.beans.QIdEntity _super = new org.n52.series.db.beans.QIdEntity(this);

    public QAbstractStaEntity(String variable) {
        super(AbstractStaEntity.class, forVariable(variable));
    }

    public QAbstractStaEntity(Path<? extends AbstractStaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractStaEntity(PathMetadata metadata) {
        super(AbstractStaEntity.class, metadata);
    }

}

