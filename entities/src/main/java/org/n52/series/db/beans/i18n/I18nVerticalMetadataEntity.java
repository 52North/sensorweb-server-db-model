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

package org.n52.series.db.beans.i18n;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.n52.series.db.beans.VerticalMetadataEntity;

import java.io.Serial;

@Entity(name = "org.n52.series.db.beans.i18n.I18nVerticalMetadataEntity")
@Table(name = "value_profile_i18n",
        indexes = @Index(name = "idx_value_profile_i18n_value_profile", columnList = "fk_value_profile_id"))
@AttributeOverride(name = "id", column = @Column(name = "value_profile_i18n_id"))
public class I18nVerticalMetadataEntity extends AbstractI18nEntity<VerticalMetadataEntity> {

    @Serial
    private static final long serialVersionUID = 329570776993990200L;

    @Column(name = "vertical_origin_name")
    // @Comment("Locale/language specific vertical origin name of the vertical metadata entity")
    private String verticalOriginName;

    @Column(name = "vertical_from_name")
    // @Comment("Locale/language specific verticalTo name of the vertical metadata entity")
    private String verticalFromName;

    @Column(name = "vertical_to_name")
    // @Comment("Locale/language specific verticalTo name of the vertical metadata entity")
    private String verticalToName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_entity_id", nullable = false)
    private VerticalMetadataEntity entity;

    public String getVerticalOriginName() {
        return verticalOriginName;
    }

    public void setVerticalOriginName(String name) {
        this.verticalOriginName = name;
    }

    public String getVerticalFromName() {
        return verticalFromName;
    }

    public void setVerticalFromName(String name) {
        this.verticalFromName = name;
    }

    public String getVerticalToName() {
        return verticalToName;
    }

    public void setVerticalToName(String name) {
        this.verticalToName = name;
    }

    @Override
    public VerticalMetadataEntity getEntity() {
        return entity;
    }

    public void setEntity(VerticalMetadataEntity entity) {
        this.entity = entity;
    }
}
