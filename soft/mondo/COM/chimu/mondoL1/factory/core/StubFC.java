/***********************************************************************
**
**  File: chimu/mondoL1/factory/core/StubFC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory.core;
import COM.chimu.mondoL1.builder.*;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.support.*;
import COM.chimu.mondo.model.*;
import COM.chimu.mondo.recipe.*;
import COM.chimu.mondo.recipe.support.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

public class StubFC extends FactoryAbsClass  {
    public StubFC() {}
    public StubFC(String name, ObjectBuilder builder) {}

    public Object createObjectFromName_parameters_for(String recipeName, Map map, ObjectBuilder builder) {
        Object rid = map.atKey("ridref");
        if (rid == null) {
            System.err.println("No ridref for: "+recipeName);
        }

        RidRegistryI registry = (RidRegistryI) builder;

        Object result = registry.atRid(rid);
        if (result == null) {
            System.err.println("Null value for: "+recipeName+" with ridref="+rid);
        }
        return result;
    }

}
