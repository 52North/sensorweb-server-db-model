/*
 * Copyright 2015-2021 52°North Spatial Information Research GmbH
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
 * Hibernate entity for onlineResource.
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
public class OnlineResourceEntity extends AbstractCiEntity {

    private static final long serialVersionUID = -7852109322377425189L;

    private String linkage;

    private String protocol;

    private String applicationProfile;

    private String function;

    /**
     * @return the linkage
     */
    public String getLinkage() {
        return linkage;
    }

    /**
     * @param linkage
     *            the linkage to set
     * @return this
     */
    public OnlineResourceEntity setLinkage(String linkage) {
        this.linkage = linkage;
        return this;
    }

    public boolean isSetLinkage() {
        return getLinkage() != null && !getLinkage().isEmpty();
    }

    /**
     * @return the protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * @param protocol
     *            the protocol to set
     * @return this
     */
    public OnlineResourceEntity setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public boolean isSetProtocol() {
        return getProtocol() != null && !getProtocol().isEmpty();
    }

    /**
     * @return the applicationProfile
     */
    public String getApplicationProfile() {
        return applicationProfile;
    }

    /**
     * @param applicationProfile
     *            the applicationProfile to set
     * @return this
     */
    public OnlineResourceEntity setApplicationProfile(String applicationProfile) {
        this.applicationProfile = applicationProfile;
        return this;
    }

    public boolean isSetApplicationProfile() {
        return getApplicationProfile() != null && !getApplicationProfile().isEmpty();
    }

    /**
     * @return the function
     */
    public String getFunction() {
        return function;
    }

    /**
     * @param function
     *            the function to set
     * @return this
     */
    public OnlineResourceEntity setFunction(String function) {
        this.function = function;
        return this;
    }

    public boolean isSetFunction() {
        return getFunction() != null && !getFunction().isEmpty();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OnlineResourceEntity)) {
            return false;
        }
        return super.equals(obj);
    }
}