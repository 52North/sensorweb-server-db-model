package org.n52.series.db.beans.feature.gml;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVerticalCSEntity is a Querydsl query type for VerticalCSEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVerticalCSEntity extends EntityPathBase<VerticalCSEntity> {

    private static final long serialVersionUID = -518610310L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVerticalCSEntity verticalCSEntity = new QVerticalCSEntity("verticalCSEntity");

    public final org.n52.series.db.beans.feature.QReferenceEntity _super = new org.n52.series.db.beans.feature.QReferenceEntity(this);

    public final StringPath actuate = createString("actuate");

    public final StringPath aggregation = createString("aggregation");

    public final StringPath arcrole = createString("arcrole");

    public final SetPath<CoordinateSystemAxisEntity, QCoordinateSystemAxisEntity> coordinateSystemAxis = this.<CoordinateSystemAxisEntity, QCoordinateSystemAxisEntity>createSet("coordinateSystemAxis", CoordinateSystemAxisEntity.class, QCoordinateSystemAxisEntity.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final StringPath href = createString("href");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final org.n52.series.db.beans.QCodespaceEntity identifierCodespace;

    public final StringPath name = createString("name");

    public final org.n52.series.db.beans.QCodespaceEntity nameCodespace;

    public final StringPath nilReason = createString("nilReason");

    public final StringPath remarks = createString("remarks");

    public final StringPath remoteSchema = createString("remoteSchema");

    public final StringPath role = createString("role");

    public final StringPath show = createString("show");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public QVerticalCSEntity(String variable) {
        this(VerticalCSEntity.class, forVariable(variable), INITS);
    }

    public QVerticalCSEntity(Path<? extends VerticalCSEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVerticalCSEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVerticalCSEntity(PathMetadata metadata, PathInits inits) {
        this(VerticalCSEntity.class, metadata, inits);
    }

    public QVerticalCSEntity(Class<? extends VerticalCSEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.identifierCodespace = inits.isInitialized("identifierCodespace") ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("identifierCodespace")) : null;
        this.nameCodespace = inits.isInitialized("nameCodespace") ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("nameCodespace")) : null;
    }

}

