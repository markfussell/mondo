/***********************************************************************
**
**  File: chimu/mondo/recipe/RecipeClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.recipe;

import COM.chimu.kernel.collections.Map;

/**
RecipeClass provides a simple implementation of a Recipe
**/
public class RecipeClass implements Recipe {
    public RecipeClass() {}

    public RecipeClass(String name, Map subRecipes) {
        this.name = name;
        this.subRecipes = subRecipes;
    }

    public String name() {
        return name;
    }

    public Map /*of String(IngredientName)->Recipe*/ subRecipes() {
        return subRecipes;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************
    /* Secondary generic setters */

    public void setName(String name) {
        this.name = name;
    }

    public void setSubRecipes(Map subRecipes) {
        this.subRecipes = subRecipes;
    }

    public String toString() {
        return "<!Recipe "+name+">";
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected String name = null;
    protected Map subRecipes = null;


}

