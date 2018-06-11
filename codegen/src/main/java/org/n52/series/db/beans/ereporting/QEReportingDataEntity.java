
package org.n52.series.db.beans.ereporting;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QEReportingDataEntity is a Querydsl query type for EReportingDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEReportingDataEntity extends EntityPathBase<EReportingDataEntity< ? >> {

    private static final long serialVersionUID = 1152992362L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEReportingDataEntity eReportingDataEntity = new QEReportingDataEntity("eReportingDataEntity");

    public final org.n52.series.db.beans.QDataEntity _super;

    public final BooleanPath child = createBoolean("child");

    public final NumberPath<Double> dataCapture = createNumber("dataCapture", Double.class);

    public final BooleanPath dataCaptureFlag = createBoolean("dataCaptureFlag");

    public final org.n52.series.db.beans.QDatasetEntity dataset;

    public final BooleanPath deleted = createBoolean("deleted");

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.QGeometryEntity geometryEntity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final org.n52.series.db.beans.QCodespaceEntity identifierCodespace;

    public final StringPath name = createString("name");

    public final org.n52.series.db.beans.QCodespaceEntity nameCodespace;

    public final SetPath<org.n52.series.db.beans.parameter.Parameter< ? >, org.n52.series.db.beans.parameter.QParameter> parameters =
            this.<org.n52.series.db.beans.parameter.Parameter< ? >, org.n52.series.db.beans.parameter.QParameter> createSet("parameters",
                                                                                                                            org.n52.series.db.beans.parameter.Parameter.class,
                                                                                                                            org.n52.series.db.beans.parameter.QParameter.class,
                                                                                                                            PathInits.DIRECT2);

    public final BooleanPath parent = createBoolean("parent");

    public final StringPath primaryObservation = createString("primaryObservation");

    public final SetPath<EReportingRelatedDataEntity, QEReportingRelatedDataEntity> relatedObservations =
            this.<EReportingRelatedDataEntity, QEReportingRelatedDataEntity> createSet("relatedObservations",
                                                                                       EReportingRelatedDataEntity.class,
                                                                                       QEReportingRelatedDataEntity.class,
                                                                                       PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> resultTime = createDateTime("resultTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> samplingTimeEnd = createDateTime("samplingTimeEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> samplingTimeStart =
            createDateTime("samplingTimeStart", java.util.Date.class);

    public final BooleanPath timeCoverageFlag = createBoolean("timeCoverageFlag");

    public final NumberPath<Double> uncertaintyEstimation = createNumber("uncertaintyEstimation", Double.class);

    public final NumberPath<Integer> validation = createNumber("validation", Integer.class);

    public final DateTimePath<java.util.Date> validTimeEnd = createDateTime("validTimeEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> validTimeStart = createDateTime("validTimeStart", java.util.Date.class);

    public final StringPath valueDescription = createString("valueDescription");

    public final StringPath valueIdentifier = createString("valueIdentifier");

    public final StringPath valueName = createString("valueName");

    public final NumberPath<Integer> verification = createNumber("verification", Integer.class);

    public final NumberPath<java.math.BigDecimal> verticalFrom =
            createNumber("verticalFrom", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> verticalTo = createNumber("verticalTo", java.math.BigDecimal.class);

    @SuppressWarnings({
        "all",
        "rawtypes",
        "unchecked"
    })
    public QEReportingDataEntity(String variable) {
        this((Class) EReportingDataEntity.class, forVariable(variable), INITS);
    }

    @SuppressWarnings({
        "all",
        "rawtypes",
        "unchecked"
    })
    public QEReportingDataEntity(Path< ? extends EReportingDataEntity> path) {
        this((Class) path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEReportingDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    @SuppressWarnings({
        "all",
        "rawtypes",
        "unchecked"
    })
    public QEReportingDataEntity(PathMetadata metadata, PathInits inits) {
        this((Class) EReportingDataEntity.class, metadata, inits);
    }

    public QEReportingDataEntity(Class< ? extends EReportingDataEntity< ? >> type,
                                 PathMetadata metadata,
                                 PathInits inits) {
        super(type, metadata, inits);
        this._super = new org.n52.series.db.beans.QDataEntity(type, metadata, inits);
        this.dataset = inits.isInitialized("dataset")
                ? new org.n52.series.db.beans.QDatasetEntity(forProperty("dataset"), inits.get("dataset"))
                : null;
        this.geometryEntity = inits.isInitialized("geometryEntity")
                ? new org.n52.series.db.beans.QGeometryEntity(forProperty("geometryEntity"))
                : null;
        this.identifierCodespace = inits.isInitialized("identifierCodespace")
                ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("identifierCodespace"))
                : null;
        this.nameCodespace = inits.isInitialized("nameCodespace")
                ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("nameCodespace"))
                : null;
    }

}
