
package org.n52.series.db.beans.feature;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QReferenceEntity is a Querydsl query type for ReferenceEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QReferenceEntity extends EntityPathBase<ReferenceEntity> {

    private static final long serialVersionUID = 663456133L;

    public static final QReferenceEntity referenceEntity = new QReferenceEntity("referenceEntity");

    public final QNilReasonEntity _super = new QNilReasonEntity(this);

    public QReferenceEntity(String variable) {
        super(ReferenceEntity.class, forVariable(variable));
    }

    public QReferenceEntity(Path< ? extends ReferenceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReferenceEntity(PathMetadata metadata) {
        super(ReferenceEntity.class, metadata);
    }

}
