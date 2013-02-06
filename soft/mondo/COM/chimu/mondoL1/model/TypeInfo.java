/***********************************************************************
**
**  File: chimu/mondoL1/model/TypeInfo.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoL1.model;


public interface TypeInfo {
    public String name();
}


/*
<Type
    name="Date"
    properties=(
        <Property name="iso" type=<Stub to="Type" name="String"> >
    recipes=(
        ()
        ("iso")
        <RecipeInfo requires=("month" "year") optional=("day")>
    )
>
*/

