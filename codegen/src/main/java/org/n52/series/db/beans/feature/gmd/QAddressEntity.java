
package org.n52.series.db.beans.feature.gmd;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QAddressEntity is a Querydsl query type for AddressEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAddressEntity extends EntityPathBase<AddressEntity> {

    private static final long serialVersionUID = 378583038L;

    public static final QAddressEntity addressEntity = new QAddressEntity("addressEntity");

    public final QAbstractCiEntity _super = new QAbstractCiEntity(this);

    public final StringPath actuate = createString("actuate");

    public final StringPath administrativeArea = createString("administrativeArea");

    public final StringPath arcrole = createString("arcrole");

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final SetPath<String, StringPath> deliveryPoint =
            this.<String, StringPath> createSet("deliveryPoint", String.class, StringPath.class, PathInits.DIRECT2);

    public final SetPath<String, StringPath> electronicMailAddress =
            this.<String, StringPath> createSet("electronicMailAddress",
                                                String.class,
                                                StringPath.class,
                                                PathInits.DIRECT2);

    public final StringPath gmdid = createString("gmdid");

    public final StringPath href = createString("href");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nilReason = createString("nilReason");

    public final StringPath postalCode = createString("postalCode");

    public final StringPath remoteSchema = createString("remoteSchema");

    public final StringPath role = createString("role");

    public final StringPath show = createString("show");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final StringPath uuid = createString("uuid");

    public QAddressEntity(String variable) {
        super(AddressEntity.class, forVariable(variable));
    }

    public QAddressEntity(Path< ? extends AddressEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddressEntity(PathMetadata metadata) {
        super(AddressEntity.class, metadata);
    }

}
