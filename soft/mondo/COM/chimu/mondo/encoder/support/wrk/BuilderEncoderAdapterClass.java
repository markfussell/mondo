/***********************************************************************
**
**  File: chimu/mondo/encoder/support/wrk/BuilderEncoderAdapterClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.encoder.support;
import COM.chimu.mondo.encoder.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.exceptions.*;

import java.util.Stack;

public class BuilderEncoderAdapterClass
                extends ObjectBuilderAbsClass
                {
    public BuilderEncoderAdapterClass(ObjectEncoder encoder) {
        this.encoder = encoder;
    }

    public Object createObjectFromName_parameters (String name, Map parameters) {
        return noValueObject();
    }


    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected ObjectEncoder encoder = null;

    //**************************************
    //**************************************
    //**************************************

}
