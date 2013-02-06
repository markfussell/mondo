/***********************************************************************
**
**  File: chimu/mondoL1/factory/AttachToRecipeFactoryClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory;
import COM.chimu.mondoL1.builder.*;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.model.*;
import COM.chimu.mondo.recipe.*;
import COM.chimu.mondo.recipe.support.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

public class AttachToRecipeFactoryClass extends FactoryAbsClass  {
    public AttachToRecipeFactoryClass(String name, ObjectBuilder builder) {
    }

    protected String getStringFrom(Object anObject) {
        if (anObject instanceof String) {
            return (String) anObject;
        } else if (anObject instanceof StringValue) {
            return ((StringValue) anObject).stringValue();
        } else {
            return anObject.toString();
        }
    }

    public Object createObjectFromName_parameters_for(String recipeName, Map map, ObjectBuilder builder) {
        //First determine what type of attachment.
        //Either:
        //  (1) <... value  = >
        //  (2) <... recipe = >

        Object nameO          = map.atKey("name");
        Object parameterNameO = map.atKey("parameter");
        Object value          = map.atKey("value");
        Object recipeObject   = map.atKey("recipe");

        boolean missingParameter = false;
        if (nameO == null) {
            System.err.println("AttachToRecipe ["+recipeName+"] call without 'name='");
            missingParameter = true;
        }
        if (parameterNameO == null) {
            System.err.println("AttachToRecipe ["+recipeName+"] call without 'parameter='");
            missingParameter = true;
        }
        if ((value == null) && (recipeObject == null)) {
            System.err.println("AttachToRecipe ["+recipeName+"] call with neither 'value=' or 'recipe='");
            missingParameter = true;
        }
        if ((value != null) && (recipeObject != null)) {
            System.err.println("AttachToRecipe ["+recipeName+"] call with both 'value=' and 'recipe='");
            missingParameter = true;
        }
        if (missingParameter) return builder.noValueObject();


        String name = getStringFrom(nameO);
        String parameterName = getStringFrom(parameterNameO);
        BuilderRecipeAttachmentI attachee = (BuilderRecipeAttachmentI) builder;

        if (value != null) {
            attachee.attachToRecipe_parameter_value(name,parameterName,value);
        } else if (recipeObject instanceof Recipe) {
            Recipe recipe = (Recipe) recipeObject;
            Function1Arg valuable = RecipeSupportPack.newRecipeValuable(recipe);
            attachee.attachToRecipe_parameter_valuable(name,parameterName,valuable);
        } else {
            System.err.println("AttachToRecipe call with 'recipe=' value not a Recipe");
            return builder.noValueObject();
        }
        return builder.noValueObject();
    }

}
