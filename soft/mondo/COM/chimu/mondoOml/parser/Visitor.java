/***********************************************************************
**
**  File: chimu/mondoOml/parser/Visitor.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;

public interface Visitor  {
    public void visitSimpleNode(SimpleNode aNode);
    public void visitUnnamedParameter(AST_UnnamedParameter aNode);
    public void visitElement(AST_Element aNode);

}
