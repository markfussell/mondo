/***********************************************************************
**
**  File: chimu/mondoL1/builder/BuilderRecipeAttachmentI.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.builder;

import COM.chimu.mondo.recipe.*;
import COM.chimu.kernel.functors.*;

public interface BuilderRecipeAttachmentI  {

    public void attachToRecipe_parameter_value(String recipeName, String parameterName, Object value);

        /**
         *@params valuable takes the builder as the first argument
         */
    public void attachToRecipe_parameter_valuable(String recipeName, String parameterName, Function1Arg valuable);
}
