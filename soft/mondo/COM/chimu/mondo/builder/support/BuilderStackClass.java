/***********************************************************************
**
**  File: chimu/mondo/builder/support/BuilderStackClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder.support;

import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;
import java.util.Vector;
import java.util.Stack;

public abstract class BuilderStackClass extends DelegatingBuilderAbsClass {

/*
    public void startRecipeContext(String recipeName) {
        Procedure2Arg contextNotifier = getContextNotifier(recipeName);
        if (contextNotifier != null) {
            contextNotifier.executeWith_with(recipeName,builder);
        }
        currentBuilder().startRecipeContext(recipeName);
    }
    public void startParameterContext(String parameterName) {
        currentBuilder().startParameterContext(parameterName);
    }
    public void finishParameterContext() {
        currentBuilder().finishParameterContext();
    }
    public void finishRecipeContext() {
        currentBuilder().finishRecipeContext();
    }
*/

    //**********************************************************
    //**********************************************************
    //**********************************************************

    public ObjectBuilder currentBuilder() {
        return currentBuilder;
    }

    public void setCurrentBuilder(ObjectBuilder builder) {
        currentBuilder = builder;
    }

    public void pushBuilder(ObjectBuilder builder) {
        builderStack.push(currentBuilder);
        currentBuilder = builder;
    }

    public ObjectBuilder popBuilder() {
        ObjectBuilder result = currentBuilder;
        currentBuilder = (ObjectBuilder) builderStack.pop();
        return result;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected ObjectBuilder currentBuilder = null;
    protected Stack builderStack = new Stack();

}
