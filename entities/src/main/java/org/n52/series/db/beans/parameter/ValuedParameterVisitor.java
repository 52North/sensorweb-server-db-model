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

package org.n52.series.db.beans.parameter;

import org.n52.series.db.beans.HibernateRelations.HasUnit;
import org.n52.series.db.beans.UnitEntity;
import org.n52.shetland.ogc.UoM;
import org.n52.shetland.ogc.gml.ReferenceType;
import org.n52.shetland.ogc.om.NamedValue;
import org.n52.shetland.ogc.om.values.BooleanValue;
import org.n52.shetland.ogc.om.values.CategoryValue;
import org.n52.shetland.ogc.om.values.CountValue;
import org.n52.shetland.ogc.om.values.QuantityValue;
import org.n52.shetland.ogc.om.values.TextValue;
import org.n52.shetland.ogc.om.values.Value;
import org.n52.shetland.ogc.ows.exception.OwsExceptionReport;

public class ValuedParameterVisitor
        implements
        ParameterVisitor<NamedValue<?>> {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public NamedValue visit(ParameterQuantity p)
            throws OwsExceptionReport {
        NamedValue<Double> namedValue = new NamedValue<>();
        addName(namedValue, p);
        namedValue.setValue(new QuantityValue(p.getValue()));
        addUnit(p, namedValue.getValue());
        return namedValue;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public NamedValue visit(ParameterBoolean p)
            throws OwsExceptionReport {
        NamedValue<Boolean> namedValue = new NamedValue<>();
        addName(namedValue, p);
        namedValue.setValue(new BooleanValue(p.getValue()));
        return namedValue;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public NamedValue visit(ParameterCategory p)
            throws OwsExceptionReport {
        NamedValue<String> namedValue = new NamedValue<>();
        addName(namedValue, p);
        namedValue.setValue(new CategoryValue(p.getValue()));
        addUnit(p, namedValue.getValue());
        return namedValue;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public NamedValue visit(ParameterCount p)
            throws OwsExceptionReport {
        NamedValue<Integer> namedValue = new NamedValue<>();
        addName(namedValue, p);
        namedValue.setValue(new CountValue(p.getValue()));
        return namedValue;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public NamedValue visit(ParameterText p)
            throws OwsExceptionReport {
        NamedValue<String> namedValue = new NamedValue<>();
        addName(namedValue, p);
        namedValue.setValue(new TextValue(p.getValue()));
        return namedValue;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public NamedValue visit(ParameterXml p)
            throws OwsExceptionReport {
        // NamedValue<XmlObject> namedValue = new NamedValue<>();
        // addName(namedValue, p);
        // namedValue.setValue(new XmlValue(p.getValueAsXml()));
        // TODO how to handle XML
        NamedValue<String> namedValue = new NamedValue<>();
        addName(namedValue, p);
        namedValue.setValue(new TextValue(p.getValue()));
        return namedValue;
    }

    protected void addUnit(ValuedParameter<?, ?> vp, Value<?> v) {
        if (!v.isSetUnit() && vp instanceof HasUnit && ((HasUnit) vp).isSetUnit()) {
            UnitEntity unit = ((HasUnit) vp).getUnit();
            UoM uom = new UoM(unit.getUnit());
            if (unit.isSetName()) {
                uom.setName(unit.getName());
            }
            if (unit.isSetLink()) {
                uom.setLink(unit.getLink());
            }
            v.setUnit(uom);
        }
    }

    protected NamedValue<?> addName(NamedValue<?> namedValue, ValuedParameter<?, ?> p) {
        ReferenceType referenceType = new ReferenceType(p.getName());
        namedValue.setName(referenceType);
        return namedValue;
    }

}
