package org.n52.series.db.beans.ereporting;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEReportingStationEntity is a Querydsl query type for EReportingStationEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEReportingStationEntity extends EntityPathBase<EReportingStationEntity> {

    private static final long serialVersionUID = -630265638L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEReportingStationEntity eReportingStationEntity = new QEReportingStationEntity("eReportingStationEntity");

    public final org.n52.series.db.beans.QDescribableEntity _super = new org.n52.series.db.beans.QDescribableEntity(this);

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.QGeometryEntity geometryEntity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final org.n52.series.db.beans.QCodespaceEntity identifierCodespace;

    public final StringPath name = createString("name");

    public final org.n52.series.db.beans.QCodespaceEntity nameCodespace;

    public QEReportingStationEntity(String variable) {
        this(EReportingStationEntity.class, forVariable(variable), INITS);
    }

    public QEReportingStationEntity(Path<? extends EReportingStationEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEReportingStationEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEReportingStationEntity(PathMetadata metadata, PathInits inits) {
        this(EReportingStationEntity.class, metadata, inits);
    }

    public QEReportingStationEntity(Class<? extends EReportingStationEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.geometryEntity = inits.isInitialized("geometryEntity") ? new org.n52.series.db.beans.QGeometryEntity(forProperty("geometryEntity")) : null;
        this.identifierCodespace = inits.isInitialized("identifierCodespace") ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("identifierCodespace")) : null;
        this.nameCodespace = inits.isInitialized("nameCodespace") ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("nameCodespace")) : null;
    }

}

