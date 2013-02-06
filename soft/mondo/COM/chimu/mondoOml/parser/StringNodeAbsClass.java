/* JJT: 0.2.2 */
/***********************************************************************
**
**  File: chimu/mondoOml/parser/StringNodeAbsClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;
import COM.chimu.mondo.builder.*;


import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

public abstract class StringNodeAbsClass
                        extends CreationNodeAbsClass
                        {
    StringNodeAbsClass(String id) {
        super(id);
    }

    //**********************************************************
    //(P)******************* Manual Code ***********************
    //**********************************************************

    protected String value = null;
    public abstract void setValue(String value);

    public String toString() {
        return "<AST_String [["+value+"]]>";
    }

    //**********************************************************
    //(P)******************* OML Builder ***********************
    //**********************************************************

    public Object buildObjectFor(ObjectBuilder builder) {
        return builder.createObjectFromString(value);
    }

}
