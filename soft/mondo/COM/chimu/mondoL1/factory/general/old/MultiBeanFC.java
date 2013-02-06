/***********************************************************************
**
**  File: chimu/mondoL1/factory/general/MultiBeanFC.java
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
import COM.chimu.kernel.collections.impl.CollectionsImplPack;
import COM.chimu.kernel.functors.*;


public class MultiBeanFC extends FactoryAbsClass implements MultiBeanF {
    public MultiBeanFC() {}
    public MultiBeanFC(String name, ObjectBuilder builder) {}

    public void setupClass_forRecipe(Class beanClass, String recipeName) {
        ClassInspector inspector   = getInspectorForClass(beanClass);
        Function0Arg   constructor = inspector.creationFunctionForClass(beanClass);

        Object[] entry = {recipeName, beanClass, inspector, constructor};
        recipeToClassInfo.atKey_put(recipeName, entry);
    }

    static protected final int RECIPE_NAME = 0;
    static protected final int BEAN_CLASS = 1;
    static protected final int INSPECTOR = 2;
    static protected final int CONSTRUCTOR = 3;

    public Object createObjectFromName_parameters_for(String recipeName, Map map, ObjectBuilder builder) {
        //Consider: String className = recipeName || appropriate attribute;
        Class objectClass;

        Object[] entry = (Object[]) recipeToClassInfo.atKey(recipeName);
        if (entry == null) {
            objectClass    = getClassForName(recipeName);
            if (objectClass == null) {
                return builder.noValueObject();
            }
            setupClass_forRecipe(objectClass,recipeName);
            entry = (Object[]) recipeToClassInfo.atKey(recipeName);
        } else {
            objectClass            = (Class)          entry[BEAN_CLASS];
        }

        ClassInspector inspector   = (ClassInspector) entry[INSPECTOR];
        Function0Arg   constructor = (Function0Arg)   entry[CONSTRUCTOR];

        Object beanObject = constructor.value();
        if (beanObject == null) {
System.err.println("No bean from "+constructor);
                return builder.noValueObject();
        }

        List properties = inspector.propertyListForClass(objectClass);
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

    String name = "MultiBeanFactory";
    Map recipeToClassInfo = CollectionsImplPack.newMap();

}
