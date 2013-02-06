/***********************************************************************
**
**  File: chimu/mondo/factory/general/MultiFunctorF.java
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


public interface MultiFunctorF extends Factory {
    public void addFunctor_withArguments(Function1Arg constructor, String[] argNames);
}
