package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nPhenomenonEntity is a Querydsl query type for I18nPhenomenonEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nPhenomenonEntity extends EntityPathBase<I18nPhenomenonEntity> {

    private static final long serialVersionUID = -217252921L;

    public static final QI18nPhenomenonEntity i18nPhenomenonEntity = new QI18nPhenomenonEntity("i18nPhenomenonEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    // custom
    public final org.n52.series.db.beans.QIdEntity entity = new org.n52.series.db.beans.QIdEntity(forProperty("entity"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath name = createString("name");

    public QI18nPhenomenonEntity(String variable) {
        super(I18nPhenomenonEntity.class, forVariable(variable));
    }

    public QI18nPhenomenonEntity(Path<? extends I18nPhenomenonEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QI18nPhenomenonEntity(PathMetadata metadata) {
        super(I18nPhenomenonEntity.class, metadata);
    }

}

