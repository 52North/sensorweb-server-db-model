
package org.n52.series.db.beans.ereporting;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QEReportingNetworkEntity is a Querydsl query type for EReportingNetworkEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEReportingNetworkEntity extends EntityPathBase<EReportingNetworkEntity> {

    private static final long serialVersionUID = -1160241580L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEReportingNetworkEntity eReportingNetworkEntity =
            new QEReportingNetworkEntity("eReportingNetworkEntity");

    public final org.n52.series.db.beans.QDescribableEntity _super =
            new org.n52.series.db.beans.QDescribableEntity(this);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final org.n52.series.db.beans.QCodespaceEntity identifierCodespace;

    public final StringPath name = createString("name");

    public final org.n52.series.db.beans.QCodespaceEntity nameCodespace;

    public QEReportingNetworkEntity(String variable) {
        this(EReportingNetworkEntity.class, forVariable(variable), INITS);
    }

    public QEReportingNetworkEntity(Path< ? extends EReportingNetworkEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEReportingNetworkEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEReportingNetworkEntity(PathMetadata metadata, PathInits inits) {
        this(EReportingNetworkEntity.class, metadata, inits);
    }

    public QEReportingNetworkEntity(Class< ? extends EReportingNetworkEntity> type,
                                    PathMetadata metadata,
                                    PathInits inits) {
        super(type, metadata, inits);
        this.identifierCodespace = inits.isInitialized("identifierCodespace")
                ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("identifierCodespace"))
                : null;
        this.nameCodespace = inits.isInitialized("nameCodespace")
                ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("nameCodespace"))
                : null;
    }

}
