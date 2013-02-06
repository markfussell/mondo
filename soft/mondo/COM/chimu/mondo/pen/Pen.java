/***********************************************************************
**
**  File: chimu/mondo/pen/Pen.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.pen;
import COM.chimu.mondo.scribe.*;
import COM.chimu.mondo.encoder.*;

/**
Pens are supports for Scribes and can describe objects of certain
types to the Encoder
**/
public interface Pen {
    public void scribeFirstObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder);
    public void scribeSecondObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder);

    public void scribeObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder);
    public void registerObject_for(Object anObject, ScribeSi scribe);

}

