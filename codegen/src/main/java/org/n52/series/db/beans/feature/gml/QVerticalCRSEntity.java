package org.n52.series.db.beans.feature.gml;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVerticalCRSEntity is a Querydsl query type for VerticalCRSEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVerticalCRSEntity extends EntityPathBase<VerticalCRSEntity> {

    private static final long serialVersionUID = 2016236960L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVerticalCRSEntity verticalCRSEntity = new QVerticalCRSEntity("verticalCRSEntity");

    public final org.n52.series.db.beans.feature.QReferenceEntity _super = new org.n52.series.db.beans.feature.QReferenceEntity(this);

    public final StringPath actuate = createString("actuate");

    public final StringPath arcrole = createString("arcrole");

    public final StringPath description = createString("description");

    public final SetPath<DomainOfValidityEntity, QDomainOfValidityEntity> domainOfValidity = this.<DomainOfValidityEntity, QDomainOfValidityEntity>createSet("domainOfValidity", DomainOfValidityEntity.class, QDomainOfValidityEntity.class, PathInits.DIRECT2);

    public final StringPath href = createString("href");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final org.n52.series.db.beans.QCodespaceEntity identifierCodespace;

    public final StringPath name = createString("name");

    public final org.n52.series.db.beans.QCodespaceEntity nameCodespace;

    public final StringPath nilReason = createString("nilReason");

    public final StringPath remarks = createString("remarks");

    public final StringPath remoteSchema = createString("remoteSchema");

    public final StringPath role = createString("role");

    public final SetPath<String, StringPath> scope = this.<String, StringPath>createSet("scope", String.class, StringPath.class, PathInits.DIRECT2);

    public final StringPath show = createString("show");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final QVerticalCSEntity verticalCS;

    public final QVerticalDatumEntity verticalDatum;

    public QVerticalCRSEntity(String variable) {
        this(VerticalCRSEntity.class, forVariable(variable), INITS);
    }

    public QVerticalCRSEntity(Path<? extends VerticalCRSEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVerticalCRSEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVerticalCRSEntity(PathMetadata metadata, PathInits inits) {
        this(VerticalCRSEntity.class, metadata, inits);
    }

    public QVerticalCRSEntity(Class<? extends VerticalCRSEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.identifierCodespace = inits.isInitialized("identifierCodespace") ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("identifierCodespace")) : null;
        this.nameCodespace = inits.isInitialized("nameCodespace") ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("nameCodespace")) : null;
        this.verticalCS = inits.isInitialized("verticalCS") ? new QVerticalCSEntity(forProperty("verticalCS"), inits.get("verticalCS")) : null;
        this.verticalDatum = inits.isInitialized("verticalDatum") ? new QVerticalDatumEntity(forProperty("verticalDatum"), inits.get("verticalDatum")) : null;
    }

}

