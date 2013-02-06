/***********************************************************************
**
**  File: chimu/mondo/builder/support/TracingBuilderClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder.support;

import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;

import java.io.*;

public class TracingBuilderClass extends ObjectBuilderAbsClass {
    public TracingBuilderClass() {
        traceStream = new PrintWriter(System.err,true);
    }

    public void setupTraceStream(PrintWriter traceStream) {
        this.traceStream = traceStream;
    };


    public Object createObjectFromName_parameters (String name, Map parameters) {
        traceStream.println("Create "+name+" with: "+parameters);
        return noValueObject();
    }

    public Object  createObjectFromList(List values){
        traceStream.println("Create List with: "+values);
        return noValueObject();
    }

    public Object  createObjectFromString(String value) {
        traceStream.println("Create String with: "+value);
        return noValueObject();
    }


    protected PrintWriter traceStream = null;
}
