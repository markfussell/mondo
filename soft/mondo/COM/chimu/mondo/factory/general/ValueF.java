/***********************************************************************
**
**  File: chimu/mondo/factory/general/ValueF.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.factory.general;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.Map;


public interface ValueF extends Factory  {
    public void setupValue(Object value);
}
