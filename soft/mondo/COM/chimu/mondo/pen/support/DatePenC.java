/***********************************************************************
**
**  File: chimu/mondo/pen/support/DatePenC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.pen.support;

import COM.chimu.mondo.pen.*;
import COM.chimu.mondo.scribe.*;
import COM.chimu.mondo.encoder.*;

import java.util.*;
import java.text.*;

public class DatePenC extends PenAbsClass {
    public DatePenC() {
        init();
    }

    public DatePenC(ScribeSi scribe) {
        init();
    }

    public DatePenC(ScribeSi scribe, ObjectEncoder encoder) {
        init();
    }

    protected void init() {
        formatter
            = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
//            = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        formatter.setTimeZone(TimeZone.getDefault());
    }

    public void registerObject_for(Object anObject, ScribeSi scribe) {}
    public void scribeObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder) {
        Date aDate = (Date) anObject;
        String name = scribe.getRecipeNameFor("java.util.Date");

        encoder.startObject(name);
            encoder.startParameter("iso");
                encoder.startParameterValue();
                scribe.scribeObject(formatter.format(aDate));
                encoder.finishParameterValue();
            encoder.finishParameter();
        encoder.finishObject();

    }

    protected DateFormat formatter = null;
}

