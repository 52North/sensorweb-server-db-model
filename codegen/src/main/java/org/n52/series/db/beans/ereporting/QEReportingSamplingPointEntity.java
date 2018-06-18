package org.n52.series.db.beans.ereporting;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEReportingSamplingPointEntity is a Querydsl query type for EReportingSamplingPointEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEReportingSamplingPointEntity extends EntityPathBase<EReportingSamplingPointEntity> {

    private static final long serialVersionUID = -1065192561L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEReportingSamplingPointEntity eReportingSamplingPointEntity = new QEReportingSamplingPointEntity("eReportingSamplingPointEntity");

    public final org.n52.series.db.beans.QDescribableEntity _super = new org.n52.series.db.beans.QDescribableEntity(this);

    public final QEReportingAssessmentTypeEntity assessmentType;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final org.n52.series.db.beans.QCodespaceEntity identifierCodespace;

    public final StringPath name = createString("name");

    public final org.n52.series.db.beans.QCodespaceEntity nameCodespace;

    public final QEReportingNetworkEntity network;

    public final QEReportingStationEntity station;

    public QEReportingSamplingPointEntity(String variable) {
        this(EReportingSamplingPointEntity.class, forVariable(variable), INITS);
    }

    public QEReportingSamplingPointEntity(Path<? extends EReportingSamplingPointEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEReportingSamplingPointEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEReportingSamplingPointEntity(PathMetadata metadata, PathInits inits) {
        this(EReportingSamplingPointEntity.class, metadata, inits);
    }

    public QEReportingSamplingPointEntity(Class<? extends EReportingSamplingPointEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.assessmentType = inits.isInitialized("assessmentType") ? new QEReportingAssessmentTypeEntity(forProperty("assessmentType")) : null;
        this.identifierCodespace = inits.isInitialized("identifierCodespace") ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("identifierCodespace")) : null;
        this.nameCodespace = inits.isInitialized("nameCodespace") ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("nameCodespace")) : null;
        this.network = inits.isInitialized("network") ? new QEReportingNetworkEntity(forProperty("network"), inits.get("network")) : null;
        this.station = inits.isInitialized("station") ? new QEReportingStationEntity(forProperty("station"), inits.get("station")) : null;
    }

}

