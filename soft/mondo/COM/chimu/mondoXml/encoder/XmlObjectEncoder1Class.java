/***********************************************************************
**
**  File: chimu/mondoXml/encoder/XmlObjectEncoder1Class.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoXml.encoder;
import COM.chimu.mondo.encoder.ObjectEncoderAbsClass;

import java.io.PrintWriter;

public class XmlObjectEncoder1Class extends ObjectEncoderAbsClass  {
    XmlObjectEncoder1Class(PrintWriter output) {
        this.output = output;
    }

    protected void print(String aString) {
        output.print(aString);
    }


    //**************************************
    //**************************************
    //**************************************

    protected String makeXmlTagNameFrom(String recipeName) {
        return recipeName.replace(':','.');
    }

    public void      startObject(String recipeName) {
        String tagName  = makeXmlTagNameFrom(recipeName);
        print("<"+tagName+">");
    }

    public void      startParameter(String parameterName) {
        String tagName  = makeXmlTagNameFrom(parameterName);
        print("<"+tagName+">");
    }
    public void      startParameterValue() {
    }
    public void      finishParameterValue() {}
    public void      finishParameter() {
        print("</>");
    }
    public void      finishObject() {
        print("</>");
    }

    public void      startDefaultParameter() {}

    //**************************************
    //**************************************
    //**************************************

    public void      startList() {
        print("<List>");
    }

    public void      startListElement() {
    //    print("<Item>");
    }
    public void      finishListElement() {
    //    print("</Item>");
    }
    public void      finishList() {
        print("</List>");
    }

    public void      encodeString(String string) {
        print("<String>");
        print(string);
        print("</String>");
    }

    public void      encodeLiteral(String value) {
        print("<Literal>");
        print(value);
        print("</Literal>");
    }
    public void      encodeNoValue() {}


    //**************************************
    //**************************************
    //**************************************

    protected PrintWriter output = null;
}
