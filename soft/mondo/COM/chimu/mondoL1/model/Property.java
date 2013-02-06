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

package COM.chimu.mondoL1.model;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.functors.*;

/**
A Property is a named characteristic of an object.  Properties
can read or write values to an object.
**/
public interface Property extends Function1Arg, Procedure2Arg {

    public String name();

    public boolean isReadable();
    public boolean isWriteable();

        /**
         * Return the value of the property for the given object.
         *
         *<Require>this.isReadable()
         */
    public Object   valueFor(Object anObject);

        /**
         * Set the value of the property for the given object.
         *
         *<Require>this.isWriteable()
         */
    public void   setValueFor_to(Object anObject, Object aValue);

    //**********************************************************
    //**********************************************************
    //**********************************************************
    //***** Functor Support *****

        //Function1Arg support
    public Object   valueWith(Object anObject);

        //Procedure2Arg support
    public void   executeWith_with(Object anObject, Object value);

}

