package org.n52.series.db.beans.feature.gmd;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QContactEntity is a Querydsl query type for ContactEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContactEntity extends EntityPathBase<ContactEntity> {

    private static final long serialVersionUID = 1736208170L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QContactEntity contactEntity = new QContactEntity("contactEntity");

    public final QAbstractCiEntity _super = new QAbstractCiEntity(this);

    public final StringPath actuate = createString("actuate");

    public final QAddressEntity address;

    public final StringPath arcrole = createString("arcrole");

    public final StringPath contactInstructions = createString("contactInstructions");

    public final StringPath gmdid = createString("gmdid");

    public final StringPath hoursOfService = createString("hoursOfService");

    public final StringPath href = createString("href");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nilReason = createString("nilReason");

    public final QOnlineResourceEntity onlineResource;

    public final QTelephoneEntity phone;

    public final StringPath remoteSchema = createString("remoteSchema");

    public final StringPath role = createString("role");

    public final StringPath show = createString("show");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final StringPath uuid = createString("uuid");

    public QContactEntity(String variable) {
        this(ContactEntity.class, forVariable(variable), INITS);
    }

    public QContactEntity(Path<? extends ContactEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QContactEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QContactEntity(PathMetadata metadata, PathInits inits) {
        this(ContactEntity.class, metadata, inits);
    }

    public QContactEntity(Class<? extends ContactEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddressEntity(forProperty("address")) : null;
        this.onlineResource = inits.isInitialized("onlineResource") ? new QOnlineResourceEntity(forProperty("onlineResource")) : null;
        this.phone = inits.isInitialized("phone") ? new QTelephoneEntity(forProperty("phone")) : null;
    }

}

