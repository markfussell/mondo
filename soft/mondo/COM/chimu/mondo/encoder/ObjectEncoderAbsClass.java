/***********************************************************************
**
**  File: chimu/mondo/encoder/ObjectEncoderAbsClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.encoder;
import COM.chimu.mondo.recipe.*;
import COM.chimu.kernel.collections.Map;
import COM.chimu.kernel.collections.List;
import java.util.Enumeration;

public abstract class ObjectEncoderAbsClass implements ObjectEncoder  {

    public void  encodeRecipe(Recipe recipe) {
        String recipeName = recipe.name();
        if (recipe instanceof StringRecipe) {
            encodeString(
                    ((StringRecipe) recipe).stringValue()
                );
            return;
        } else if (recipe instanceof ListRecipe) {
            encodeListOfRecipes(
                    ((ListRecipe) recipe).subRecipeList()
                );
            return;
        }

        startObject(recipeName);
        Map subRecipes = recipe.subRecipes();
        if (!subRecipes.isEmpty()) {
            Enumeration enum = subRecipes.keys();
            while (enum.hasMoreElements()) {
                String ingredientName = (String) enum.nextElement();
                if (ingredientName.equals("!content")) {
                    startDefaultParameter();
                } else {
                    startParameter(ingredientName);
                }

                Object ingredientRecipeTest = subRecipes.atKey(ingredientName);
                if (ingredientRecipeTest instanceof Recipe) {
                    Recipe ingredientRecipe = (Recipe) subRecipes.atKey(ingredientName);

                    if (ingredientRecipe != null) {
                        startParameterValue();
                        encodeRecipe(ingredientRecipe);
                        finishParameterValue();
                    }
                } else {
                    startParameterValue();
                    encodeString ("**"+ingredientRecipeTest.toString());
                    finishParameterValue();
                }

                finishParameter();
            }
        }
        finishObject();
    }

    public void      encodeListOfRecipes(List list) {
        startList();
        int size = list.size();
        for (int i=0; i<size; i++) {
            startListElement();
            encodeRecipe((Recipe) list.atIndex(i));
            finishListElement();
        };
        finishList();
    }

    public void      startValuedParameter(String ingredientName) {
        startParameter(ingredientName);
        startParameterValue();
    }

    public void      finishValuedParameter() {
        finishParameterValue();
        finishParameter();
    }

}

