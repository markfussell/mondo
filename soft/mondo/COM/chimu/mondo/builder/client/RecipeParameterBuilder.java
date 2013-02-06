/***********************************************************************
**
**  File: chimu/mondo/builder/client/RecipeParameterBuilder.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder.client;

import COM.chimu.mondo.builder.*;
import COM.chimu.kernel.collections.Map;

public interface RecipeParameterBuilder  {
    public void buildObjectIntoMap_for(Map parameterMap, ObjectBuilder builder);
}
