/***********************************************************************
**
**  File: chimu/mondo/pen/support/NullPenC.java
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

public class NullPenC extends PenAbsClass {
    public NullPenC() {}
    public NullPenC(ScribeSi scribe) {
        super(scribe);
    }

    public NullPenC(ScribeSi scribe, ObjectEncoder encoder) {
        super(scribe,encoder);
    }

    public void scribeObject(Object anObject) {}
    public void registerObject_for(Object anObject, ScribeSi scribe) {}
}

