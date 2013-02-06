/***********************************************************************
**
**  File: chimu/mondo/encoder/ObjectEncoder.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.encoder;
import COM.chimu.mondo.recipe.*;

/**
ObjectEncoder supports creating Recipes on a stream like object.
**/
public interface ObjectEncoder  {

    public void encodeRecipe(Recipe recipe);

    //**************************************
    //**************************************
    //**************************************

    public void      startObject(String recipeName);
    public void      startParameter(String ingredientName);
    public void      startParameterValue();
    public void      finishParameterValue();
    public void      finishParameter();
    public void      finishObject();

    public void      startDefaultParameter();

    //**************************************
    //**************************************
    //**************************************

    public void      startValuedParameter(String ingredientName);
    public void      finishValuedParameter();

    //**************************************
    //**************************************
    //**************************************

    public void      startList();
    public void      startListElement();
    public void      finishListElement();
    public void      finishList();

    public void      encodeString(String value);
    public void      encodeLiteral(String value);
    public void      encodeNoValue();
}
