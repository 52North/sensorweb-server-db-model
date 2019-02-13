package org.n52.series.db.beans.ereporting;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEReportingProfileDataEntity is a Querydsl query type for EReportingProfileDataEntity
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QEReportingProfileDataEntity extends BeanPath<EReportingProfileDataEntity> {

    private static final long serialVersionUID = -657734695L;

    public static final QEReportingProfileDataEntity eReportingProfileDataEntity = new QEReportingProfileDataEntity("eReportingProfileDataEntity");

    public final NumberPath<Double> dataCapture = createNumber("dataCapture", Double.class);

    public final BooleanPath dataCaptureFlag = createBoolean("dataCaptureFlag");

    public final StringPath primaryObservation = createString("primaryObservation");

    public final BooleanPath timeCoverageFlag = createBoolean("timeCoverageFlag");

    public final NumberPath<Double> uncertaintyEstimation = createNumber("uncertaintyEstimation", Double.class);

    public final NumberPath<Integer> validation = createNumber("validation", Integer.class);

    public final NumberPath<Integer> verification = createNumber("verification", Integer.class);

    public QEReportingProfileDataEntity(String variable) {
        super(EReportingProfileDataEntity.class, forVariable(variable));
    }

    public QEReportingProfileDataEntity(Path<? extends EReportingProfileDataEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEReportingProfileDataEntity(PathMetadata metadata) {
        super(EReportingProfileDataEntity.class, metadata);
    }

}

