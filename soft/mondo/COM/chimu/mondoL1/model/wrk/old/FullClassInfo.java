/***********************************************************************
**
**  File: chimu/mondoL1/model/ClassInfo.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.model.*;

import COM.chimu.mondoL1.factory.beans.*;
import COM.chimu.mondoL1.model.support.*;

import COM.chimu.mondo.model.*;

import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.support.*;
import COM.chimu.mondo.factory.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

import java.util.Date;

public interface ClassInfo {
    //**********************************************************
    //******************* Coordination Info ********************
    //**********************************************************
        //This is the central ClassInfo object: the
        //Coordinator

    public Class        javaClass();
    public ObjectBase   objectBase();


    public Object infoNamed(String infoType);

    public ClassInfo    metaClassInfo();
    public TypeInfo     typeInfo();
    public PropertyInfo propertyInfo();
    public BuildingInfo buildingInfo();
    public ScribingInfo scribingInfo();

    //**********************************************************
    //********************* Property Info **********************
    //**********************************************************

    public Map /*of String->Property*/ properties();
    public Property propertyNamed(String name);
    public List /*of Property*/ propertyList();

    public Function0Arg basicNewFunction();

    //**********************************************************
    //********************* Building Info **********************
    //**********************************************************
    //Property Info +

    public Factory defaultFactoryFor(ObjectBuilder scribe);

    //**********************************************************
    //********************* Scribing Info **********************
    //**********************************************************
    //?Property Info +

    public Pen defaultPenFor(Scribe scribe);

    public Extracter defaultExtracterFor(Object anObject);
    public Extracter defaultStubExtracterFor(Object anObject);


    //public void BeanInfo

    //public boolean hasBuildingInfo()
    //public boolean hasScribingInfo()

    //**********************************************************
    //**********************************************************
    //**********************************************************

}

