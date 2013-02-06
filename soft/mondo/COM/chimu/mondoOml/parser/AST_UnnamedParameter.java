/* JJT: 0.2.2 */
/***********************************************************************
**
**  File: chimu/mondoOml/parser/AST_UnnamedParameter.java
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

public class AST_UnnamedParameter
                    extends SimpleNode
                    implements ParameterNode
                    {
  AST_UnnamedParameter(String id) {
    super(id);
  }

  public static Node jjtCreate(String id) {
    return new AST_UnnamedParameter(id);
  }

    //**********************************************************
    //(P)******************* Manual Code ***********************
    //**********************************************************

    public String toString() {
        return BuilderConstants.CONTENT_KEY+"=";
    }

    public String identifyingName() {
        return BuilderConstants.CONTENT_KEY.toUpperCase();
    }

    public boolean hasValue() {
        return true;
    }

    //**********************************************************
    //(P)******************* OML Builder ***********************
    //**********************************************************

    public void buildObjectIntoMap_for(Map map, ObjectBuilder builder) {
        RecipeObjectBuilder ocInfo = getCreationInfo();
        if (ocInfo != null) {
            Object newObject = ocInfo.buildObjectFor(builder);
            if (newObject != builder.noValueObject()) {
                map.atKey_put(builder.defaultParameterName(),newObject);
                return;
            }
        }
        map.atKey_put(builder.defaultParameterName(),builder.noValueObject());
    }

    public RecipeObjectBuilder getCreationInfo() {
        Object node = jjtGetChild(0);
        if (! (node instanceof RecipeObjectBuilder) ) return null;
        return (RecipeObjectBuilder) node;
    }


}
