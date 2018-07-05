package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGeometryEntity is a Querydsl query type for GeometryEntity
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QGeometryEntity extends BeanPath<GeometryEntity> {

    private static final long serialVersionUID = -1815592794L;

    public static final QGeometryEntity geometryEntity = new QGeometryEntity("geometryEntity");

    // custom
    public final com.querydsl.spatial.jts.JTSGeometryPath geometry = new com.querydsl.spatial.jts.JTSGeometryPath(forProperty("geometry"));

    public QGeometryEntity(String variable) {
        super(GeometryEntity.class, forVariable(variable));
    }

    public QGeometryEntity(Path<? extends GeometryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGeometryEntity(PathMetadata metadata) {
        super(GeometryEntity.class, metadata);
    }

}

