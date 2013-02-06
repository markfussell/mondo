/***********************************************************************
**
**  File: chimu/mondoL1/factory/primitives/DateFC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory.io;


import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.factory.support.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.functors.*;

import java.text.*;
import java.util.Locale;
import java.util.Date;

import java.io.*;

public class UrlStringFromFileNameFC extends FactoryAbsClass  {
    public UrlStringFromFileNameFC() {}
    public UrlStringFromFileNameFC(String name, ObjectBuilder builder) {}

    public Object createObjectFromName_parameters_for(String recipeName, Map parameters, ObjectBuilder builder) {
        String filename = ParameterLib.getStringValueFor_from("filename",parameters);
        if (filename == null) {
            return getUrlPathFrom("");
        } else {
            return getUrlPathFrom(filename);
        }
    }

    protected String getUrlPathFrom(String fileName) {
        File    file = new File(fileName);
        String  path = file.getAbsolutePath();
        char     sep = File.separatorChar;
        if (sep != '/') {
            path = path.replace(sep,'/');
        }
        if (path.charAt(0) == '/') {
            return "file://" + path;
        } else {
            return "file:///" + path;
        }
    }

    public String toString() {
        return "<UrlFromFileNameFactory>";
    }

}
