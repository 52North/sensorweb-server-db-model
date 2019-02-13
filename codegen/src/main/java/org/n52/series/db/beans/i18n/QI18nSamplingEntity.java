package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QI18nSamplingEntity is a Querydsl query type for I18nSamplingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nSamplingEntity extends EntityPathBase<I18nSamplingEntity> {

    private static final long serialVersionUID = 788577255L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QI18nSamplingEntity i18nSamplingEntity = new QI18nSamplingEntity("i18nSamplingEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.sampling.QSamplingEntity entity;

    public final StringPath environmentalConditions = createString("environmentalConditions");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public final StringPath samplingMethod = createString("samplingMethod");

    public QI18nSamplingEntity(String variable) {
        this(I18nSamplingEntity.class, forVariable(variable), INITS);
    }

    public QI18nSamplingEntity(Path<? extends I18nSamplingEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QI18nSamplingEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QI18nSamplingEntity(PathMetadata metadata, PathInits inits) {
        this(I18nSamplingEntity.class, metadata, inits);
    }

    public QI18nSamplingEntity(Class<? extends I18nSamplingEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.entity = inits.isInitialized("entity") ? new org.n52.series.db.beans.sampling.QSamplingEntity(forProperty("entity"), inits.get("entity")) : null;
    }

}

