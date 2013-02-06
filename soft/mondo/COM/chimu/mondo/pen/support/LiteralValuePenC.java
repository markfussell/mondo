/***********************************************************************
**
**  File: chimu/mondo/pen/support/LiteralValuePenC.java
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

public class LiteralValuePenC extends PenAbsClass implements LiteralValuePen {
    public LiteralValuePenC() {}
    public LiteralValuePenC(ScribeSi scribe) {}
    public LiteralValuePenC(ScribeSi scribe, ObjectEncoder encoder) {}

    public void setValue(String value) {
        this.value = value;
    }
    protected String value = "null";

    public void registerObject_for(Object anObject, ScribeSi scribe) {}
    public void scribeObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder) {
        encoder.startObject("MONDO:Literal");
        encoder.startDefaultParameter();
        encoder.startParameterValue();
        encoder.encodeString(value);
        encoder.finishParameterValue();
        encoder.finishParameter();
        encoder.finishObject();
    }
}

