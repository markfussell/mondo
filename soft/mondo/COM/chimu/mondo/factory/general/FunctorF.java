/***********************************************************************
**
**  File: chimu/mondo/factory/general/FunctorF.java
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


public interface FunctorF extends Factory {
    public void setupFunctor_withArguments(Function1Arg constructor, String[] argNames);
}
