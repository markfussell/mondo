
package COM.chimu.mondoL1.model.support;

import COM.chimu.mondoL1.model.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;
import COM.chimu.kernel.functors.*;

/**
An Extracter pulls out recipe information.
**/
public class ExtracterClass extends ExtracterAbsClass {
    public ExtracterClass() {}
    public ExtracterClass(String name, Map parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map /*of String->Function1Arg*/ parameters() {
        return parameters;
    }

    public void setParameters(Map parameters) {
        this.parameters = parameters;
    }

    protected Map parameters = EMPTY_PARAMETERS;
    protected String name = "";


    static protected Map EMPTY_PARAMETERS = CollectionsImplPack.newMap();
}
