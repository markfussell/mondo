/***********************************************************************
**
**  File: chimu/mondo/encoder/support/EncoderRebuilder.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.encoder.support;
import COM.chimu.mondo.encoder.ObjectEncoder;

public interface EncoderRebuilder extends ObjectEncoder {
    public Object currentBuiltObject();
}
