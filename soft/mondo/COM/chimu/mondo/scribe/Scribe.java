/***********************************************************************
**
**  File: chimu/mondo/scribe/Scribe.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.scribe;

/**
A Scribe is an object that can take a web of objects and
write them to and encoding stream (see the mondo.encoding).
In that regard Scribes are just a special way to interact
with the domain model.

**/
public interface Scribe {
    public void scribeObjectWebFor(Object anObject);
}

