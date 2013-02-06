/***********************************************************************
**
**  File: chimu/mondo/factory/general/FunctorFC.java
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


public class FunctorFC extends FactoryAbsClass implements FunctorF {
    public FunctorFC() {}
    public FunctorFC(String name, ObjectBuilder builder) {
        this.name = name;
    }

    public void setupFunctor_withArguments(Function1Arg constructor, String[] argNames) {
        this.argNames = argNames;
        this.constructor = constructor;
    }

    public Object[] newParameterArrayFrom(Map map) {
        int size = argNames.length;
        Object[] result = new Object[size];
        for (int i=0; i<size; i++) {
            result[i]=map.atKey(argNames[i]);
        }
        return result;
    }

    public Object createObjectFromName_parameters_for(String recipeName, Map map, ObjectBuilder builder) {
        Object[] parameterArray = newParameterArrayFrom(map);
        return constructor.valueWith(parameterArray);
    }

    public String toString() {
        return name;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

//Maximum match length
//Ordered preference?
//Cache keys->functor

    //**********************************************************
    //**********************************************************
    //**********************************************************

    String name = "FunctorFactory";
    Function1Arg constructor = null;
    String[] argNames = null;
}
