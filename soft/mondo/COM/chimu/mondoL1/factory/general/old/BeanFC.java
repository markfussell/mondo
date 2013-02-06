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

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.functors.*;


public class BeanFC extends FactoryAbsClass implements BeanF {
    public BeanFC() {}
    public BeanFC(String name, ObjectBuilder builder) {
        this.name = name;
    }

    public void setupClass(Class beanClass) {
        forClass    = beanClass;
        inspector   = getInspectorForClass(forClass);
        constructor = inspector.creationFunctionForClass(forClass);
    }

    public Object createObjectFromName_parameters_for(String recipeName, Map map, ObjectBuilder builder) {
        if (inspector == null) {
            Class objectClass    = getClassForName(name);
            if (objectClass == null) {
                return builder.noValueObject();
            }
            setupClass(objectClass);
        }

        Object beanObject = constructor.value();
        if (beanObject == null) {
System.err.println("No bean from "+constructor);
                return builder.noValueObject();
        }

        List properties = inspector.propertyListForClass(forClass);
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
System.err.println("Bean Ho! "+recipeName);

        return beanObject;
    }

    public String toString() {
        return name;
    }

    protected Class getClassForName(String recipeName) {
        try {
            return Class.forName(recipeName);
        } catch (ClassNotFoundException e) {
System.err.println("No class "+recipeName);
        }
        return null;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    static protected ClassInspector getInspectorForClass(Class aClass) {
        BeanBasedInspectorClass bbi = new BeanBasedInspectorClass(aClass);
        bbi.doneSetup();
        return bbi;
    }

    static Inspector getInspectorFor(Object anObject) {
        if (anObject instanceof Inspectable) {
            return ((Inspectable) anObject).inspector();
        } else {
            BeanBasedInspectorClass bbi = new BeanBasedInspectorClass(anObject.getClass());
            bbi.doneSetup();
            return bbi;
        }
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    String name = "BeanFactory";
    ClassInspector inspector = null;
    Class forClass = null;
    Function0Arg constructor = null;

}
