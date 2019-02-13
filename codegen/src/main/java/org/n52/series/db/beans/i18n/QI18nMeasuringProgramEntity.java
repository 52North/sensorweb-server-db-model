package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QI18nMeasuringProgramEntity is a Querydsl query type for I18nMeasuringProgramEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nMeasuringProgramEntity extends EntityPathBase<I18nMeasuringProgramEntity> {

    private static final long serialVersionUID = -1114245911L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QI18nMeasuringProgramEntity i18nMeasuringProgramEntity = new QI18nMeasuringProgramEntity("i18nMeasuringProgramEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.sampling.QMeasuringProgramEntity entity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nMeasuringProgramEntity(String variable) {
        this(I18nMeasuringProgramEntity.class, forVariable(variable), INITS);
    }

    public QI18nMeasuringProgramEntity(Path<? extends I18nMeasuringProgramEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QI18nMeasuringProgramEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QI18nMeasuringProgramEntity(PathMetadata metadata, PathInits inits) {
        this(I18nMeasuringProgramEntity.class, metadata, inits);
    }

    public QI18nMeasuringProgramEntity(Class<? extends I18nMeasuringProgramEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.entity = inits.isInitialized("entity") ? new org.n52.series.db.beans.sampling.QMeasuringProgramEntity(forProperty("entity")) : null;
    }

}

