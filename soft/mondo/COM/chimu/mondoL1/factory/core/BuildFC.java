/***********************************************************************
**
**  File: chimu/mondoL1/factory/core/BuildFC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory.core;

import COM.chimu.mondoL1.factory.*;
import COM.chimu.mondoL1.factory.support.*;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.factory.support.*;
import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.support.*;
import COM.chimu.mondo.model.*;

import COM.chimu.mondoOml.parser.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

import java.io.*;
import java.net.*;

/*
    url    = <Url>
    string = <ReadString file=<File> >

    encoding = (oml|xml|sgml)

    decoder = <OML>
    decoder = <XML>
    option = (single|list|text)

*/

public class BuildFC implements Factory  {
    public BuildFC(String name, ObjectBuilder builder) {}
    public BuildFC() {}

        //String encoding, String option, Function2Arg decoder
    public void setupDecoder(Function2Arg decoder) {
        this.decoder = decoder;
    }

    public Object createObjectFromName_parameters_for(String name, Map map, ObjectBuilder builder) {
        InputStream parserInput = null;
        Object result;

        String urlString = ParameterLib.getStringValueFor_from("url",map);
        if (urlString == null) {
            System.err.println("No url for <Build> factory");
        }
        String sourceString = null;

        //**********************************
        //**********************************
        //**********************************

        if (urlString != null) {
            parserInput = L1FactorySupportPack.dataInputStreamFromUrl(urlString);
        } else if (sourceString != null) {


        }



        if (parserInput == null) {
            return builder.noValueObject();
        }


        //**********************************
        //**********************************
        //**********************************

//System.err.println("INNER PARSE TIME: "+System.currentTimeMillis());
        //builder = new TracingBuilderClass();
        try {
            result = decoder.valueWith_with(parserInput,builder);
        } catch (Exception e) {
            e.printStackTrace();
            return builder.noValueObject();
        }
//System.err.println("END INNER PARSE TIME: "+System.currentTimeMillis());

        return result;

    }

    Function2Arg decoder = OmlParserPack.anOmlListFileDecoder();
}
