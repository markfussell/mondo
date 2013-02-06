
package COM.chimu.mondoInfo.COM.chimu.kernel.collections;

import  COM.chimu.mondo.scribe.*;
import  COM.chimu.mondo.pen.*;
import  COM.chimu.mondo.encoder.*;

import java.util.*;
import java.text.*;
import COM.chimu.kernel.collections.*;

public class CollectionPenC extends PenAbsClass {
    public CollectionPenC() {}

    public void scribeObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder) {
        Collection aCollection = (Collection) anObject;
        Enumeration enum = aCollection.elements();

        String name = scribe.getRecipeNameFor("List");
            //Should determine whether it is a Set or something
            //other than a pure List

        encoder.startObject(name);
            encoder.startDefaultParameter();
            encoder.startList();
                while (enum.hasMoreElements()) {
                    encoder.startListElement();
                    scribe.scribeObject(enum.nextElement());
                    encoder.finishListElement();
                };
            encoder.finishList();
            encoder.finishValuedParameter();
        encoder.finishObject();
    }

    public void registerObject_for(Object anObject, ScribeSi scribe) {
        Collection aCollection = (Collection) anObject;
        Enumeration enum = aCollection.elements();

        while (enum.hasMoreElements()) {
            scribe.registerObject(enum.nextElement());
        };
    }

}

