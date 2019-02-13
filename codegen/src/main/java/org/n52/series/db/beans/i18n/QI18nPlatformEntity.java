package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QI18nPlatformEntity is a Querydsl query type for I18nPlatformEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nPlatformEntity extends EntityPathBase<I18nPlatformEntity> {

    private static final long serialVersionUID = 1561574259L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QI18nPlatformEntity i18nPlatformEntity = new QI18nPlatformEntity("i18nPlatformEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.QPlatformEntity entity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nPlatformEntity(String variable) {
        this(I18nPlatformEntity.class, forVariable(variable), INITS);
    }

    public QI18nPlatformEntity(Path<? extends I18nPlatformEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QI18nPlatformEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QI18nPlatformEntity(PathMetadata metadata, PathInits inits) {
        this(I18nPlatformEntity.class, metadata, inits);
    }

    public QI18nPlatformEntity(Class<? extends I18nPlatformEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.entity = inits.isInitialized("entity") ? new org.n52.series.db.beans.QPlatformEntity(forProperty("entity")) : null;
    }

}

