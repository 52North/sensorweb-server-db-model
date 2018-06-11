
package org.n52.series.db.beans.feature.gmd;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QTelephoneEntity is a Querydsl query type for TelephoneEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTelephoneEntity extends EntityPathBase<TelephoneEntity> {

    private static final long serialVersionUID = 1595989582L;

    public static final QTelephoneEntity telephoneEntity = new QTelephoneEntity("telephoneEntity");

    public final QAbstractCiEntity _super = new QAbstractCiEntity(this);

    public final StringPath actuate = createString("actuate");

    public final StringPath arcrole = createString("arcrole");

    public final SetPath<String, StringPath> facsimile =
            this.<String, StringPath> createSet("facsimile", String.class, StringPath.class, PathInits.DIRECT2);

    public final StringPath gmdid = createString("gmdid");

    public final StringPath href = createString("href");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nilReason = createString("nilReason");

    public final StringPath remoteSchema = createString("remoteSchema");

    public final StringPath role = createString("role");

    public final StringPath show = createString("show");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final StringPath uuid = createString("uuid");

    public final SetPath<String, StringPath> voice =
            this.<String, StringPath> createSet("voice", String.class, StringPath.class, PathInits.DIRECT2);

    public QTelephoneEntity(String variable) {
        super(TelephoneEntity.class, forVariable(variable));
    }

    public QTelephoneEntity(Path< ? extends TelephoneEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTelephoneEntity(PathMetadata metadata) {
        super(TelephoneEntity.class, metadata);
    }

}
