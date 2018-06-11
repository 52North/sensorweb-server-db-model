
package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QDatasetEntity is a Querydsl query type for DatasetEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDatasetEntity extends EntityPathBase<DatasetEntity> {

    private static final long serialVersionUID = -1193260374L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDatasetEntity datasetEntity = new QDatasetEntity("datasetEntity");

    public final QDescribableEntity _super = new QDescribableEntity(this);

    public final QCategoryEntity category;

    public final BooleanPath deleted = createBoolean("deleted");

    public final StringPath description = createString("description");

    public final BooleanPath disabled = createBoolean("disabled");

    // custom
    public final QAbstractFeatureEntity feature = new QAbstractFeatureEntity(forProperty("feature"));

    public final NumberPath<java.math.BigDecimal> firstQuantityValue =
            createNumber("firstQuantityValue", java.math.BigDecimal.class);

    public final DateTimePath<java.util.Date> firstValueAt = createDateTime("firstValueAt", java.util.Date.class);

    public final BooleanPath hidden = createBoolean("hidden");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final QCodespaceEntity identifierCodespace;

    public final NumberPath<java.math.BigDecimal> lastQuantityValue =
            createNumber("lastQuantityValue", java.math.BigDecimal.class);

    public final DateTimePath<java.util.Date> lastValueAt = createDateTime("lastValueAt", java.util.Date.class);

    public final StringPath name = createString("name");

    public final QCodespaceEntity nameCodespace;

    public final QFormatEntity observationType;

    public final QOfferingEntity offering;

    public final SetPath<org.n52.series.db.beans.parameter.Parameter< ? >, org.n52.series.db.beans.parameter.QParameter> parameters =
            this.<org.n52.series.db.beans.parameter.Parameter< ? >, org.n52.series.db.beans.parameter.QParameter> createSet("parameters",
                                                                                                                            org.n52.series.db.beans.parameter.Parameter.class,
                                                                                                                            org.n52.series.db.beans.parameter.QParameter.class,
                                                                                                                            PathInits.DIRECT2);

    public final QPhenomenonEntity phenomenon;

    public final QPlatformEntity platform;

    public final QProcedureEntity procedure;

    public final BooleanPath published = createBoolean("published");

    public final StringPath valueType = createString("valueType");

    public QDatasetEntity(String variable) {
        this(DatasetEntity.class, forVariable(variable), INITS);
    }

    public QDatasetEntity(Path< ? extends DatasetEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDatasetEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDatasetEntity(PathMetadata metadata, PathInits inits) {
        this(DatasetEntity.class, metadata, inits);
    }

    public QDatasetEntity(Class< ? extends DatasetEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category")
                ? new QCategoryEntity(forProperty("category"))
                : null;
        this.identifierCodespace = inits.isInitialized("identifierCodespace")
                ? new QCodespaceEntity(forProperty("identifierCodespace"))
                : null;
        this.nameCodespace = inits.isInitialized("nameCodespace")
                ? new QCodespaceEntity(forProperty("nameCodespace"))
                : null;
        this.observationType = inits.isInitialized("observationType")
                ? new QFormatEntity(forProperty("observationType"))
                : null;
        this.offering = inits.isInitialized("offering")
                ? new QOfferingEntity(forProperty("offering"), inits.get("offering"))
                : null;
        this.phenomenon = inits.isInitialized("phenomenon")
                ? new QPhenomenonEntity(forProperty("phenomenon"), inits.get("phenomenon"))
                : null;
        this.platform = inits.isInitialized("platform")
                ? new QPlatformEntity(forProperty("platform"))
                : null;
        this.procedure = inits.isInitialized("procedure")
                ? new QProcedureEntity(forProperty("procedure"), inits.get("procedure"))
                : null;
    }

}
