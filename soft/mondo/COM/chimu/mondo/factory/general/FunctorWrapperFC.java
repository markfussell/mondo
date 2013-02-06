/***********************************************************************
**
**  File: chimu/mondo/factory/general/FunctorWrapperFC.java
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


public class FunctorWrapperFC extends WrapperFactoryAbsClass {
    public FunctorWrapperFC() {}
    public FunctorWrapperFC(String name, ObjectBuilder builder) {
        this.name = name;
    }

    public void setupWrapperFunctor(Function1Arg converter) {
        this.converter = converter;
    }

    protected Object convertValue(Object value) {
        return converter.valueWith(value);
    }

    public String toString() {
        return name;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    String name = "FunctorWrapperFactory";
    Function1Arg converter = null;
}
