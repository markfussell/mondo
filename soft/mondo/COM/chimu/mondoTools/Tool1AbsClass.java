/***********************************************************************
**
**  File: chimu/mondoTools/Tool1AbsClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoTools;

import COM.chimu.mondoOml.parser.OmlParserPack;

import COM.chimu.mondo.builder.client.*;

import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.support.*;

import COM.chimu.mondo.model.*;

import COM.chimu.mondo.encoder.*;
import COM.chimu.mondo.recipe.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.functors.*;

import java.io.*;
import java.util.Stack;
import java.util.Vector;

public abstract class Tool1AbsClass {

//  Conceptual Inherited Static Method
/*
    public static void main(String args[]) {
        new Tool1AbsClass().executeWithArgs(args);
    }
*/

    public void executeWithArgs(String args[]) {
        InputStream is = getInputStreamFrom(args);
    }

    protected Object buildObjectFrom_using(InputStream is, ObjectBuilder builder) {
        if (useXml) {
            return COM.chimu.mondoXml.client.msXml.
                   MsXmlClientPack.buildObjectFrom_using(is, builder);
        }
        return OmlParserPack.buildObjectFromListFile_using(is, builder);
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected String programName() {
        return this.getClass().getName();
    }
    protected String programVersion() {
        return "0.1";
    }
    protected String programNameAndVersion() {
        return programName()+" "+programVersion();
    }

    protected InputStream getInputStreamFrom(String[] args) {
        args = getArgumentsFrom(args);

        InputStream is = null;
        if (args.length == 0) {
            is = new java.io.DataInputStream(System.in);
        } else if (args.length == 1) {
            if (args[0].endsWith(".xml")) {
                useXml=true;
            }

            System.err.println(programName()+":  Reading from file " + args[0] + " . . .");
            try {
                is = new java.io.DataInputStream(new java.io.FileInputStream(args[0]));
            } catch (java.io.FileNotFoundException e) {
                System.err.println(programName()+":  File " + args[0] + " not found.");
                throw new RuntimeException("File Not Found");
            }
        } else {
            System.err.println(programName()+":  Usage is one of:");
            System.err.println("         java "+programName()+" < inputfile");
            System.err.println("OR");
            System.err.println("         java "+programName()+" inputfile");
            throw new RuntimeException("Incorrect Usage");
        }
        return is;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected boolean useXml = false;

    public String[] getArgumentsFrom(String[] args) {
        Vector files = new Vector();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            if (arg.equals("-xml")) {
                useXml = true;
            } else if (arg.equals("-oml")) {
                useXml = false;
            } else {
                files.addElement(arg);
            }
        };
        String[] result = new String[files.size()];
        files.copyInto(result);
        return result;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************


}

