/***********************************************************************
**
**  File: chimu/mondoL1/model/support/PushPullClassLoaderI.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.model.support;

import COM.chimu.kernel.functors.*;

import java.io.*;
import java.util.Hashtable;

public interface PushPullClassLoaderI {
    public void setTraceStream_name(PrintWriter stream, String name);

    public Class pushClassName_bytecodes(String className, byte[] classBytes);
    public void  pushClassName_callback(String className, Function1Arg callback);
    public Class pushClassName_class(String className, Class aClass);


    //public Class findLoadedClassNamed(String className)
}
