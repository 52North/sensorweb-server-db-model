package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProcedureEntity is a Querydsl query type for ProcedureEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProcedureEntity extends EntityPathBase<ProcedureEntity> {

    private static final long serialVersionUID = 819484933L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProcedureEntity procedureEntity = new QProcedureEntity("procedureEntity");

    public final QHierarchicalEntity _super = new QHierarchicalEntity(this);

    public final BooleanPath aggregation = createBoolean("aggregation");

    public final SetPath<ProcedureEntity, QProcedureEntity> children = this.<ProcedureEntity, QProcedureEntity>createSet("children", ProcedureEntity.class, QProcedureEntity.class, PathInits.DIRECT2);

    public final BooleanPath deleted = createBoolean("deleted");

    public final StringPath description = createString("description");

    public final StringPath descriptionFile = createString("descriptionFile");

    public final QFormatEntity format;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final QCodespaceEntity identifierCodespace;

    public final BooleanPath insitu = createBoolean("insitu");

    public final BooleanPath mobile = createBoolean("mobile");

    public final StringPath name = createString("name");

    public final QCodespaceEntity nameCodespace;

    public final SetPath<ProcedureEntity, QProcedureEntity> parents = this.<ProcedureEntity, QProcedureEntity>createSet("parents", ProcedureEntity.class, QProcedureEntity.class, PathInits.DIRECT2);

    public final SetPath<ProcedureHistoryEntity, QProcedureHistoryEntity> procedureHistory = this.<ProcedureHistoryEntity, QProcedureHistoryEntity>createSet("procedureHistory", ProcedureHistoryEntity.class, QProcedureHistoryEntity.class, PathInits.DIRECT2);

    public final BooleanPath reference = createBoolean("reference");

    public final SetPath<org.n52.series.db.beans.i18n.I18nProcedureEntity, org.n52.series.db.beans.i18n.QI18nProcedureEntity> translations = this.<org.n52.series.db.beans.i18n.I18nProcedureEntity, org.n52.series.db.beans.i18n.QI18nProcedureEntity>createSet("translations", org.n52.series.db.beans.i18n.I18nProcedureEntity.class, org.n52.series.db.beans.i18n.QI18nProcedureEntity.class, PathInits.DIRECT2);

    public final QProcedureEntity typeOf;

    public QProcedureEntity(String variable) {
        this(ProcedureEntity.class, forVariable(variable), INITS);
    }

    public QProcedureEntity(Path<? extends ProcedureEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProcedureEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProcedureEntity(PathMetadata metadata, PathInits inits) {
        this(ProcedureEntity.class, metadata, inits);
    }

    public QProcedureEntity(Class<? extends ProcedureEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.format = inits.isInitialized("format") ? new QFormatEntity(forProperty("format")) : null;
        this.identifierCodespace = inits.isInitialized("identifierCodespace") ? new QCodespaceEntity(forProperty("identifierCodespace")) : null;
        this.nameCodespace = inits.isInitialized("nameCodespace") ? new QCodespaceEntity(forProperty("nameCodespace")) : null;
        this.typeOf = inits.isInitialized("typeOf") ? new QProcedureEntity(forProperty("typeOf"), inits.get("typeOf")) : null;
    }

}

