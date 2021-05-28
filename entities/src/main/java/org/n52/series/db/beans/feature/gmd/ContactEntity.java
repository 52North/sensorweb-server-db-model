/*
 * Copyright (C) 2015-2021 52°North Spatial Information Research GmbH
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
 * Hibernate entity for contact.
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
public class ContactEntity extends AbstractCiEntity {

    private static final long serialVersionUID = 8049831514286990626L;

    private TelephoneEntity phone;
    private AddressEntity address;
    private OnlineResourceEntity onlineResource;
    private String hoursOfService;
    private String contactInstructions;

    /**
     * @return the phone
     */
    public TelephoneEntity getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(TelephoneEntity phone) {
        this.phone = phone;
    }

    public boolean isSetPhone() {
        return getPhone() != null;
    }

    /**
     * @return the address
     */
    public AddressEntity getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public boolean isSetAddress() {
        return getAddress() != null;
    }

    /**
     * @return the onlineResource
     */
    public OnlineResourceEntity getOnlineResource() {
        return onlineResource;
    }

    /**
     * @param onlineResource
     *            the onlineResource to set
     */
    public void setOnlineResource(OnlineResourceEntity onlineResource) {
        this.onlineResource = onlineResource;
    }

    public boolean isSetOnlineResource() {
        return getOnlineResource() != null;
    }

    /**
     * @return the hoursOfService
     */
    public String getHoursOfService() {
        return hoursOfService;
    }

    /**
     * @param hoursOfService
     *            the hoursOfService to set
     */
    public void setHoursOfService(String hoursOfService) {
        this.hoursOfService = hoursOfService;
    }

    public boolean isSetHoursOfService() {
        return getHoursOfService() != null && !getHoursOfService().isEmpty();
    }

    /**
     * @return the contactInstructions
     */
    public String getContactInstructions() {
        return contactInstructions;
    }

    /**
     * @param contactInstructions
     *            the contactInstructions to set
     */
    public void setContactInstructions(String contactInstructions) {
        this.contactInstructions = contactInstructions;
    }

    public boolean isSetContactInstructions() {
        return getContactInstructions() != null && !getContactInstructions().isEmpty();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ContactEntity)) {
            return false;
        }
        return super.equals(obj);
    }
}
