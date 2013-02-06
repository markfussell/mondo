/***********************************************************************
**
**  File: chimu/mondo/scribe/ScribeSi.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.scribe;

import COM.chimu.mondo.encoder.*;

public interface ScribeSi extends Scribe {
    public void scribeObject(Object anObject);

    public ObjectEncoder defaultEncoder();

    public String getRecipeNameFor(String classIdentifier);
    public void registerObject(Object anObject);

    public Object noValueObject();
}

