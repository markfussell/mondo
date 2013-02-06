
package COM.chimu.mondoL1.pen.primitives;
import COM.chimu.mondoL1.model.*;

import  COM.chimu.mondo.pen.*;
import  COM.chimu.mondo.scribe.*;
import  COM.chimu.mondo.encoder.*;

import java.util.*;
import java.text.*;

public class DictionaryPenC extends PenAbsClass {
    public DictionaryPenC() {}

    public void scribeObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder) {
        Dictionary aDict = (Dictionary) anObject;
        Enumeration enum = aDict.keys();

        String name = scribe.getRecipeNameFor("Map");

        encoder.startObject(name);
            encoder.startDefaultParameter();
                encoder.startList();
                while (enum.hasMoreElements()) {
                    Object key = enum.nextElement();
                    encoder.startListElement();
                        //Or create a pair and scribeObject
                    encoder.startObject("Pair");
                        encoder.startValuedParameter("key");
                        scribe.scribeObject(key);
                        encoder.finishValuedParameter();

                        encoder.startValuedParameter("value");
                        scribe.scribeObject(aDict.get(key));
                        encoder.finishValuedParameter();
                    encoder.finishObject();
                    encoder.finishListElement();
                };
                encoder.finishList();
            encoder.finishValuedParameter();
        encoder.finishObject();
    }

    public void registerObject_for(Object anObject, ScribeSi scribe) {
        Dictionary aDict = (Dictionary) anObject;
        Enumeration enum = aDict.keys();

        while (enum.hasMoreElements()) {
            Object key = enum.nextElement();
            scribe.registerObject(key);
            scribe.registerObject(aDict.get(key));
        };
    }


}

