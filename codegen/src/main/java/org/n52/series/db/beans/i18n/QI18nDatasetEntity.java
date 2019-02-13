package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QI18nDatasetEntity is a Querydsl query type for I18nDatasetEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nDatasetEntity extends EntityPathBase<I18nDatasetEntity<? extends org.n52.series.db.beans.DescribableEntity>> {

    private static final long serialVersionUID = -1180153442L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QI18nDatasetEntity i18nDatasetEntity = new QI18nDatasetEntity("i18nDatasetEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.QDatasetEntity entity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QI18nDatasetEntity(String variable) {
        this((Class) I18nDatasetEntity.class, forVariable(variable), INITS);
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QI18nDatasetEntity(Path<? extends I18nDatasetEntity> path) {
        this((Class) path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QI18nDatasetEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QI18nDatasetEntity(PathMetadata metadata, PathInits inits) {
        this((Class) I18nDatasetEntity.class, metadata, inits);
    }

    public QI18nDatasetEntity(Class<? extends I18nDatasetEntity<? extends org.n52.series.db.beans.DescribableEntity>> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.entity = inits.isInitialized("entity") ? new org.n52.series.db.beans.QDatasetEntity(forProperty("entity"), inits.get("entity")) : null;
    }

}

