/* JJT: 0.2.2 */
/***********************************************************************
**
**  File: chimu/mondoOml/parser/CreationNodeAbsClass.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;
import COM.chimu.mondo.builder.*;
import COM.chimu.mondo.builder.client.*;



import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;

public abstract class CreationNodeAbsClass
                        extends SimpleNode
                        implements RecipeObjectBuilder
                        {
    CreationNodeAbsClass(String id) {
        super(id);
    }

    public void appendToList_for(List list, ObjectBuilder builder) {
        Object newObject = buildObjectFor(builder);
        if (newObject != builder.noValueObject()) {
            if (newObject instanceof Collection) {
                list.addAll((Collection) newObject);
            } else {
                list.add(newObject);
            }
        }
    }


}
