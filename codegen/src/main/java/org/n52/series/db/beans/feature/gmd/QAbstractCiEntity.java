
package org.n52.series.db.beans.feature.gmd;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QAbstractCiEntity is a Querydsl query type for AbstractCiEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractCiEntity extends EntityPathBase<AbstractCiEntity> {

    private static final long serialVersionUID = 1104201156L;

    public static final QAbstractCiEntity abstractCiEntity = new QAbstractCiEntity("abstractCiEntity");

    public final org.n52.series.db.beans.feature.QReferenceEntity _super =
            new org.n52.series.db.beans.feature.QReferenceEntity(this);

    public QAbstractCiEntity(String variable) {
        super(AbstractCiEntity.class, forVariable(variable));
    }

    public QAbstractCiEntity(Path< ? extends AbstractCiEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractCiEntity(PathMetadata metadata) {
        super(AbstractCiEntity.class, metadata);
    }

}
