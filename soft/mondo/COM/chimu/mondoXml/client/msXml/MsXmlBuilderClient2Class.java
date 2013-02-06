/***********************************************************************
**
**  File: chimu/mondoXml/client/msXml/MsXmlBuilderClient2Class.java
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

class MsXmlBuilderClient2Class {
    MsXmlBuilderClient2Class() {}

    Object NO_VALUE = null;
    ObjectBuilder builder = null;


    public void setupObjectBuilder(ObjectBuilder builder) {
        this.builder = builder;
        NO_VALUE = builder.noValueObject();
    }

    protected boolean isParameter(Element e) {
        int eType = e.getType();
        if (eType == Element.ELEMENT) {
            String name = e.getTagName().getName();
            if (Character.isLowerCase(name.charAt(0))) {
                return true;
            }
        };
        return false;
    }


    protected String getParameterNameFrom(Element e) {
        return makeParameterNameFrom(e.getTagName().toString());
    }

    protected String makeParameterNameFrom(String name) {
        return name.replace('.',':');
    }

    protected String makeRecipeNameFrom(String name) {
        return name.replace('.',':');
    }

    protected void buildParameter_into(Element e, Map parameters) {
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
                //Might want to make this dependent on an attribute
                //Instead of automatic
                //Or verify the numElements instead of the results [better->fix the recipe]
            int size = contents.size();
            if (size == 0) {
                //Ignore empty content
            } else if (size == 1) { //This autochops parameters to a single element
                parameters.atKey_put(
                        getParameterNameFrom(e),
                        contents.atIndex(0)
                    );
            } else {
                parameters.atKey_put(
                        getParameterNameFrom(e),
                        builder.createObjectFromList(contents)
                    );
            }
        }
    }


    public Object buildObjectFrom(Element e) {
        int eType = e.getType();
        if (eType == Element.ELEMENT) {
            //Document doc  = e.getDocument();
            //Element  decl = doc.getElementDecl(e.getName());

            String elementName = e.getTagName().getName();
            if (elementName.equals("XML.List")) {//Special immediate interpretation
                List contents = builder.newContentsList();
                Enumeration enum = e.getElements();
                while (enum.hasMoreElements()) {
                    Element childE = (Element) enum.nextElement();
                    if (isParameter(childE)) {
                        System.err.println("Expected an object within the XML.List but found a parameter: "+childE);
                    } else {
                        Object childObject = buildObjectFrom(childE);
                        if (childObject != NO_VALUE) {
                            contents.add(childObject);
                        }
                    }
                }
                return builder.createObjectFromList(contents);
            };
            if (elementName.equals("XML.String")) {//Special immediate interpretation
                String value = e.getText();
                return builder.createObjectFromString(value);
            };

            Map parameters = builder.newParameterMap();

            Enumeration enum2 = e.getAttributes();
            while (enum2.hasMoreElements()) {
                Attribute attribute = (Attribute) enum2.nextElement();
                Object value = builder.createObjectFromString(attribute.getValue().toString());
                parameters.atKey_put(
                        makeParameterNameFrom(attribute.getName().toString()),
                        value
                    );
            }

            if (e.numElements() > 0) {
                List contents = builder.newContentsList();
                Enumeration enum = e.getElements();
                while (enum.hasMoreElements()) {
                    Element childE = (Element) enum.nextElement();
                    if (isParameter(childE)) {
                        buildParameter_into(childE,parameters);
                    } else {
                        Object childObject = buildObjectFrom(childE);
                        if (childObject != NO_VALUE) {
                            contents.add(childObject);
                        }
                    }
                }

                    //Might want to make this dependent on an attribute
                    //Instead of automatic
                    //Or verify the numElements instead of the results [better->fix the recipe]
                int size = contents.size();
                if (size == 0) {
                    //Ignore empty content
                } else if (size == 1) { //This autochops parameters to a single element
                    parameters.atKey_put(
                            builder.defaultParameterName(),
                            contents.atIndex(0)
                        );
                } else {
                    parameters.atKey_put(
                            builder.defaultParameterName(),
                            builder.createObjectFromList(contents)
                        );
                }
            }

            return builder.createObjectFromName_parameters(
                    makeRecipeNameFrom(e.getTagName().toString()),
                    parameters
                );
        } else if (eType == Element.CDATA) {
            String string = e.getText();
            return builder.createObjectFromString(string);
        } else if (eType == Element.PCDATA) {
            String string = e.getText();
            return builder.createObjectFromString(string);
        } else if (eType == Element.WHITESPACE) {
            String string = e.getText();
            return NO_VALUE; //builder.createObjectFromString(string);
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
            if (contents.size() > 1) {
                return builder.createObjectFromList(contents);
            } else if (contents.size() == 0) {
                return NO_VALUE;
            } else {
                return contents.atIndex(0);
            }
        }
        return NO_VALUE;
    }

}
