package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QI18nVerticalMetadataEntity is a Querydsl query type for I18nVerticalMetadataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nVerticalMetadataEntity extends EntityPathBase<I18nVerticalMetadataEntity> {

    private static final long serialVersionUID = 121712965L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QI18nVerticalMetadataEntity i18nVerticalMetadataEntity = new QI18nVerticalMetadataEntity("i18nVerticalMetadataEntity");

    public final QAbstractI18nEntity _super = new QAbstractI18nEntity(this);

    public final org.n52.series.db.beans.QVerticalMetadataEntity entity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath verticalFromName = createString("verticalFromName");

    public final StringPath verticalOriginName = createString("verticalOriginName");

    public final StringPath verticalToName = createString("verticalToName");

    public QI18nVerticalMetadataEntity(String variable) {
        this(I18nVerticalMetadataEntity.class, forVariable(variable), INITS);
    }

    public QI18nVerticalMetadataEntity(Path<? extends I18nVerticalMetadataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QI18nVerticalMetadataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QI18nVerticalMetadataEntity(PathMetadata metadata, PathInits inits) {
        this(I18nVerticalMetadataEntity.class, metadata, inits);
    }

    public QI18nVerticalMetadataEntity(Class<? extends I18nVerticalMetadataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.entity = inits.isInitialized("entity") ? new org.n52.series.db.beans.QVerticalMetadataEntity(forProperty("entity"), inits.get("entity")) : null;
    }

}

