package org.n52.series.db.beans.ereporting;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEReportingDatasetEntity is a Querydsl query type for EReportingDatasetEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEReportingDatasetEntity extends EntityPathBase<EReportingDatasetEntity> {

    private static final long serialVersionUID = 861804830L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEReportingDatasetEntity eReportingDatasetEntity = new QEReportingDatasetEntity("eReportingDatasetEntity");

    public final org.n52.series.db.beans.QDatasetEntity _super;

    public final org.n52.series.db.beans.QCategoryEntity category;

    public final BooleanPath deleted = createBoolean("deleted");

    public final StringPath description = createString("description");

    public final BooleanPath disabled = createBoolean("disabled");

    // custom
    public final org.n52.series.db.beans.QAbstractFeatureEntity feature = new org.n52.series.db.beans.QAbstractFeatureEntity(forProperty("feature"));

    public final NumberPath<java.math.BigDecimal> firstQuantityValue = createNumber("firstQuantityValue", java.math.BigDecimal.class);

    public final DateTimePath<java.util.Date> firstValueAt = createDateTime("firstValueAt", java.util.Date.class);

    public final BooleanPath hidden = createBoolean("hidden");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final org.n52.series.db.beans.QCodespaceEntity identifierCodespace;

    public final NumberPath<java.math.BigDecimal> lastQuantityValue = createNumber("lastQuantityValue", java.math.BigDecimal.class);

    public final DateTimePath<java.util.Date> lastValueAt = createDateTime("lastValueAt", java.util.Date.class);

    public final StringPath name = createString("name");

    public final org.n52.series.db.beans.QCodespaceEntity nameCodespace;

    public final org.n52.series.db.beans.QFormatEntity observationType;

    public final org.n52.series.db.beans.QOfferingEntity offering;

    public final SetPath<org.n52.series.db.beans.parameter.Parameter<?>, org.n52.series.db.beans.parameter.QParameter> parameters = this.<org.n52.series.db.beans.parameter.Parameter<?>, org.n52.series.db.beans.parameter.QParameter>createSet("parameters", org.n52.series.db.beans.parameter.Parameter.class, org.n52.series.db.beans.parameter.QParameter.class, PathInits.DIRECT2);

    public final org.n52.series.db.beans.QPhenomenonEntity phenomenon;

    public final org.n52.series.db.beans.QPlatformEntity platform;

    public final org.n52.series.db.beans.QProcedureEntity procedure;

    public final BooleanPath published = createBoolean("published");

    public final QEReportingSamplingPointEntity samplingPoint;

    public final StringPath valueType = createString("valueType");

    public QEReportingDatasetEntity(String variable) {
        this(EReportingDatasetEntity.class, forVariable(variable), INITS);
    }

    public QEReportingDatasetEntity(Path<? extends EReportingDatasetEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEReportingDatasetEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEReportingDatasetEntity(PathMetadata metadata, PathInits inits) {
        this(EReportingDatasetEntity.class, metadata, inits);
    }

    public QEReportingDatasetEntity(Class<? extends EReportingDatasetEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new org.n52.series.db.beans.QDatasetEntity(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new org.n52.series.db.beans.QCategoryEntity(forProperty("category")) : null;
        this.identifierCodespace = inits.isInitialized("identifierCodespace") ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("identifierCodespace")) : null;
        this.nameCodespace = inits.isInitialized("nameCodespace") ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("nameCodespace")) : null;
        this.observationType = inits.isInitialized("observationType") ? new org.n52.series.db.beans.QFormatEntity(forProperty("observationType")) : null;
        this.offering = inits.isInitialized("offering") ? new org.n52.series.db.beans.QOfferingEntity(forProperty("offering"), inits.get("offering")) : null;
        this.phenomenon = inits.isInitialized("phenomenon") ? new org.n52.series.db.beans.QPhenomenonEntity(forProperty("phenomenon"), inits.get("phenomenon")) : null;
        this.platform = inits.isInitialized("platform") ? new org.n52.series.db.beans.QPlatformEntity(forProperty("platform")) : null;
        this.procedure = inits.isInitialized("procedure") ? new org.n52.series.db.beans.QProcedureEntity(forProperty("procedure"), inits.get("procedure")) : null;
        this.samplingPoint = inits.isInitialized("samplingPoint") ? new QEReportingSamplingPointEntity(forProperty("samplingPoint"), inits.get("samplingPoint")) : null;
    }

}

