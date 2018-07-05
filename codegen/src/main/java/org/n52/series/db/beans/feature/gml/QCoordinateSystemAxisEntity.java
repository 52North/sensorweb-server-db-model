
package org.n52.series.db.beans.feature.gml;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QCoordinateSystemAxisEntity is a Querydsl query type for CoordinateSystemAxisEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCoordinateSystemAxisEntity extends EntityPathBase<CoordinateSystemAxisEntity> {

    private static final long serialVersionUID = -1856589988L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCoordinateSystemAxisEntity coordinateSystemAxisEntity =
            new QCoordinateSystemAxisEntity("coordinateSystemAxisEntity");

    public final org.n52.series.db.beans.feature.QReferenceEntity _super =
            new org.n52.series.db.beans.feature.QReferenceEntity(this);

    public final StringPath actuate = createString("actuate");

    public final StringPath arcrole = createString("arcrole");

    public final StringPath axisAbbrev = createString("axisAbbrev");

    public final StringPath axisDirection = createString("axisDirection");

    public final org.n52.series.db.beans.QCodespaceEntity codespaceAxisAbbrev;

    public final org.n52.series.db.beans.QCodespaceEntity codespaceAxisDirection;

    public final org.n52.series.db.beans.QCodespaceEntity codespaceRangeMeaning;

    public final StringPath description = createString("description");

    public final StringPath href = createString("href");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final org.n52.series.db.beans.QCodespaceEntity identifierCodespace;

    public final NumberPath<Double> maximumValue = createNumber("maximumValue", Double.class);

    public final NumberPath<Double> minimumValue = createNumber("minimumValue", Double.class);

    public final StringPath name = createString("name");

    public final org.n52.series.db.beans.QCodespaceEntity nameCodespace;

    public final StringPath nilReason = createString("nilReason");

    public final StringPath rangeMeaning = createString("rangeMeaning");

    public final StringPath remarks = createString("remarks");

    public final StringPath remoteSchema = createString("remoteSchema");

    public final StringPath role = createString("role");

    public final StringPath show = createString("show");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final org.n52.series.db.beans.QUnitEntity uom;

    public QCoordinateSystemAxisEntity(String variable) {
        this(CoordinateSystemAxisEntity.class, forVariable(variable), INITS);
    }

    public QCoordinateSystemAxisEntity(Path< ? extends CoordinateSystemAxisEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCoordinateSystemAxisEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCoordinateSystemAxisEntity(PathMetadata metadata, PathInits inits) {
        this(CoordinateSystemAxisEntity.class, metadata, inits);
    }

    public QCoordinateSystemAxisEntity(Class< ? extends CoordinateSystemAxisEntity> type,
                                       PathMetadata metadata,
                                       PathInits inits) {
        super(type, metadata, inits);
        this.codespaceAxisAbbrev = inits.isInitialized("codespaceAxisAbbrev")
                ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("codespaceAxisAbbrev"))
                : null;
        this.codespaceAxisDirection = inits.isInitialized("codespaceAxisDirection")
                ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("codespaceAxisDirection"))
                : null;
        this.codespaceRangeMeaning = inits.isInitialized("codespaceRangeMeaning")
                ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("codespaceRangeMeaning"))
                : null;
        this.identifierCodespace = inits.isInitialized("identifierCodespace")
                ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("identifierCodespace"))
                : null;
        this.nameCodespace = inits.isInitialized("nameCodespace")
                ? new org.n52.series.db.beans.QCodespaceEntity(forProperty("nameCodespace"))
                : null;
        this.uom = inits.isInitialized("uom")
                ? new org.n52.series.db.beans.QUnitEntity(forProperty("uom"))
                : null;
    }

}
