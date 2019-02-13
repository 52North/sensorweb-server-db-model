package org.n52.series.db.beans.sta;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDatastreamEntity is a Querydsl query type for DatastreamEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDatastreamEntity extends EntityPathBase<DatastreamEntity> {

    private static final long serialVersionUID = 1449703212L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDatastreamEntity datastreamEntity = new QDatastreamEntity("datastreamEntity");

    public final QAbstractNameDescriptionStaEntity _super = new QAbstractNameDescriptionStaEntity(this);

    public final SetPath<org.n52.series.db.beans.DatasetEntity, org.n52.series.db.beans.QDatasetEntity> datasets = this.<org.n52.series.db.beans.DatasetEntity, org.n52.series.db.beans.QDatasetEntity>createSet("datasets", org.n52.series.db.beans.DatasetEntity.class, org.n52.series.db.beans.QDatasetEntity.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.QGeometryEntity geometryEntity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final org.n52.series.db.beans.QPhenomenonEntity observableProperty;

    public final org.n52.series.db.beans.QFormatEntity observationType;

    public final org.n52.series.db.beans.QProcedureEntity procedure;

    public final DateTimePath<java.util.Date> resultTimeEnd = createDateTime("resultTimeEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> resultTimeStart = createDateTime("resultTimeStart", java.util.Date.class);

    public final DateTimePath<java.util.Date> samplingTimeEnd = createDateTime("samplingTimeEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> samplingTimeStart = createDateTime("samplingTimeStart", java.util.Date.class);

    public final org.n52.series.db.beans.QPlatformEntity thing;

    public final org.n52.series.db.beans.QUnitEntity unitOfMeasurement;

    public QDatastreamEntity(String variable) {
        this(DatastreamEntity.class, forVariable(variable), INITS);
    }

    public QDatastreamEntity(Path<? extends DatastreamEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDatastreamEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDatastreamEntity(PathMetadata metadata, PathInits inits) {
        this(DatastreamEntity.class, metadata, inits);
    }

    public QDatastreamEntity(Class<? extends DatastreamEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.geometryEntity = inits.isInitialized("geometryEntity") ? new org.n52.series.db.beans.QGeometryEntity(forProperty("geometryEntity")) : null;
        this.observableProperty = inits.isInitialized("observableProperty") ? new org.n52.series.db.beans.QPhenomenonEntity(forProperty("observableProperty"), inits.get("observableProperty")) : null;
        this.observationType = inits.isInitialized("observationType") ? new org.n52.series.db.beans.QFormatEntity(forProperty("observationType")) : null;
        this.procedure = inits.isInitialized("procedure") ? new org.n52.series.db.beans.QProcedureEntity(forProperty("procedure")) : null;
        this.thing = inits.isInitialized("thing") ? new org.n52.series.db.beans.QPlatformEntity(forProperty("thing"), inits.get("thing")) : null;
        this.unitOfMeasurement = inits.isInitialized("unitOfMeasurement") ? new org.n52.series.db.beans.QUnitEntity(forProperty("unitOfMeasurement")) : null;
    }

}

