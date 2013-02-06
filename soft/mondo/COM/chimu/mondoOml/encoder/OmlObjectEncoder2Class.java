/***********************************************************************
**
**  File: chimu/mondoOml/encoder/OmlObjectEncoder2Class.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.encoder;
import COM.chimu.mondo.encoder.ObjectEncoderAbsClass;

import java.io.PrintWriter;

public class OmlObjectEncoder2Class extends ObjectEncoderAbsClass {
    OmlObjectEncoder2Class(PrintWriter output) {
        this.output = output;
        this.indentString="";
    }

    protected void print(String aString) {
        output.print(aString);
    }

    protected void println(String aString) {
        output.println();
        for (int i = 0; i<level; i++) {
            output.print("    ");
        }
        output.print(aString);
    }

    //**************************************
    //**************************************
    //**************************************

    public void      startObject(String typeIdentifier) {
        print("<"+typeIdentifier);
        level++;
        hadParameter=false;
    }
    public void      startParameter(String parameterName) {
        println(" "+parameterName);
        hadParameter=true;
    }
    public void      startParameterValue() {
        print("=");
    }
    public void      finishParameterValue() {}
    public void      finishParameter() {}
    public void      finishObject() {
        level--;
        if (hadParameter) {
            println(">");
        } else {
            print(">");
        }
    }

    public void      startDefaultParameter() {
        print(" ");
        hadParameter=true;
    }

    //**************************************
    //**************************************
    //**************************************

    public void      startList() {
        print("(");
        isFirst = true;
    }

    public void      startListElement() {
        if (isFirst) {
            isFirst=false;
        } else {
            print(" ");
        }
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
    protected String indentString = null;
    protected int level = 0;
    protected boolean isFirst;
    protected boolean hadParameter;
}
