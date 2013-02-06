/***********************************************************************
**
**  File: chimu/mondo/builder/client/BuilderClientConstants.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder.client;

/**
This contains internal builder constants
**/
public interface BuilderClientConstants  {

    //**********************************************************
    //****************** Parser/Client Support *****************
    //**********************************************************

    public static String LITERAL_RECIPE  = "MONDO:Literal";
    public static String TEXT_RECIPE     = "MONDO:Text";
    public static String MAP_RECIPE      = "MONDO:Map";

    //**************************************
    //********** File Oriented *************
    //**************************************

    public static String TEXT_FILE_RECIPE       = "MONDO:TextFile";
    public static String LIST_FILE_RECIPE       = "MONDO:ListFile";
    public static String OBJECT_FILE_RECIPE     = "MONDO:ObjectFile";

}
