/***********************************************************************
**
**  File: chimu/mondo/factory/support/ParameterLib.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.factory.support;

import COM.chimu.mondo.model.*;
import COM.chimu.mondo.builder.BuilderConstants;

import COM.chimu.kernel.collections.*;

/**
**/
public class ParameterLib {

    //**********************************************************
    //**********************************************************
    //**********************************************************

    static public Object getContentFrom(Map parameters) {
        return parameters.atKey(BuilderConstants.CONTENT_KEY);
    }

    static public String getStringValueFor_from(String parameterName, Map parameters) {
        Object stringO = parameters.atKey(parameterName);
        return ModelPack.getStringValueFrom(stringO);
    }

    static public boolean isParameter_inMap(String parameterName, Map parameters) {
        return parameters.includesKey(parameterName);
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    private ParameterLib() {};

}
