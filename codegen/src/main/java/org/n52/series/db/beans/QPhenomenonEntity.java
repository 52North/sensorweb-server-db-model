
package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QPhenomenonEntity is a Querydsl query type for PhenomenonEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPhenomenonEntity extends EntityPathBase<PhenomenonEntity> {

    private static final long serialVersionUID = 156159803L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPhenomenonEntity phenomenonEntity = new QPhenomenonEntity("phenomenonEntity");

    public final QHierarchicalEntity _super = new QHierarchicalEntity(this);

    public final SetPath<PhenomenonEntity, QPhenomenonEntity> children =
            this.<PhenomenonEntity, QPhenomenonEntity> createSet("children",
                                                                 PhenomenonEntity.class,
                                                                 QPhenomenonEntity.class,
                                                                 PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final QCodespaceEntity identifierCodespace;

    public final StringPath name = createString("name");

    public final QCodespaceEntity nameCodespace;

    public final SetPath<PhenomenonEntity, QPhenomenonEntity> parents =
            this.<PhenomenonEntity, QPhenomenonEntity> createSet("parents",
                                                                 PhenomenonEntity.class,
                                                                 QPhenomenonEntity.class,
                                                                 PathInits.DIRECT2);

    public final SetPath<org.n52.series.db.beans.i18n.I18nPhenomenonEntity, org.n52.series.db.beans.i18n.QI18nPhenomenonEntity> translations =
            this.<org.n52.series.db.beans.i18n.I18nPhenomenonEntity, org.n52.series.db.beans.i18n.QI18nPhenomenonEntity> createSet("translations",
                                                                                                                                   org.n52.series.db.beans.i18n.I18nPhenomenonEntity.class,
                                                                                                                                   org.n52.series.db.beans.i18n.QI18nPhenomenonEntity.class,
                                                                                                                                   PathInits.DIRECT2);

    public QPhenomenonEntity(String variable) {
        this(PhenomenonEntity.class, forVariable(variable), INITS);
    }

    public QPhenomenonEntity(Path< ? extends PhenomenonEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPhenomenonEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPhenomenonEntity(PathMetadata metadata, PathInits inits) {
        this(PhenomenonEntity.class, metadata, inits);
    }

    public QPhenomenonEntity(Class< ? extends PhenomenonEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.identifierCodespace = inits.isInitialized("identifierCodespace")
                ? new QCodespaceEntity(forProperty("identifierCodespace"))
                : null;
        this.nameCodespace = inits.isInitialized("nameCodespace")
                ? new QCodespaceEntity(forProperty("nameCodespace"))
                : null;
    }

}
