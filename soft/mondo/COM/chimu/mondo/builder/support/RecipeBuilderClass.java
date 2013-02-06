/***********************************************************************
**
**  File: chimu/mondo/builder/support/RecipeBuilderClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder.support;

import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.recipe.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;
import java.util.Vector;

public class RecipeBuilderClass extends ObjectBuilderAbsClass {
    public Map newParameterMap() {
        return CollectionsImplPack.newOrderedMap();
    }

    public Object createObjectFromName_parameters (String name, Map parameters) {
        return RecipePack.newRecipeNamed_subRecipes(name,parameters);
    }

    public Object  createObjectFromList(List values){
        return RecipePack.newListRecipe(values);
    }

    public Object  createObjectFromString(String value) {
        return RecipePack.newStringRecipe(value);
    }

}
