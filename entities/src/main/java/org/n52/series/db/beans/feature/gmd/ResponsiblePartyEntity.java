/*
 * Copyright 2015-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
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

package org.n52.series.db.beans.feature.gmd;

/**
 * Hibernate entity for responsibleParty.
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 *
 */
public class ResponsiblePartyEntity extends AbstractCiEntity {

    private static final long serialVersionUID = -371431604695988543L;

    private String individualName;
    private String organizationName;
    private String positionName;
    private ContactEntity contactInfo;
    private RoleEntity ciRole;

    /**
     * @return the individualName
     */
    public String getIndividualName() {
        return individualName;
    }

    /**
     * @param individualName
     *            the individualName to set
     */
    public void setIndividualName(String individualName) {
        this.individualName = individualName;
    }

    public boolean isSetIndividualName() {
        return getIndividualName() != null && !getIndividualName().isEmpty();
    }

    /**
     * @return the organizationName
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * @param organizationName
     *            the organizationName to set
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public boolean isSetOrganizationName() {
        return getOrganizationName() != null && !getOrganizationName().isEmpty();
    }

    /**
     * @return the positionName
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * @param positionName
     *            the positionName to set
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public boolean isSetPositionName() {
        return getPositionName() != null && !getPositionName().isEmpty();
    }

    /**
     * @return the contactInfo
     */
    public ContactEntity getContactInfo() {
        return contactInfo;
    }

    /**
     * @param contactInfo
     *            the contactInfo to set
     */
    public void setContactInfo(ContactEntity contactInfo) {
        this.contactInfo = contactInfo;
    }

    public boolean isSetContactInfo() {
        return getContactInfo() != null;
    }

    /**
     * @return the ciRole
     */
    public RoleEntity getCiRole() {
        return ciRole;
    }

    /**
     * @param ciRole
     *            the ciRole to set
     */
    public void setCiRole(RoleEntity ciRole) {
        this.ciRole = ciRole;
    }
}
