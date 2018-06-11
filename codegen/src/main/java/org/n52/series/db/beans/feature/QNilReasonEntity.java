
package org.n52.series.db.beans.feature;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QNilReasonEntity is a Querydsl query type for NilReasonEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QNilReasonEntity extends EntityPathBase<NilReasonEntity> {

    private static final long serialVersionUID = -1951307153L;

    public static final QNilReasonEntity nilReasonEntity = new QNilReasonEntity("nilReasonEntity");

    public final org.n52.series.db.beans.QDescribableEntity _super =
            new org.n52.series.db.beans.QDescribableEntity(this);

    public QNilReasonEntity(String variable) {
        super(NilReasonEntity.class, forVariable(variable));
    }

    public QNilReasonEntity(Path< ? extends NilReasonEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNilReasonEntity(PathMetadata metadata) {
        super(NilReasonEntity.class, metadata);
    }

}
