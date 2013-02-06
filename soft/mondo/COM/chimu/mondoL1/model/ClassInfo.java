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
ClassInfo is the central coordinating information type.  Its
primary responsibility is to allow retrieval of other information
types
**/
public interface ClassInfo extends ClassCoreInfo {

    //**********************************************************
    //******************* Coordination Info ********************
    //**********************************************************
        //This is the central ClassInfo object: the
        //Coordinator

    public Class        javaClass();
    public ObjectBase   objectBase();
    public TypeInfo     typeInfo();
    public ClassInfo    metaClassInfo();

    public Object infoNamed(String infoType);

    public ClassPropertyInfo propertyInfo();
    public ClassBuildingInfo buildingInfo();
    public ClassScribingInfo scribingInfo();

    //**********************************************************
    //**********************************************************
    //**********************************************************

}

