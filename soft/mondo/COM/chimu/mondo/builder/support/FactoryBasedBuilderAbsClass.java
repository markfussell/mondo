/***********************************************************************
**
**  File: chimu/mondo/builder/support/FactoryBasedBuilderAbsClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder.support;

import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.factory.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;
import java.util.Vector;

public abstract class FactoryBasedBuilderAbsClass
                            extends ObjectBuilderAbsClass
                            implements FactoryBasedBuilder {

    public Object createObjectFromName_parameters (String name, Map parameters) {
        name = expandRecipeName(name);
        return factoryCreateObjectFromName_parameters(name,parameters);
    }

    public void setFactoryForRecipe_to(String recipeName, Factory factory) {
        recipeNameToFactory.atKey_put(recipeName,factory);
    }

    protected String expandRecipeName(String recipeName) {
        //if (expansionPrefix == null)
        return recipeName;
    }

    protected Object factoryCreateObjectFromName_parameters (String name, Map parameters) {
        Factory factory = findFactoryForRecipeName(name);
        if (factory != null) {
            try {
                return factory.createObjectFromName_parameters_for(name,parameters, this);
            } catch (Exception e) {
                System.err.println("Factory exception for: "+factory);
                e.printStackTrace();
                return noValueObject();
            }
        } else {
            return defaultCreateObjectFromName_parameters(name,parameters);
        }
    }

    //**************************************
    //**************************************
    //**************************************

    protected Factory findFactoryForRecipeName(String recipeName) {
        Factory factory = (Factory) recipeNameToFactory.atKey(recipeName);
        if (factory == null) {
            factory = createFactory(recipeName);
            recipeNameToFactory.atKey_put(recipeName,factory);
        };
        return factory;
    }

    protected abstract Factory createFactory(String recipeName);
    protected abstract Object defaultCreateObjectFromName_parameters (String name, Map parameters);

    //**************************************
    //**************************************
    //**************************************

    protected Map recipeNameToFactory = CollectionsImplPack.newMap();

}
