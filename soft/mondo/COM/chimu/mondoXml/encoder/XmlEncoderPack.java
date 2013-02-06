/***********************************************************************
**
**  File: chimu/mondoXml/encoder/XmlEncoderPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoXml.encoder;
import COM.chimu.mondo.encoder.ObjectEncoder;
import java.io.PrintWriter;

/**

**/
public class XmlEncoderPack {

    //**********************************************************
    //(P)***************** Factory Methods *********************
    //**********************************************************

    static public ObjectEncoder newXmlEncoder(PrintWriter pw) {
        return new XmlObjectEncoder1Class(pw);
    }

    static public ObjectEncoder newXmlEncoder2(PrintWriter pw) {
        return new XmlObjectEncoder2Class(pw);
    }

    //static public ObjectEncoder newXmlEncoder3(PrintWriter pw) {
    //    return new XmlObjectEncoder3Class(pw);
    //}



    //**********************************************************
    //**********************************************************
    //**********************************************************

    private XmlEncoderPack() {}


}

