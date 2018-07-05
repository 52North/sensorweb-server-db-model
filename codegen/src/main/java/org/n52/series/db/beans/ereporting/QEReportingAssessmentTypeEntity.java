
package org.n52.series.db.beans.ereporting;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QEReportingAssessmentTypeEntity is a Querydsl query type for EReportingAssessmentTypeEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEReportingAssessmentTypeEntity extends EntityPathBase<EReportingAssessmentTypeEntity> {

    private static final long serialVersionUID = 1784649756L;

    public static final QEReportingAssessmentTypeEntity eReportingAssessmentTypeEntity =
            new QEReportingAssessmentTypeEntity("eReportingAssessmentTypeEntity");

    public final StringPath assessmentType = createString("assessmentType");

    public final StringPath uri = createString("uri");

    public QEReportingAssessmentTypeEntity(String variable) {
        super(EReportingAssessmentTypeEntity.class, forVariable(variable));
    }

    public QEReportingAssessmentTypeEntity(Path< ? extends EReportingAssessmentTypeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEReportingAssessmentTypeEntity(PathMetadata metadata) {
        super(EReportingAssessmentTypeEntity.class, metadata);
    }

}
