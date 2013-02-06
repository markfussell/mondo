/***********************************************************************
**
**  File: chimu/mondo/factory/general/ChainedFactoriesF.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.factory.general;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.functors.*;


public interface ChainedFactoriesF extends Factory {
    public void addFactory(Factory factory);
}
