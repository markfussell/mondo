
package COM.chimu.mondoL1.model;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.functors.*;

/**
An Extracter pulls out recipe information.
**/
public abstract class ExtracterAbsClass implements Extracter {

    public List /*of Function1Arg*/ parameterFunctors() {
        return (List) parameters().values();
    }

    public Function1Arg parameterFunctorNamed(String name) {
        return (Function1Arg) parameters().atKey(name);
    }
    public List /*of String*/ parameterNames() {
        return parameters().keysList();
    }
}
