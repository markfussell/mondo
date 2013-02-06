/***********************************************************************
**
**  File: chimu/mondo/builder/ObjectBuilder.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.builder;

import COM.chimu.mondo.recipe.Recipe;

import COM.chimu.kernel.collections.Map;
import COM.chimu.kernel.collections.List;

/**
An ObjectBuilder creates DomainObjects from recipes.  This is one
of the core interfaces in MONDO and define the process of constructing
an ObjectBase from Recipes.

<P>The main responsibility of the ObjectBuilder
is implemented through the method #createObjectFromName_parameters.
The other methods either support this method or are shortcut convenience
methods that make life easier on the BuilderClient.

<P>Terms:
<PRE>
  create: Either build a new DomainObject or return an existing DomainObject.
          Note that this is different from 'new' in that all the objects
          are formally coming from the domain and are not "interface" objects
          like the ingredients map and the contents sequence.  All
          ingredients (e.g. to be put into a parameter map) should have come
          from a 'create'.
</PRE>

<P>Clients of the ObjectBuilder (BuilderClients) must use the following
protocol of interaction with the builder.
<PRE>
RECIPE:
   startRecipeContext(recipeName)
       ingredient = &lt;&lt;SUB_RECIPE>>
       parameters.atKey_put(parameterName, ingredient)
       ...
       ...
       ingredient = &lt;&lt;SUB_RECIPE>>
       parameters.atKey_put(parameterName, ingredient)
       ...
       ...
   finishRecipeContext()
   createObjectFromName_parameters(recipeName, parameters)
</PRE>
<P>The context notifications are to allow builders to take control
of how ingredients are built (e.g. a different sub-builder).  Most
builders will ignore the context information.  The simplified view is:
<PRE>
RECIPE:
     parameters = newParameterMap()
        add ingredient1 = &lt;&lt;SUB_RECIPE>>
        add ingredient2 = &lt;&lt;SUB_RECIPE>>
     result = createObjectFromName_parameters(recipeName, parameters)
</PRE>
<P>Starting and finishing contexts are not required if you pass in a fully
formed recipe object: the recipe building takes care of it internally.

@see COM.chimu.mondo.recipe.RecipePack;
**/
public interface ObjectBuilder  {

        /**
         * Create an object using the recipeName and the
         * parameters (ingredients).  This is the normal method
         * for the ObjectBuilder and identifies
         */
    public Object  createObjectFromName_parameters(String recipeName, Map parameters);

        /**
         * createObjectFromString is an expediency "primitive"
         * that avoids using a sequence of "letter" recipes to
         * build a string.
         */
    public Object  createObjectFromString(String value);

        /**
         * createObjectFromList is an expediency "primitive"
         * that avoids using Maps with numbered keys to
         * represent a list.
         */
    public Object  createObjectFromList(List values);

        /**
         * Create a List to put sequenctial items into.
         * This is for the createObjectFromList interface.
         */
    public List  newContentsList();

    //**************************************
    //**************************************
    //**************************************

        /**
         * Create an object from the recipe (which could have ingredient recipes
         * that need to be created first).  This is an auxiliary method because
         * it is rare that Recipes are instantiated.
         */
    public Object  createObjectFromRecipe(Recipe recipe);

    //**************************************
    //**************************************
    //**************************************

        /**
         * The context boundaries are provided to allow a
         * recipe to change the construction process for
         * their ingredients.  Only a few builders require
         * this.
         */
    public void startRecipeContext(String recipeName);
    public void finishRecipeContext();

        /**
         * Possible but not determined yet
         */
    public void startParameterContext(String parameterName);
    public void finishParameterContext();

    //**********************************************************
    //**********************************************************
    //**********************************************************

        /**
         * Create a Map to put recipe parameters into.
         */
    public Map       newParameterMap();

        /**
         * This returns an empty ParameterMap (when you have
         * no ingredients) that can be shared.
         * Thou shalt not modify this map.
         */
    public Object  emptyParameterMapObject();

        /**
         * This returns an object that indicates either: (1)
         * That a createObject resulted in no object being returned
         * (2) That a parameter/ingredient to a recipe do not exist.
         *
         * <P>The NO_VALUE object is used because 'null' could be a valid
         * value of a parameter or return value so we need a second
         * distinguished object to indicate the "NO_VALUE" state.
         * (Or alternatively, the builder would have to dual query the Map
         * and the client would have to deal with a more complicated
         * interface).
         *
         * <P>This is equivalent to a recipe of "!NO_VALUE"
         */
    public Object  noValueObject();

        /**
         * What is the name to give a defaulted parameter (one without a key)
         */
    public String  defaultParameterName();


    //**********************************************************
    //**********************************************************
    //**********************************************************
    /*
       The following are expediency functions which can make working with the
       builder a little easier.
    */



        /**
         * UNDECIDED:
         *
         * Create a Literal object.  Literals are strings that are
         * evaluated in the context of the Domain.  In a sense they
         * are (could be) arbitrary expressions but they are generally
         * just Numbers and Symbols (like 'null' or 'true').
         *
         * <P>The interface for Literal may change to
         * identify number values from other symbols.
         *
         * <P>This is equivalent to a recipe of "!Literal" with a
         * default parameter value (see defaultParameterName() )
         * of the string value.
         */
    public Object  createObjectFromLiteral(String value);


}

