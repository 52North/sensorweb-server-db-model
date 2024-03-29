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
package org.n52.series.db.beans;

/**
 * Entity for AQD e-Reporting Network
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
public class NetworkEntity extends DescribableEntity {

    public static final String ID = "network";

    private static final long serialVersionUID = -6039520306580755303L;

    private Long network;

    /**
     * @return the network
     */
    public Long getNetwork() {
        return network;
    }

    /**
     * @param network
     *            the network to set
     * @return this
     */
    public NetworkEntity setNetwork(Long network) {
        this.network = network;
        return this;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NetworkEntity)) {
            return false;
        }
        return super.equals(obj);
    }
}
