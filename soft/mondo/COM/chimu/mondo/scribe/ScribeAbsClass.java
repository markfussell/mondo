/***********************************************************************
**
**  File: chimu/mondo/scribe/ScribeAbsClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.scribe;

import COM.chimu.mondo.encoder.*;
import COM.chimu.mondo.model.ModelPack;

public abstract class ScribeAbsClass implements Scribe {
    public Object noValueObject() {
        return ModelPack.NO_VALUE;
    }

}

