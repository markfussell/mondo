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

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;

public abstract class ClassCoreInfoAbsClass implements ClassCoreInfo {
    public String   name()                   {return classInfo().name();}
    public boolean  isFor(Object anObject)   {return classInfo().isFor(anObject);}
    public boolean  isForClass(Class aClass) {return classInfo().isForClass(aClass);}

    public boolean  isApplicableTo(Object anObject)   {return classInfo().isApplicableTo(anObject);}
    public boolean  isApplicableToClass(Class aClass) {return classInfo().isApplicableToClass(aClass);}

}

