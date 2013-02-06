/***********************************************************************
**
**  File: chimu/mondoL1/model/ScribingInfo.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.model;

import COM.chimu.mondo.model.*;

import COM.chimu.mondo.pen.*;
import COM.chimu.mondo.scribe.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;

public interface ClassScribingInfo extends ClassPropertyInfo {
    //**********************************************************
    //********************* Scribing Info **********************
    //**********************************************************

    public Pen defaultPenFor(Scribe scribe);

    public Extracter defaultExtracterFor(Object anObject);
    public Extracter defaultStubExtracterFor(Object anObject);
}

