/***********************************************************************
**
**  File: chimu/mondo/builder/support/NoValueBuilderClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder.support;

import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;
import java.util.Vector;

public class NoValueBuilderClass extends ObjectBuilderAbsClass {

    public Object createObjectFromName_parameters (String name, Map parameters) {
        return noValueObject();
    }

    public Object  createObjectFromList(List values){
        return noValueObject();
    }

    public Object  createObjectFromString(String value) {
        return noValueObject();
    }


}
