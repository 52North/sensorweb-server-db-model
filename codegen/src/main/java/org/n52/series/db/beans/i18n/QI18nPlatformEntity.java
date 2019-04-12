package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nPlatformEntity is a Querydsl query type for I18nPlatformEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nPlatformEntity extends EntityPathBase<I18nPlatformEntity> {

    private static final long serialVersionUID = 1561574259L;

    public static final QI18nPlatformEntity i18nPlatformEntity = new QI18nPlatformEntity("i18nPlatformEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    // custom
    public final org.n52.series.db.beans.QIdEntity entity = new org.n52.series.db.beans.QIdEntity(forProperty("entity"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nPlatformEntity(String variable) {
        super(I18nPlatformEntity.class, forVariable(variable));
    }

    public QI18nPlatformEntity(Path<? extends I18nPlatformEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QI18nPlatformEntity(PathMetadata metadata) {
        super(I18nPlatformEntity.class, metadata);
    }

    public QI18nPlatformEntity(PathMetadata metadata, PathInits inits) {
        this(I18nPlatformEntity.class, metadata, inits);
    }

    public QI18nPlatformEntity(Class<? extends I18nPlatformEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.entity = inits.isInitialized("entity") ? new org.n52.series.db.beans.QPlatformEntity(forProperty("entity"), inits.get("entity")) : null;
    }

}

