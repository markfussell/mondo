/* JJT: 0.2.2 */
/***********************************************************************
**
**  File: chimu/mondoOml/parser/AST_String.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;
import COM.chimu.mondo.builder.*;




public class AST_String extends StringNodeAbsClass {
  AST_String(String id) {
    super(id);
  }

  public static Node jjtCreate(String id) {
    return new AST_String(id);
  }

    //**********************************************************
    //(P)******************* Manual Code ***********************
    //**********************************************************

    public void setValue(String value) {
        this.value = value;
    }

    public void setValue_unquote(String value, int quoteLength) {
        this.value = value.substring(quoteLength,value.length()-quoteLength);
    }

    public void setValue_unquoteDChar(String value, char quoteChar) {
        int quoteLength = value.indexOf(quoteChar)+1;
        quoteLength = value.indexOf(quoteChar,quoteLength)+1; //find the second

        this.value  = value.substring(quoteLength,value.length()-quoteLength);
    }

}
