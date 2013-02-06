/***********************************************************************
**
**  File: chimu/mondoTools/ClassLoaderStarter.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoTools.converters;

import COM.chimu.mondoL1.factory.primitives.BinaryFC;

import java.io.*;
import java.lang.reflect.*;

/**
**/
public class BinaryFileToHexMain {
    public static void main(String args[]) {
        new BinaryFileToHexMain().executeWithArgs(args);
    }

    public void executeWithArgs(String args[]) {
        if (args.length < 1) {
            System.out.println("Usage: java BinaryFileToHexMain <filename> ...");
            return;
        }
        String fileName = args[0];

        try {
            FileInputStream fin;
            byte classBytes[];
            fin = new FileInputStream(fileName);

            // read the bytes in the file into an array called classBytes
            classBytes = new byte[fin.available()];
            fin.read(classBytes);

            char[] encoded = BinaryFC.encodeToHex(classBytes);
            System.out.print(encoded);
        } catch (Exception e) {e.printStackTrace();}
    }

}