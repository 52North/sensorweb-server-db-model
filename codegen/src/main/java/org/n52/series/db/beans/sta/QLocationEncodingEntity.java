package org.n52.series.db.beans.sta;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocationEncodingEntity is a Querydsl query type for LocationEncodingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocationEncodingEntity extends EntityPathBase<LocationEncodingEntity> {

    private static final long serialVersionUID = -1370244630L;

    public static final QLocationEncodingEntity locationEncodingEntity = new QLocationEncodingEntity("locationEncodingEntity");

    public final QAbstractStaEntity _super = new QAbstractStaEntity(this);

    public final StringPath encodingType = createString("encodingType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QLocationEncodingEntity(String variable) {
        super(LocationEncodingEntity.class, forVariable(variable));
    }

    public QLocationEncodingEntity(Path<? extends LocationEncodingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocationEncodingEntity(PathMetadata metadata) {
        super(LocationEncodingEntity.class, metadata);
    }

}

