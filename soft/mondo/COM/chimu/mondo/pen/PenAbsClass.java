/***********************************************************************
**
**  File: chimu/mondo/pen/PenAbsClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.pen;

import COM.chimu.mondo.scribe.*;
import COM.chimu.mondo.encoder.*;

import COM.chimu.kernel.exceptions.*;

/**

**/
public abstract class PenAbsClass implements Pen {
    public PenAbsClass() {}
    public PenAbsClass(ScribeSi scribe) {}
    public PenAbsClass(ScribeSi scribe, ObjectEncoder encoder) {}


    public void scribeFirstObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder) {
        scribeObject_for_to(anObject, scribe, encoder);
    }

    public void scribeSecondObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder) {
        scribeObject_for_to(anObject, scribe, encoder);
    }

    public void scribeObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder) {
        scribeObject_for(anObject, scribe);
    }

    protected void scribeObject_for(Object anObject, ScribeSi scribe) {
        scribeObject(anObject);
    }

    protected void scribeObject(Object anObject) {
        throw new DevelopmentException("Class should have implemented this method or ..._for_to");
    }

    public abstract void registerObject_for(Object anObject, ScribeSi scribe);
}

