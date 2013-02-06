/***********************************************************************
**
**  File: chimu/mondoL1/model/CoreClassInfo.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.model;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;

public interface ClassCoreInfo {

    //**********************************************************
    //*********************** Core Info ************************
    //**********************************************************
        //The only core aspect is the ability to reach
        //the main (coordinator) ClassInfo Object

    public ClassInfo    classInfo();

    //**************************************
    //************ Common Info *************
    //**************************************

        //Commonly useful information.  Could also be placed
        //in a single place (the main classInfo object)
        //but is convenient to have accessible

    public String   name();
    public boolean  isFor(Object anObject);
    public boolean  isForClass(Class aClass);

    public boolean  isApplicableTo(Object anObject);
    public boolean  isApplicableToClass(Class aClass);

}

