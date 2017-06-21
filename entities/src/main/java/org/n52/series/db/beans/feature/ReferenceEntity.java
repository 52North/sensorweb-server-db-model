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
package org.n52.series.db.beans.feature;

import java.net.URI;
import java.net.URISyntaxException;

import org.n52.shetland.w3c.xlink.Reference;

/**
 * @author Carsten Hollmann <c.hollmann@52north.org>
 * @since 4.4.0
 *
 */
public abstract class ReferenceEntity extends NilReasonEntity {

    private String href;
    private String type;
    private String role;
    private String arcrole;
    private String title;
    private String show;
    private String actuate;
    private String remoteSchema;

    /**
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href
     *            the href to set
     */
    public void setHref(String href) {
        this.href = href;
    }
    
    public boolean isSetHref() {
        return getHref() != null && !getHref().isEmpty();
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    public boolean isSetType() {
        return getType() != null && !getType().isEmpty();
    }
    
    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    public boolean isSetRole() {
        return getRole() != null && !getRole().isEmpty();
    }

    /**
     * @return the arcrole
     */
    public String getArcrole() {
        return arcrole;
    }

    /**
     * @param arcrole
     *            the arcrole to set
     */
    public void setArcrole(String arcrole) {
        this.arcrole = arcrole;
    }
    
    public boolean isSetArcrole() {
        return getArcrole() != null && !getArcrole().isEmpty();
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSetTitle() {
        return getTitle() != null && !getTitle().isEmpty();
    }
    
    /**
     * @return the show
     */
    public String getShow() {
        return show;
    }

    /**
     * @param show
     *            the show to set
     */
    public void setShow(String show) {
        this.show = show;
    }
    
    public boolean isSetShow() {
        return getShow() != null && !getShow().isEmpty();
    }

    /**
     * @return the actuate
     */
    public String getActuate() {
        return actuate;
    }

    /**
     * @param actuate
     *            the actuate to set
     */
    public void setActuate(String actuate) {
        this.actuate = actuate;
    }
    
    public boolean isSetActuate() {
        return getActuate() != null && !getActuate().isEmpty();
    }

    /**
     * @return the remoteSchema
     */
    public String getRemoteSchema() {
        return remoteSchema;
    }

    /**
     * @param remoteSchema
     *            the remoteSchema to set
     */
    public void setRemoteSchema(String remoteSchema) {
        this.remoteSchema = remoteSchema;
    }
    
    public boolean isSetRemoteSchema() {
        return getRemoteSchema() != null && !getRemoteSchema().isEmpty();
    }
    
    public Reference createReferenceValues() {
        Reference reference = new Reference();
        if (isSetHref()) {
            try {
                reference.setHref(new URI(getHref()));
            } catch (URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (isSetType()) {
            reference.setType(getType());
        }
        if (isSetRole()) {
            reference.setRole(getRole());
        }
        if (isSetArcrole()) {
            reference.setArcrole(getArcrole());
        }
        if (isSetShow()) {
            reference.setShow(getShow());
        }
        if (isSetActuate()) {
            reference.setActuate(getActuate());
        }
        if (isSetRemoteSchema()) {
            reference.setRemoteSchema(getRemoteSchema());
        }
        return reference;
    }
}
