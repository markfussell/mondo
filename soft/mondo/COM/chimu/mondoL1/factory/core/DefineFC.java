/***********************************************************************
**
**  File: chimu/mondoL1/factory/core/DefineFC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory.core;
import COM.chimu.mondoL1.builder.*;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.factory.general.*;
import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.support.*;
import COM.chimu.mondo.model.*;
import COM.chimu.mondo.recipe.*;
import COM.chimu.mondo.recipe.support.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

public class DefineFC extends FactoryAbsClass  {
    public DefineFC() {}
    public DefineFC(String name, ObjectBuilder builder) {}

    public Object createObjectFromName_parameters_for(String recipeName, Map map, ObjectBuilder builder) {
        //First determine what type of attachment.
        //Either:
        //  (1) <... value  = >
        //  (2) <... recipe = >

        Object nameO = map.atKey("name");
        Object value = map.atKey("value");

        boolean missingParameter = false;
        if (nameO == null) {
            System.err.println("Define ["+recipeName+"] call without 'name='");
        }
        if (value == null) {
            System.err.println("Define ["+recipeName+"] call without 'value='");
        }
        if (builder instanceof FactoryBasedBuilder) {

            String name = ModelPack.getStringValueFrom(nameO);
            ValueF factory = new ValueFC(name,builder);
            factory.setupValue(value);

            ((FactoryBasedBuilder) builder).setFactoryForRecipe_to(
                name, factory);

        } else {
            System.err.println("Not a factory based builder "+builder);
        }


        return builder.noValueObject();
    }

}
