/***********************************************************************
**
**  File: chimu/mondo/builder/client/RecipeObjectBuilder.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder.client;

import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.List;

public interface RecipeObjectBuilder  {
        /**
         * Build an object through the ObjectBuilder using
         * the Ingredients you internally maintain.
         */
    public Object buildObjectFor(ObjectBuilder builder);
    public void appendToList_for(List list, ObjectBuilder builder);
}
