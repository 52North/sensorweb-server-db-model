package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nMeasuringProgramEntity is a Querydsl query type for I18nMeasuringProgramEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nMeasuringProgramEntity extends EntityPathBase<I18nMeasuringProgramEntity> {

    private static final long serialVersionUID = -1114245911L;

    public static final QI18nMeasuringProgramEntity i18nMeasuringProgramEntity = new QI18nMeasuringProgramEntity("i18nMeasuringProgramEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    // custom
    public final org.n52.series.db.beans.QIdEntity entity = new org.n52.series.db.beans.QIdEntity(forProperty("entity"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nMeasuringProgramEntity(String variable) {
        super(I18nMeasuringProgramEntity.class, forVariable(variable));
    }

    public QI18nMeasuringProgramEntity(Path<? extends I18nMeasuringProgramEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QI18nMeasuringProgramEntity(PathMetadata metadata) {
        super(I18nMeasuringProgramEntity.class, metadata);
    }

}

