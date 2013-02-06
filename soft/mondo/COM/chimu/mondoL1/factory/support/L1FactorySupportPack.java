/***********************************************************************
**
**  File: chimu/mondoL1/factory/support/L1FactorySupportPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory.support;

import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.exceptions.*;

import java.io.*;
import java.net.*;

/**
**/
public class L1FactorySupportPack {

    //**********************************************************
    //**********************************************************
    //**********************************************************

    static public InputStream dataInputStreamFromUrl(String urlString) {
        return new java.io.DataInputStream(inputStreamFromUrl(urlString));
    }

    static public InputStream inputStreamFromUrl(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeWrappedException("Could not open URL on: "+urlString,e);
        }

//System.err.println(url+"="+url.getProtocol()+" "+url.getHost()+" "+url.getFile());

        InputStream stream = null;
        try {
            stream = url.openStream();
        } catch (Exception e) {
            throw new RuntimeWrappedException("Could not open URL stream: "+urlString,e);
        }

        return stream;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    private L1FactorySupportPack() {}

}

