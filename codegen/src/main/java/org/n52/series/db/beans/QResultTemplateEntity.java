package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResultTemplateEntity is a Querydsl query type for ResultTemplateEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResultTemplateEntity extends EntityPathBase<ResultTemplateEntity> {

    private static final long serialVersionUID = -1991068821L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResultTemplateEntity resultTemplateEntity = new QResultTemplateEntity("resultTemplateEntity");

    public final QIdEntity _super = new QIdEntity(this);

    public final StringPath encoding = createString("encoding");

    // custom
    public final QAbstractFeatureEntity feature = new QAbstractFeatureEntity(forProperty("feature"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final QOfferingEntity offering;

    public final QPhenomenonEntity phenomenon;

    public final QProcedureEntity procedure;

    public final StringPath structure = createString("structure");

    public QResultTemplateEntity(String variable) {
        this(ResultTemplateEntity.class, forVariable(variable), INITS);
    }

    public QResultTemplateEntity(Path<? extends ResultTemplateEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResultTemplateEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResultTemplateEntity(PathMetadata metadata, PathInits inits) {
        this(ResultTemplateEntity.class, metadata, inits);
    }

    public QResultTemplateEntity(Class<? extends ResultTemplateEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.offering = inits.isInitialized("offering") ? new QOfferingEntity(forProperty("offering"), inits.get("offering")) : null;
        this.phenomenon = inits.isInitialized("phenomenon") ? new QPhenomenonEntity(forProperty("phenomenon"), inits.get("phenomenon")) : null;
        this.procedure = inits.isInitialized("procedure") ? new QProcedureEntity(forProperty("procedure")) : null;
    }

}

