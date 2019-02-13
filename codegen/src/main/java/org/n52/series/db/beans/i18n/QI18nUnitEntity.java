package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QI18nUnitEntity is a Querydsl query type for I18nUnitEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nUnitEntity extends EntityPathBase<I18nUnitEntity> {

    private static final long serialVersionUID = 978616900L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QI18nUnitEntity i18nUnitEntity = new QI18nUnitEntity("i18nUnitEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final org.n52.series.db.beans.QUnitEntity entity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nUnitEntity(String variable) {
        this(I18nUnitEntity.class, forVariable(variable), INITS);
    }

    public QI18nUnitEntity(Path<? extends I18nUnitEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QI18nUnitEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QI18nUnitEntity(PathMetadata metadata, PathInits inits) {
        this(I18nUnitEntity.class, metadata, inits);
    }

    public QI18nUnitEntity(Class<? extends I18nUnitEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.entity = inits.isInitialized("entity") ? new org.n52.series.db.beans.QUnitEntity(forProperty("entity")) : null;
    }

}

