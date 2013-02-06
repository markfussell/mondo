/***********************************************************************
**
**  File: chimu/mondoL1/model/ClassInfo.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.model;

import COM.chimu.mondo.model.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;


/**
Information about how to construct, set, and extract information
from an object
**/
public interface ClassPropertyInfo extends ClassCoreInfo {

    //**********************************************************
    //********************* Property Info **********************
    //**********************************************************

    public Map /*of String->Property*/ properties();
    public Property propertyNamed(String name);
    public List /*of Property*/ propertyList();

    public Function0Arg basicNewFunction();

}

