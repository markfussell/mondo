
package COM.chimu.mondoL1.model.support;

import COM.chimu.mondoL1.model.*;
import COM.chimu.mondo.model.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

import java.lang.reflect.*;

public class ObjectBase1Class extends ObjectBaseAbsClass {
    public ClassInfo classInfoForClass(Class aClass) {
        ClassInfo ci = (ClassInfo) classToClassInfo.atKey(aClass);
        if (ci != null) return ci;

        //************************

        ci = getClassInfoFromFunctor(aClass);
        if (ci == null) ci = getClassInfoFromClassObject(aClass);
        if (ci == null) ci = getClassInfoFromClassInfoClass(aClass);
        if (ci == null) ci = getClassInfoFromClassInfoFile(aClass);
        if (ci == null) ci = getDefaultClassInfoFor(aClass);

        //************************

        if (ci != null) {
            classToClassInfo.atKey_put(aClass,ci);
            return ci;
        } else {
            return null;
        }
    }

    //**************************************
    //**************************************
    //**************************************

    protected ClassInfo getClassInfoFromFunctor(Class aClass) {
        Function0Arg cif = (Function0Arg) classToClassInfoFunctor.atKey(aClass);
        if (cif == null) return null;
        return (ClassInfo) cif.value();
    }

    protected ClassInfo getClassInfoFromClassObject(Class aClass) {
        try {
            Method newMethod = aClass.getMethod("newClassInfo",CLASS_INFO_CLASSES);
            if (newMethod == null) return null;
            Object[] args = {this};
            return (ClassInfo) newMethod.invoke(null,args);
        } catch (Exception e) {
            //System.err.println("Could not access 'newClassInfo' in: "+aClass);
            //e.printStackTrace();
        }
        return null;
    }

    static protected Class[] CLASS_INFO_CLASSES = {ObjectBase.class};



    protected ClassInfo getClassInfoFromClassInfoClass(Class aClass) {
        return null;
    }

    protected ClassInfo getClassInfoFromClassInfoFile(Class aClass) {
        return null;
    }

    protected ClassInfo getDefaultClassInfoFor(Class aClass) {
        PureBeanClassInfoClass cic = new PureBeanClassInfoClass(aClass);
        cic.setupObjectBase(this);
        return cic;
    }


    //Everything below this line is probably L2

    //**********************************************************
    //(P)******************** Asking ***************************
    //**********************************************************

    //public ObjectRetriever retrieverNamed(String name);

    //**********************************************************
    //(P)***************** Factory Methods *********************
    //**********************************************************

    //**************************************
    //(P)************ Queries **************
    //**************************************

    //public QueryDescription newQueryDescription();
    //public OqlQuery newOqlQuery(String oqlString);

    //**********************************************************
    //**********************************************************
    //**********************************************************

    Map classToClassInfo = CollectionsImplPack.newMap();
    Map classToClassInfoFunctor = CollectionsImplPack.newMap();

}

