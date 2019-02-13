package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QI18nProcedureEntity is a Querydsl query type for I18nProcedureEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nProcedureEntity extends EntityPathBase<I18nProcedureEntity> {

    private static final long serialVersionUID = 530344697L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QI18nProcedureEntity i18nProcedureEntity = new QI18nProcedureEntity("i18nProcedureEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.QProcedureEntity entity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath longName = createString("longName");

    public final StringPath name = createString("name");

    public final StringPath shortName = createString("shortName");

    public QI18nProcedureEntity(String variable) {
        this(I18nProcedureEntity.class, forVariable(variable), INITS);
    }

    public QI18nProcedureEntity(Path<? extends I18nProcedureEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QI18nProcedureEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QI18nProcedureEntity(PathMetadata metadata, PathInits inits) {
        this(I18nProcedureEntity.class, metadata, inits);
    }

    public QI18nProcedureEntity(Class<? extends I18nProcedureEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.entity = inits.isInitialized("entity") ? new org.n52.series.db.beans.QProcedureEntity(forProperty("entity")) : null;
    }

}

