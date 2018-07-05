package org.n52.series.db.beans.ereporting;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEReportingQualityEntity is a Querydsl query type for EReportingQualityEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEReportingQualityEntity extends EntityPathBase<EReportingQualityEntity> {

    private static final long serialVersionUID = -1340513179L;

    public static final QEReportingQualityEntity eReportingQualityEntity = new QEReportingQualityEntity("eReportingQualityEntity");

    public final org.n52.series.db.beans.QIdEntity _super = new org.n52.series.db.beans.QIdEntity(this);

    public final BooleanPath dataCaptureFlag = createBoolean("dataCaptureFlag");

    public final NumberPath<Long> dataset = createNumber("dataset", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath primaryObservation = createString("primaryObservation");

    public final BooleanPath timeCoverageFlag = createBoolean("timeCoverageFlag");

    public final NumberPath<Double> uncertaintyEstimation = createNumber("uncertaintyEstimation", Double.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QEReportingQualityEntity(String variable) {
        super(EReportingQualityEntity.class, forVariable(variable));
    }

    public QEReportingQualityEntity(Path<? extends EReportingQualityEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEReportingQualityEntity(PathMetadata metadata) {
        super(EReportingQualityEntity.class, metadata);
    }

}

