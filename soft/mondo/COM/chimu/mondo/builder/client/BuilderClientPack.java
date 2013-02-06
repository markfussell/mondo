/***********************************************************************
**
**  File: chimu/mondo/builder/client/BuilderClientPack.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder.client;

/**
BuilderClientPack contains a couple useful interfaces for writing
clients to an ObjectBuilder.

<P>Although an ObjectBuilder has one
primary method, clients will tend to alternate between two states:
building up an IngredientsMap and calling the ObjectBuilder with
the recipe (name) and the ingredients for that recipe.  The possible
structure for this hierarchical alternating is reflected in the
RecipeObjectBuilder and RecipeParameterBuilder interfaces.

<P>NOTE: If these do not seem generally useful I should move them
into the OML client.
**/
public class BuilderClientPack {

    //**********************************************************
    //(P)***************** Factory Methods *********************
    //**********************************************************

    //**********************************************************
    //**********************************************************
    //**********************************************************

    private BuilderClientPack() {}


}

