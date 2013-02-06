/***********************************************************************
**
**  File: chimu/mondoOml/parser/DumpVisitorClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;

public class DumpVisitorClass extends VisitorAbsClass {
    protected String prefix = "";

    public void visitSimpleNode(SimpleNode aNode) {
        if (aNode instanceof AST_Element) {
            AST_Element element = (AST_Element) aNode;
            if (element.name.equals("A")) {
                System.out.println("We are here");
            }
        }
        System.out.println(aNode.toString(prefix));
        if (aNode.children != null) {
            String oldPrefix = prefix;
            prefix += "    ";
            for (java.util.Enumeration e = aNode.children.elements();
                    e.hasMoreElements();) {
                SimpleNode n = (SimpleNode) e.nextElement();
                n.accept(this);
            };
            prefix = oldPrefix;
        }
    }

    public void visitUnnamedParameter(AST_UnnamedParameter aNode) {
        if (aNode.children != null) {
            for ( java.util.Enumeration e = aNode.children.elements();
                      e.hasMoreElements();) {
            	SimpleNode n = (SimpleNode)e.nextElement();
                n.accept(this);
            }
        }
    }

}

