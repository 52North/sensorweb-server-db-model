package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nEntity is a Querydsl query type for I18nEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QI18nEntity extends EntityPathBase<I18nEntity<?>> {

    private static final long serialVersionUID = -462006752L;

    public static final QI18nEntity i18nEntity = new QI18nEntity("i18nEntity");

    public final QAbstractI18nEntity _super = new QAbstractI18nEntity(this);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QI18nEntity(String variable) {
        super((Class) I18nEntity.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QI18nEntity(Path<? extends I18nEntity> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QI18nEntity(PathMetadata metadata) {
        super((Class) I18nEntity.class, metadata);
    }

}

