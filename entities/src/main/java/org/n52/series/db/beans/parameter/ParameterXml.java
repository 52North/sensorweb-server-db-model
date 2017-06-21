package org.n52.series.db.beans.parameter;

import org.n52.shetland.ogc.om.NamedValue;
import org.n52.shetland.ogc.ows.exception.OwsExceptionReport;

public class ParameterXml extends Parameter<String> {

    @Override
    public String getValueAsString() {
        return getValue();
    }
    
    @Override
    public void accept(VoidParameterVisitor visitor) throws OwsExceptionReport {
        visitor.visit(this);
    }

    @Override
    public <T> NamedValue<T> accept(ParameterVisitor<T> visitor) throws OwsExceptionReport {
        return visitor.visit(this);
    }
}
