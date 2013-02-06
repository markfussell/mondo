/***********************************************************************
**
**  File: chimu/mondo/factory/general/ChainedFactoriesFC.java
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
import COM.chimu.kernel.collections.impl.*;
import COM.chimu.kernel.functors.*;


public class ChainedFactoriesFC extends FactoryAbsClass implements ChainedFactoriesF {
    public ChainedFactoriesFC() {}
    public ChainedFactoriesFC(String name, ObjectBuilder builder) {}

    //**********************************************************
    //**********************************************************
    //**********************************************************

    public void addFactory(Factory factory) {
        factoryChain.add(factory);
    }

    public Object createObjectFromName_parameters_for(String recipeName, Map map, ObjectBuilder builder) {
        Object noResult = builder.noValueObject();
        int size = factoryChain.size();
        for (int i=0; i<size; i++) {
            Factory factory = (Factory) factoryChain.atIndex(i);
            Object result = factory.createObjectFromName_parameters_for(recipeName, map, builder);
            if (result != noResult) return result;
        }
        return noResult;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    List factoryChain = CollectionsImplPack.newList();
}
