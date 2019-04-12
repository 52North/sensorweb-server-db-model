package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVerticalMetadataEntity is a Querydsl query type for VerticalMetadataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVerticalMetadataEntity extends EntityPathBase<VerticalMetadataEntity> {

    private static final long serialVersionUID = 1676385721L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVerticalMetadataEntity verticalMetadataEntity = new QVerticalMetadataEntity("verticalMetadataEntity");

    public final QIdEntity _super = new QIdEntity(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Short> orientation = createNumber("orientation", Short.class);

    public final SetPath<org.n52.series.db.beans.i18n.I18nVerticalMetadataEntity, org.n52.series.db.beans.i18n.QI18nVerticalMetadataEntity> translations = this.<org.n52.series.db.beans.i18n.I18nVerticalMetadataEntity, org.n52.series.db.beans.i18n.QI18nVerticalMetadataEntity>createSet("translations", org.n52.series.db.beans.i18n.I18nVerticalMetadataEntity.class, org.n52.series.db.beans.i18n.QI18nVerticalMetadataEntity.class, PathInits.DIRECT2);

    public final StringPath verticalFromName = createString("verticalFromName");

    public final StringPath verticalOriginName = createString("verticalOriginName");

    public final StringPath verticalToName = createString("verticalToName");

    public final QUnitEntity verticalUnit;

    public QVerticalMetadataEntity(String variable) {
        this(VerticalMetadataEntity.class, forVariable(variable), INITS);
    }

    public QVerticalMetadataEntity(Path<? extends VerticalMetadataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVerticalMetadataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVerticalMetadataEntity(PathMetadata metadata, PathInits inits) {
        this(VerticalMetadataEntity.class, metadata, inits);
    }

    public QVerticalMetadataEntity(Class<? extends VerticalMetadataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.verticalUnit = inits.isInitialized("verticalUnit") ? new QUnitEntity(forProperty("verticalUnit")) : null;
    }

}

