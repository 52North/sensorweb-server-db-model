package org.n52.series.db.beans.sta.plus;

import org.n52.series.db.beans.AbstractDatasetEntity;
import org.n52.series.db.beans.sta.AggregationEntity;
import org.n52.series.db.beans.sta.StaPlusDataset;

import java.util.Set;
import java.util.stream.Collectors;

public class StaPlusDatasetAggregationEntity extends StaPlusDataset
        implements StaPlusAbstractDatasetEntity, AggregationEntity<StaPlusDataset> {

    private static final long serialVersionUID = -4016466176991438726L;

    private LicenseEntity license;
    private PartyEntity party;
    private ProjectEntity project;
    private Set<AbstractDatasetEntity> datasets;

    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    public void setDatasets(Set<AbstractDatasetEntity> datasets) {
        this.datasets = datasets;
    }

    public boolean isSetDatasets() {
        return getDatasets() != null && !getDatasets().isEmpty();
    }

    public LicenseEntity getLicense() {
        return license;
    }

    public void setLicense(LicenseEntity license) {
        this.license = license;
    }

    public PartyEntity getParty() {
        return party;
    }

    public void setParty(PartyEntity party) {
        this.party = party;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public void copy(StaPlusDataset dataset) {
        setIdentifier(dataset.getIdentifier());
        setIdentifierCodespace(dataset.getIdentifierCodespace());
        setStaIdentifier(dataset.getStaIdentifier());
        setName(dataset.getName());
        setNameCodespace(dataset.getNameCodespace());
        setDescription(dataset.getDescription());
        if (dataset.getParameters() != null) {
            setParameters(dataset.getParameters().stream().collect(Collectors.toSet()));
        }
        setCategory(dataset.getCategory());
        setFeature(dataset.getFeature());
        setFirstObservation(dataset.getFirstObservation());
        setFirstQuantityValue(dataset.getFirstQuantityValue());
        setFirstValueAt(dataset.getFirstValueAt());
        setLastObservation(dataset.getLastObservation());
        setLastQuantityValue(dataset.getLastQuantityValue());
        setLastValueAt(dataset.getLastValueAt());
        setOMObservationType(dataset.getOMObservationType());
        setOffering(dataset.getOffering());
        setPhenomenon(dataset.getPhenomenon());
        setPlatform(dataset.getPlatform());
        setProcedure(dataset.getProcedure());
        setProcessed(dataset.isProcessed());
        setSamplingTimeStart(dataset.getSamplingTimeStart());
        setSamplingTimeEnd(dataset.getSamplingTimeEnd());
        setGeometryEntity(dataset.getGeometryEntity());
        if (dataset.getResultTimes() != null) {
            setResultTimes(dataset.getResultTimes().stream().collect(Collectors.toSet()));
        }
        setUnit(dataset.getUnit());

        if (dataset instanceof StaPlusDatasetAggregationEntity) {
            setDatasets(((StaPlusDatasetAggregationEntity) dataset).getDatasets());
        }

        setProject(((StaPlusDatasetEntity) dataset).getProject());
        setLicense(((StaPlusDatasetEntity) dataset).getLicense());
        setParty(((StaPlusDatasetEntity) dataset).getParty());
    }
}
