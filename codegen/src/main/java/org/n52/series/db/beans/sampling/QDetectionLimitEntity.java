package org.n52.series.db.beans.sampling;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDetectionLimitEntity is a Querydsl query type for DetectionLimitEntity
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QDetectionLimitEntity extends BeanPath<DetectionLimitEntity> {

    private static final long serialVersionUID = 94127567L;

    public static final QDetectionLimitEntity detectionLimitEntity = new QDetectionLimitEntity("detectionLimitEntity");

    public final NumberPath<java.math.BigDecimal> detectionLimit = createNumber("detectionLimit", java.math.BigDecimal.class);

    public final NumberPath<Short> flag = createNumber("flag", Short.class);

    public QDetectionLimitEntity(String variable) {
        super(DetectionLimitEntity.class, forVariable(variable));
    }

    public QDetectionLimitEntity(Path<? extends DetectionLimitEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDetectionLimitEntity(PathMetadata metadata) {
        super(DetectionLimitEntity.class, metadata);
    }

}

