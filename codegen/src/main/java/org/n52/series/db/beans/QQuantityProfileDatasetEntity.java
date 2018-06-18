package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuantityProfileDatasetEntity is a Querydsl query type for QuantityProfileDatasetEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQuantityProfileDatasetEntity extends EntityPathBase<QuantityProfileDatasetEntity> {

    private static final long serialVersionUID = 293882990L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuantityProfileDatasetEntity quantityProfileDatasetEntity = new QQuantityProfileDatasetEntity("quantityProfileDatasetEntity");

    public final QProfileDatasetEntity _super;

    // inherited
    public final QCategoryEntity category;

    //inherited
    public final BooleanPath deleted;

    //inherited
    public final StringPath description;

    //inherited
    public final BooleanPath disabled;

    // custom
    // inherited
    public final QAbstractFeatureEntity feature;

    public final SimplePath<org.n52.series.db.beans.data.Data> firstObservation = createSimple("firstObservation", org.n52.series.db.beans.data.Data.class);

    //inherited
    public final NumberPath<java.math.BigDecimal> firstQuantityValue;

    //inherited
    public final DateTimePath<java.util.Date> firstValueAt;

    //inherited
    public final BooleanPath hidden;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath identifier;

    // inherited
    public final QCodespaceEntity identifierCodespace;

    public final SimplePath<org.n52.series.db.beans.data.Data> lastObservation = createSimple("lastObservation", org.n52.series.db.beans.data.Data.class);

    //inherited
    public final NumberPath<java.math.BigDecimal> lastQuantityValue;

    //inherited
    public final DateTimePath<java.util.Date> lastValueAt;

    //inherited
    public final StringPath name;

    // inherited
    public final QCodespaceEntity nameCodespace;

    // inherited
    public final QFormatEntity observationType;

    // inherited
    public final QOfferingEntity offering;

    //inherited
    public final SetPath<org.n52.series.db.beans.parameter.Parameter<?>, org.n52.series.db.beans.parameter.QParameter> parameters;

    // inherited
    public final QPhenomenonEntity phenomenon;

    // inherited
    public final QPlatformEntity platform;

    // inherited
    public final QProcedureEntity procedure;

    //inherited
    public final BooleanPath published;

    public final QUnitEntity unit;

    //inherited
    public final StringPath valueType;

    public final StringPath verticalParameterName = createString("verticalParameterName");

    public QQuantityProfileDatasetEntity(String variable) {
        this(QuantityProfileDatasetEntity.class, forVariable(variable), INITS);
    }

    public QQuantityProfileDatasetEntity(Path<? extends QuantityProfileDatasetEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuantityProfileDatasetEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuantityProfileDatasetEntity(PathMetadata metadata, PathInits inits) {
        this(QuantityProfileDatasetEntity.class, metadata, inits);
    }

    public QQuantityProfileDatasetEntity(Class<? extends QuantityProfileDatasetEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QProfileDatasetEntity(type, metadata, inits);
        this.category = _super.category;
        this.deleted = _super.deleted;
        this.description = _super.description;
        this.disabled = _super.disabled;
        this.feature = _super.feature;
        this.firstQuantityValue = _super.firstQuantityValue;
        this.firstValueAt = _super.firstValueAt;
        this.hidden = _super.hidden;
        this.id = _super.id;
        this.identifier = _super.identifier;
        this.identifierCodespace = _super.identifierCodespace;
        this.lastQuantityValue = _super.lastQuantityValue;
        this.lastValueAt = _super.lastValueAt;
        this.name = _super.name;
        this.nameCodespace = _super.nameCodespace;
        this.observationType = _super.observationType;
        this.offering = _super.offering;
        this.parameters = _super.parameters;
        this.phenomenon = _super.phenomenon;
        this.platform = _super.platform;
        this.procedure = _super.procedure;
        this.published = _super.published;
        this.unit = inits.isInitialized("unit") ? new QUnitEntity(forProperty("unit")) : null;
        this.valueType = _super.valueType;
    }

}

