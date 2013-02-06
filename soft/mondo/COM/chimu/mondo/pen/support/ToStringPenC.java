/***********************************************************************
**
**  File: chimu/mondo/pen/support/ToStringPenC.java
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

public class ToStringPenC extends PenAbsClass {
    public ToStringPenC() {}
    public ToStringPenC(ScribeSi scribe) {}
    public ToStringPenC(ScribeSi scribe, ObjectEncoder encoder) {}

    public void registerObject_for(Object anObject, ScribeSi scribe) {}
    public void scribeObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder) {
        encoder.encodeString(anObject.toString());
    }
}

