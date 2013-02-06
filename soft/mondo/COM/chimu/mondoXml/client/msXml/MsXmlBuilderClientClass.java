/***********************************************************************
**
**  File: chimu/mondoXml/client/msXml/MsXmlBuilderClientClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoXml.client.msXml;

import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.client.*;

import com.ms.xml.om.*;
import com.ms.xml.util.*;

import COM.chimu.kernel.collections.*;
import java.util.Enumeration;

//******************************************
//******************************************

class MsXmlBuilderClientClass {
    MsXmlBuilderClientClass() {}

    Object NO_VALUE = null;
    ObjectBuilder builder = null;

    public void setupObjectBuilder(ObjectBuilder builder) {
        this.builder = builder;
        NO_VALUE = builder.noValueObject();
    }

    public Object buildObjectFrom(Element e) {
        int eType = e.getType();
        if (eType == Element.ELEMENT) {
            //Document doc  = e.getDocument();
            //Element  decl = doc.getElementDecl(e.getName());

            Map parameters = builder.newParameterMap();
            if (e.numElements() > 0) {
                List contents = builder.newContentsList();
                Enumeration enum = e.getElements();
                while (enum.hasMoreElements()) {
                    Element childE = (Element) enum.nextElement();
                    Object childObject = buildObjectFrom(childE);
                    if (childObject != NO_VALUE) {
                        contents.add(childObject);
                    }
                }
                parameters.atKey_put(
                        builder.defaultParameterName(),
                        builder.createObjectFromList(contents)
                    );
            }

            Enumeration enum2 = e.getAttributes();
            while (enum2.hasMoreElements()) {
                Attribute attribute = (Attribute) enum2.nextElement();
                Object value = builder.createObjectFromString(attribute.getValue().toString());
                parameters.atKey_put(attribute.getName().toString(),value);
            }
            return builder.createObjectFromName_parameters(e.getTagName().toString(), parameters);
        } else if (eType == Element.CDATA) {
            String string = e.getText();
            return builder.createObjectFromString(string);
        } else if (eType == Element.PCDATA) {
            String string = e.getText();
            return builder.createObjectFromString(string);
        } else if (eType == Element.WHITESPACE) {
            String string = e.getText();
            return builder.createObjectFromString(string);
        } else if (eType == Element.ENTITY) {
            String string = e.getText();
            return builder.createObjectFromString(string);
        } else if (eType == Element.ENTITYREF) {
            String string = e.getText();
            return builder.createObjectFromString(string);
        } else if (eType == Element.DOCUMENT) {
            List contents = builder.newContentsList();
            Enumeration enum = e.getElements();
            while (enum.hasMoreElements()) {
                Element childE = (Element) enum.nextElement();
                Object childObject = buildObjectFrom(childE);
                if (childObject != NO_VALUE) {
                    contents.add(childObject);
                }
            }
            return builder.createObjectFromList(contents);
        }
        return NO_VALUE;
    }

}
