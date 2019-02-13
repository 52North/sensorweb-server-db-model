package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlatformEntity is a Querydsl query type for PlatformEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlatformEntity extends EntityPathBase<PlatformEntity> {

    private static final long serialVersionUID = 1155259367L;

    public static final QPlatformEntity platformEntity = new QPlatformEntity("platformEntity");

    public final QDescribableEntity _super = new QDescribableEntity(this);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final StringPath name = createString("name");

    public final SetPath<org.n52.series.db.beans.i18n.I18nPlatformEntity, org.n52.series.db.beans.i18n.QI18nPlatformEntity> translations = this.<org.n52.series.db.beans.i18n.I18nPlatformEntity, org.n52.series.db.beans.i18n.QI18nPlatformEntity>createSet("translations", org.n52.series.db.beans.i18n.I18nPlatformEntity.class, org.n52.series.db.beans.i18n.QI18nPlatformEntity.class, PathInits.DIRECT2);

    public QPlatformEntity(String variable) {
        super(PlatformEntity.class, forVariable(variable));
    }

    public QPlatformEntity(Path<? extends PlatformEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlatformEntity(PathMetadata metadata) {
        super(PlatformEntity.class, metadata);
    }

}

