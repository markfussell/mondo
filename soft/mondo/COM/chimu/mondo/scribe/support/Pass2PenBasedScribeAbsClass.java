/***********************************************************************
**
**  File: chimu/mondo/scribe/support/Pass2PenBasedScribeAbsClass.java
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

public abstract class Pass2PenBasedScribeAbsClass
            extends ScribeAbsClass
            implements ScribeSi, PenBasedScribe
            {

    public ObjectEncoder defaultEncoder() {
        return null;
    }

/*
    protected void prepareObjectWebFor(Object object) {
        findRepeats();
    }

    protected void writeHeader() {}
*/

    public void scribeObjectWebFor(Object anObject) {
        // prepareObjectWeb();
        registerObject(anObject);

        //encodeHeaderRecipes();
        //scibeMainRecipe(object);

        scribeObject(anObject);

        //encodeFooterRecipes();
        //shutdown();
    }

    //**************************************
    //**************************************
    //**************************************

    public void registerObject(Object anObject) {
        if (anObject == null) return;
        int[] entry = (int[]) objectToCount.atKey(anObject);
        if (entry != null) {
            entry[0]=entry[0]++;
            return;
        }
        int[] newEntry = {1};
        objectToCount.atKey_put(anObject,newEntry);

        Pen pen = getPenFor(anObject);

        if (pen != null) {
            objectToPen.atKey_put(anObject,pen);
            pen.registerObject_for(anObject,this);
        }
    }


/*
    public void encodeHeaderRecipes() {
        List keys = objectToCount.keysList();
        int size = keys.size();
        for (int i=0; i<size; i++) {
            Object anObject = keys.atIndex(i);
            int[] entry = objectToCount.atKey(anObject);
            int count = entry[0];

            if (count > 1) {
                Pen pen = getPenFor(anObject);
                if (pen != null) {
                    pen.writeHeaderFor(anObject);
                    Pen bodyPen = pen.bodyPenFor(anObject);
                    if (bodyPen != null) {
                        //put in new pen
                    }
                }
            }


        }
    }
*/


    public void scribeObject(Object object) {
        Pen pen = getPenFor(object);
        if (pen != null) {
            pen.scribeObject_for_to(object,this,myEncoder());
//            Object[] writeEntry = objectToWrites.atKey
        }
    }

    protected abstract ObjectEncoder myEncoder();

    //**********************************************************
    //**********************************************************
    //**********************************************************

    protected Pen getPenFor(Object object) {
        if (object == null) return penForNull;

        Pen pen = (Pen) objectToPen.atKey(object);
        if (pen != null) return pen;

        Class objectClass = object.getClass();
        pen = (Pen) classToPen.atKey(objectClass);
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

    public void setPenForObject_to(Object anObject, Pen aPen) {
        objectToPen.atKey_put(anObject, aPen);
    }

    public void setPenForClass_to(Class aClass, Pen aPen) {
        classToPen.atKey_put(aClass, aPen);
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

        /** Registers a Pen for a specific object */
    protected Map objectToPen = CollectionsImplPack.newMap();
    protected Map classToPen = CollectionsImplPack.newMap();
    protected Map objectToCount = CollectionsImplPack.newMap();
    protected Pen penForNull = null;

}

