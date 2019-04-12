package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nDataEntity is a Querydsl query type for I18nDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nDataEntity extends EntityPathBase<I18nDataEntity> {

    private static final long serialVersionUID = 59827178L;

    public static final QI18nDataEntity i18nDataEntity = new QI18nDataEntity("i18nDataEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    // custom
    public final org.n52.series.db.beans.QIdEntity entity = new org.n52.series.db.beans.QIdEntity(forProperty("entity"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public final StringPath valueDescription = createString("valueDescription");

    public final StringPath valueName = createString("valueName");

    public QI18nDataEntity(String variable) {
        super(I18nDataEntity.class, forVariable(variable));
    }

    public QI18nDataEntity(Path<? extends I18nDataEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QI18nDataEntity(PathMetadata metadata) {
        super(I18nDataEntity.class, metadata);
    }

}

