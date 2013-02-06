/***********************************************************************
**
**  File: chimu/mondo/builder/support/BuilderSupportPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder.support;

import COM.chimu.mondo.builder.*;

import java.io.*;

/**
BuilderSupportPack contains abstract classes and utility builders.
The most important conceptual abstract class is the
FactoryBasedBuilder, which supports associating Factories with
particular recipes.  The DelegationBuilder is also important for
combining different builders together with a single facade.

<P>The utility builders include NoValue builders and simple tracing builders.

<P>Finally, the RecipeBuilder is extremely useful because it allows the Builder
recipe stream to be reified into actual Recipe DomainObjects.  These
recipe objects can later be re-fed into the building process.
**/
public class BuilderSupportPack {

    //**********************************************************
    //(P)***************** Factory Methods *********************
    //**********************************************************

        /**
         * Returns an ObjectBuilder which always "creates"
         * the NoValue object.
         */
    static public ObjectBuilder newNoValueBuilder() {
        return new NoValueBuilderClass();
    }

    static public ObjectBuilder newTracingBuilder() {
        return new TracingBuilderClass();
    }

    static public ObjectBuilder newRecipeBuilder() {
        return new RecipeBuilderClass();
    }

    static public ObjectBuilder newTracingBuilder(PrintWriter pw) {
        TracingBuilderClass builder = new TracingBuilderClass();
        builder.setupTraceStream(pw);
        return builder;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    private BuilderSupportPack() {}


}

