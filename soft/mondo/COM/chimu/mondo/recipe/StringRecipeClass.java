/***********************************************************************
**
**  File: chimu/mondo/recipe/StringRecipeClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.recipe;

import COM.chimu.kernel.collections.Map;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

/**
RecipeClass provides a simple implementation of a Recipe
**/
public class StringRecipeClass implements StringRecipe {
    public StringRecipeClass() {}

    public StringRecipeClass(String value) {
        this.value = value;
    }

    public String name() {
        return "!String";
    }

    public Map /*of String(IngredientName)->Recipe*/ subRecipes() {
        return SUB_RECIPES;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************
    /* Secondary generic setters */

    public void setName(String name) {
    }

    public void setSubRecipes(Map subRecipes) {
    }

    public String toString() {
        return "<!Recipe "+name()+" "+value+">";
    }

    public String stringValue() {
        return value;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected String value = null;
    static protected Map SUB_RECIPES = CollectionsImplPack.newMap();


}

