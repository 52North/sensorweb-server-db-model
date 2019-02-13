package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractI18nEntity is a Querydsl query type for AbstractI18nEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractI18nEntity extends EntityPathBase<AbstractI18nEntity<org.n52.series.db.beans.VerticalMetadataEntity>> {

    private static final long serialVersionUID = -1493241630L;

    public static final QAbstractI18nEntity abstractI18nEntity = new QAbstractI18nEntity("abstractI18nEntity");

    public final org.n52.series.db.beans.QIdEntity _super = new org.n52.series.db.beans.QIdEntity(this);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAbstractI18nEntity(String variable) {
        super((Class) AbstractI18nEntity.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAbstractI18nEntity(Path<? extends AbstractI18nEntity> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAbstractI18nEntity(PathMetadata metadata) {
        super((Class) AbstractI18nEntity.class, metadata);
    }

}

