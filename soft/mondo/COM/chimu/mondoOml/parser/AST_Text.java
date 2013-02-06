/* JJT: 0.2.2 */
/***********************************************************************
**
**  File: chimu/mondoOml/parser/AST_Text.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;

import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.client.*;



import java.util.*;
import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;


public class AST_Text
                        extends SimpleNode
                        implements RecipeObjectBuilder
                         {

  AST_Text(String id) {
    super(id);
  }

  public static Node jjtCreate(String id) {
    return new AST_Text(id);
  }

    //**********************************************************
    //(P)******************* Manual Code ***********************
    //**********************************************************

    protected Sequence contents = CollectionsImplPack.newSequence();
    public void appendNode(SimpleNode node) {
        contents.add(node);
    }
    public void appendChars(String value) {
        AST_String string = new AST_String("AST_String");
        string.setValue(value);
        contents.add(string);
    }

    public String toString() {
        StringBuffer stringB = new StringBuffer();
        stringB.append("{");
        int size = contents.size();
        for (int i=0; i<size; i++) {
            stringB.append(contents.atIndex(i));
        }
        stringB.append("}");
        return stringB.toString();
    }

    //**********************************************************
    //(P)******************* OML Builder ***********************
    //**********************************************************

    public Object buildObjectFor(ObjectBuilder builder) {
        List value = buildValueFor(builder);
        return builder.createObjectFromList(value);
    }

    public void appendToList_for(List list, ObjectBuilder builder) {
        Object newObject = buildObjectFor(builder);
        if (newObject != builder.noValueObject()) {
            list.add(newObject);
        }
    }

    protected List buildValueFor(ObjectBuilder builder) {
        List list = builder.newContentsList();

        int size = numberOfComponents();
        for (int i = 0; i < size; i++) {
            RecipeObjectBuilder creationInfo = componentAtIndex(i);
            if (creationInfo != null) { //Could be null if a creationInfo is not at that index
                Object newObject = creationInfo.buildObjectFor(builder);
                if (newObject != builder.noValueObject()) {
if (newObject == null) {
    System.err.println("NULL added to list by "+creationInfo+" in "+this);
}
                    if (newObject instanceof Collection) {
                        list.addAll((Collection) newObject);
                    } else {
                        list.add(newObject);
                    }
                }
            }
        }
        return list;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected int numberOfComponents() {
        return contents.size();
    }

    protected RecipeObjectBuilder componentAtIndex(int index) {
        Object node = contents.atIndex(index);
        if (! (node instanceof RecipeObjectBuilder) ) return null;

        return (RecipeObjectBuilder) node;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected int numberOfComponents = -1;

}
