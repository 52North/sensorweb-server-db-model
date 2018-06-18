package org.n52.series.db.beans.feature.gml;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDomainOfValidityEntity is a Querydsl query type for DomainOfValidityEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDomainOfValidityEntity extends EntityPathBase<DomainOfValidityEntity> {

    private static final long serialVersionUID = 672963617L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDomainOfValidityEntity domainOfValidityEntity = new QDomainOfValidityEntity("domainOfValidityEntity");

    public final org.n52.series.db.beans.feature.QReferenceEntity _super = new org.n52.series.db.beans.feature.QReferenceEntity(this);

    public final StringPath actuate = createString("actuate");

    public final StringPath arcrole = createString("arcrole");

    public final StringPath description = createString("description");

    public final org.n52.series.db.beans.feature.gmd.QExExtentEntity exExtent;

    public final StringPath href = createString("href");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final org.n52.series.db.beans.QCodespaceEntity identifierCodespace;

    public final StringPath name = createString("name");

    public final org.n52.series.db.beans.QCodespaceEntity nameCodespace;

    public final StringPath nilReason = createString("nilReason");

    public final StringPath remoteSchema = createString("remoteSchema");

    public final StringPath role = createString("role");

    public final StringPath show = createString("show");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public QDomainOfValidityEntity(String variable) {
        this(DomainOfValidityEntity.class, forVariable(variable), INITS);
    }

    public QDomainOfValidityEntity(Path<? extends DomainOfValidityEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDomainOfValidityEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDomainOfValidityEntity(PathMetadata metadata, PathInits inits) {
        this(DomainOfValidityEntity.class, metadata, inits);
    }

    public QDomainOfValidityEntity(Class<? extends DomainOfValidityEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.exExtent = inits.isInitialized("exExtent") ? new org.n52.series.db.beans.feature.gmd.QExExtentEntity(forProperty("exExtent")) : null;
        this.identifierCodespace = inits.isInitialized("identifierCodespace") ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("identifierCodespace")) : null;
        this.nameCodespace = inits.isInitialized("nameCodespace") ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("nameCodespace")) : null;
    }

}

