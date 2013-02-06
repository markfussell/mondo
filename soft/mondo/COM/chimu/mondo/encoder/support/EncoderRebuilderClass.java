/***********************************************************************
**
**  File: chimu/mondo/encoder/support/EncoderRebuilderClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.encoder.support;
import COM.chimu.mondo.encoder.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.exceptions.*;

import java.util.Stack;

public class EncoderRebuilderClass extends ObjectEncoderAbsClass implements EncoderRebuilder {
    public EncoderRebuilderClass(ObjectBuilder builder) {
        this.builder = builder;
    }

    public void      startObject(String recipeName) {
        pushRecipeInfoStack();
        builder.startRecipeContext(recipeName);
        this.recipeName  = recipeName;
        parameterMap     = builder.newParameterMap();
    }

    public void      startParameter(String parameterName) {
        currentParameterName = parameterName;
        builder.startParameterContext(currentParameterName);
    }
    public void      startParameterValue() {}
    public void      finishParameterValue() {}
    public void      finishParameter() {
        builder.finishParameterContext();
        parameterMap.atKey_put(currentParameterName,currentValue);
    }

    public void      finishObject() {
        currentValue = builder.createObjectFromName_parameters(recipeName,parameterMap);
        builder.finishRecipeContext();
        popRecipeInfoStack();
    }

    public void      startDefaultParameter() {
        currentParameterName = builder.defaultParameterName();
        builder.startParameterContext(currentParameterName);
    }

    //**************************************
    //**************************************
    //**************************************

    public void      startList() {
        pushRecipeInfoStack();
        builder.startRecipeContext(recipeName);
        currentListValue = builder.newContentsList();
    }

    public void      startListElement() {};
    public void      finishListElement() {
        currentListValue.add(currentValue);
    }

    public void      finishList() {
        currentValue = builder.createObjectFromList(currentListValue);
        currentListValue = null;
        builder.finishRecipeContext();
        popRecipeInfoStack();
    }

    //**************************************
    //**************************************
    //**************************************

    public void      encodeString(String value) {
        currentValue = builder.createObjectFromString(value);
    }

    public void      encodeLiteral(String value) {
        currentValue = builder.createObjectFromLiteral(value);
    }

    public void      encodeNoValue() {
        currentValue = builder.noValueObject();
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected void popRecipeInfoStack() {
        Object[] recipeInfo = (Object[]) objectRecipeInfos.pop();
        int i = 0;
        recipeName              = (String)   recipeInfo[i++];
        parameterMap            = (Map)      recipeInfo[i++];
        currentParameterName    = (String)   recipeInfo[i++];
        currentListValue        = (List) recipeInfo[i++];

    }

    protected void pushRecipeInfoStack() {
        Object[] recipeInfo = new Object[4];

        int i = 0;
        recipeInfo[i++] = recipeName;
        recipeInfo[i++] = parameterMap;
        recipeInfo[i++] = currentParameterName;
        recipeInfo[i++] = currentListValue;
        objectRecipeInfos.push(recipeInfo);

        currentValue=null;

        recipeName=null;
        parameterMap = null; currentParameterName=null;
        currentListValue =null;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    public Object currentBuiltObject() {
        return currentValue;
    }


    protected ObjectBuilder builder = null;

    //**************************************
    //**************************************
    //**************************************

    protected Stack     objectRecipeInfos = new Stack();

    protected Object    currentValue;

    //**************************************
    // CreationState
    protected String    recipeName = null;
    protected Map       parameterMap = null;
    protected String    currentParameterName = null;
    protected List      currentListValue = null;

}
