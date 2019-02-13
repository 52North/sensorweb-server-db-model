package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QI18nOfferingEntity is a Querydsl query type for I18nOfferingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nOfferingEntity extends EntityPathBase<I18nOfferingEntity> {

    private static final long serialVersionUID = 1847732422L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QI18nOfferingEntity i18nOfferingEntity = new QI18nOfferingEntity("i18nOfferingEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.QOfferingEntity entity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nOfferingEntity(String variable) {
        this(I18nOfferingEntity.class, forVariable(variable), INITS);
    }

    public QI18nOfferingEntity(Path<? extends I18nOfferingEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QI18nOfferingEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QI18nOfferingEntity(PathMetadata metadata, PathInits inits) {
        this(I18nOfferingEntity.class, metadata, inits);
    }

    public QI18nOfferingEntity(Class<? extends I18nOfferingEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.entity = inits.isInitialized("entity") ? new org.n52.series.db.beans.QOfferingEntity(forProperty("entity"), inits.get("entity")) : null;
    }

}

