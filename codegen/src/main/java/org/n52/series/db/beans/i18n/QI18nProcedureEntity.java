package org.n52.series.db.beans.i18n;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QI18nProcedureEntity is a Querydsl query type for I18nProcedureEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QI18nProcedureEntity extends EntityPathBase<I18nProcedureEntity> {

    private static final long serialVersionUID = 530344697L;

    public static final QI18nProcedureEntity i18nProcedureEntity = new QI18nProcedureEntity("i18nProcedureEntity");

    public final QI18nEntity _super = new QI18nEntity(this);

    public final StringPath description = createString("description");

    // custom
    public final org.n52.series.db.beans.QIdEntity entity = new org.n52.series.db.beans.QIdEntity(forProperty("entity"));

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath locale = createString("locale");

    public final StringPath longName = createString("longName");

    public final StringPath name = createString("name");

    public final StringPath shortName = createString("shortName");

    public QI18nProcedureEntity(String variable) {
        super(I18nProcedureEntity.class, forVariable(variable));
    }

    public QI18nProcedureEntity(Path<? extends I18nProcedureEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QI18nProcedureEntity(PathMetadata metadata) {
        super(I18nProcedureEntity.class, metadata);
    }

}

