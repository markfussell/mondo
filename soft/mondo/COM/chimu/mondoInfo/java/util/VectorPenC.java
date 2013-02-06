
package COM.chimu.mondoInfo.java.util;

import  COM.chimu.mondo.scribe.*;
import  COM.chimu.mondo.pen.*;
import  COM.chimu.mondo.encoder.*;

import java.util.*;
import java.text.*;

public class VectorPenC extends PenAbsClass {
    public VectorPenC() {}

    public void scribeObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder) {
        Vector aVector = (Vector) anObject;
        Enumeration enum = aVector.elements();

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
        Vector aVector = (Vector) anObject;
        Enumeration enum = aVector.elements();

        while (enum.hasMoreElements()) {
            scribe.registerObject(enum.nextElement());
        };
    }

}

