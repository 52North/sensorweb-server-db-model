package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOfferingEntity is a Querydsl query type for OfferingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOfferingEntity extends EntityPathBase<OfferingEntity> {

    private static final long serialVersionUID = 1441417530L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOfferingEntity offeringEntity = new QOfferingEntity("offeringEntity");

    public final QHierarchicalEntity _super = new QHierarchicalEntity(this);

    public final StringPath description = createString("description");

    public final QGeometryEntity geometryEntity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final StringPath name = createString("name");

    public final DateTimePath<java.util.Date> phenomenonTimeEnd = createDateTime("phenomenonTimeEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> phenomenonTimeStart = createDateTime("phenomenonTimeStart", java.util.Date.class);

    public final DateTimePath<java.util.Date> resultTimeEnd = createDateTime("resultTimeEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> resultTimeStart = createDateTime("resultTimeStart", java.util.Date.class);

    public final SetPath<org.n52.series.db.beans.i18n.I18nOfferingEntity, org.n52.series.db.beans.i18n.QI18nOfferingEntity> translations = this.<org.n52.series.db.beans.i18n.I18nOfferingEntity, org.n52.series.db.beans.i18n.QI18nOfferingEntity>createSet("translations", org.n52.series.db.beans.i18n.I18nOfferingEntity.class, org.n52.series.db.beans.i18n.QI18nOfferingEntity.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> validTimeEnd = createDateTime("validTimeEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> validTimeStart = createDateTime("validTimeStart", java.util.Date.class);

    public QOfferingEntity(String variable) {
        this(OfferingEntity.class, forVariable(variable), INITS);
    }

    public QOfferingEntity(Path<? extends OfferingEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOfferingEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOfferingEntity(PathMetadata metadata, PathInits inits) {
        this(OfferingEntity.class, metadata, inits);
    }

    public QOfferingEntity(Class<? extends OfferingEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.geometryEntity = inits.isInitialized("geometryEntity") ? new QGeometryEntity(forProperty("geometryEntity")) : null;
    }

}

