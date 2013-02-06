/***********************************************************************
**
**  File: chimu/mondoL1/factory/functions/ConcatenateFC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory.functions;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.support.*;
import COM.chimu.mondo.model.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

public class ConcatenateFC extends FactoryAbsClass  {
    public ConcatenateFC() {}
    public ConcatenateFC(String name, ObjectBuilder builder) {}

    public Object createObjectFromName_parameters_for(String name, Map map, ObjectBuilder builder) {
        Sequence values = (Sequence) map.atKey(builder.defaultParameterName());
        if (values == null) return builder.createObjectFromString("");

        StringBuffer stringB = new StringBuffer();
        int size = values.size();
        for (int i=0; i<size; i++) {
            String value = ModelPack.getStringValueFrom (
                    values.atIndex(i)
                );
            stringB.append(value);
        }
        return builder.createObjectFromString(stringB.toString());
    }
}
