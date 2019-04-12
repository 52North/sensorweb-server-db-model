package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nUnitEntity is a Querydsl query type for I18nUnitEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nUnitEntity extends EntityPathBase<I18nUnitEntity> {

    private static final long serialVersionUID = 978616900L;

    public static final QI18nUnitEntity i18nUnitEntity = new QI18nUnitEntity("i18nUnitEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    // custom
    public final org.n52.series.db.beans.QIdEntity entity = new org.n52.series.db.beans.QIdEntity(forProperty("entity"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nUnitEntity(String variable) {
        super(I18nUnitEntity.class, forVariable(variable));
    }

    public QI18nUnitEntity(Path<? extends I18nUnitEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QI18nUnitEntity(PathMetadata metadata) {
        super(I18nUnitEntity.class, metadata);
    }

}

