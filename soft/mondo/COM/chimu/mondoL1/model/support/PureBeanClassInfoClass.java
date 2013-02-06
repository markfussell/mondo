/***********************************************************************
**
**  File: chimu/formTools/examples/scheme1/PersonClass_FormInfo.java
**
**  Copyright (c) 1997, ChiMu Corporation. All Rights Reserved.
**
**  This software is the confidential and proprietary information of
**  ChiMu Corporation ("Confidential Information").  You shall not
**  disclose such Confidential Information and shall use it only in
**  accordance with the terms of the license agreement you entered into
**  with ChiMu Corporation.
**
***********************************************************************/

package COM.chimu.mondoL1.model.support;
import COM.chimu.mondoL1.model.*;
import COM.chimu.mondoL1.pen.general.ClassInfoBasedPenC;

import COM.chimu.mondo.pen.*;
import COM.chimu.mondo.scribe.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.exceptions.*;
import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;


/**
**/
public class PureBeanClassInfoClass
                extends SimpleClassInfoAbsClass
                {

    public PureBeanClassInfoClass() {}
    public PureBeanClassInfoClass(Class javaClass) {
        setupClass(javaClass);
        init();
    }

    public void setupObjectBase(ObjectBase base) {
        this.base = base;
    }

    public void setupClass(Class javaClass) {
        this.javaClass = javaClass;
    }

    public void doneSetup() {
        init();
    }

    public Class javaClass() {
        return javaClass;
    }


    //**********************************************************
    //**********************************************************
    //**********************************************************
    //Temporary approach:

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected Class javaClass;


}


