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
package org.n52.series.db.beans.sta;

import org.n52.series.db.beans.DescribableEntity;

public class StaDescribableEntity extends DescribableEntity implements AbstractStaEntity {

    private static final long serialVersionUID = 948180142611914656L;

    private boolean processed;

    @Override
    public boolean isProcessed() {
        return processed;
    }

    @Override
    public AbstractStaEntity setProcessed(boolean processsed) {
        this.processed = processsed;
        return this;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof StaDescribableEntity)) {
            return false;
        }
        return super.equals(obj);
    }
}
