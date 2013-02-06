/***********************************************************************
**
**  File: chimu/mondoL1/factory/general/L1FactoryGeneralPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory.general;


import COM.chimu.mondoL1.factory.*;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.exceptions.*;

import java.lang.reflect.*;

/**

**/
public class L1FactoryGeneralPack {

/*
    //**********************************************************
    //(P)***************** Factory Methods *********************
    //**********************************************************

    static public BeanFactory newBeanFactoryFor_named(ObjectBuilder builder, String name) {
        return new BeanFactoryClass(name,builder);
    }

    static public BeanFactory newBeanFactoryFor_class(ObjectBuilder builder, Class aClass) {
        BeanFactory beanFactory = new BeanFactoryClass(aClass.getName(),builder);
        beanFactory.setupClass(aClass);
        return beanFactory;
    }

    //**************************************
    //**************************************
    //**************************************

    static public MultiFunctorFactory newMultiFunctorFactoryFor_named(ObjectBuilder builder, String name) {
        return new MultiFunctorFactoryClass(name,builder);
    }

    static public Factory newMultiFunctorConstructorFactoryFor_named(Class aClass, Class[] signature, String[] argNames) {
        Constructor constructor = null;
        try {
            constructor = aClass.getConstructor(signature);
        } catch (Exception e) {
            throw new RuntimeWrappedException("Signature "+signature+" is not available on "+aClass,e);
        };
        Function1Arg functor = L1FactoryPack.functorForConstructor(constructor);
        return newFunctorFactoryFor_named_functor_arguments(null,aClass.getName(), functor, argNames);
    }

    static public Factory newFunctorFactoryFor_named_functor_arguments(ObjectBuilder builder, String name, Function1Arg functor, String[] argNames) {
        FunctorFactoryClass factory = new FunctorFactoryClass(name,builder);
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
        Function1Arg functor = L1FactoryPack.functorForConstructor(constructor);
        return newFunctorFactoryFor_named_functor_arguments(null,aClass.getName(), functor, argNames);
    }
*/

    //**********************************************************
    //**********************************************************
    //**********************************************************

    private L1FactoryGeneralPack() {}


}

