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
    public String getName();

    //**************************************
    //**************************************
    //**************************************

        /** The ClassInformation that is (by default) the implementation of this
         * type
         */
    public ClassInfo              defaultClassInfo();
    public List /*of ClassInfo*/  classInfos();

    public void setDefaultClassInfo(ClassInfo cic);
    public void attachClassInfo(ClassInfo cic);

    //**************************************
    //**************************************
    //**************************************

        /**
         * Is the object of this Type?
         */
    public boolean canApplyTo(Object anObject);


    //superTypes...
    //subTypes...
    //allSuperTypes...
    //allSubTypes...

    public List propertyNames();

    public Map /*of String->Property*/ propertiesFor(Object anObject);
    public Property propertyNamed_for(String name, Object anObject);
    public List /*of Property*/ propertyListFor(Object anObject);

    public List /*of Object*/ propertyValuesFor(List /*of Names*/);

    //**************************************
    //**************************************
    //**************************************
    //Factory/Pen Oriented

        //Defaults to all the properties
    public List /*of List of PropertyNames*/ recipes();
    public List /*of PropertyNames*/ bestRecipeFor(Object anObject);
    public List /*of PropertyNames*/ bestRecipe();

    //RecipeConstructor:
    //   RecipeName
    //   ingredientName->property | Function1Arg

    //FactoryInfo
    //    recipes()
    //    bestRecipeFor(...)
    //
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

