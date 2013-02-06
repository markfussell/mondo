/***********************************************************************
**
**  File: chimu/mondo/builder/support/DelegatingBuilderAbsClass.java
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

public abstract class DelegatingBuilderAbsClass implements ObjectBuilder {

    public Map newParameterMap() {
        return currentBuilder().newParameterMap();
    }

    public List newContentsList() {
        return currentBuilder().newContentsList();
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    public Object createObjectFromName_parameters (String name, Map parameters) {
        return currentBuilder().createObjectFromName_parameters(name,parameters);
    }

    public Object  createObjectFromRecipe(Recipe recipe) {
        return currentBuilder().createObjectFromRecipe(recipe);
    }

    public void startRecipeContext(String recipeName) {
        currentBuilder().startRecipeContext(recipeName);
    }
    public void startParameterContext(String parameterName) {
        currentBuilder().startParameterContext(parameterName);
    }
    public void finishParameterContext() {
        currentBuilder().finishParameterContext();
    }
    public void finishRecipeContext() {
        currentBuilder().finishRecipeContext();
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    public Object  noValueObject() {
        return currentBuilder().noValueObject();
    }

    public String defaultParameterName() {
        return currentBuilder().defaultParameterName();
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************


    public Object  createObjectFromString(String value) {
        return currentBuilder().createObjectFromString(value);
    }
    public Object  createObjectFromLiteral(String value){
        return currentBuilder().createObjectFromLiteral(value);
    }

    public Object  createObjectFromList(List values){
        return currentBuilder().createObjectFromList(values);
    }


    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected abstract ObjectBuilder currentBuilder();

}
