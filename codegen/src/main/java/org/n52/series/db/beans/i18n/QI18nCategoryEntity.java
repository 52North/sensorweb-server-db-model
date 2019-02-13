package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QI18nCategoryEntity is a Querydsl query type for I18nCategoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nCategoryEntity extends EntityPathBase<I18nCategoryEntity> {

    private static final long serialVersionUID = -317965378L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QI18nCategoryEntity i18nCategoryEntity = new QI18nCategoryEntity("i18nCategoryEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.QCategoryEntity entity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nCategoryEntity(String variable) {
        this(I18nCategoryEntity.class, forVariable(variable), INITS);
    }

    public QI18nCategoryEntity(Path<? extends I18nCategoryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QI18nCategoryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QI18nCategoryEntity(PathMetadata metadata, PathInits inits) {
        this(I18nCategoryEntity.class, metadata, inits);
    }

    public QI18nCategoryEntity(Class<? extends I18nCategoryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.entity = inits.isInitialized("entity") ? new org.n52.series.db.beans.QCategoryEntity(forProperty("entity")) : null;
    }

}

