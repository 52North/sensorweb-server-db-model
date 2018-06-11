
package org.n52.series.db.beans.feature.gml;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QVerticalDatumEntity is a Querydsl query type for VerticalDatumEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVerticalDatumEntity extends EntityPathBase<VerticalDatumEntity> {

    private static final long serialVersionUID = 429375915L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVerticalDatumEntity verticalDatumEntity = new QVerticalDatumEntity("verticalDatumEntity");

    public final org.n52.series.db.beans.feature.QReferenceEntity _super =
            new org.n52.series.db.beans.feature.QReferenceEntity(this);

    public final StringPath actuate = createString("actuate");

    public final StringPath anchorDefinition = createString("anchorDefinition");

    public final StringPath arcrole = createString("arcrole");

    public final org.n52.series.db.beans.QCodespaceEntity codespaceAnchorDefinition;

    public final StringPath description = createString("description");

    public final QDomainOfValidityEntity domainOfValidity;

    public final StringPath href = createString("href");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final org.n52.series.db.beans.QCodespaceEntity identifierCodespace;

    public final StringPath name = createString("name");

    public final org.n52.series.db.beans.QCodespaceEntity nameCodespace;

    public final StringPath nilReason = createString("nilReason");

    public final DateTimePath<java.util.Date> realizationEpoch =
            createDateTime("realizationEpoch", java.util.Date.class);

    public final StringPath remarks = createString("remarks");

    public final StringPath remoteSchema = createString("remoteSchema");

    public final StringPath role = createString("role");

    public final SetPath<String, StringPath> scope =
            this.<String, StringPath> createSet("scope", String.class, StringPath.class, PathInits.DIRECT2);

    public final StringPath show = createString("show");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public QVerticalDatumEntity(String variable) {
        this(VerticalDatumEntity.class, forVariable(variable), INITS);
    }

    public QVerticalDatumEntity(Path< ? extends VerticalDatumEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVerticalDatumEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVerticalDatumEntity(PathMetadata metadata, PathInits inits) {
        this(VerticalDatumEntity.class, metadata, inits);
    }

    public QVerticalDatumEntity(Class< ? extends VerticalDatumEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.codespaceAnchorDefinition = inits.isInitialized("codespaceAnchorDefinition")
                ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("codespaceAnchorDefinition"))
                : null;
        this.domainOfValidity = inits.isInitialized("domainOfValidity")
                ? new QDomainOfValidityEntity(forProperty("domainOfValidity"), inits.get("domainOfValidity"))
                : null;
        this.identifierCodespace = inits.isInitialized("identifierCodespace")
                ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("identifierCodespace"))
                : null;
        this.nameCodespace = inits.isInitialized("nameCodespace")
                ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("nameCodespace"))
                : null;
    }

}
