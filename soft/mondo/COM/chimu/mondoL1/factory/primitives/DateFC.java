/***********************************************************************
**
**  File: chimu/mondoL1/factory/primitives/DateFC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.factory.primitives;


import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.factory.support.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.functors.*;

import java.text.*;
import java.util.Locale;
import java.util.Date;


public class DateFC extends FactoryAbsClass  {
    public DateFC() {init();}
    public DateFC(String name, ObjectBuilder builder) {init();}

    protected void init() {
        setFormat("yyyy-MM-dd");
    }


    public Object createObjectFromName_parameters_for(String recipeName, Map parameters, ObjectBuilder builder) {
        String iso = ParameterLib.getStringValueFor_from("iso",parameters);
        if (iso == null) {
            return new Date();
        } else {
            if (iso.indexOf("-") == 2) {//Left off current century
                iso="19"+iso;
            }
            try {
                return dateFormatter.parse(iso);
            } catch (Exception e) {
                System.err.println(iso);
                return builder.noValueObject();
            };
        }
    }

    public String getFormat() {
        return dateFormat;
    }

    public void setFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        dateFormatter = new SimpleDateFormat(dateFormat, Locale.US);
    }

    public String toString() {
        return "<DateFactory format=\""+dateFormat+"\">";
    }

    protected String dateFormat = null;
    protected DateFormat dateFormatter = null;

}
