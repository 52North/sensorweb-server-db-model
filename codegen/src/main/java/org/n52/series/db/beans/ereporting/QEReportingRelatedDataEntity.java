package org.n52.series.db.beans.ereporting;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEReportingRelatedDataEntity is a Querydsl query type for EReportingRelatedDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEReportingRelatedDataEntity extends EntityPathBase<EReportingRelatedDataEntity> {

    private static final long serialVersionUID = 61938651L;

    public static final QEReportingRelatedDataEntity eReportingRelatedDataEntity = new QEReportingRelatedDataEntity("eReportingRelatedDataEntity");

    public final org.n52.series.db.beans.QAbstractRelationEntity _super = new org.n52.series.db.beans.QAbstractRelationEntity(this);

    public final StringPath relatedUrl = createString("relatedUrl");

    public final StringPath role = createString("role");

    public QEReportingRelatedDataEntity(String variable) {
        super(EReportingRelatedDataEntity.class, forVariable(variable));
    }

    public QEReportingRelatedDataEntity(Path<? extends EReportingRelatedDataEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEReportingRelatedDataEntity(PathMetadata metadata) {
        super(EReportingRelatedDataEntity.class, metadata);
    }

}

