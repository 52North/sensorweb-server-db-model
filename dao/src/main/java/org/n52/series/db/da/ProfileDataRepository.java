package org.n52.series.db.da;

import org.hibernate.Session;
import org.n52.io.response.profile.ProfileData;
import org.n52.io.response.profile.ProfileValue;
import org.n52.series.db.DataAccessException;
import org.n52.series.db.beans.ProfileDataEntity;
import org.n52.series.db.beans.ProfileDatasetEntity;
import org.n52.series.db.dao.DbQuery;

public class ProfileDataRepository extends AbstractDataRepository<ProfileData, ProfileDatasetEntity, ProfileDataEntity, ProfileValue>{

    @Override
    public Class<ProfileDatasetEntity> getEntityType() {
        return ProfileDatasetEntity.class;
    }

    @Override
    protected ProfileValue createSeriesValueFor(ProfileDataEntity valueEntity,
                                                ProfileDatasetEntity datasetEntity,
                                                DbQuery query) {
        // TODO Auto-generated method stub
        return new ProfileValue();
    }

    @Override
    protected ProfileData assembleData(ProfileDatasetEntity datasetEntity, DbQuery query, Session session)
            throws DataAccessException {
        // TODO Auto-generated method stub
        return new ProfileData();
    }

    @Override
    protected ProfileData assembleDataWithReferenceValues(ProfileDatasetEntity datasetEntity,
                                                          DbQuery dbQuery,
                                                          Session session)
            throws DataAccessException {
        // TODO Auto-generated method stub
        return new ProfileData();
    }

}
