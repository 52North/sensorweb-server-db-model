package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDatasetEntity is a Querydsl query type for DatasetEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDatasetEntity extends EntityPathBase<DatasetEntity> {

    private static final long serialVersionUID = -1193260374L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDatasetEntity datasetEntity = new QDatasetEntity("datasetEntity");

    public final QDescribableEntity _super = new QDescribableEntity(this);

    public final QCategoryEntity category;

    public final EnumPath<org.n52.series.db.beans.dataset.DatasetType> datasetType = createEnum("datasetType", org.n52.series.db.beans.dataset.DatasetType.class);

    public final BooleanPath deleted = createBoolean("deleted");

    public final StringPath description = createString("description");

    public final BooleanPath disabled = createBoolean("disabled");

    public final QFeatureEntity feature;

    // custom
    public final QDataEntity firstObservation = new QDataEntity(forProperty("firstObservation"));

    public final NumberPath<java.math.BigDecimal> firstQuantityValue = createNumber("firstQuantityValue", java.math.BigDecimal.class);

    public final DateTimePath<java.util.Date> firstValueAt = createDateTime("firstValueAt", java.util.Date.class);

    public final BooleanPath hidden = createBoolean("hidden");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final BooleanPath insitu = createBoolean("insitu");

    // custom
    public final QDataEntity lastObservation = new QDataEntity(forProperty("lastObservation"));

    public final NumberPath<java.math.BigDecimal> lastQuantityValue = createNumber("lastQuantityValue", java.math.BigDecimal.class);

    public final DateTimePath<java.util.Date> lastValueAt = createDateTime("lastValueAt", java.util.Date.class);

    public final BooleanPath mobile = createBoolean("mobile");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> numberOfDecimals = createNumber("numberOfDecimals", Integer.class);

    public final EnumPath<org.n52.series.db.beans.dataset.ObservationType> observationType = createEnum("observationType", org.n52.series.db.beans.dataset.ObservationType.class);

    public final QOfferingEntity offering;

    public final StringPath originTimezone = createString("originTimezone");

    public final QPhenomenonEntity phenomenon;

    public final QPlatformEntity platform;

    public final QProcedureEntity procedure;

    public final BooleanPath published = createBoolean("published");

    public final ListPath<DatasetEntity, QDatasetEntity> referenceValues = this.<DatasetEntity, QDatasetEntity>createList("referenceValues", DatasetEntity.class, QDatasetEntity.class, PathInits.DIRECT2);

    public final org.n52.series.db.beans.sampling.QSamplingProfileDatasetEntity samplingProfile;

    public final SetPath<org.n52.series.db.beans.i18n.I18nDatasetEntity<?>, org.n52.series.db.beans.i18n.QI18nDatasetEntity> translations = this.<org.n52.series.db.beans.i18n.I18nDatasetEntity<?>, org.n52.series.db.beans.i18n.QI18nDatasetEntity>createSet("translations", org.n52.series.db.beans.i18n.I18nDatasetEntity.class, org.n52.series.db.beans.i18n.QI18nDatasetEntity.class, PathInits.DIRECT2);

    public final QUnitEntity unit;

    public final EnumPath<org.n52.series.db.beans.dataset.ValueType> valueType = createEnum("valueType", org.n52.series.db.beans.dataset.ValueType.class);

    public final QVerticalMetadataEntity verticalMetadata;

    public QDatasetEntity(String variable) {
        this(DatasetEntity.class, forVariable(variable), INITS);
    }

    public QDatasetEntity(Path<? extends DatasetEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDatasetEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDatasetEntity(PathMetadata metadata, PathInits inits) {
        this(DatasetEntity.class, metadata, inits);
    }

    public QDatasetEntity(Class<? extends DatasetEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategoryEntity(forProperty("category")) : null;
        this.feature = inits.isInitialized("feature") ? new QFeatureEntity(forProperty("feature"), inits.get("feature")) : null;
        this.offering = inits.isInitialized("offering") ? new QOfferingEntity(forProperty("offering"), inits.get("offering")) : null;
        this.phenomenon = inits.isInitialized("phenomenon") ? new QPhenomenonEntity(forProperty("phenomenon"), inits.get("phenomenon")) : null;
        this.platform = inits.isInitialized("platform") ? new QPlatformEntity(forProperty("platform"), inits.get("platform")) : null;
        this.procedure = inits.isInitialized("procedure") ? new QProcedureEntity(forProperty("procedure")) : null;
        this.samplingProfile = inits.isInitialized("samplingProfile") ? new org.n52.series.db.beans.sampling.QSamplingProfileDatasetEntity(forProperty("samplingProfile")) : null;
        this.unit = inits.isInitialized("unit") ? new QUnitEntity(forProperty("unit")) : null;
        this.verticalMetadata = inits.isInitialized("verticalMetadata") ? new QVerticalMetadataEntity(forProperty("verticalMetadata"), inits.get("verticalMetadata")) : null;
    }

}

