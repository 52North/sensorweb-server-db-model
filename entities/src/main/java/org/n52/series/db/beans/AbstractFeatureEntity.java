package org.n52.series.db.beans;

import org.n52.series.db.beans.HibernateRelations.HasDescriptionXml;
import org.n52.series.db.beans.feature.FeatureVisitor;
import org.n52.series.db.beans.feature.GeometryVisitor;
import org.n52.shetland.ogc.ows.exception.OwsExceptionReport;

import com.vividsolutions.jts.geom.Geometry;

public abstract class AbstractFeatureEntity extends HierarchicalEntity<AbstractFeatureEntity> implements HasDescriptionXml<AbstractFeatureEntity> {

    private GeometryEntity geometryEntity;
    private FeatureTypeEntity featureType;
    private String url;
    private String descriptionXml;
    
    public abstract AbstractFeatureEntity accept(FeatureVisitor<?> visitor) throws OwsExceptionReport;

    public abstract Geometry accept(GeometryVisitor visitor) throws OwsExceptionReport;

    public Geometry getGeometry() {
        return geometryEntity != null
                ? geometryEntity.getGeometry()
                : null;
    }

    public AbstractFeatureEntity setGeometry(Geometry geometry) {
        this.geometryEntity = new GeometryEntity();
        this.geometryEntity.setGeometry(geometry);
        return this;
    }

    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    public AbstractFeatureEntity setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
        return this;
    }

    public boolean isSetGeometry() {
        return geometryEntity != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName())
          .append(" [")
          .append(" Domain id: ")
          .append(getDomainId())
          .append(", service: ")
          .append(getService())
          .append(" ]")
          .toString();
    }

    @Override
    public String getDescriptionXml() {
        return descriptionXml;
    }

    @Override
    public AbstractFeatureEntity setDescriptionXml(String descriptionXml) {
        this.descriptionXml = descriptionXml;
        return this;
    }

    public FeatureTypeEntity getFeatureType() {
        return featureType;
    }

    public AbstractFeatureEntity setFeatureType(FeatureTypeEntity featureType) {
        this.featureType = featureType;
        return this;
    }
    
    public boolean isSetFeatureType() {
        return getFeatureType() != null;
    }

    public String getUrl() {
        return url;
    }

    public AbstractFeatureEntity setUrl(String url) {
        this.url = url;
        return this;
    }
    
    public boolean isSetUrl() {
        return getUrl() != null && !getUrl().isEmpty();
    }

}
