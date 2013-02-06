/***********************************************************************
**
**  File: chimu/mondoOml/parser/VisitorAbsClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;
public class VisitorAbsClass implements Visitor  {
    public void visitSimpleNode(SimpleNode aNode) {};

    public void visitElement(AST_Element aNode) {
        visitSimpleNode(aNode);
    };

    public void visitUnnamedParameter(AST_UnnamedParameter aNode) {
        visitSimpleNode(aNode);
    };
}
