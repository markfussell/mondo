/* JJT: 0.2.2 */
/***********************************************************************
**
**  File: chimu/mondoOml/parser/AST_Element.java
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
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

public class AST_Element extends CreationNodeAbsClass
                         {
  AST_Element(String id) {
    super(id);
  }

  public static Node jjtCreate(String id) {
    return new AST_Element(id);
  }

    //**********************************************************
    //(P)******************* Manual Code ***********************
    //**********************************************************

    public void accept(Visitor visitor) {
        visitor.visitElement(this);
    }

    public String toString() { return "<"+name+">"; }

    protected String name = null;

    public void setName(String name) {
        if (name.startsWith("!")) {
            name = "MONDO:"+name.substring(1);
        }
        if (name.startsWith("&")) {
            name = "MONDO:A:"+name.substring(1);
        }
        this.name = name;
    }
    public String name() {return name;}

    //**********************************************************
    //(P)******************* OML Builder ***********************
    //**********************************************************

    public Object buildObjectFor(ObjectBuilder builder) {
        builder.startRecipeContext(name);
        Map map = buildAttributeObjectsFor(builder);
        builder.finishRecipeContext();
        Object result = builder.createObjectFromName_parameters(name,map);
        return result;
    }

    protected Map buildAttributeObjectsFor(ObjectBuilder builder) {
        Map map = builder.newParameterMap();

        int size = numberOfParameters();
        for (int i = 0; i < size; i++) {
            RecipeParameterBuilder param = parameterAtIndex(i);
            if (param != null) { //Could be null if a parameter is not at that index
                param.buildObjectIntoMap_for(map,builder);
            }
        }
        return map;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected int numberOfParameters() {
        if (numberOfParameters < 0) { //Calculated cached value
            numberOfParameters = jjtGetNumChildren();
        }
        return numberOfParameters;
    }

    protected RecipeParameterBuilder parameterAtIndex(int index) {
        Object node = jjtGetChild(index);

        if (! (node instanceof ParameterNode) ) return null;
        ParameterNode parameter = (ParameterNode) node;

        if (index+1 == numberOfParameters) {
            if ( (parameter.identifyingName()).equals(identifyingName()) ) {
                return null;
            }
        }

        return parameter;
    }

    public String identifyingName() {
        return name.toUpperCase();
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected int numberOfParameters = -1;


}
