/* JJT: 0.2.2 */
/***********************************************************************
**
**  File: chimu/mondoOml/parser/Node.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;


/**
All AST nodes must implement this interface.  It provides basic
machinery for constructing the parent and child relationships
between nodes.
**/
public interface Node {

        /**
         * This method is called after the node has been made the current
         * node.  It indicates that child nodes can now be added to it.
         */
    public void jjtOpen();

        /**
         * This method is called after all the child nodes have been
         * added.
         */
    public void jjtClose();

        /**
         * This method is used to inform the node of its parent.
         */
    public void jjtSetParent(Node n);
    public Node jjtGetParent();

        /**
         * This method tells the node to add its argument to the node's
         * list of children.
         */
    public void jjtAddChild(Node n);

        /**
         * This method returns a child node.  The children are numbered
         * from zero, left to right.
         */
    public Node jjtGetChild(int i);

        /** Return the number of children the node has. */
    int jjtGetNumChildren();
}
