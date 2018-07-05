package org.n52.series.db.beans.feature.gmd;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResponsiblePartyEntity is a Querydsl query type for ResponsiblePartyEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResponsiblePartyEntity extends EntityPathBase<ResponsiblePartyEntity> {

    private static final long serialVersionUID = 1896846956L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResponsiblePartyEntity responsiblePartyEntity = new QResponsiblePartyEntity("responsiblePartyEntity");

    public final QAbstractCiEntity _super = new QAbstractCiEntity(this);

    public final StringPath actuate = createString("actuate");

    public final StringPath arcrole = createString("arcrole");

    public final QRoleEntity ciRole;

    public final QContactEntity contactInfo;

    public final StringPath gmdid = createString("gmdid");

    public final StringPath href = createString("href");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath individualName = createString("individualName");

    public final StringPath nilReason = createString("nilReason");

    public final StringPath organizationName = createString("organizationName");

    public final StringPath positionName = createString("positionName");

    public final StringPath remoteSchema = createString("remoteSchema");

    public final StringPath role = createString("role");

    public final StringPath show = createString("show");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final StringPath uuid = createString("uuid");

    public QResponsiblePartyEntity(String variable) {
        this(ResponsiblePartyEntity.class, forVariable(variable), INITS);
    }

    public QResponsiblePartyEntity(Path<? extends ResponsiblePartyEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResponsiblePartyEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResponsiblePartyEntity(PathMetadata metadata, PathInits inits) {
        this(ResponsiblePartyEntity.class, metadata, inits);
    }

    public QResponsiblePartyEntity(Class<? extends ResponsiblePartyEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ciRole = inits.isInitialized("ciRole") ? new QRoleEntity(forProperty("ciRole")) : null;
        this.contactInfo = inits.isInitialized("contactInfo") ? new QContactEntity(forProperty("contactInfo"), inits.get("contactInfo")) : null;
    }

}

