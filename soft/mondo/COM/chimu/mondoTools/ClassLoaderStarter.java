/***********************************************************************
**
**  File: chimu/mondoTools/ClassLoaderStarter.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoTools;

import java.io.*;
import java.lang.reflect.*;

/**
ClassLoaderStarter supports starting an application with a different loader than the
default system loader.  Simply give it the class name of the desired ClassLoader
and the class name of the StartingClass (to be loaded by the new loader) as the first
two command line arguments.

<PRE>
Usage: java ClassLoaderStarter <loaderName> <startingClassName> ...
</PRE>
**/
public class ClassLoaderStarter {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ClassLoaderStarter <loaderName> <startingClassName> ...");
            return;
        }
        String loaderClassName   = args[0];
        String startingClassName = args[1];
        ClassLoader loader = null;

        try {
            Class  loaderClass  = Class.forName(loaderClassName);
            loader  = (ClassLoader) loaderClass.newInstance();
        } catch (Exception e) {
            System.out.println("Could not create the ClassLoader because:");
            e.printStackTrace();
            return;
        }

        String[] newArgs = new String[args.length-2];
        for (int i=0; i<newArgs.length; i++) {
            newArgs[i] = args[i+2];
        }
        callMainIn_usingLoader_args(startingClassName,loader,newArgs);
    }

    public static void callMainIn_usingLoader_args(
                String startingClassName,
                ClassLoader startingLoader,
                String[] args
            ) {
        try {
            Class  startingClass  = startingLoader.loadClass(startingClassName);
                //Class  startingClass  = Class.forName(startingClassName);

            Class[]  argumentTypes  = {args.getClass()};
            Object[] argumentValues = {args};

            Method main = startingClass.getMethod("main",argumentTypes);

            main.invoke(null,argumentValues);
       } catch (Exception e) {
            e.printStackTrace();
        }
    }

}