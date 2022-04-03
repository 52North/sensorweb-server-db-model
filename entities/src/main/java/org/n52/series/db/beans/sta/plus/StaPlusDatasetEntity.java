package org.n52.series.db.beans.sta.plus;

import org.n52.series.db.beans.sta.StaPlusDataset;

public class StaPlusDatasetEntity extends StaPlusDataset implements StaPlusAbstractDatasetEntity {

    private static final long serialVersionUID = -4016466176991438726L;

    private LicenseEntity license;
    private PartyEntity party;
    private ProjectEntity project;
    private boolean processed;

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

}
