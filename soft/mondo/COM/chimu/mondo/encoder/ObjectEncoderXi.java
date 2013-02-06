/***********************************************************************
**
**  File: chimu/mondo/encoder/ObjectEncoderXi.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.encoder;

public interface ObjectEncoderXi extends ObjectEncoder  {

    //**************************************
    //**************************************
    //**************************************

    public void      startText();
    public void      startTextElement();
    public void      finishTextElement();
    public void      finishText();

}
