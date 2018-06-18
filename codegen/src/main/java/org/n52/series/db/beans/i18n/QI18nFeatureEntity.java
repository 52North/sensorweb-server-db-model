package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nFeatureEntity is a Querydsl query type for I18nFeatureEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nFeatureEntity extends EntityPathBase<I18nFeatureEntity> {

    private static final long serialVersionUID = 527022492L;

    public static final QI18nFeatureEntity i18nFeatureEntity = new QI18nFeatureEntity("i18nFeatureEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    // custom
    public final org.n52.series.db.beans.QDescribableEntity entity = new org.n52.series.db.beans.QDescribableEntity(forProperty("entity"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nFeatureEntity(String variable) {
        super(I18nFeatureEntity.class, forVariable(variable));
    }

    public QI18nFeatureEntity(Path<? extends I18nFeatureEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QI18nFeatureEntity(PathMetadata metadata) {
        super(I18nFeatureEntity.class, metadata);
    }

}

