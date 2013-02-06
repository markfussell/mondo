/***********************************************************************
**
**  File: chimu/mondoL1/model/support/L1ModelSupportPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.model.support;

/**

**/
public class L1ModelSupportPack {
    static public ClassLoader primaryClassLoader() {
        return primaryClassLoader;
    }

    static public void setupPrimaryClassLoader(ClassLoader loader) {
        primaryClassLoader = loader;
    }

    //**********************************************************
    //(P)***************** Factory Methods *********************
    //**********************************************************

    static public ClassLoader newPushPullClassLoader() {
        return new PushPullClassLoaderClass();
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    static protected ClassLoader primaryClassLoader = null;

    //**************************************
    //**************************************
    //**************************************

    private L1ModelSupportPack() {}


}

