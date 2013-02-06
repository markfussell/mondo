/***********************************************************************
**
**  File: chimu/mondoL1/factory/primitives/BinaryFC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory.primitives;
import COM.chimu.mondoL1.factory.support.*;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.factory.support.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.Map;

import java.io.*;

public class BinaryFC extends FactoryAbsClass  {
    public BinaryFC() {};
    public BinaryFC(String name, ObjectBuilder builder) {};


    public Object createObjectFromName_parameters_for(String recipeName, Map parameters, ObjectBuilder builder) {
        String encoding = ParameterLib.getStringValueFor_from("encoding",parameters);
        if (encoding == null) encoding = "hex";
            //??? What other encodings should we support
            //return decodeFromHex(content);

        Object contentO = ParameterLib.getContentFrom(parameters);
        if (contentO != null) return decodeFromContent(contentO);

        String urlString = ParameterLib.getStringValueFor_from("url",parameters);
        if (urlString != null) return readFromUrl(urlString);


        return new byte[0];
    }


    protected byte[] decodeFromContent(Object contentO) {
        char[] content = null;
        if (contentO instanceof String) {
            content = ((String) contentO).toCharArray();
        } else if (contentO instanceof char[]) {
            content = (char[]) contentO;
        } else if (contentO instanceof byte[]) {
            return (byte[]) contentO;
        } else {
            throwErrorCalled_withInvalid_equalTo("Binary","content",contentO);
        }

        return decodeFromHex(content);
    }


    protected byte[] readFromUrl(String urlString) {
        try {
            InputStream in      = L1FactorySupportPack.inputStreamFromUrl(urlString);
            byte inBytes[]   = new byte[in.available()];

            in.read(inBytes);

            return inBytes; //decodeFromHex(classBytes);
        } catch (Exception e) {e.printStackTrace();}
        return null;
    }


    //**********************************************************
    //**********************************************************
    //**********************************************************

    static public char[] encodeToHex(byte[] inBytes) {
        char[] outBytes = new char[inBytes.length*2];

        int size = inBytes.length;
        int index=0;
        for (int i=0;i<size;i++) {
            char[] encoding = hexEncoding[inBytes[i]+128];
            outBytes[index++]= encoding[0];
            outBytes[index++]= encoding[1];
        }

        return outBytes;
    }

    static public byte[] decodeFromHex(char[] inBytes) {
        byte[] outBytes = new byte[inBytes.length/2];

        int size = outBytes.length;
        int index=0;
        for (int i=0;i<size;i++) {
		    byte value = (byte) (
		            Character.digit( inBytes[index++],16)*16+
                    Character.digit( inBytes[index++],16));
            outBytes[i]=value;
        }

        return outBytes;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************


    static private char[][] hexEncoding = new char[256][];
    static private char[] hexDigitEncoding = new char[16];

    static {
        for (int i=0; i<10; i++) {
            hexDigitEncoding[i] = (char) ('0'+i);
        }
        for (int i=0; i<6; i++) {
            hexDigitEncoding[i+10] = (char) ('a'+i);
        }
        int index = 128;
        for (int i=0; i<8; i++) {
            char firstDigit =hexDigitEncoding[i];
            for (int j=0; j<16; j++) {
                char secondDigit = hexDigitEncoding[j];
                char[] buffer = {firstDigit,secondDigit};
                hexEncoding[index] = buffer;
                index++;
            }
        }
        index = 0;
        for (int i=8; i<16; i++) {
            char firstDigit =hexDigitEncoding[i];
            for (int j=0; j<16; j++) {
                char secondDigit = hexDigitEncoding[j];
                char[] buffer = {firstDigit,secondDigit};
                hexEncoding[index] = buffer;
                index++;
            }
        }
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************
    //Testing routine

    static public void main(String[] args) {
        for (int i=0; i<hexEncoding.length; i++) {
            System.err.print(hexEncoding[i]);
        }
        System.err.println();

        if (args.length==0) return;

        String className = args[0];

        try {
            FileInputStream fin;
            byte classBytes[];
            fin = new FileInputStream(className.replace('.', File.separatorChar)
                                      + ".class");

            // read the bytes in the file into an array called classBytes
            classBytes = new byte[fin.available()];
            fin.read(classBytes);

            char[] encoded = encodeToHex(classBytes);

            Writer out = new BufferedWriter(new FileWriter(className+".hex"));
            out.write(encoded);
            out.flush();
            out.close();
        } catch (Exception e) {e.printStackTrace();}

    }

}
