/* JJT: 0.2.2 */
/***********************************************************************
**
**  File: chimu/mondoOml/parser/AST_DirectValue.java
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

public class AST_DirectValue
                        extends CreationNodeAbsClass
                        {
  AST_DirectValue(String id) {
    super(id);
  }

  public static Node jjtCreate(String id) {
    return new AST_DirectValue(id);
  }

    //**********************************************************
    //(P)******************* Manual Code ***********************
    //**********************************************************

    protected String value = null;

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return "<AST_DirectValue [["+value+"]]>";
    }

    //**********************************************************
    //(P)******************* OML Builder ***********************
    //**********************************************************

    public Object buildObjectFor(ObjectBuilder builder) {
        return builder.createObjectFromLiteral(value);
    }

}
