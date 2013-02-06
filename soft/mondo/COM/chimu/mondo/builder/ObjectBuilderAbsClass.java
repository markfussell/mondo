/***********************************************************************
**
**  File: chimu/mondo/builder/ObjectBuilderAbsClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder;

import COM.chimu.mondo.recipe.*;
import COM.chimu.mondo.model.ModelPack;  //Use the models NO_VALUE here

import COM.chimu.mondo.builder.client.BuilderClientConstants;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;
import java.util.Enumeration;

public abstract class ObjectBuilderAbsClass implements ObjectBuilder {

    public Map newParameterMap() {
        return CollectionsImplPack.newMap();
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

        /**
         * createObjectFromName_parameters is the main entrypoint
         * to the builder.  It both supports atoms (through recipes
         * with no ingredients) and compound object constructs.
         */
    public abstract Object createObjectFromName_parameters (String recipeName, Map parameters);

    public abstract Object createObjectFromString(String value);

    public abstract Object createObjectFromList(List values);

    public List newContentsList() {
        return CollectionsImplPack.newList();
    }

    //**************************************
    //**************************************
    //**************************************

        /**
         * Create an object from the recipe (which could have ingredient recipes
         * that need to be created first).  This can be viewed as an auxiliary
         * method because it is rare that Recipes are instantiated.
         */
    public Object  createObjectFromRecipe(Recipe recipe) {
        Object result;
        String recipeName = recipe.name();
        startRecipeContext(recipeName);

        //First handle the two optimization cases and then the normal case
        if (recipe instanceof StringRecipe) {
            result = createObjectFromString(
                    ((StringRecipe) recipe).stringValue()
                );
        } else if (recipe instanceof ListRecipe) {
            List subRecipeList = ((ListRecipe) recipe).subRecipeList();
            int size = subRecipeList.size();
            List ingredientList = CollectionsImplPack.newList(size);
            for (int i=0; i<size; i++) {
                        //startIndexParameterContext?
                Object ingredient = this.createObjectFromRecipe(
                        (Recipe) subRecipeList.atIndex(i)
                    );
                if (ingredient != noValueObject()) {
                    ingredientList.add(ingredient);
                }
                        //finishIndexParameterContext?
            };
            result = createObjectFromList(ingredientList);
        } else {

            Map subRecipes = recipe.subRecipes();
            if (subRecipes.isEmpty()) {  //Just an optimization
                result = createObjectFromName_parameters(recipeName,EMPTY_MAP);
            } else {
                Map parameters = CollectionsImplPack.newMap();
                Enumeration enum = subRecipes.keys();
                while (enum.hasMoreElements()) {
                    String ingredientName = (String) enum.nextElement();
                    startParameterContext(ingredientName);
                    Object ingredient = this.createObjectFromRecipe(
                            (Recipe) subRecipes.atKey(ingredientName)
                        );
                    if (ingredient != noValueObject()) {
                        parameters.atKey_put(ingredientName,ingredient);
                    }
                    finishParameterContext();
                }
                result = createObjectFromName_parameters(recipe.name(),parameters);
            }
        }
        finishRecipeContext();
        return result;
    }

    static protected Map EMPTY_MAP = CollectionsImplPack.newMap();

    //**************************************
    //**************************************
    //**************************************

    public void startRecipeContext(String recipeName) {}
    public void finishRecipeContext() {}

    public void startParameterContext(String parameterName) {}
    public void finishParameterContext() {}

    //**********************************************************
    //**********************************************************
    //**********************************************************

    public Object  noValueObject() {
        return ModelPack.NO_VALUE;
    }

    public Object  emptyParameterMapObject() {
        return EMPTY_MAP;
    }

    public String defaultParameterName() {
        return BuilderConstants.CONTENT_KEY;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************


        /**
         * This is just a redirect into the main entrypoint
         * method.  Subclasses can decide whether to handle
         * these methods directly or handle them through the
         * main entrypoint #createObjectFromName_parameters.
         */
    public Object  createObjectFromLiteral(String value){
        Object objectValue = createObjectFromString(value);
        Map map = newParameterMap();
        map.atKey_put(BuilderConstants.CONTENT_KEY, objectValue);
        return createObjectFromName_parameters(
                BuilderClientConstants.LITERAL_RECIPE, map
            );
    }


    //**********************************************************
    //**********************************************************
    //**********************************************************

    public Object  createObjectFromNull(){
/*
        Map map = newParameterMap();
        map.atKey_put(BuilderConstants.CONTENT_KEY, values);
        return createObjectFromName_parameters(
                BuilderConstants.NULL_RECIPE, map
            );
*/
        return null;
    }

}
