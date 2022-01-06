/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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

import java.util.Set;

/**
 * Hibernate entity for address.
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
public class AddressEntity extends AbstractCiEntity {

    private static final long serialVersionUID = -1303589675919102730L;

    private Set<String> deliveryPoint;
    private String city;
    private String administrativeArea;
    private String postalCode;
    private String country;
    private Set<String> electronicMailAddress;

    /**
     * @return the deliveryPoint
     */
    public Set<String> getDeliveryPoint() {
        return deliveryPoint;
    }

    /**
     * @param deliveryPoint
     *            the deliveryPoint to set
     */
    public void setDeliveryPoint(Set<String> deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public boolean hasSetDeliveryPoint() {
        return getDeliveryPoint() != null && !getDeliveryPoint().isEmpty();
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    public boolean isSetCity() {
        return getCity() != null && !getCity().isEmpty();
    }

    /**
     * @return the administrativeArea
     */
    public String getAdministrativeArea() {
        return administrativeArea;
    }

    /**
     * @param administrativeArea
     *            the administrativeArea to set
     */
    public void setAdministrativeArea(String administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    public boolean isSetAdministrativeArea() {
        return getAdministrativeArea() != null && !getAdministrativeArea().isEmpty();
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode
     *            the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isSetPostalCode() {
        return getPostalCode() != null && !getPostalCode().isEmpty();
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     *            the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isSetCountry() {
        return getCountry() != null && !getCountry().isEmpty();
    }

    /**
     * @return the electronicMailAddress
     */
    public Set<String> getElectronicMailAddress() {
        return electronicMailAddress;
    }

    /**
     * @param electronicMailAddress
     *            the electronicMailAddress to set
     */
    public void setElectronicMailAddress(Set<String> electronicMailAddress) {
        this.electronicMailAddress = electronicMailAddress;
    }

    public boolean hasElectronicMailAddress() {
        return getElectronicMailAddress() != null && !getElectronicMailAddress().isEmpty();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AddressEntity)) {
            return false;
        }
        return super.equals(obj);
    }
}
