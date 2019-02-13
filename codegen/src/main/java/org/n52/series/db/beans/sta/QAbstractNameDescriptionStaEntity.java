package org.n52.series.db.beans.sta;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractNameDescriptionStaEntity is a Querydsl query type for AbstractNameDescriptionStaEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractNameDescriptionStaEntity extends EntityPathBase<AbstractNameDescriptionStaEntity> {

    private static final long serialVersionUID = 1752674291L;

    public static final QAbstractNameDescriptionStaEntity abstractNameDescriptionStaEntity = new QAbstractNameDescriptionStaEntity("abstractNameDescriptionStaEntity");

    public final org.n52.series.db.beans.QIdEntity _super = new org.n52.series.db.beans.QIdEntity(this);

    public QAbstractNameDescriptionStaEntity(String variable) {
        super(AbstractNameDescriptionStaEntity.class, forVariable(variable));
    }

    public QAbstractNameDescriptionStaEntity(Path<? extends AbstractNameDescriptionStaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractNameDescriptionStaEntity(PathMetadata metadata) {
        super(AbstractNameDescriptionStaEntity.class, metadata);
    }

}

