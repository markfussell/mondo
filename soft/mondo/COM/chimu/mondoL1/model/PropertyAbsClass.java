package COM.chimu.mondoL1.model;


/**
This provides an abstract root implementation
**/
public abstract class PropertyAbsClass
                                implements Property {

    public Object   valueWith(Object anObject) {
        return valueFor(anObject);
    }

        //Procedure2Arg support
    public void   executeWith_with(Object anObject, Object value) {
        setValueFor_to(anObject,value);
    }

}

