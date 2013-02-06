/***********************************************************************
**
**  File: chimu/mondo/encoder/support/NullEncoderClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.encoder.support;
import COM.chimu.mondo.encoder.*;

public class NullEncoderClass extends ObjectEncoderAbsClass  {

    //**************************************
    //**************************************
    //**************************************

    public void      startObject(String typeIdentifier) {}
    public void      startParameter(String parameterName) {}
    public void      startParameterValue() {}
    public void      finishParameterValue() {}
    public void      finishParameter() {}
    public void      finishObject() {}

    public void      startDefaultParameter() {}

    //**************************************
    //**************************************
    //**************************************

    public void      startList() {}
    public void      startListElement() {}
    public void      finishListElement() {}
    public void      finishList() {}

    //**************************************
    //**************************************
    //**************************************

    public void      encodeString(String string) {}
    public void      encodeLiteral(String value) {}
    public void      encodeNoValue() {}

}
