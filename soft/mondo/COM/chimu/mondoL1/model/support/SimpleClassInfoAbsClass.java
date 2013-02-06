/***********************************************************************
**
**  File: chimu/formTools/examples/scheme1/PersonClass_FormInfo.java
**
**  Copyright (c) 1997, ChiMu Corporation. All Rights Reserved.
**
**  This software is the confidential and proprietary information of
**  ChiMu Corporation ("Confidential Information").  You shall not
**  disclose such Confidential Information and shall use it only in
**  accordance with the terms of the license agreement you entered into
**  with ChiMu Corporation.
**
***********************************************************************/

package COM.chimu.mondoL1.model.support;
import COM.chimu.mondoL1.model.*;

import COM.chimu.mondoL1.pen.general.ClassInfoBasedPenC;
import COM.chimu.mondoL1.factory.general.ClassInfoBasedF;
import COM.chimu.mondoL1.factory.general.ClassInfoBasedFC;

import COM.chimu.mondo.pen.*;
import COM.chimu.mondo.scribe.*;
import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.exceptions.*;
import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

import java.lang.reflect.*;
/**
**/
public abstract class SimpleClassInfoAbsClass
                extends ClassInfoAbsClass
                implements ClassScribingInfo, ClassBuildingInfo {

    public SimpleClassInfoAbsClass() {}

    public void setupObjectBase(ObjectBase base) {
        this.base = base;
    }

    public void doneSetup() {
        init();
    }

    protected void init() {
        Class tempJavaClass = javaClass();
        if (tempJavaClass != null) {
            generatePropertiesFor(tempJavaClass);
            basicNewFunction = constructorFunctorFor(tempJavaClass);
        }
    }

    //**********************************************************
    //******************* Coordination Info ********************
    //**********************************************************

    public String name() {return javaClass().getName();}

    public ObjectBase   objectBase() {return base;}
    public TypeInfo typeInfo() {return null;}

    public Object infoNamed(String name) {
        // return null;
        throw new RuntimeException("ClassInfo object does not have information about: "+name);
    }

    //**********************************************************
    //********************* Property Info **********************
    //**********************************************************

    public ClassPropertyInfo propertyInfo() {return this;}

    public Map /*of String->Property*/ properties() {
        return myProperties;
    }

    public List propertyList() {
        return (List) properties().values();
    }

    public Property   propertyNamed(String name) {
        return (Property) properties().atKey(name);
    }

    public Function0Arg basicNewFunction() {
        return basicNewFunction;
    };

    //**********************************************************
    //********************* Scribing Info **********************
    //**********************************************************

    public ClassBuildingInfo buildingInfo() {return this;}

    public Factory defaultFactoryFor(ObjectBuilder scribe) {
        ClassInfoBasedF cibfc = new ClassInfoBasedFC();
        cibfc.setupClassInfo(this);
        return cibfc;
    }

    //**********************************************************
    //********************* Scribing Info **********************
    //**********************************************************

    public ClassScribingInfo scribingInfo() {return this;}

    public Pen defaultPenFor(Scribe scribe)  {
        return new ClassInfoBasedPenC(this);
    }

    public Extracter defaultExtracterFor(Object anObject) {
        return defaultExtracter;
    }

    public Extracter defaultStubExtracterFor(Object anObject) {
            //By default objects do not understand Stub information
        return null;
    }

    //**************************************
    //**************************************
    //**************************************


    protected void generatePropertiesFor(Class beanClass) {
        BeanModelLib.generateBeanPropertiesFor_into(beanClass, myProperties);

        Map defaultExtractProperties = CollectionsImplPack.newMap();
        List properties = (List) myProperties.values();
        int size = properties.size();
        for (int i=0; i<size; i++) {
            Property property = (Property) properties.atIndex(i);
            if (property.isReadable() && property.isWriteable()) {
                defaultExtractProperties.atKey_put(property.name(),property);
            }
        }
        defaultExtracter = new ExtracterClass(beanClass.getName(), defaultExtractProperties);
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected Map myProperties = CollectionsImplPack.newMap();
    protected Extracter defaultExtracter;
    protected ObjectBase base;
    protected Function0Arg basicNewFunction;

    //**********************************************************
    //**********************************************************
    //**********************************************************

    static public Function0Arg constructorFunctorFor(Class aClass) {
        Constructor constructor = null;
        try {
            constructor = aClass.getConstructor(null);
        } catch (Exception e) {
            throw new RuntimeWrappedException("Empty Signature is not available on "+aClass,e);
        };
        return new BasicConstructorFunctor(constructor);
    }


    static protected class BasicConstructorFunctor implements Function0Arg {
        BasicConstructorFunctor(Constructor constructor) {
            this.constructor = constructor;
        }

        public Object value() {
            Object result = null;
            try {
                result = constructor.newInstance(null);
            } catch (Exception e) {
                result = null; //Throw away the exception
            }
            return result;
        }

        protected Constructor constructor = null;
    }


}


