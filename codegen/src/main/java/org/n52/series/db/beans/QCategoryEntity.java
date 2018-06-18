package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategoryEntity is a Querydsl query type for CategoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategoryEntity extends EntityPathBase<CategoryEntity> {

    private static final long serialVersionUID = -724280270L;

    public static final QCategoryEntity categoryEntity = new QCategoryEntity("categoryEntity");

    public final QDescribableEntity _super = new QDescribableEntity(this);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final StringPath name = createString("name");

    public final SetPath<org.n52.series.db.beans.i18n.I18nCategoryEntity, org.n52.series.db.beans.i18n.QI18nCategoryEntity> translations = this.<org.n52.series.db.beans.i18n.I18nCategoryEntity, org.n52.series.db.beans.i18n.QI18nCategoryEntity>createSet("translations", org.n52.series.db.beans.i18n.I18nCategoryEntity.class, org.n52.series.db.beans.i18n.QI18nCategoryEntity.class, PathInits.DIRECT2);

    public QCategoryEntity(String variable) {
        super(CategoryEntity.class, forVariable(variable));
    }

    public QCategoryEntity(Path<? extends CategoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategoryEntity(PathMetadata metadata) {
        super(CategoryEntity.class, metadata);
    }

}

