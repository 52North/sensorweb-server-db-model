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
package org.n52.series.db.beans.feature.inspire;

import java.io.Serializable;
import java.util.Set;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class MediaMonitored implements Serializable {

    private static final long serialVersionUID = 6901599832181367565L;

    private long feature;
    private Set<String> mediaMonitored;

    public long getFeature() {
        return feature;
    }

    public void setFeature(long feature) {
        this.feature = feature;
    }

    /**
     * @return the mediaMonitored
     */
    public Set<String> getMediaMonitored() {
        return mediaMonitored;
    }

    /**
     * @param mediaMonitored
     *            the mediaMonitored to set
     */
    public void setMediaMonitored(Set<String> mediaMonitored) {
        this.mediaMonitored = mediaMonitored;
    }
}
