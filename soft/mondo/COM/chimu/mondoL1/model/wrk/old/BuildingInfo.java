/***********************************************************************
**
**  File: chimu/mondoL1/model/BuildingInfo.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.model.*;

import COM.chimu.mondo.model.*;

import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.factory.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;

public interface BuildingInfo extends CoreClassInfo {
    public Factory defaultFactoryFor(ObjectBuilder scribe);
    // public Function0Arg basicNewFunction();
}

