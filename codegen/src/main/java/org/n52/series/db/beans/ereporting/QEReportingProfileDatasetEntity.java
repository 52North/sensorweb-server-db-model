package org.n52.series.db.beans.ereporting;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEReportingProfileDatasetEntity is a Querydsl query type for EReportingProfileDatasetEntity
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QEReportingProfileDatasetEntity extends BeanPath<EReportingProfileDatasetEntity> {

    private static final long serialVersionUID = -2013679793L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEReportingProfileDatasetEntity eReportingProfileDatasetEntity = new QEReportingProfileDatasetEntity("eReportingProfileDatasetEntity");

    public final QEReportingSamplingPointEntity samplingPoint;

    public QEReportingProfileDatasetEntity(String variable) {
        this(EReportingProfileDatasetEntity.class, forVariable(variable), INITS);
    }

    public QEReportingProfileDatasetEntity(Path<? extends EReportingProfileDatasetEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEReportingProfileDatasetEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEReportingProfileDatasetEntity(PathMetadata metadata, PathInits inits) {
        this(EReportingProfileDatasetEntity.class, metadata, inits);
    }

    public QEReportingProfileDatasetEntity(Class<? extends EReportingProfileDatasetEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.samplingPoint = inits.isInitialized("samplingPoint") ? new QEReportingSamplingPointEntity(forProperty("samplingPoint"), inits.get("samplingPoint")) : null;
    }

}

