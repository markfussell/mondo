/***********************************************************************
**
**  File: chimu/mondo/factory/general/NoValueFC.java
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


public class NoValueFC extends FactoryAbsClass  {
    public NoValueFC(String name, ObjectBuilder builder) {
    }

    public Object createObjectFromName_parameters_for(String name, Map map, ObjectBuilder builder) {
        return builder.noValueObject();
    }

    public String toString() {
        return "<ANoValueFactory>";
    }
}
