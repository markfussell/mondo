/***********************************************************************
**
**  File: chimu/mondoL1/factory/L1FactoryPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.exceptions.*;

import java.lang.reflect.*;

/**

**/
public class L1FactoryPack {


    //**********************************************************
    //(P)***************** Factory Methods *********************
    //**********************************************************

    static public Function1Arg functorForConstructor(Constructor constructor) {
        return new ConstructorFunctor(constructor);
    }

    static public Function1Arg constructorFunctorFor_signature(Class aClass, Class[] signature) {
        Constructor constructor = null;
        try {
            constructor = aClass.getConstructor(signature);
        } catch (Exception e) {
            throw new RuntimeWrappedException("Signature "+signature+" is not available on "+aClass,e);
        };
        return functorForConstructor(constructor);
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************


    static protected class ConstructorFunctor implements Function1Arg {
        ConstructorFunctor(Constructor constructor) {
            this.constructor = constructor;
        }

        public Object valueWith(Object parameterArrayO) {
            Object result = null;
            try {
                result = constructor.newInstance((Object[]) parameterArrayO);
            } catch (Exception e) {
                result = null; //Throw away the exception
            }
            return result;
        }

        protected Constructor constructor = null;
    }

    static protected class MethodFunctor implements Function1Arg {
        MethodFunctor(Method constructor) {
            this.constructor = constructor;
        }

        public Object valueWith(Object parameterArrayO) {
            Object result = null;
            try {
                result = constructor.invoke(null,(Object[]) parameterArrayO);
            } catch (Exception e) {
                result = null; //Throw away the exception
            }
            return result;
        }

        protected Method constructor = null;
    }



    //**********************************************************
    //**********************************************************
    //**********************************************************

    private L1FactoryPack() {}


}

