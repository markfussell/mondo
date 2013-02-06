/***********************************************************************
**
**  File: chimu/mondo/factory/general/HoistParameterFC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.factory.general;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.Map;


public class HoistParameterFC extends FactoryAbsClass  {
    public HoistParameterFC() {}

    public HoistParameterFC(String name, ObjectBuilder builder) {
        parameter = builder.defaultParameterName();
    }

    public Object createObjectFromName_parameters_for(String name, Map map, ObjectBuilder builder) {
        return map.atKey(parameter);
    }

    public String toString() {
        return "<HoistContentFactory>";
    }

    protected String parameter = null;
}
