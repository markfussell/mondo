
package COM.chimu.mondoL1.model;

import COM.chimu.mondo.model.*;

import COM.chimu.kernel.functors.*;
import COM.chimu.kernel.collections.*;


public interface ObjectBase {
    public ClassInfo classInfoForClass(Class aClass);

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

}

