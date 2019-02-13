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

    public static final QProcedureEntity procedureEntity = new QProcedureEntity("procedureEntity");

    public final QHierarchicalEntity _super = new QHierarchicalEntity(this);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final StringPath name = createString("name");

    public final BooleanPath reference = createBoolean("reference");

    public final SetPath<org.n52.series.db.beans.i18n.I18nProcedureEntity, org.n52.series.db.beans.i18n.QI18nProcedureEntity> translations = this.<org.n52.series.db.beans.i18n.I18nProcedureEntity, org.n52.series.db.beans.i18n.QI18nProcedureEntity>createSet("translations", org.n52.series.db.beans.i18n.I18nProcedureEntity.class, org.n52.series.db.beans.i18n.QI18nProcedureEntity.class, PathInits.DIRECT2);

    public QProcedureEntity(String variable) {
        super(ProcedureEntity.class, forVariable(variable));
    }

    public QProcedureEntity(Path<? extends ProcedureEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProcedureEntity(PathMetadata metadata) {
        super(ProcedureEntity.class, metadata);
    }

}

