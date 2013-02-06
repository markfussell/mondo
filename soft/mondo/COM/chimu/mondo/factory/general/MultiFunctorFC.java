/***********************************************************************
**
**  File: chimu/mondo/factory/general/MultiFunctorFC.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondo.factory.general;

import COM.chimu.mondo.factory.*;
import COM.chimu.mondo.builder.*;

import COM.chimu.kernel.collections.*;
import COM.chimu.kernel.collections.impl.CollectionsImplPack;
import COM.chimu.kernel.functors.*;


public class MultiFunctorFC extends FactoryAbsClass implements MultiFunctorF {
    public MultiFunctorFC() {}
    public MultiFunctorFC(String name, ObjectBuilder builder) {
        this.name = name;
    }

    public void addFunctor_withArguments(Function1Arg constructor, String[] argNames) {
        String signature = buildNameSignatureFrom(argNames);
        Object[] entry = {constructor, argNames};
        signatureToConstructor.atKey_put(signature, entry);
    }

    protected Object[] newParameterArrayFor_from(String[] argNames, Map map) {
        int size = argNames.length;
        Object[] result = new Object[size];
        for (int i=0; i<size; i++) {
            result[i]=map.atKey(argNames[i]);
        }
        return result;
    }

    protected String buildNameSignatureFrom(String[] argNames) {
        StringBuffer stringB = new StringBuffer();
        int size = argNames.length;
        for (int i=0; i<size; i++) {
            stringB.append(argNames[i]+"|");
        }
        return stringB.toString();
    }

    protected String buildNameSignatureFromList(List argNames) {
        StringBuffer stringB = new StringBuffer();
        int size = argNames.size();
        for (int i=0; i<size; i++) {
            stringB.append(((String) argNames.atIndex(i))+"|");
        }
        return stringB.toString();
    }

    protected Object[] /*[Function1Arg,String[]]*/ findMatchFor(List keysList) {
        String signature = buildNameSignatureFromList(keysList);
        Object[] entry = (Object[]) signatureToConstructor.atKey(signature);
        if (entry != null) return entry;

        if (keysList.size() == 2) {
            String[] reversedList = {(String) keysList.atIndex(1), (String) keysList.atIndex(0)};
            signature = buildNameSignatureFrom(reversedList);
            entry = (Object[]) signatureToConstructor.atKey(signature);
            if (entry != null) return entry;
        }



        //Else we have the harder task of deciding
System.err.println("Could not find: "+keysList);
        return null;
    }

    public Object createObjectFromName_parameters_for(String recipeName, Map map, ObjectBuilder builder) {
        Object[] match = findMatchFor(map.keysList());

        Function1Arg constructor = (Function1Arg) match[0];
        Object[] parameterArray = newParameterArrayFor_from((String[]) match[1],map);
        return constructor.valueWith(parameterArray);
    }

    public String toString() {
        return name;
    }

    //**********************************************************
    //**********************************************************
    //**********************************************************

//Maximum match length
//Ordered preference?
//Cache keys->functor

    //**********************************************************
    //**********************************************************
    //**********************************************************

    String name = "FunctorFactory";
    Function1Arg constructor = null;
    String[] argNames = null;

    Map /*String->Object[] (Function1Arg, String[])*/
        signatureToConstructor = CollectionsImplPack.newMap();
}
