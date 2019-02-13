package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QI18nPhenomenonEntity is a Querydsl query type for I18nPhenomenonEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nPhenomenonEntity extends EntityPathBase<I18nPhenomenonEntity> {

    private static final long serialVersionUID = -217252921L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QI18nPhenomenonEntity i18nPhenomenonEntity = new QI18nPhenomenonEntity("i18nPhenomenonEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.QPhenomenonEntity entity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nPhenomenonEntity(String variable) {
        this(I18nPhenomenonEntity.class, forVariable(variable), INITS);
    }

    public QI18nPhenomenonEntity(Path<? extends I18nPhenomenonEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QI18nPhenomenonEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QI18nPhenomenonEntity(PathMetadata metadata, PathInits inits) {
        this(I18nPhenomenonEntity.class, metadata, inits);
    }

    public QI18nPhenomenonEntity(Class<? extends I18nPhenomenonEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.entity = inits.isInitialized("entity") ? new org.n52.series.db.beans.QPhenomenonEntity(forProperty("entity"), inits.get("entity")) : null;
    }

}

