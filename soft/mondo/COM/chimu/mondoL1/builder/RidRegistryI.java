/***********************************************************************
**
**  File: chimu/mondoL1/builder/RidRegistryI.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.builder;

import COM.chimu.mondo.recipe.*;
import COM.chimu.kernel.functors.*;

public interface RidRegistryI  {
    public void   atRid_put(Object recipeId, Object anObject);
    public Object atRid(Object recipeId);
}
