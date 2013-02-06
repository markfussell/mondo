/***********************************************************************
**
**  File: chimu/mondo/factory/support/ParameterLib.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.model.support;

import COM.chimu.mondoL1.model.*;
import COM.chimu.mondo.builder.BuilderConstants;

import COM.chimu.kernel.collections.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

import java.beans.*;
import java.lang.reflect.*;

/**
**/
public class BeanModelLib {

    //**********************************************************
    //**********************************************************
    //**********************************************************

    static public void generateBeanPropertiesFor_into(Class beanClass, Map properties) {
        try {
            BeanInfo bean = Introspector.getBeanInfo(beanClass);

            PropertyDescriptor[] beanProperties = bean.getPropertyDescriptors();
            for (int i=0; i<beanProperties.length; i++) {
                PropertyDescriptor propertyD = beanProperties[i];
                String propName   = propertyD.getName();
                Method getter = propertyD.getReadMethod();
                Method setter = propertyD.getWriteMethod();

                if (getter == null) {
                    try {
                        getter = beanClass.getMethod(propertyD.getName(),null);
                    } catch (Exception e2) {};
                }

                MethodPropertyClass myProperty = new MethodPropertyClass(propName);
                myProperty.setupGetter_setter(getter, setter);
                myProperty.doneSetup();


                properties.atKey_put(propName,myProperty);
            }
        } catch (Exception e) {e.printStackTrace();};
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    private BeanModelLib() {};

}
