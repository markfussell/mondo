/***********************************************************************
**
**  File: chimu/mondoL1/factory/general/BeanF.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory.general;

import COM.chimu.mondoL1.model.*;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.functors.*;


public interface ClassInfoBasedF extends Factory {
    public void setupClassInfo(ClassInfo classInfo);
}
