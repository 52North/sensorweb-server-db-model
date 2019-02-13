package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProcedureHistoryEntity is a Querydsl query type for ProcedureHistoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProcedureHistoryEntity extends EntityPathBase<ProcedureHistoryEntity> {

    private static final long serialVersionUID = 1272043061L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProcedureHistoryEntity procedureHistoryEntity = new QProcedureHistoryEntity("procedureHistoryEntity");

    public final QIdEntity _super = new QIdEntity(this);

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final QFormatEntity format;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProcedureEntity procedure;

    public final DateTimePath<java.util.Date> startTime = createDateTime("startTime", java.util.Date.class);

    public final StringPath xml = createString("xml");

    public QProcedureHistoryEntity(String variable) {
        this(ProcedureHistoryEntity.class, forVariable(variable), INITS);
    }

    public QProcedureHistoryEntity(Path<? extends ProcedureHistoryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProcedureHistoryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProcedureHistoryEntity(PathMetadata metadata, PathInits inits) {
        this(ProcedureHistoryEntity.class, metadata, inits);
    }

    public QProcedureHistoryEntity(Class<? extends ProcedureHistoryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.format = inits.isInitialized("format") ? new QFormatEntity(forProperty("format")) : null;
        this.procedure = inits.isInitialized("procedure") ? new QProcedureEntity(forProperty("procedure")) : null;
    }

}

