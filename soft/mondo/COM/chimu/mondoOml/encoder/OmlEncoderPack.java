/***********************************************************************
**
**  File: chimu/mondoOml/encoder/OmlEncoderPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.encoder;
import COM.chimu.mondo.encoder.ObjectEncoder;
import java.io.PrintWriter;

/**

**/
public class OmlEncoderPack {

    //**********************************************************
    //(P)***************** Factory Methods *********************
    //**********************************************************

    static public ObjectEncoder newOmlEncoder(PrintWriter pw) {
        return new OmlObjectEncoderClass(pw);
    }

    static public ObjectEncoder newOmlEncoder2(PrintWriter pw) {
        return new OmlObjectEncoder2Class(pw);
    }

    static public ObjectEncoder newOmlEncoder3(PrintWriter pw) {
        return new OmlObjectEncoder3Class(pw);
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    private OmlEncoderPack() {}


}

