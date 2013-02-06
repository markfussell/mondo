/***********************************************************************
**
**  File: chimu/mondo/recipe/ListRecipe.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.recipe;

import COM.chimu.kernel.collections.List;


public interface ListRecipe extends Recipe {
    public List subRecipeList();
}

