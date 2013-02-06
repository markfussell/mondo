/***********************************************************************
**
**  File: chimu/mondo/builder/client/BuilderClientPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.factory.general;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.factory.support.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.exceptions.*;

import java.lang.reflect.*;

/**
**/
public class FactoryGeneralPack {

    //**********************************************************
    //(P)***************** Factory Methods *********************
    //**********************************************************

    static public Factory newHoistCollapseContent(ObjectBuilder builder) {
        return new HoistCollapseParameterFC(null,builder);
    }

    static public Factory newHoistContent(ObjectBuilder builder) {
        return new HoistParameterFC(null,builder);
    }

    //**************************************
    //**************************************
    //**************************************

    static public MultiFunctorF newMultiFunctorFactoryFor_named(ObjectBuilder builder, String name) {
        return new MultiFunctorFC(name,builder);
    }

    static public Factory newMultiFunctorConstructorFactoryFor_named(Class aClass, Class[] signature, String[] argNames) {
        Constructor constructor = null;
        try {
            constructor = aClass.getConstructor(signature);
        } catch (Exception e) {
            throw new RuntimeWrappedException("Signature "+signature+" is not available on "+aClass,e);
        };
        Function1Arg functor = FactorySupportPack.functorForConstructor(constructor);
        return newFunctorFactoryFor_named_functor_arguments(null,aClass.getName(), functor, argNames);
    }

    static public Factory newFunctorFactoryFor_named_functor_arguments(ObjectBuilder builder, String name, Function1Arg functor, String[] argNames) {
        FunctorF factory = new FunctorFC(name,builder);
        factory.setupFunctor_withArguments(functor,argNames);
        return factory;
    }

    static public Factory newConstructorFactoryForClass_signature_arguments(Class aClass, Class[] signature, String[] argNames) {
        Constructor constructor = null;
        try {
            constructor = aClass.getConstructor(signature);
        } catch (Exception e) {
            throw new RuntimeWrappedException("Signature "+signature+" is not available on "+aClass,e);
        };
        Function1Arg functor = FactorySupportPack.functorForConstructor(constructor);
        return newFunctorFactoryFor_named_functor_arguments(null,aClass.getName(), functor, argNames);
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    private FactoryGeneralPack() {}


}

