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
package org.n52.series.db.beans.feature;

import java.net.URI;
import java.net.URISyntaxException;

import org.n52.shetland.w3c.xlink.Reference;

/**
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
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
