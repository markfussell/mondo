/***********************************************************************
**
**  File: chimu/mondoOml/parser/ParameterNode.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;

import COM.chimu.kernel.collections.*;
import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.client.*;


/**
ParameterNode includes the node functionality to identify
whether this is the last node of the list.
**/
public interface ParameterNode extends RecipeParameterBuilder  {
    public String identifyingName();
    public boolean hasValue();
}
