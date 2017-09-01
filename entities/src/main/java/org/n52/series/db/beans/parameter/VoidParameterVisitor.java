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

import org.n52.shetland.ogc.om.NamedValue;
import org.n52.shetland.ogc.ows.exception.OwsExceptionReport;

public abstract class VoidParameterVisitor implements ParameterVisitor<Void> {

    protected abstract void _visit(ParameterQuantity p)
            throws OwsExceptionReport;

    protected abstract void _visit(ParameterBoolean p)
            throws OwsExceptionReport;

    protected abstract void _visit(ParameterCategory p)
            throws OwsExceptionReport;

    protected abstract void _visit(ParameterCount p)
            throws OwsExceptionReport;

    protected abstract void _visit(ParameterText p)
            throws OwsExceptionReport;

    protected abstract void _visit(ParameterXml p)
            throws OwsExceptionReport;

    @Override
    public NamedValue<Void> visit(ParameterQuantity p)
            throws OwsExceptionReport {
        _visit(p);
        return null;
    }

    @Override
    public NamedValue<Void> visit(ParameterBoolean p)
            throws OwsExceptionReport {
        _visit(p);
        return null;
    }

    @Override
    public NamedValue<Void> visit(ParameterCategory p)
            throws OwsExceptionReport {
        _visit(p);
        return null;
    }

    @Override
    public NamedValue<Void> visit(ParameterCount p)
            throws OwsExceptionReport {
        _visit(p);
        return null;
    }

    @Override
    public NamedValue<Void> visit(ParameterText p)
            throws OwsExceptionReport {
        _visit(p);
        return null;
    }

    @Override
    public NamedValue<Void> visit(ParameterXml p)
            throws OwsExceptionReport {
        _visit(p);
        return null;
    }

}
