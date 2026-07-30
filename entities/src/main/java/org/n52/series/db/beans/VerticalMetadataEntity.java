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

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.n52.series.db.beans.i18n.I18nVerticalMetadataEntity;

import java.io.Serial;
import java.util.Set;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.VerticalMetadataEntity")
@Table(name = "value_profile",
        indexes = @Index(name = "idx_profile_vertical_unit", columnList = "fk_vertical_unit_id"))
@AttributeOverride(name = "id", column = @Column(name = "value_profile_id"))
public class VerticalMetadataEntity extends IdEntity {

    public static final String PROPERTY_VERTICAL_UNIT = "verticalUnit";
    public static final String PROPERTY_VERTICAL_ORIENTATION = "orientation";
    public static final String PROPERTY_VERTICAL_ORIGIN_NAME = "verticalOriginName";
    public static final String PROPERTY_VERTICAL_FROM_NAME = "verticalFromName";
    public static final String PROPERTY_VERTICAL_TO_NAME = "verticalToName";
    @Serial
    private static final long serialVersionUID = 3156288491348980598L;

    @Column(name = "orientation", nullable = false)
    // @Comment("The \"orientation\" of the vertical values as integer. 1 => above verticalOriginName and -1
    // => below
    // verticalOriginName") // Hibernate 6.2+
    private Short orientation;

    @Column(name = "vertical_origin_name")
    // @Comment("The vertical origin name of the vertical values, e.g. water surface") // Hibernate 6.2+
    private String verticalOriginName;

    @Column(name = "vertical_from_name")
    // @Comment("The name of the vertical from values, e.g. from or depthFrom") // Hibernate 6.2+
    private String verticalFromName;

    @Column(name = "vertical_to_name")
    // @Comment("The name of the vertical from values, e.g. to or depthTo") // Hibernate 6.2+
    private String verticalToName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_vertical_unit_id", nullable = false, foreignKey = @ForeignKey(name = "fk_profile_unit"))
    private UnitEntity verticalUnit;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "value_profile_i18n", joinColumns = @JoinColumn(name = "fk_value_profile_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "value_profile_i18n_id", nullable = false))
    private Set<I18nVerticalMetadataEntity> translations;

    public Short getOrientation() {
        return orientation;
    }

    public void setOrientation(Short orientation) {
        this.orientation = orientation;
    }

    public boolean isSetOrientation() {
        return orientation != null;
    }

    public boolean isAboveVerticalOrigin() {
        return isSetOrientation() && getOrientation() >= 1;
    }

    public boolean isBelowVerticalOrigin() {
        return isSetOrientation() && getOrientation() <= -1;
    }

    public String getVerticalOriginName() {
        return verticalOriginName;
    }

    public void setVerticalOriginName(String name) {
        this.verticalOriginName = name;
    }

    public boolean isSetVerticalOriginName() {
        return getVerticalOriginName() != null && !getVerticalOriginName().isEmpty();
    }

    public String getVerticalFromName() {
        return verticalFromName;
    }

    public void setVerticalFromName(String name) {
        this.verticalFromName = name;
    }

    public boolean isSetVerticalFromName() {
        return getVerticalFromName() != null && !getVerticalFromName().isEmpty();
    }

    public String getVerticalToName() {
        return verticalToName;
    }

    public void setVerticalToName(String name) {
        this.verticalToName = name;
    }

    public boolean isSetVerticalToName() {
        return getVerticalToName() != null && !getVerticalToName().isEmpty();
    }

    public boolean areVerticalNamesEqual() {
        return isSetVerticalFromName() && isSetVerticalToName()
                && getVerticalFromName().equalsIgnoreCase(getVerticalToName());
    }

    public UnitEntity getVerticalUnit() {
        return verticalUnit;
    }

    public boolean hasVerticalUnit() {
        return getVerticalUnit() != null;
    }

    public void setVerticalUnit(UnitEntity verticalUnit) {
        if (this.verticalUnit == null && verticalUnit != null) {
            this.verticalUnit = verticalUnit;
        }
    }

    public Set<I18nVerticalMetadataEntity> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<I18nVerticalMetadataEntity> translations) {
        this.translations = translations;
    }
}
