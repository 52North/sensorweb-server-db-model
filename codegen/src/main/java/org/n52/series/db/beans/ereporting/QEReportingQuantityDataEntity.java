package org.n52.series.db.beans.ereporting;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEReportingQuantityDataEntity is a Querydsl query type for EReportingQuantityDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEReportingQuantityDataEntity extends EntityPathBase<EReportingQuantityDataEntity> {

    private static final long serialVersionUID = 722863701L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEReportingQuantityDataEntity eReportingQuantityDataEntity = new QEReportingQuantityDataEntity("eReportingQuantityDataEntity");

    public final QEReportingDataEntity _super;

    //inherited
    public final BooleanPath child;

    //inherited
    public final NumberPath<Double> dataCapture;

    //inherited
    public final BooleanPath dataCaptureFlag;

    // inherited
    public final org.n52.series.db.beans.QDatasetEntity dataset;

    //inherited
    public final BooleanPath deleted;

    //inherited
    public final StringPath description;

    // inherited
    public final org.n52.series.db.beans.QGeometryEntity geometryEntity;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath identifier;

    // inherited
    public final org.n52.series.db.beans.QCodespaceEntity identifierCodespace;

    //inherited
    public final StringPath name;

    // inherited
    public final org.n52.series.db.beans.QCodespaceEntity nameCodespace;

    //inherited
    public final SetPath<org.n52.series.db.beans.parameter.Parameter<?>, org.n52.series.db.beans.parameter.QParameter> parameters;

    //inherited
    public final BooleanPath parent;

    //inherited
    public final StringPath primaryObservation;

    //inherited
    public final SetPath<EReportingRelatedDataEntity, QEReportingRelatedDataEntity> relatedObservations;

    //inherited
    public final DateTimePath<java.util.Date> resultTime;

    //inherited
    public final DateTimePath<java.util.Date> samplingTimeEnd;

    //inherited
    public final DateTimePath<java.util.Date> samplingTimeStart;

    //inherited
    public final BooleanPath timeCoverageFlag;

    //inherited
    public final NumberPath<Double> uncertaintyEstimation;

    //inherited
    public final NumberPath<Integer> validation;

    //inherited
    public final DateTimePath<java.util.Date> validTimeEnd;

    //inherited
    public final DateTimePath<java.util.Date> validTimeStart;

    public final SimplePath<Object> value = createSimple("value", Object.class);

    //inherited
    public final StringPath valueDescription;

    //inherited
    public final StringPath valueIdentifier;

    //inherited
    public final StringPath valueName;

    //inherited
    public final NumberPath<Integer> verification;

    //inherited
    public final NumberPath<java.math.BigDecimal> verticalFrom;

    //inherited
    public final NumberPath<java.math.BigDecimal> verticalTo;

    public QEReportingQuantityDataEntity(String variable) {
        this(EReportingQuantityDataEntity.class, forVariable(variable), INITS);
    }

    public QEReportingQuantityDataEntity(Path<? extends EReportingQuantityDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEReportingQuantityDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEReportingQuantityDataEntity(PathMetadata metadata, PathInits inits) {
        this(EReportingQuantityDataEntity.class, metadata, inits);
    }

    public QEReportingQuantityDataEntity(Class<? extends EReportingQuantityDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QEReportingDataEntity(type, metadata, inits);
        this.child = _super.child;
        this.dataCapture = _super.dataCapture;
        this.dataCaptureFlag = _super.dataCaptureFlag;
        this.dataset = _super.dataset;
        this.deleted = _super.deleted;
        this.description = _super.description;
        this.geometryEntity = _super.geometryEntity;
        this.id = _super.id;
        this.identifier = _super.identifier;
        this.identifierCodespace = _super.identifierCodespace;
        this.name = _super.name;
        this.nameCodespace = _super.nameCodespace;
        this.parameters = _super.parameters;
        this.parent = _super.parent;
        this.primaryObservation = _super.primaryObservation;
        this.relatedObservations = _super.relatedObservations;
        this.resultTime = _super.resultTime;
        this.samplingTimeEnd = _super.samplingTimeEnd;
        this.samplingTimeStart = _super.samplingTimeStart;
        this.timeCoverageFlag = _super.timeCoverageFlag;
        this.uncertaintyEstimation = _super.uncertaintyEstimation;
        this.validation = _super.validation;
        this.validTimeEnd = _super.validTimeEnd;
        this.validTimeStart = _super.validTimeStart;
        this.valueDescription = _super.valueDescription;
        this.valueIdentifier = _super.valueIdentifier;
        this.valueName = _super.valueName;
        this.verification = _super.verification;
        this.verticalFrom = _super.verticalFrom;
        this.verticalTo = _super.verticalTo;
    }

}

