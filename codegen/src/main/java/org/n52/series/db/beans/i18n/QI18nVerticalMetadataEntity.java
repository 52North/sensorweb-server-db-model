package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nVerticalMetadataEntity is a Querydsl query type for I18nVerticalMetadataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nVerticalMetadataEntity extends EntityPathBase<I18nVerticalMetadataEntity> {

    private static final long serialVersionUID = 121712965L;

    public static final QI18nVerticalMetadataEntity i18nVerticalMetadataEntity = new QI18nVerticalMetadataEntity("i18nVerticalMetadataEntity");

    public final QAbstractI18nEntity _super = new QAbstractI18nEntity(this);

    // custom
    public final org.n52.series.db.beans.QIdEntity entity = new org.n52.series.db.beans.QIdEntity(forProperty("entity"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath verticalFromName = createString("verticalFromName");

    public final StringPath verticalOriginName = createString("verticalOriginName");

    public final StringPath verticalToName = createString("verticalToName");

    public QI18nVerticalMetadataEntity(String variable) {
        super(I18nVerticalMetadataEntity.class, forVariable(variable));
    }

    public QI18nVerticalMetadataEntity(Path<? extends I18nVerticalMetadataEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QI18nVerticalMetadataEntity(PathMetadata metadata) {
        super(I18nVerticalMetadataEntity.class, metadata);
    }

}

