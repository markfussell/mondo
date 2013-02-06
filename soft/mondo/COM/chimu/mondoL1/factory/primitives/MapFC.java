/***********************************************************************
**
**  File: chimu/mondoL1/factory/primitives/DateFC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory.primitives;


import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.factory.support.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;
import COM.chimu.kernel.functors.*;

import java.text.*;
import java.util.Locale;
import java.util.Date;


public class MapFC extends FactoryAbsClass  {
    public MapFC() {}
    public MapFC(String name, ObjectBuilder builder) {}

    protected Map createMap() {
        return CollectionsImplPack.newMap();
    }

    public Object createObjectFromName_parameters_for(String recipeName, Map parameters, ObjectBuilder builder) {
        Object pairsO = parameters.atKey("pairs");
        if (pairsO == null) {
            throwErrorCalled_without(recipeName,"pairs");
        } else if ( !(pairsO instanceof List) ) {
            throwErrorCalled_withInvalid_equalTo(recipeName,"pairs",pairsO);
        }

        List pairs = (List) pairsO;

        Map map = createMap();
        int size = pairs.size();
        for (int i=0; i<size; i++) {
            Pair pair = (Pair) pairs.atIndex(i);
            map.atKey_put(pair.key(), pair.value());
        }
        return map;
    }

    public String toString() {
        return "<Map>";
    }
}
