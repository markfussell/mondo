/***********************************************************************
**
**  File: chimu/mondo/model/StringValue.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.model;

import COM.chimu.kernel.collections.*;

/**
StringValue defines the ability of any object to be turned into a
model-significant String.

<P>StringValue is a required artifact in programming environments where
extending the functionality of a String itself is impossible.  This
is the case in Java.  StringValue may also be useful in the contexts
where a String could be extended with new functionality but it is not
desired.

**/
public interface StringValue {
    public String stringValue();
}

