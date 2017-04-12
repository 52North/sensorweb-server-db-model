package org.n52.series.db.beans;

import org.n52.io.response.profile.ProfileDatasetOutput;

public class ProfileDatasetEntity extends DatasetEntity<ProfileDataEntity> {

    public ProfileDatasetEntity() {
        super(ProfileDatasetOutput.DATASET_TYPE);
    }
}
