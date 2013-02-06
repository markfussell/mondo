/***********************************************************************
**
**  File: chimu/mondo/factory/Factory.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.factory;

import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.Map;

/**
A Factory creates objects for a builder for a limited
number of Types.
**/
public interface Factory  {
    Object createObjectFromName_parameters_for(String name, Map ingredients, ObjectBuilder builder);
}
