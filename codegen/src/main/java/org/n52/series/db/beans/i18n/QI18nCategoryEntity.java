package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nCategoryEntity is a Querydsl query type for I18nCategoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nCategoryEntity extends EntityPathBase<I18nCategoryEntity> {

    private static final long serialVersionUID = -317965378L;

    public static final QI18nCategoryEntity i18nCategoryEntity = new QI18nCategoryEntity("i18nCategoryEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    // custom
    public final org.n52.series.db.beans.QDescribableEntity entity = new org.n52.series.db.beans.QDescribableEntity(forProperty("entity"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nCategoryEntity(String variable) {
        super(I18nCategoryEntity.class, forVariable(variable));
    }

    public QI18nCategoryEntity(Path<? extends I18nCategoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QI18nCategoryEntity(PathMetadata metadata) {
        super(I18nCategoryEntity.class, metadata);
    }

}

