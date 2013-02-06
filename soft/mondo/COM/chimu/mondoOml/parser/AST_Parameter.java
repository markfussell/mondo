/* JJT: 0.2.2 */
/***********************************************************************
**
**  File: chimu/mondoOml/parser/AST_Parameter.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;

import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.client.*;


import COM.chimu.kernel.collections.*;


public class AST_Parameter
                    extends SimpleNode
                    implements ParameterNode
                    {
  AST_Parameter(String id) {
    super(id);
  }

  public static Node jjtCreate(String id) {
    return new AST_Parameter(id);
  }

    //**********************************************************
    //(P)******************* Manual Code ***********************
    //**********************************************************

    protected String name = null;
    public void setName(String name) {this.name = name;}

    public String toString() {
        return name+"=";
    }

    public boolean hasValue() {
        return !hasNoValue();
    }

    public boolean hasNoValue() {
        if (children == null) return true;
        return children.isEmpty();
    }

    public String identifyingName() {
        return name.toUpperCase();
    }

    //**********************************************************
    //(P)******************* OML Builder ***********************
    //**********************************************************

    public void buildObjectIntoMap_for(Map map, ObjectBuilder builder) {
        if (hasValue()) {
            RecipeObjectBuilder ocInfo = getCreationInfo();
            if (ocInfo != null) {
                Object newObject = ocInfo.buildObjectFor(builder);
                if (newObject != builder.noValueObject()) {
                    map.atKey_put(name,newObject);
                    return;
                }
            }
        }
        map.atKey_put(name,builder.noValueObject());
    }

    public RecipeObjectBuilder getCreationInfo() {
        Object node = jjtGetChild(0);
        if (! (node instanceof RecipeObjectBuilder) ) return null;
        return (RecipeObjectBuilder) node;
    }


}
