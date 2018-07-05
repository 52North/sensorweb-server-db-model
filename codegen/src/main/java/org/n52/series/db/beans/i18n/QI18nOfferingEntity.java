package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nOfferingEntity is a Querydsl query type for I18nOfferingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nOfferingEntity extends EntityPathBase<I18nOfferingEntity> {

    private static final long serialVersionUID = 1847732422L;

    public static final QI18nOfferingEntity i18nOfferingEntity = new QI18nOfferingEntity("i18nOfferingEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    // custom
    public final org.n52.series.db.beans.QDescribableEntity entity = new org.n52.series.db.beans.QDescribableEntity(forProperty("entity"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nOfferingEntity(String variable) {
        super(I18nOfferingEntity.class, forVariable(variable));
    }

    public QI18nOfferingEntity(Path<? extends I18nOfferingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QI18nOfferingEntity(PathMetadata metadata) {
        super(I18nOfferingEntity.class, metadata);
    }

}

