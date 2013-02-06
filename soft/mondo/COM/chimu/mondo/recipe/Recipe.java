/***********************************************************************
**
**  File: chimu/mondo/recipe/Recipe.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.recipe;

import COM.chimu.kernel.collections.Map;

/**
A Recipe is a description of how to build an object.  Recipes are
extremely simple: they have a name and they have a Map which is
keyed with the ingredient names needed for the recipe.  The value
associated with each ingredient name is yet another recipe.
Although recipes can have an arbitrarily complex hierarchy (as the
nodes of a tree), the only thing in them other than recipes
are Strings; all the leaf nodes will only have a name.

<P>To
build an object from a recipe you first build all the ingredients
(turning them into objects) and then you build the actual recipe
itself using those ingredients.  The name of the recipe identifies
what you want to build (or what instruction to carry out).  The
result is an Object plus whatever side-effects occur within the
ObjectBuilder and the DomainModel[1].

<P>Recipe is a core concept to MONDO but recipes are usually
implied through a communication channel/interface (see ObjectBuilder)
instead of actually being instantiated.


<P>[1] This may sound very similar to functional programming,
and ultimately it is identical.  The evaluation of a recipe is
just very-slightly different from a LISP list evaluation: instead
of evaluating a List (or index keyed Map) with a distinguished
first element, we evaluate a Map with a distinguished key name.


**/
public interface Recipe {
    public String name();
    public Map /*of String(IngredientName)->Recipe*/ subRecipes();
}

