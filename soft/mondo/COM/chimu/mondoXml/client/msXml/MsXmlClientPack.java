/***********************************************************************
**
**  File: chimu/mondoXml/client/msXml/MsXmlClientPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoXml.client.msXml;

import com.ms.xml.om.*;
import com.ms.xml.util.*;
import com.ms.xml.parser.ParseException;

import COM.chimu.mondo.builder.*;
import COM.chimu.kernel.functors.*;

import java.io.*;

/**

**/
public class MsXmlClientPack {

    //**********************************************************
    //(P)***************** Factory Methods *********************
    //**********************************************************

    static public Object buildObjectFrom_using(InputStream instream, ObjectBuilder builder) {
        Document document = new Document();
        try {
            document.load(instream);
        } catch (ParseException e) {
            e.printStackTrace();
            document.reportError(e, System.err);
            document = null;
        }

        if (document == null) return builder.noValueObject();

        MsXmlBuilderClient2Class builderClient = new MsXmlBuilderClient2Class();
        builderClient.setupObjectBuilder(builder);
        return builderClient.buildObjectFrom(document);
    }

    static public Function2Arg anXmlFileDecoder() {
        return new XmlFileDecoder();
    }

    static class XmlFileDecoder implements Function2Arg {
        public Object valueWith_with(Object arg1, Object arg2) {
            InputStream stream = (InputStream) arg1;
            ObjectBuilder builder = (ObjectBuilder) arg2;

            return MsXmlClientPack.buildObjectFrom_using(stream,builder);
        }
    }


    //**********************************************************
    //**********************************************************
    //**********************************************************

    private MsXmlClientPack() {}


}

