/***********************************************************************
**
**  File: chimu/mondo/pen/MemoryPenAbsClass.java
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

**/
public abstract class MemoryPenAbsClass extends PenAbsClass implements MemoryPen {
    public MemoryPenAbsClass(ScribeSi scribe) {
        this.scribe = scribe;
        this.encoder = scribe.defaultEncoder();
    }

    public MemoryPenAbsClass(ScribeSi scribe, ObjectEncoder encoder) {
        this.scribe = scribe;
        this.encoder = scribe.defaultEncoder();
    }

    public void setupEncoder(ObjectEncoder encoder) {
        this.encoder = encoder;
    }

    protected ScribeSi      scribe  = null;
    protected ObjectEncoder encoder = null;
}

