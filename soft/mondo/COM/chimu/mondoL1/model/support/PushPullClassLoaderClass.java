/***********************************************************************
**
**  File: chimu/mondoL1/model/support/PushPullClassLoaderClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.model.support;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

import java.io.*;
import java.util.Hashtable;
import java.util.Properties;

public class PushPullClassLoaderClass
                    extends    ClassLoader
                    implements PushPullClassLoaderI {

    public PushPullClassLoaderClass() {
        Properties properties = System.getProperties();
        String classPath = (String) properties.get("java.class.path");
        String separatorS = (String) properties.get("path.separator");
        char seperator = separatorS.charAt(0);

        List list = CollectionsImplPack.newList();
        int index = 0;
        int sepIndex;

        for(;;) {
            sepIndex = classPath.indexOf(seperator,index);
            if (sepIndex == -1) break;
            list.add(classPath.substring(index,sepIndex));
            index = sepIndex+1;
        }

        pathList = list;

        pathArray = new String[list.size()];
        int size = list.size();
        for (int i=0; i<size; i++) {
            pathArray[i] = (String) list.atIndex(i);
        }
        // list.copyInto(pathArray);
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    public void setTraceStream_name(PrintWriter stream, String name) {
        this.name = name;
    }

        //?? Was-Resolved ??
    public Class pushClassName_class(String className, Class aClass) {
        Class result = (Class) loadedClasses.get(className);
        if (result == null) {
            result = aClass;
            loadedClasses.put(className, result);
        }
        return result;
    }

    public Class pushClassName_bytecodes(String className, byte[] classBytes) {
        Class result = (Class) loadedClasses.get(className);
        if (result == null) {
            result = defineClass(null,classBytes, 0, classBytes.length);
            loadedClasses.put(className, result);
        }
        return result;
    }

    public void pushClassName_callback(String className, Function1Arg callback) {
        classNameToCallback.atKey_put(className,callback);
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected byte[] getClassBytesFor(String className) throws ClassNotFoundException {
        Function1Arg callback = (Function1Arg) classNameToCallback.atKey(className);
        if (callback != null) {
            return (byte[]) callback.valueWith(this);
        }
        int packageSep = className.lastIndexOf('.');
        String packageName = "";
        if (packageSep > -1) {
            packageName = className.substring(0,packageSep);
        }
        String classFile = className.replace('.',File.separatorChar);
        classFile = classFile+".class";



        try {
            String pathName = (String) packageToPath.atKey(packageName);
            File file = null;

            if (pathName != null) {

                file = new File(pathName,classFile);

                if (file.exists()) {
                } else {
                    file = null;
                }
            }

            if (file == null) {
                int size = pathArray.length;
                for (int i=0; i<size; i++) {
                    pathName = pathArray[i];
                    file = new File(pathName,classFile);
                    if (file.exists()) {
                        packageToPath.atKey_put(packageName,pathName);
                        break;
                    }
                }
            }

            if (file != null) {
                FileInputStream fis = new FileInputStream(file);
                byte[] classBytes = new byte[fis.available()];
                fis.read(classBytes);
                return classBytes;
            }
        } catch (Exception e) {}
        throw new ClassNotFoundException("Could not find "+className);
    }

    protected Class loadClass(String className, boolean resolveIt)
                           throws ClassNotFoundException {
        tracePrint("loadClass(\"" + className + "\", " + resolveIt + ") :");
        tracePush();

        Class result = (Class) loadedClasses.get(className);

        if (result == null) {
            if (className.startsWith("java")) {
                result = findSystemClass(className);
            } else {
                byte classBytes[] = getClassBytesFor(className);
                result = defineClass(className, classBytes, 0, classBytes.length);
            }

            if (result != null) {
                loadedClasses.put(className, result);
            } else {
                throw new ClassNotFoundException("Could not find "+className);
            }
        }

        if (resolveIt && !resolvedClasses.containsKey(className)) {
            resolveClass(result);
        }

        tracePop();
        return result;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************


    protected void tracePrint(String str) {
        if (ts == null) return;
        ts.print(name+" ");
        for (int i = traceLevel; i > 0; i--) {
            ts.print("    ");
        }
        ts.println(str);
    }

    protected void tracePush() {
        traceLevel++;
    }

    protected void tracePop() {
        traceLevel--;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected Hashtable loadedClasses   = new Hashtable();
    protected Hashtable resolvedClasses = new Hashtable();

    protected Map classNameToCallback = CollectionsImplPack.newMap();
    protected Map packageToPath = CollectionsImplPack.newMap();

    protected String        name = "LOADER";
    protected PrintWriter   ts = null;
    protected int           traceLevel = 0;

    protected List pathList = null;
    protected String[] pathArray = null;



}
