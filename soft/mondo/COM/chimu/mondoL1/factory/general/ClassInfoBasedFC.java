/***********************************************************************
**
**  File: chimu/mondoL1/factory/general/BeanFC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory.general;

import COM.chimu.mondoL1.model.*;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.functors.*;

public class ClassInfoBasedFC extends FactoryAbsClass implements ClassInfoBasedF {
    public ClassInfoBasedFC() {}
    public ClassInfoBasedFC(String name, ObjectBuilder builder) {}

    public void setupClassInfo(ClassInfo classInfo) {
        this.classPropertyInfo = classInfo.propertyInfo();
    }

    public Object createObjectFromName_parameters_for(String recipeName, Map map, ObjectBuilder builder) {
        if (classPropertyInfo == null) throw new RuntimeException("Incorrectly configured factory.  Has no ClassPropertyInfo.");
        Function0Arg constructor = classPropertyInfo.basicNewFunction();
        if (constructor == null) {
            System.err.println("No constructor for ClassInfo: "+classPropertyInfo);
            return builder.noValueObject();
        }

        Object beanObject = constructor.value();
        if (beanObject == null) {
                return builder.noValueObject();
        }

        List properties = classPropertyInfo.propertyList();
        if (properties != null) {
            int size = properties.size();
            for (int i=0; i<size; i++) {
                Property property = (Property) properties.atIndex(i);
                if (property.isWriteable()) {
                    String propertyName = property.name();
                    if (map.includesKey(propertyName)) {
                        property.setValueFor_to(
                                beanObject,
                                map.atKey(propertyName));
                    } else {
                        //Handle namespace prefix possibilities
                        //Whole namespaces or individual mappings
                        // +->mondo:  || type->mondo:type
                    }
                }
            }
        }
        return beanObject;
    }

    public String toString() {
        return "<"+classPropertyInfo.name()+">";
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    ClassPropertyInfo classPropertyInfo = null;
}
