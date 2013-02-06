/***********************************************************************
**
**  File: chimu/mondo/pen/MemoryPen.java
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
public interface MemoryPen extends Pen {

    public void setupEncoder(ObjectEncoder encoder);

}

