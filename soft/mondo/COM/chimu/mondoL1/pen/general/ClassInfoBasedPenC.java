
package COM.chimu.mondoL1.pen.general;
import COM.chimu.mondoL1.model.*;

import COM.chimu.mondo.pen.*;
import COM.chimu.mondo.scribe.*;
import COM.chimu.mondo.encoder.*;

import  COM.chimu.kernel.collections.*;
import  COM.chimu.kernel.functors.*;

public class ClassInfoBasedPenC extends PenAbsClass {
    public ClassInfoBasedPenC() {}
    public ClassInfoBasedPenC(ClassInfo classInfo) {
        this.classScribeInfo = classInfo.scribingInfo();
    }

    public void setupClassInfo(ClassInfo classInfo) {
        this.classScribeInfo = classInfo.scribingInfo();
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    public void scribeObject_for_to(Object anObject, ScribeSi scribe, ObjectEncoder encoder) {
        Extracter extracter = classScribeInfo.defaultExtracterFor(anObject);
        if (extracter == null) {
            System.err.println("No extracter for "+anObject+" within "+classScribeInfo);
            return;
        };
        extract_with_for_to(anObject,extracter,scribe, encoder);
    }

    protected void extract_with_for_to(
                Object anObject,
                Extracter extracter,
                ScribeSi scribe,
                ObjectEncoder encoder
            ) {
        String name = scribe.getRecipeNameFor(extracter.name());

        encoder.startObject(name);

        Map parameters = extracter.parameters();
        List parameterNames = extracter.parameterNames();

        int size = parameterNames.size();
        for (int i=0; i<size; i++) {
            String parameterName = (String) parameterNames.atIndex(i);
            Function1Arg parameter = (Function1Arg) parameters.atKey(
                    parameterName
                );
            Object parameterValue = parameter.valueWith(anObject);
            if (parameterValue != scribe.noValueObject()) {
                encoder.startValuedParameter(parameterName);
                scribe.scribeObject(parameterValue);
                encoder.finishValuedParameter();
            }
        }
        encoder.finishObject();
    }


    public void registerObject_for(Object anObject, ScribeSi scribe) {
        Extracter extracter = classScribeInfo.defaultExtracterFor(anObject);
        if (extracter == null) return;

        Map parameters = extracter.parameters();
        List parameterNames = extracter.parameterNames();
        int size = parameterNames.size();
        for (int i=0; i<size; i++) {
            String parameterName = (String) parameterNames.atIndex(i);
            Function1Arg parameter = (Function1Arg) parameters.atKey(
                    parameterName
                );
            Object parameterValue = parameter.valueWith(anObject);
            if (parameterValue != scribe.noValueObject()) {
                scribe.registerObject(parameterValue);
            }
        }
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

    ClassScribingInfo classScribeInfo = null;

}

