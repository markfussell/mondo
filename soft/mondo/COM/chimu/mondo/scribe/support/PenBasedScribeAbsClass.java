/***********************************************************************
**
**  File: chimu/mondo/scribe/support/PenBasedScribeAbsClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.scribe.support;

import COM.chimu.mondo.scribe.*;
import COM.chimu.mondo.pen.*;

import COM.chimu.mondo.encoder.*;

import COM.chimu.kernel.collections.Map;
import COM.chimu.kernel.collections.Sequence;
import COM.chimu.kernel.collections.Collection;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

public abstract class PenBasedScribeAbsClass
            extends ScribeAbsClass
            implements ScribeSi, PenBasedScribe
            {

    public ObjectEncoder defaultEncoder() {
        return null;
    }

    public void scribeObjectWebFor(Object anObject) {
        scribeObject(anObject);
    }

    //**************************************
    //**************************************
    //**************************************

    static protected final int ENTRY2_ICOUNT = 0;
    static protected final int ENTRY2_CCOUNT = 1;
    static protected final int ENTRY2_STAGE  = 2;

    static protected final int ENTRY_COUNTERS = 0;
    static protected final int ENTRY_MEMENTO  = 1;

    static protected final int STAGE_PREPARE = 0;
    static protected final int STAGE_HEADER  = 1;
    static protected final int STAGE_FIRST   = 2;
    static protected final int STAGE_SECOND  = 3;



    public void scribeObject(Object object) {
        if (object == null) {
            penForNull.scribeFirstObject_for_to(object,this,myEncoder());
            return;
        }

        Object[] objectEntry = (Object[]) objectToInfo.atKey(object);
        if (objectEntry == null) {
            int[] counters = {-1,0,STAGE_FIRST};
            Object[] newEntry = {counters,null};
            objectToInfo.atKey_put(object,newEntry);
            objectEntry = newEntry;
        }
        int ccount = ((int[]) objectEntry[ENTRY_COUNTERS])[ENTRY2_CCOUNT];

        Pen pen = getPenFor(object);
        if (pen != null) {
            if (ccount == 0) {
                pen.scribeFirstObject_for_to(object,this,myEncoder());
            } else {
                pen.scribeSecondObject_for_to(object,this,myEncoder());
            }
            ((int[]) objectEntry[ENTRY_COUNTERS])[ENTRY2_CCOUNT]=ccount+1;
        }
    }

    protected abstract ObjectEncoder myEncoder();

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected Pen getPenFor(Object object) {
        if (object == null) return penForNull;

        Class objectClass = object.getClass();
        Pen pen  = (Pen) classToPen.atKey(objectClass);
        if (pen != null) return pen;

        pen = createPenFor(object, objectClass);
        if (pen == null) {
            pen = getDefaultPenFor(object, objectClass);
        }

        classToPen.atKey_put(objectClass, pen);
        return pen;
    }

    protected abstract Pen createPenFor(Object object, Class objectClass);
    protected abstract Pen getDefaultPenFor(Object object, Class objectClass);

    //**************************************
    //**************************************
    //**************************************

    /*subsystem*/ public String getRecipeNameFor(String className) {
        int index = className.lastIndexOf('.');
        if (index > -1) {
            className = className.substring(index+1);
        }
        if (className.endsWith("Class")) {
            if (className.length() > 5) {
                className = className.substring(0,className.length()-5);
            }
        }
        return className;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    public void setPenForNullTo(Pen pen) {
        penForNull = pen;
    }

    public void setPenForClass_to(Class aClass, Pen aPen) {
        classToPen.atKey_put(aClass, aPen);
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

        /** Registers a Pen for a specific object */
    protected Map classToPen    = CollectionsImplPack.newMap();
    protected Map objectToCount = CollectionsImplPack.newMap();
    protected Map objectToInfo  = CollectionsImplPack.newMap();
    protected Pen penForNull = null;

}

