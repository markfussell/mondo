/***********************************************************************
**
**  File: chimu/mondo/builder/support/FactoryBasedBuilder.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder.support;

import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.factory.*;

public  interface FactoryBasedBuilder extends ObjectBuilder {
    public void setFactoryForRecipe_to(String recipeName, Factory factory);
}
