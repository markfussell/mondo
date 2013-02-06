/***********************************************************************
**
**  File: chimu/mondoXml/encoder/XmlObjectEncoder2Class.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoXml.encoder;
import COM.chimu.mondo.encoder.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.exceptions.*;

import java.util.Stack;
import java.io.PrintWriter;

public class XmlObjectEncoder2Class extends ObjectEncoderAbsClass  {
    public XmlObjectEncoder2Class(PrintWriter output) {
        this.output = output;
    }

    protected void print(String aString) {
        output.print(aString);
    }

    protected void newLine() {
        output.println();
    }

    protected void finishIndentLine() {
        output.println();
        int indent = objectRecipeInfos.size() - 1;
        for (int i=0;i<indent;i++) {
            output.print("  ");
        }
    }

    protected void startIndentLine() {
        output.println();
        int indent = objectRecipeInfos.size();
        for (int i=0;i<indent;i++) {
            output.print("  ");
        }
    }

    protected String makeXmlTagNameFrom(String recipeName) {
        return recipeName.replace(':','.');
    }

    public void      startObject(String recipeName) {
        if (isInListMode) {
            startIndentLine();
        }
        pushRecipeInfoStack();
        if (recipeName.equals("MONDO:Literal")) {
            isInLiteralMode = true;
        }
        this.tagName  = makeXmlTagNameFrom(recipeName);
        print("<"+tagName+">");
    }

    public void      startParameter(String parameterName) {
        if (parameterName.equals("mondo:content")) {
            startDefaultParameter();
            return;
        }
        currentParameterName = makeXmlTagNameFrom(parameterName);
        startIndentLine();
        print("<"+currentParameterName+">");
    }
    public void      startParameterValue() {}
    public void      finishParameterValue() {}
    public void      finishParameter() {
        if (currentParameterName != null) {
            print("</"+currentParameterName+">");
        }
    }

    public void      finishObject() {
        boolean hadParameter = (currentParameterName != null);
        if (hadParameter) {
            finishIndentLine();
        }
        print("</"+tagName+">");
        popRecipeInfoStack();
    }

    public void      startDefaultParameter() {
        currentParameterName = null;
    }

    //**************************************
    //**************************************
    //**************************************

    public void      startList() {
        pushRecipeInfoStack();
        boolean inParameter = (previousParameterName != null);
        isInListMode = true;
        if (inParameter) {
            print("<XML.List>");
        }
    }

    public void      startListElement() {
        boolean inParameter = (previousParameterName != null);
        if (inParameter) {
            startIndentLine();
        }
    };
    public void      finishListElement() {
        //if (previousParameterName != null) {
        //    finishIndentLine();
        //}
    }

    public void      finishList() {
        boolean inParameter = (previousParameterName != null);
        if (inParameter) {
            finishIndentLine();
            print("</XML.List>");
        }
        popRecipeInfoStack();
    }

    //**************************************
    //**************************************
    //**************************************

    public void      encodeString(String string) {
        boolean hasParameter = (currentParameterName != null);
        if (hasParameter) {
            print(string);
        } else if (isInListMode && (previousParameterName == null)) {
            print(string);
        } else if (isInLiteralMode) {
            print(string);
        } else {
            print("<XML.String>");
            print(string);
            print("</XML.String>");
        }
    }

    public void      encodeLiteral(String value) {
        print("<Literal>");
        print(value);
        print("</Literal>");
    }
    public void      encodeNoValue() {}

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected void popRecipeInfoStack() {
        Object[] recipeInfo = (Object[]) objectRecipeInfos.pop();
        int i = 0;
        tagName                 = (String)   recipeInfo[i++];
        currentParameterName    = (String)   recipeInfo[i++];
        previousParameterName   = (String)   recipeInfo[i++];
        isInListMode            = (recipeInfo[i++] != null);
        isInLiteralMode         = (recipeInfo[i++] != null);

    }

    protected void pushRecipeInfoStack() {
        Object[] recipeInfo = new Object[5];

        int i = 0;
        recipeInfo[i++] = tagName;
        recipeInfo[i++] = currentParameterName;
        recipeInfo[i++] = previousParameterName;
        recipeInfo[i++] = isInListMode ? Boolean.TRUE : null;
        recipeInfo[i++] = isInLiteralMode ? Boolean.TRUE : null;
        objectRecipeInfos.push(recipeInfo);

        previousParameterName = currentParameterName;

        currentValue=null;

        tagName=null;
        parameterMap = null; currentParameterName=null;
        isInListMode = false;
        isInLiteralMode = false;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    public Object currentBuiltObject() {
        return currentValue;
    }

    protected boolean isInListMode() {
        return isInListMode;
    }

    protected boolean isInLiteralMode() {
        return isInLiteralMode;
    }

    protected PrintWriter output = null;

    //**************************************
    //**************************************
    //**************************************

    protected Stack     objectRecipeInfos = new Stack();

    protected Object    currentValue;

    //**************************************
    // CreationState
    protected String    tagName = null;
    protected Map       parameterMap = null;
    protected String    currentParameterName = null;
    protected String    previousParameterName = null;
    protected boolean   isInListMode = false;
    protected boolean   isInLiteralMode = false;

}
