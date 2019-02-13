package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBlobDataEntity is a Querydsl query type for BlobDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBlobDataEntity extends EntityPathBase<BlobDataEntity> {

    private static final long serialVersionUID = -1512715941L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBlobDataEntity blobDataEntity = new QBlobDataEntity("blobDataEntity");

    public final QDataEntity _super;

    // inherited
    public final QDatasetEntity dataset;

    //inherited
    public final BooleanPath deleted;

    //inherited
    public final StringPath description;

    // inherited
    public final org.n52.series.db.beans.ereporting.QEReportingProfileDataEntity ereportingProfile;

    // inherited
    public final QGeometryEntity geometryEntity;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath identifier;

    // inherited
    public final QCodespaceEntity identifierCodespace;

    //inherited
    public final StringPath name;

    // inherited
    public final QCodespaceEntity nameCodespace;

    //inherited
    public final SetPath<org.n52.series.db.beans.parameter.ParameterEntity<?>, org.n52.series.db.beans.parameter.QParameterEntity> parameters;

    //inherited
    public final NumberPath<Long> parent;

    //inherited
    public final SetPath<RelatedDataEntity, QRelatedDataEntity> relatedObservations;

    //inherited
    public final DateTimePath<java.util.Date> resultTime;

    //inherited
    public final DateTimePath<java.util.Date> samplingTimeEnd;

    //inherited
    public final DateTimePath<java.util.Date> samplingTimeStart;

    //inherited
    public final SetPath<org.n52.series.db.beans.i18n.I18nDataEntity, org.n52.series.db.beans.i18n.QI18nDataEntity> translations;

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
    public final NumberPath<java.math.BigDecimal> verticalFrom;

    //inherited
    public final NumberPath<java.math.BigDecimal> verticalTo;

    public QBlobDataEntity(String variable) {
        this(BlobDataEntity.class, forVariable(variable), INITS);
    }

    public QBlobDataEntity(Path<? extends BlobDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBlobDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBlobDataEntity(PathMetadata metadata, PathInits inits) {
        this(BlobDataEntity.class, metadata, inits);
    }

    public QBlobDataEntity(Class<? extends BlobDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QDataEntity(type, metadata, inits);
        this.dataset = _super.dataset;
        this.deleted = _super.deleted;
        this.description = _super.description;
        this.ereportingProfile = _super.ereportingProfile;
        this.geometryEntity = _super.geometryEntity;
        this.id = _super.id;
        this.identifier = _super.identifier;
        this.identifierCodespace = _super.identifierCodespace;
        this.name = _super.name;
        this.nameCodespace = _super.nameCodespace;
        this.parameters = _super.parameters;
        this.parent = _super.parent;
        this.relatedObservations = _super.relatedObservations;
        this.resultTime = _super.resultTime;
        this.samplingTimeEnd = _super.samplingTimeEnd;
        this.samplingTimeStart = _super.samplingTimeStart;
        this.translations = _super.translations;
        this.validTimeEnd = _super.validTimeEnd;
        this.validTimeStart = _super.validTimeStart;
        this.valueDescription = _super.valueDescription;
        this.valueIdentifier = _super.valueIdentifier;
        this.valueName = _super.valueName;
        this.verticalFrom = _super.verticalFrom;
        this.verticalTo = _super.verticalTo;
    }

}

