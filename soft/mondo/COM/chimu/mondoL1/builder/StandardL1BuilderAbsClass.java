/***********************************************************************
**
**  File: chimu/mondoL1/builder/StandardL1BuilderAbsClass.java
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

public abstract class StandardL1BuilderAbsClass
                    extends AttachableBuilderAbsClass
                    implements BuilderRecipeAttachmentI
                    {

//Conceputally you would normally do the following
/*
    public Object createObjectFromName_parameters (String name, Map parameters) {
        parameters = allParametersFor_with(name,parameters);
        return factoryCreateObjectFromName_parameters(name,parameters);
    }
*/

    /*friend*/ public void atRid_put(Object recipeId, Object anObject) {
        ridToObject.atKey_put(recipeId,anObject);
    }

    /*friend*/ public Object atRid(Object recipeId) {
        return ridToObject.atKey(recipeId);
    }

    //**************************************
    //**************************************
    //**************************************

    Map ridToObject = CollectionsImplPack.newMap();

}

