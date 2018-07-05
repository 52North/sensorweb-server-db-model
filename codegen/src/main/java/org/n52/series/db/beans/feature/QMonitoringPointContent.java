
package org.n52.series.db.beans.feature;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

/**
 * QMonitoringPointContent is a Querydsl query type for MonitoringPointContent
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMonitoringPointContent extends BeanPath<MonitoringPointContent> {

    private static final long serialVersionUID = 1530240730L;

    public static final QMonitoringPointContent monitoringPointContent =
            new QMonitoringPointContent("monitoringPointContent");

    public final CollectionPath<org.n52.series.db.beans.feature.gmd.ResponsiblePartyEntity, org.n52.series.db.beans.feature.gmd.QResponsiblePartyEntity> relatedParty =
            this.<org.n52.series.db.beans.feature.gmd.ResponsiblePartyEntity, org.n52.series.db.beans.feature.gmd.QResponsiblePartyEntity> createCollection("relatedParty",
                                                                                                                                                            org.n52.series.db.beans.feature.gmd.ResponsiblePartyEntity.class,
                                                                                                                                                            org.n52.series.db.beans.feature.gmd.QResponsiblePartyEntity.class,
                                                                                                                                                            PathInits.DIRECT2);

    public final CollectionPath<org.n52.series.db.beans.feature.gml.VerticalDatumEntity, org.n52.series.db.beans.feature.gml.QVerticalDatumEntity> verticalDatum =
            this.<org.n52.series.db.beans.feature.gml.VerticalDatumEntity, org.n52.series.db.beans.feature.gml.QVerticalDatumEntity> createCollection("verticalDatum",
                                                                                                                                                      org.n52.series.db.beans.feature.gml.VerticalDatumEntity.class,
                                                                                                                                                      org.n52.series.db.beans.feature.gml.QVerticalDatumEntity.class,
                                                                                                                                                      PathInits.DIRECT2);

    public QMonitoringPointContent(String variable) {
        super(MonitoringPointContent.class, forVariable(variable));
    }

    public QMonitoringPointContent(Path< ? extends MonitoringPointContent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMonitoringPointContent(PathMetadata metadata) {
        super(MonitoringPointContent.class, metadata);
    }

}
