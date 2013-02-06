/***********************************************************************
**
**  File: chimu/mondo/factory/FactoryAbsClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.factory;

import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;

public abstract class FactoryAbsClass implements Factory  {


    //**********************************************************
    //*************** Error Support Procedures *****************
    //**********************************************************

    protected void warnIgnoredIn_parameter(String recipeName, String parameterName) {
        System.err.println("Ignored '"+parameterName+"' in "+this.getClass().getName()+" ["+recipeName+"]");
    }


    protected void throwErrorCalled_without(String recipeName, String parameterName) {
        throw new RuntimeException(this.getClass().getName()+" ["+recipeName+"] called without '"+parameterName+"'");
    }

    protected void throwErrorCalled_withInvalid_equalTo(String recipeName, String parameterName, Object value) {
        throw new RuntimeException(this.getClass().getName()+" ["+recipeName+"] called with invalid '"+
                parameterName+"'= {"+value.getClass()+"} "+value);
    }

    protected void throwErrorCalled_withInvalidBuilder_class(String recipeName, ObjectBuilder builder, Class aClass) {
        throw new RuntimeException(this.getClass().getName()+" ["+recipeName+"] called from a builder "+
                "that does not support the "+aClass.getName()+" interface.  Builder is {"+
                builder.getClass()+"} "+builder);

    }



}
