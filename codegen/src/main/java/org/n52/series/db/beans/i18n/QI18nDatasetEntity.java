package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nDatasetEntity is a Querydsl query type for I18nDatasetEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nDatasetEntity extends EntityPathBase<I18nDatasetEntity<? extends org.n52.series.db.beans.DescribableEntity>> {

    private static final long serialVersionUID = -1180153442L;

    public static final QI18nDatasetEntity i18nDatasetEntity = new QI18nDatasetEntity("i18nDatasetEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    // custom
    public final org.n52.series.db.beans.QIdEntity entity = new org.n52.series.db.beans.QIdEntity(forProperty("entity"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QI18nDatasetEntity(String variable) {
        super((Class) I18nDatasetEntity.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QI18nDatasetEntity(Path<? extends I18nDatasetEntity> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QI18nDatasetEntity(PathMetadata metadata) {
        super((Class) I18nDatasetEntity.class, metadata);
    }

}

