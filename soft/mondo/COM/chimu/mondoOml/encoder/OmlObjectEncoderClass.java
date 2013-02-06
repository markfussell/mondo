/***********************************************************************
**
**  File: chimu/mondoOml/encoder/OmlObjectEncoderClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.encoder;
import COM.chimu.mondo.encoder.ObjectEncoderAbsClass;

import java.io.PrintWriter;

public class OmlObjectEncoderClass extends ObjectEncoderAbsClass  {
    OmlObjectEncoderClass(PrintWriter output) {
        this.output = output;
    }

    protected void print(String aString) {
        output.print(aString);
    }

    //**************************************
    //**************************************
    //**************************************

    public void      startObject(String typeIdentifier) {
        print("<"+typeIdentifier);
    }
    public void      startParameter(String parameterName) {
        print(" "+parameterName);
    }
    public void      startParameterValue() {
        print("=");
    }
    public void      finishParameterValue() {}
    public void      finishParameter() {}
    public void      finishObject() {
        print(">");
    }

    public void      startDefaultParameter() {}

    //**************************************
    //**************************************
    //**************************************

    public void      startList() {
        print("(");
    }

    public void      startListElement() {
        print(" ");
    }
    public void      finishListElement() {
    }
    public void      finishList() {
        print(")");
    }

    public void      encodeString(String string) {
        if (string.indexOf('"') < 0) {
            print("\""+string+"\"");
        } else if (string.indexOf('\'') < 0) {
            print("'"+string+"'");
        } else if (string.indexOf("]]") < 0) {
            print("[["+string+"]]");
        } else if (string.indexOf("]CDATA]") < 0) {
            print("[CDATA["+string+"]CDATA]");
        } else {
            throw new RuntimeException("Do not have a suitable delimiter for [CDATA["+string+"]CDATA]");
        };
    }

    public void      encodeLiteral(String value) {
        print(value);
    }
    public void      encodeNoValue() {}


    //**************************************
    //**************************************
    //**************************************

    protected PrintWriter output = null;
}
