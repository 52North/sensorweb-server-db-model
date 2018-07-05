package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUnitEntity is a Querydsl query type for UnitEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUnitEntity extends EntityPathBase<UnitEntity> {

    private static final long serialVersionUID = 1300692152L;

    public static final QUnitEntity unitEntity = new QUnitEntity("unitEntity");

    public final QDescribableEntity _super = new QDescribableEntity(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final StringPath link = createString("link");

    public final StringPath name = createString("name");

    public final SetPath<org.n52.series.db.beans.i18n.I18nUnitEntity, org.n52.series.db.beans.i18n.QI18nUnitEntity> translations = this.<org.n52.series.db.beans.i18n.I18nUnitEntity, org.n52.series.db.beans.i18n.QI18nUnitEntity>createSet("translations", org.n52.series.db.beans.i18n.I18nUnitEntity.class, org.n52.series.db.beans.i18n.QI18nUnitEntity.class, PathInits.DIRECT2);

    public QUnitEntity(String variable) {
        super(UnitEntity.class, forVariable(variable));
    }

    public QUnitEntity(Path<? extends UnitEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUnitEntity(PathMetadata metadata) {
        super(UnitEntity.class, metadata);
    }

}

