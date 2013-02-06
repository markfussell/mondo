/***********************************************************************
**
**  File: chimu/mondoOml/parser/OmlParserPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;

import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.client.*;
import COM.chimu.kernel.functors.*;

import COM.chimu.kernel.collections.*;

import java.io.InputStream;

/**

**/
public class OmlParserPack {

    static public OmlParser newOmlParser(InputStream stream) {
        return new OmlParser(stream);
    }

    static public Object buildObjectFromTextFile_using(InputStream stream, ObjectBuilder builder) {
        OmlParser parser = newOmlParser(stream);

        try {
            parser.TextFile();
        } catch (ParseError e) {
            System.err.println("Oml Parser:  Encountered errors during parse.");
            e.printStackTrace();
            System.err.println("Parsed the following tree:");
            SimpleNode rootNode = parser.rootParseNode();
            rootNode.dump("");
            return null;
        }

        SimpleNode rootNode = parser.rootParseNode();
        Object result = ((RecipeObjectBuilder) rootNode).buildObjectFor(builder);
        //map.atKey_put("mondo:content",result);
        //result = builder.createObjectFrom_parameters("MONDO:TextFile",map);
        return result;
    }

    static public Object buildObjectFromListFile_using(InputStream stream, ObjectBuilder builder) {
        OmlParser parser = newOmlParser(stream);
        try {
            parser.ObjectListFile();
        } catch (ParseError e) {
            System.err.println("Oml Parser:  Encountered errors during parse.");
            e.printStackTrace();
            System.err.println("Parsed the following tree:");
            SimpleNode rootNode = parser.rootParseNode();
            rootNode.dump("");
            return null;
        }

        SimpleNode rootNode = parser.rootParseNode();
        if (rootNode instanceof AST_List) {
            AST_List rootList = (AST_List) rootNode;
            int number = rootList.numberOfComponents();
            if (number == 0) {
                return builder.noValueObject();
            } else if (number == 1) {
                return rootList.componentAtIndex(0).buildObjectFor(builder);
            } else {
                System.err.println("Multiple ("+number+") recipes in file");

                builder.startRecipeContext(BuilderClientConstants.LIST_FILE_RECIPE);
                Map map = builder.newParameterMap();
                Object result = ((RecipeObjectBuilder) rootNode).buildObjectFor(builder);
                map.atKey_put(builder.defaultParameterName(),result);
                builder.finishRecipeContext();
                result = builder.createObjectFromName_parameters(BuilderClientConstants.LIST_FILE_RECIPE,map);
                    //map.atKey_put("mondo:content",result);
                    //result = builder.createObjectFrom_parameters(BuilderClientConstants_LIST_FILE_RECIPE,map);
                    //result = builder.createObjectFrom_parameters("MONDO:ObjectFile",map);
                return result;
            }
        }

        System.err.println("Unexpected rootNode: "+rootNode);
        return builder.noValueObject();
    }


    static public Function2Arg anOmlListFileDecoder() {
        return new OmlListFileDecoder();
    }

    static class OmlListFileDecoder implements Function2Arg {
        public Object valueWith_with(Object arg1, Object arg2) {
            InputStream stream = (InputStream) arg1;
            ObjectBuilder builder = (ObjectBuilder) arg2;

            return OmlParserPack.buildObjectFromListFile_using(stream,builder);
        }
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    private OmlParserPack() {}


}

