package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nSamplingEntity is a Querydsl query type for I18nSamplingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nSamplingEntity extends EntityPathBase<I18nSamplingEntity> {

    private static final long serialVersionUID = 788577255L;

    public static final QI18nSamplingEntity i18nSamplingEntity = new QI18nSamplingEntity("i18nSamplingEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    // custom
    public final org.n52.series.db.beans.QIdEntity entity = new org.n52.series.db.beans.QIdEntity(forProperty("entity"));

    public final StringPath environmentalConditions = createString("environmentalConditions");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public final StringPath samplingMethod = createString("samplingMethod");

    public QI18nSamplingEntity(String variable) {
        super(I18nSamplingEntity.class, forVariable(variable));
    }

    public QI18nSamplingEntity(Path<? extends I18nSamplingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QI18nSamplingEntity(PathMetadata metadata) {
        super(I18nSamplingEntity.class, metadata);
    }

}

