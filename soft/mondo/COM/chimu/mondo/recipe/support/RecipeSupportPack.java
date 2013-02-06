/***********************************************************************
**
**  File: chimu/mondo/recipe/support/RecipeSupportPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.recipe.support;

import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.recipe.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;

/**
**/
public class RecipeSupportPack {

    //**********************************************************
    //(P)***************** Factory Methods *********************
    //**********************************************************

    static public Function1Arg newRecipeValuable(Recipe recipe) {
        return new RecipeValuable(recipe);
    }

    static protected class RecipeValuable implements Function1Arg {
        RecipeValuable(Recipe recipe) {
            this.recipe = recipe;
        }

        Recipe recipe = null;

        public Object valueWith(Object arg1) {
            ObjectBuilder builder = (ObjectBuilder) arg1;
            return builder.createObjectFromRecipe(recipe);
        }
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    private RecipeSupportPack() {}


}

