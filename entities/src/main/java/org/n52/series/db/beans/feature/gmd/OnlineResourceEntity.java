/**
 * Copyright (C) 2012-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.series.db.beans.feature.gmd;

/**
 * Hibernate entity for onlineResource.
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 *
 */
public class OnlineResourceEntity extends AbstractCiEntity {

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

}
