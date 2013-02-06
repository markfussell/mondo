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
import COM.chimu.kernel.functors.*;

import java.text.*;
import java.util.Locale;
import java.util.Date;


public class PairFC extends FactoryAbsClass  {
    public PairFC() {}
    public PairFC(String name, ObjectBuilder builder) {}

    public Object createObjectFromName_parameters_for(String recipeName, Map parameters, ObjectBuilder builder) {
        Object keyO = parameters.atKey("key");
        Object valueO = parameters.atKey("value");

        if ( (keyO == null) || (valueO == null) ) {
            throwErrorCalled_without(recipeName,"key | value");
        }

        return new MyPair(keyO, valueO);
    }

    static protected class MyPair implements Pair {
        MyPair(Object key, Object value) {
            this.key = key; this.value = value;
        }

        public Object key() {return key;}
        public Object value() {return value;}

        protected Object key;
        protected Object value;
    }


    public String toString() {
        return "<PairFactory>";
    }

}
