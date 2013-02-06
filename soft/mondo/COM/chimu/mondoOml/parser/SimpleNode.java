/* JJT: 0.2.2 */
/***********************************************************************
**
**  File: chimu/mondoOml/parser/SimpleNode.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;



public class SimpleNode implements Node {
  protected Node parent;
  protected java.util.Vector children;
  protected String identifier;
  protected Object info;

  public SimpleNode(String id) {
    identifier = id;
  }

  public static Node jjtCreate(String id) {
    return new SimpleNode(id);
  }

  public void jjtOpen() {}
  public void jjtClose() {
    if (children != null) {
      children.trimToSize();
    }
  }

  public void jjtSetParent(Node n) { parent = n; }
  public Node jjtGetParent() { return parent; }

  public void jjtAddChild(Node n) {
    if (children == null) {
      children = new java.util.Vector();
    }
    children.addElement(n);
  }
  public Node jjtGetChild(int i) {
    return (Node)children.elementAt(i);
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.size();
  }

  /* These two methods provide a very simple mechanism for attaching
     arbitrary data to the node. */

  public void setInfo(Object i) { info = i; }
  public Object getInfo() { return info; }

  /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */

  public String toString() { return identifier; }
  public String toString(String prefix) { return prefix + toString(); }

  /* Override this method if you want to customize how the node dumps
     out its children. */

  public void dump(String prefix) {
    System.out.println(toString(prefix));
    if (children != null) {
      for (java.util.Enumeration e = children.elements();
	   e.hasMoreElements();) {
	SimpleNode n = (SimpleNode)e.nextElement();
	n.dump(prefix + " ");
      }
    }
  }

    //**********************************************************
    //(P)******************* Manual Code ***********************
    //**********************************************************

    public void accept(Visitor visitor) {
        visitor.visitSimpleNode(this);
    }

}

