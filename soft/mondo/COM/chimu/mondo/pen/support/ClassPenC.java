/***********************************************************************
**
**  File: chimu/mondo/pen/support/ClassPenC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.pen.support;

import COM.chimu.mondo.pen.*;
import COM.chimu.mondo.scribe.*;
import COM.chimu.mondo.encoder.*;

import java.util.*;
import java.text.*;

public class ClassPenC extends PenAbsClass {
    public ClassPenC() {}
    public ClassPenC(ScribeSi scribe) { }
    public ClassPenC(ScribeSi scribe, ObjectEncoder encoder) {}

    protected void init() {}

    public void registerObject_for(Object anObject, ScribeSi scribe) {}
    public void scribeObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder) {
        Class aClass = (Class) anObject;
        String name = scribe.getRecipeNameFor("java.lang.Class");
        String className = name;
        int index = className.indexOf('.');
        if (index > -1) {
            className = className.substring(index+1);
        }

        encoder.startObject(name);
            encoder.startValuedParameter("name");
                scribe.scribeObject(className);
            encoder.finishValuedParameter();

            encoder.startValuedParameter("javaClass");
                scribe.scribeObject(aClass.getName());
            encoder.finishValuedParameter();
        encoder.finishObject();

    }

}

