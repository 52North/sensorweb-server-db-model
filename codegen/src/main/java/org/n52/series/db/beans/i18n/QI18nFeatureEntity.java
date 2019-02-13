package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QI18nFeatureEntity is a Querydsl query type for I18nFeatureEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nFeatureEntity extends EntityPathBase<I18nFeatureEntity> {

    private static final long serialVersionUID = 527022492L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QI18nFeatureEntity i18nFeatureEntity = new QI18nFeatureEntity("i18nFeatureEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.QFeatureEntity entity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nFeatureEntity(String variable) {
        this(I18nFeatureEntity.class, forVariable(variable), INITS);
    }

    public QI18nFeatureEntity(Path<? extends I18nFeatureEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QI18nFeatureEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QI18nFeatureEntity(PathMetadata metadata, PathInits inits) {
        this(I18nFeatureEntity.class, metadata, inits);
    }

    public QI18nFeatureEntity(Class<? extends I18nFeatureEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.entity = inits.isInitialized("entity") ? new org.n52.series.db.beans.QFeatureEntity(forProperty("entity"), inits.get("entity")) : null;
    }

}

