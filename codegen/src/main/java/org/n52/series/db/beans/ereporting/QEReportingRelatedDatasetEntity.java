
package org.n52.series.db.beans.ereporting;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QEReportingRelatedDatasetEntity is a Querydsl query type for EReportingRelatedDatasetEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEReportingRelatedDatasetEntity extends EntityPathBase<EReportingRelatedDatasetEntity> {

    private static final long serialVersionUID = 1593196557L;

    public static final QEReportingRelatedDatasetEntity eReportingRelatedDatasetEntity =
            new QEReportingRelatedDatasetEntity("eReportingRelatedDatasetEntity");

    public final org.n52.series.db.beans.QAbstractRelationEntity _super =
            new org.n52.series.db.beans.QAbstractRelationEntity(this);

    public final StringPath relatedUrl = createString("relatedUrl");

    public final StringPath role = createString("role");

    public QEReportingRelatedDatasetEntity(String variable) {
        super(EReportingRelatedDatasetEntity.class, forVariable(variable));
    }

    public QEReportingRelatedDatasetEntity(Path< ? extends EReportingRelatedDatasetEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEReportingRelatedDatasetEntity(PathMetadata metadata) {
        super(EReportingRelatedDatasetEntity.class, metadata);
    }

}
