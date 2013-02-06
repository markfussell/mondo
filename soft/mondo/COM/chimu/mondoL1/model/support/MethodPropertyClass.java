/***********************************************************************
**
**  File: chimu/form/mapping/ObjectMapper.java
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

import java.lang.reflect.*;

/**
A MethodProperty supports the property interface through a Getter/Setter
method pair.
**/
public class MethodPropertyClass extends PropertyAbsClass {
    public MethodPropertyClass(String name) {
        this.name = name;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    public void setupName(String name) {
        this.name = name;
    }

    public void setupGetter_setter(Method getter, Method setter) {
        this.getter = getter;
        this.setter = setter;
    }

    public void doneSetup() {}

    //**********************************************************
    //**********************************************************
    //**********************************************************

    public String name() {
        return name;
    }

    public boolean isReadable() {
        return (getter != null);
    }

    public boolean isWriteable() {
        return (setter != null);
    }

    public String toString() {
        StringBuffer stringB = new StringBuffer();
        stringB.append("<Property "+name());
        stringB.append(" (");
        if (isReadable()) stringB.append("r");
        if (isWriteable()) stringB.append("w");
        stringB.append(")");
        if (isReadable()) stringB.append(" r="+getter.getName());
        if (isWriteable()) stringB.append(" w="+setter.getName());
        stringB.append(">");
        return stringB.toString();
    }

        /**
         * Return the value of the property for the given object
         */
    public Object   valueFor(Object anObject) {
        try {
            return getter.invoke(anObject,null);
        } catch (Exception e) {
            if (e instanceof InvocationTargetException) {
                ((InvocationTargetException) e).getTargetException().printStackTrace();
            } else {
                e.printStackTrace();
            }
            return null;
        };
    }

        /**
         * Set the value of the property to the given object
         */
    public void   setValueFor_to(Object anObject,Object value) {
        Object[] values = {value};
        try {
            setter.invoke(anObject,values);
            return;
        } catch (Exception e) {
            System.err.println("Tried to setValue on: {"+anObject.getClass()+"} "+anObject);
            System.err.println("Could not set: "+name+" "+setter+" with ");
            for (int i=0; i<values.length; i++) {
                System.err.println("    {"+values[i].getClass()+"} "+values[i]);
            }
            System.err.println();

            if (e instanceof InvocationTargetException) {
                ((InvocationTargetException) e).getTargetException().printStackTrace();
            } else {
                e.printStackTrace();
            }
            return;
        };
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected String name = null;
    protected Method getter = null;
    protected Method setter = null;

}

