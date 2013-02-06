/***********************************************************************
**
**  File: chimu/mondoL1/model/ClassInfoAbsClass.java
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

public abstract class ClassInfoAbsClass
                            implements ClassInfo {

    //**********************************************************
    //*********************** Core Info ************************
    //**********************************************************

    public ClassInfo    classInfo() {
        return this;
    }

    //**************************************
    //************ Common Info *************
    //**************************************

    public boolean  isFor(Object anObject) {
        return anObject.getClass() == javaClass();
    }

    public boolean  isApplicableTo(Object anObject)   {
        return javaClass().isInstance(anObject);
    }

    public boolean  isForClass(Class aClass) {
        return (javaClass() == aClass);
    }

    public boolean  isApplicableToClass(Class aClass) {
        return javaClass().isAssignableFrom(aClass);
    }

    //**********************************************************
    //******************* Coordination Info ********************
    //**********************************************************

    public ClassInfo    metaClassInfo() {
        return objectBase().classInfoForClass(javaClass().getClass());
    }

    public ClassBuildingInfo buildingInfo() {
        return (ClassBuildingInfo) infoNamed("Building");
    }

    public ClassScribingInfo scribingInfo() {
        return (ClassScribingInfo) infoNamed("Scribing");
    }

    public ClassPropertyInfo propertyInfo() {
        return (ClassPropertyInfo) infoNamed("Property");
    }


}

