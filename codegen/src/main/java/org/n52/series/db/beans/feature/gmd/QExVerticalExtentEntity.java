package org.n52.series.db.beans.feature.gmd;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QExVerticalExtentEntity is a Querydsl query type for ExVerticalExtentEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExVerticalExtentEntity extends EntityPathBase<ExVerticalExtentEntity> {

    private static final long serialVersionUID = 1286508655L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QExVerticalExtentEntity exVerticalExtentEntity = new QExVerticalExtentEntity("exVerticalExtentEntity");

    public final QAbstractCiEntity _super = new QAbstractCiEntity(this);

    public final StringPath actuate = createString("actuate");

    public final StringPath arcrole = createString("arcrole");

    public final StringPath gmdid = createString("gmdid");

    public final StringPath href = createString("href");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> maximumValue = createNumber("maximumValue", Double.class);

    public final NumberPath<Double> minimumValue = createNumber("minimumValue", Double.class);

    public final StringPath nilReason = createString("nilReason");

    public final StringPath remoteSchema = createString("remoteSchema");

    public final StringPath role = createString("role");

    public final StringPath show = createString("show");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final StringPath uuid = createString("uuid");

    public final org.n52.series.db.beans.feature.gml.QVerticalCRSEntity verticalCRS;

    public QExVerticalExtentEntity(String variable) {
        this(ExVerticalExtentEntity.class, forVariable(variable), INITS);
    }

    public QExVerticalExtentEntity(Path<? extends ExVerticalExtentEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QExVerticalExtentEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QExVerticalExtentEntity(PathMetadata metadata, PathInits inits) {
        this(ExVerticalExtentEntity.class, metadata, inits);
    }

    public QExVerticalExtentEntity(Class<? extends ExVerticalExtentEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.verticalCRS = inits.isInitialized("verticalCRS") ? new org.n52.series.db.beans.feature.gml.QVerticalCRSEntity(forProperty("verticalCRS"), inits.get("verticalCRS")) : null;
    }

}

