/***********************************************************************
**
**  File: chimu/mondo/factory/general/HoistCollapseParameterFC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.factory.general;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;


public class HoistCollapseParameterFC extends FactoryAbsClass implements SetParameterToI {
    public HoistCollapseParameterFC() {}
    public HoistCollapseParameterFC(String name, ObjectBuilder builder) {
        parameter = builder.defaultParameterName();
    }

    public void setParameterTo(String parameterName) {
        parameter = parameterName;
    }


    public Object createObjectFromName_parameters_for(String name, Map map, ObjectBuilder builder) {
        Object value =map.atKey(parameter);
        if (value instanceof Collection) {
            Collection values = (Collection) value;
            if (values.size() == 0) {
                return builder.noValueObject();
            } else if (values.size() == 1) {
                return ((List) values).atIndex(0);  //Cheat, should really ask for .first
            };
        }
        return value;
    }

    public String toString() {
        return "<HoistCollapseParameterFactory>";
    }

    protected String parameter = null;
}
