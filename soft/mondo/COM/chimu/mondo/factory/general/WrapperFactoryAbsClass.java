/***********************************************************************
**
**  File: chimu/mondo/factory/general/WrapperFactoryAbsClass.java
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
import COM.chimu.kernel.functors.*;


public abstract class WrapperFactoryAbsClass extends FactoryAbsClass {
    public WrapperFactoryAbsClass() {}
    public WrapperFactoryAbsClass(String name, ObjectBuilder builder) {}

    public void setupFactory(Factory innerFactory) {
        this.innerFactory = innerFactory;
    }

    protected abstract Object convertValue(Object value);
    public Object createObjectFromName_parameters_for(String recipeName, Map map, ObjectBuilder builder) {
        return convertValue(
                innerFactory.createObjectFromName_parameters_for(
                    recipeName, map, builder
                )
            );
    }

    protected Factory innerFactory = null;
}
