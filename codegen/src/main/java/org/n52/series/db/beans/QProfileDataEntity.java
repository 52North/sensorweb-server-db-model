package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.SetPath;
import com.querydsl.core.types.dsl.StringPath;


/**
 * QProfileDataEntity is a Querydsl query type for ProfileDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProfileDataEntity extends EntityPathBase<ProfileDataEntity> {

    private static final long serialVersionUID = -2021503131L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProfileDataEntity profileDataEntity = new QProfileDataEntity("profileDataEntity");

    public final QCompositeDataEntity _super;

    //inherited
    public final BooleanPath child;

    // inherited
    public final QDatasetEntity dataset;

    //inherited
    public final BooleanPath deleted;

    //inherited
    public final StringPath description;

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
    public final SetPath<org.n52.series.db.beans.parameter.Parameter<?>, org.n52.series.db.beans.parameter.QParameter> parameters;

    //inherited
    public final BooleanPath parent;

    //inherited
    public final SetPath<RelatedDataEntity, QRelatedDataEntity> relatedObservations;

    //inherited
    public final DateTimePath<java.util.Date> resultTime;

    //inherited
    public final DateTimePath<java.util.Date> samplingTimeEnd;

    //inherited
    public final DateTimePath<java.util.Date> samplingTimeStart;

    //inherited
    public final DateTimePath<java.util.Date> validTimeEnd;

    //inherited
    public final DateTimePath<java.util.Date> validTimeStart;

    public final SetPath<DataEntity<?>, QDataEntity> value = this.<DataEntity<?>, QDataEntity>createSet("value", DataEntity.class, QDataEntity.class, PathInits.DIRECT2);

    //inherited
    public final StringPath valueDescription;

    //inherited
    public final StringPath valueIdentifier;

    //inherited
    public final StringPath valueName;

    //inherited
    public final NumberPath<java.math.BigDecimal> verticalFrom;

    public final StringPath verticalFromName = createString("verticalFromName");

    //inherited
    public final NumberPath<java.math.BigDecimal> verticalTo;

    public final StringPath verticalToName = createString("verticalToName");

    public final QUnitEntity verticalUnit;

    public QProfileDataEntity(String variable) {
        this(ProfileDataEntity.class, forVariable(variable), INITS);
    }

    public QProfileDataEntity(Path<? extends ProfileDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProfileDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProfileDataEntity(PathMetadata metadata, PathInits inits) {
        this(ProfileDataEntity.class, metadata, inits);
    }

    public QProfileDataEntity(Class<? extends ProfileDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QCompositeDataEntity(type, metadata, inits);
        this.child = _super.child;
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
        this.relatedObservations = _super.relatedObservations;
        this.resultTime = _super.resultTime;
        this.samplingTimeEnd = _super.samplingTimeEnd;
        this.samplingTimeStart = _super.samplingTimeStart;
        this.validTimeEnd = _super.validTimeEnd;
        this.validTimeStart = _super.validTimeStart;
        this.valueDescription = _super.valueDescription;
        this.valueIdentifier = _super.valueIdentifier;
        this.valueName = _super.valueName;
        this.verticalFrom = _super.verticalFrom;
        this.verticalTo = _super.verticalTo;
        this.verticalUnit = inits.isInitialized("verticalUnit") ? new QUnitEntity(forProperty("verticalUnit")) : null;
    }

}

