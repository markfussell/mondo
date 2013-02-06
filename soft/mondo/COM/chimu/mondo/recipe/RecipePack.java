/***********************************************************************
**
**  File: chimu/mondo/recipe/RecipePack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.recipe;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

/**
A recipe is a core concept to MONDO and this package documents
the concepts and provides implementations supporting the recipe
structure.  But recipes are usually implied and not actually
instantiated so most of MONDO does not really care about this
package :-(
**/
public class RecipePack {

        /**
         * The disinguished key name that can be used if you
         * represent a recipe as a Map (with one value a String
         * and the rest Maps).
         */
    static public String RECIPE_KEY_NAME = "!RECIPE";

    //**********************************************************
    //(P)***************** Factory Methods *********************
    //**********************************************************

    static public Recipe newRecipeNamed_subRecipes(String name, Map subRecipes) {
        return new RecipeClass(name,subRecipes);
    }

        /**
         * Create a recipe that has no subRecipes
         */
    static public Recipe newRecipeNamed(String name) {
        return new RecipeClass(name,EMPTY_PARAMETER_MAP);
    }

    static public Recipe newStringRecipe(String value) {
        return new StringRecipeClass(value);
    }

    static public Recipe newListRecipe(List values) {
        return new ListRecipeClass(values);
    }

    static protected Map EMPTY_PARAMETER_MAP = CollectionsImplPack.newMap();

    //**********************************************************
    //**********************************************************
    //**********************************************************

    private RecipePack() {}


}

