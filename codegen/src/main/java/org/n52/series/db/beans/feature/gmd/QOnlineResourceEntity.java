
package org.n52.series.db.beans.feature.gmd;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QOnlineResourceEntity is a Querydsl query type for OnlineResourceEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOnlineResourceEntity extends EntityPathBase<OnlineResourceEntity> {

    private static final long serialVersionUID = 525864413L;

    public static final QOnlineResourceEntity onlineResourceEntity = new QOnlineResourceEntity("onlineResourceEntity");

    public final QAbstractCiEntity _super = new QAbstractCiEntity(this);

    public final StringPath actuate = createString("actuate");

    public final StringPath applicationProfile = createString("applicationProfile");

    public final StringPath arcrole = createString("arcrole");

    public final StringPath description = createString("description");

    public final StringPath function = createString("function");

    public final StringPath gmdid = createString("gmdid");

    public final StringPath href = createString("href");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath linkage = createString("linkage");

    public final StringPath name = createString("name");

    public final StringPath nilReason = createString("nilReason");

    public final StringPath protocol = createString("protocol");

    public final StringPath role = createString("role");

    public final StringPath show = createString("show");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final StringPath uuid = createString("uuid");

    public QOnlineResourceEntity(String variable) {
        super(OnlineResourceEntity.class, forVariable(variable));
    }

    public QOnlineResourceEntity(Path< ? extends OnlineResourceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOnlineResourceEntity(PathMetadata metadata) {
        super(OnlineResourceEntity.class, metadata);
    }

}
