
package COM.chimu.mondoL1.model;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.functors.*;

/**
An Extracter pulls out recipe information.
**/
public interface Extracter {
    public String name();
    public Map /*of String->Function1Arg*/ parameters();

    public List /*of Function1Arg*/ parameterFunctors();
    public Function1Arg parameterFunctorNamed(String name);
    public List /*of String*/ parameterNames();
}
