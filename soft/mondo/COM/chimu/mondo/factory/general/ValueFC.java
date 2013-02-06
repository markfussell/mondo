/***********************************************************************
**
**  File: chimu/mondo/factory/general/ValueFC.java
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


public class ValueFC extends FactoryAbsClass implements ValueF {
    public ValueFC() {}
    public ValueFC(String name, ObjectBuilder builder) {
        value = builder.noValueObject();
    }

    public void setupValue(Object value) {
        this.value = value;
    }

    public Object createObjectFromName_parameters_for(String name, Map map, ObjectBuilder builder) {
        return value;
    }

    public String toString() {
        return "<ValueFactory value="+value+">";
    }

    protected Object value;
}
