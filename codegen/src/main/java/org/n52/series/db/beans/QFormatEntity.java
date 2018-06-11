
package org.n52.series.db.beans;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QFormatEntity is a Querydsl query type for FormatEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFormatEntity extends EntityPathBase<FormatEntity> {

    private static final long serialVersionUID = -66752341L;

    public static final QFormatEntity formatEntity = new QFormatEntity("formatEntity");

    public final QIdEntity _super = new QIdEntity(this);

    public final StringPath format = createString("format");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QFormatEntity(String variable) {
        super(FormatEntity.class, forVariable(variable));
    }

    public QFormatEntity(Path< ? extends FormatEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFormatEntity(PathMetadata metadata) {
        super(FormatEntity.class, metadata);
    }

}
