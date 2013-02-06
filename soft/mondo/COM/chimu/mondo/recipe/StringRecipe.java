/***********************************************************************
**
**  File: chimu/mondo/recipe/StringRecipe.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.recipe;

import COM.chimu.mondo.model.StringValue;

public interface StringRecipe extends Recipe, StringValue {
    public String stringValue();
}

