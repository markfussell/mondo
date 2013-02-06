/***********************************************************************
**
**  File: chimu/mondo/recipe/ListRecipeClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.recipe;

import COM.chimu.kernel.collections.Map;
import COM.chimu.kernel.collections.List;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

/**
**/
public class ListRecipeClass implements ListRecipe {
    public ListRecipeClass() {}

    public ListRecipeClass(List subRecipeList) {
        this.subRecipeList = subRecipeList;
    }

    public String name() {
        return "!List";
    }

    public Map /*of String(IngredientName)->Recipe*/ subRecipes() {
        if (subRecipeMap == null) {
            subRecipeMap = createMapFromList(subRecipeList);
        }
        return subRecipeMap;
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
        return "<!Recipe "+name()+" "+subRecipeList+">";
    }

    public List subRecipeList() {
        return subRecipeList;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected static Map createMapFromList(List values) {
        Map map = CollectionsImplPack.newMap();
        int size = values.size();
        if (size < indexToName.length) {
            for (int i=0; i<size; i++) {
                map.atKey_put(indexToName[i],values.atIndex(i));
            }
        } else {
            for (int i=0; i<indexToName.length; i++) {
                map.atKey_put(indexToName[i],values.atIndex(i));
            }
            for (int i=indexToName.length; i< size; i++) {
                map.atKey_put(String.valueOf(i),values.atIndex(i));
            }
        }
        return map;
    }


    protected String value = null;
    protected List subRecipeList = null;
    protected Map  subRecipeMap  = null;

    static protected String[] indexToName = {
            "0","1","2","3","4","5","6","7","8","9",
            "10","11","12","13","14","15","16","17","18","19"
        };

}

