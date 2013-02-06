/***********************************************************************
**
**  File: chimu/mondo/model/ModelPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.model;

//IntegrationStamp: v0.1 [971120]

/**
The Model package contains interfaces and supporting
implementations for the DomainModel component of a
system.  The DomainModel contains the "knowledge of
the world" that is required for a particular system.
This could be the actual information in a document or
a representation of a Person within a computer.

<P>For MONDO, the DomainModel is the most important
part of the system.  But it is also the most flexible.
The application

<P>For MONDO, the DomainModel is the most flexible part
of the system.  The builder can choose to use any classes
it desires, and those classes do not have to support any
of the functionality in this package.  But other subsystems
within MONDO will require functionality from DomainObjects
and may require them to support functionality within here.

**/
public class ModelPack {

        /**
         * The NO_VALUE object provides a second distinguished object
         * (like null) which indicates (for example) that a Map had
         * no key with that value.
         */
    public static Object NO_VALUE        = new String("<No Value>");

    //**********************************************************
    //**********************************************************
    //**********************************************************

    static public String getStringValueFrom(Object stringO) {
        if (stringO == null) return null;
        if (stringO instanceof String) return (String) stringO;
        if (stringO instanceof StringValue) return ((StringValue) stringO).stringValue();
        return stringO.toString();
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    private ModelPack() {}


}

