/***********************************************************************
**
**  File: chimu/mondoOml/encoder/OmlObjectEncoder3Class.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.encoder;
import COM.chimu.mondo.encoder.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.exceptions.*;

import java.util.Stack;
import java.io.PrintWriter;

public class OmlObjectEncoder3Class extends ObjectEncoderAbsClass  {
    public OmlObjectEncoder3Class(PrintWriter output) {
        this.output = output;
    }

    protected int outputCounter = 0;

    protected void print(String aString) {
        outputCounter += aString.length();
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


    public void      startObject(String recipeName) {
        if (isInListMode) {
            startIndentLine();
        }
        pushRecipeInfoStack();
        this.recipeName  = recipeName;

        if (recipeName.equals("MONDO:Literal")) {
            isInLiteralMode = true;
            return;
        }
        if (recipeName.equals(BuilderConstants.LIST_RECIPE)) {
            return;
        }
        print("<"+recipeName);
    }

    public void      startParameter(String parameterName) {
        if (parameterName.equals(BuilderConstants.CONTENT_KEY)) {
            startDefaultParameter();
            return;
        }

        currentParameterName = parameterName;
        startIndentLine();
        print(parameterName);
    }
    public void      startParameterValue() {
        if (currentParameterName != null) {
            print("=");
        }
    }

    public void      finishParameterValue() {}
    public void      finishParameter() {}

    public void      finishObject() {
        boolean hadParameter = (currentParameterName != null);
        if (recipeName.equals("MONDO:List")) {

        } else if (isInLiteralMode) {
        } else {
            if ((outputCounter-startingOutputCounter) > 100) {
                finishIndentLine();
                print(recipeName+">");
            } else {
                if (hadParameter) {
                    finishIndentLine();
                }
                print(">");
            }
        }
        popRecipeInfoStack();
    }

    public void      startDefaultParameter() {
        currentParameterName = null;
        print(" ");
    }

    //**************************************
    //**************************************
    //**************************************

    public void      startList() {
        pushRecipeInfoStack();
        isInListMode = true;
        print("(");
    }

    public void      startListElement() {
        print(" ");
    };
    public void      finishListElement() {
        //if (previousParameterName != null) {
        //    finishIndentLine();
        //}
    }

    public void      finishList() {
        print(")");
        popRecipeInfoStack();
    }

    //**************************************
    //**************************************
    //**************************************

    public void      encodeString(String string) {
        if (isInLiteralMode) {
            encodeLiteral(string);
            return;
        }

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

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected void popRecipeInfoStack() {
        Object[] recipeInfo = (Object[]) objectRecipeInfos.pop();
        int i = 0;
        recipeName              = (String)   recipeInfo[i++];
        currentParameterName    = (String)   recipeInfo[i++];
        previousParameterName   = (String)   recipeInfo[i++];
        isInListMode            = (recipeInfo[i++] != null);
        isInLiteralMode         = (recipeInfo[i++] != null);
        startingOutputCounter   = ((Integer)   recipeInfo[i++]).intValue();

    }

    protected void pushRecipeInfoStack() {
        Object[] recipeInfo = new Object[10];

        int i = 0;
        recipeInfo[i++] = recipeName;
        recipeInfo[i++] = currentParameterName;
        recipeInfo[i++] = previousParameterName;
        recipeInfo[i++] = isInListMode ? Boolean.TRUE : null;
        recipeInfo[i++] = isInLiteralMode ? Boolean.TRUE : null;
        recipeInfo[i++] = new Integer(startingOutputCounter);
        objectRecipeInfos.push(recipeInfo);

        previousParameterName = currentParameterName;

        currentValue=null;

        recipeName=null;
        parameterMap = null; currentParameterName=null;
        isInListMode = false;
        isInLiteralMode = false;
        startingOutputCounter = outputCounter;
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
    protected String    recipeName = null;
    protected Map       parameterMap = null;
    protected String    currentParameterName = null;
    protected String    previousParameterName = null;
    protected boolean   isInListMode = false;
    protected boolean   isInLiteralMode = false;

    protected int   startingOutputCounter = 0;

}
