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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlatformEntity platformEntity = new QPlatformEntity("platformEntity");

    public final QDescribableEntity _super = new QDescribableEntity(this);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final QCodespaceEntity identifierCodespace;

    public final StringPath name = createString("name");

    public final QCodespaceEntity nameCodespace;

    public final SetPath<org.n52.series.db.beans.parameter.ParameterEntity<?>, org.n52.series.db.beans.parameter.QParameterEntity> parameters = this.<org.n52.series.db.beans.parameter.ParameterEntity<?>, org.n52.series.db.beans.parameter.QParameterEntity>createSet("parameters", org.n52.series.db.beans.parameter.ParameterEntity.class, org.n52.series.db.beans.parameter.QParameterEntity.class, PathInits.DIRECT2);

    public final SetPath<org.n52.series.db.beans.i18n.I18nPlatformEntity, org.n52.series.db.beans.i18n.QI18nPlatformEntity> translations = this.<org.n52.series.db.beans.i18n.I18nPlatformEntity, org.n52.series.db.beans.i18n.QI18nPlatformEntity>createSet("translations", org.n52.series.db.beans.i18n.I18nPlatformEntity.class, org.n52.series.db.beans.i18n.QI18nPlatformEntity.class, PathInits.DIRECT2);

    public QPlatformEntity(String variable) {
        this(PlatformEntity.class, forVariable(variable), INITS);
    }

    public QPlatformEntity(Path<? extends PlatformEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlatformEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlatformEntity(PathMetadata metadata, PathInits inits) {
        this(PlatformEntity.class, metadata, inits);
    }

    public QPlatformEntity(Class<? extends PlatformEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.identifierCodespace = inits.isInitialized("identifierCodespace") ? new QCodespaceEntity(forProperty("identifierCodespace")) : null;
        this.nameCodespace = inits.isInitialized("nameCodespace") ? new QCodespaceEntity(forProperty("nameCodespace")) : null;
    }

}

