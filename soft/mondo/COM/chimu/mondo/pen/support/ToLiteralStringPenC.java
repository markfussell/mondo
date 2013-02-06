/***********************************************************************
**
**  File: chimu/mondo/pen/support/ToLiteralStringPenC.java
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

public class ToLiteralStringPenC extends PenAbsClass {
    public ToLiteralStringPenC() {}
    public ToLiteralStringPenC(ScribeSi scribe) {}
    public ToLiteralStringPenC(ScribeSi scribe, ObjectEncoder encoder) {}

    public void registerObject_for(Object anObject, ScribeSi scribe) {}
    public void scribeObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder) {
        encoder.startObject("MONDO:Literal");
        encoder.startDefaultParameter();
        encoder.startParameterValue();
        encoder.encodeString(anObject.toString());
        encoder.finishParameterValue();
        encoder.finishParameter();
        encoder.finishObject();
    }
}

