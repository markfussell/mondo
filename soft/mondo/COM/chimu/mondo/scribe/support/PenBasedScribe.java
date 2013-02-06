/***********************************************************************
**
**  File: chimu/mondo/scribe/support/PenBasedScribe.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.scribe.support;

import COM.chimu.mondo.scribe.*;
import COM.chimu.mondo.pen.*;

import COM.chimu.mondo.encoder.*;

import COM.chimu.kernel.collections.Map;
import COM.chimu.kernel.collections.Sequence;
import COM.chimu.kernel.collections.Collection;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

public interface PenBasedScribe extends Scribe {

    public void setPenForNullTo(Pen pen);
//    public void setPenForObject_to(Object anObject, Pen aPen);
    public void setPenForClass_to(Class aClass, Pen aPen);

}

