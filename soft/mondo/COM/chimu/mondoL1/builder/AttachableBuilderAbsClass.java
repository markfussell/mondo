/***********************************************************************
**
**  File: chimu/mondoL1/builder/AttachableBuilderAbsClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.builder;

import COM.chimu.mondo.model.*;

import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.support.*;

import COM.chimu.mondo.recipe.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

public abstract class AttachableBuilderAbsClass
                    extends FactoryBasedBuilderAbsClass
                    implements BuilderRecipeAttachmentI
                    {

//Conceputally you would normally do the following
/*
    public Object createObjectFromName_parameters (String name, Map parameters) {
        parameters = allParametersFor_with(name,parameters);
        return factoryCreateObjectFromName_parameters(name,parameters);
    }
*/

    //**************************************
    //**************************************
    //**************************************

    protected Map allParametersFor_with(String recipeName, Map parameters) {
        List extraParametersList         = (List) recipeToParameterValues.atKey(recipeName);
        List extraParameterFunctionsList = (List) recipeToParameterFunctions.atKey(recipeName);
        if (
                (extraParametersList == null) && (extraParameterFunctionsList == null)
            ) return parameters;

        if (parameters.size() == 0) {
            parameters = newParameterMap();
        }

        if (extraParametersList != null) {
            int size = extraParametersList.size();
            for (int i=0; i<size; i++) {
                Object[] extraParameters = (Object[]) extraParametersList.atIndex(i);
                String parameterName  = (String) extraParameters[0];
                Object parameterValue = extraParameters[1];

                if (parameterValue != noValueObject()) {
                    parameters.atKey_put(parameterName,parameterValue);
                }
            }
        };
        if (extraParameterFunctionsList != null) {
            int size = extraParameterFunctionsList.size();
            for (int i=0; i<size; i++) {
                Object[] extraParameterFunctions = (Object[]) extraParameterFunctionsList.atIndex(i);
                String parameterName  = (String) extraParameterFunctions[0];
                Function1Arg parameterFunction = (Function1Arg) extraParameterFunctions[1];
                Object parameterValue = parameterFunction.valueWith(this);

                if (parameterValue != noValueObject()) {
                    parameters.atKey_put(parameterName,parameterValue);
                }
            }
        };

        return parameters;
    }

    public void attachToRecipe_parameter_value(String recipeName, String parameterName, Object value) {
        Object[] entry = {parameterName, value};
        List list = (List) recipeToParameterValues.atKey(recipeName);
        if (list == null) {
            list = CollectionsImplPack.newList();
            recipeToParameterValues.atKey_put(recipeName,list);
        };
        list.add(entry);
    }

    public void attachToRecipe_parameter_valuable(String recipeName, String parameterName, Function1Arg valueable) {
        Object[] entry = {parameterName, valueable};
        List list = (List) recipeToParameterFunctions.atKey(recipeName);
        if (list == null) {
            list = CollectionsImplPack.newList();
            recipeToParameterFunctions.atKey_put(recipeName,list);
        };
        list.add(entry);
    }

    //**************************************
    //**************************************
    //**************************************

    protected Map recipeToParameterValues  = CollectionsImplPack.newMap();
    protected Map recipeToParameterFunctions = CollectionsImplPack.newMap();

}

