/*
 * Copyright (C) 2015-2023 52°North Spatial Information Research GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.series.db.beans.parameter.license;

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.sta.LicenseEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public abstract class LicenseParameterEntity<T> extends ParameterEntity<T> {

    public static final String PROP_GROUP = "license";
    public static final String PROP_GROUP_ID = "licenseId";
    private static final long serialVersionUID = 1123453212836718013L;
    private LicenseEntity license;
    private Long licenseId;

    public LicenseEntity getLicense() {
        return license;
    }

    public void setLicense(LicenseEntity license) {
        this.license = license;
    }

    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    @Override
    public void setDescribeableEntity(DescribableEntity entity) {
        setLicense((LicenseEntity) entity);
    }
}
