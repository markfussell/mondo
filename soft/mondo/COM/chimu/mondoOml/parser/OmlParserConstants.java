/***********************************************************************
**
**  File: chimu/mondoOml/parser/OmlParserConstants.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;

public interface OmlParserConstants {

  int EOF = 0;
  int TAGO = 1;
  int TXTO = 7;
  int LSTO = 8;
  int SINGLE_LINE_COMMENT = 9;
  int SGML_COMMENT = 10;
  int SGML_COMMENT2 = 11;
  int MULTI_LINE_COMMENT = 12;
  int StringSQ = 13;
  int StringDQ = 14;
  int StringLQ = 15;
  int StringVLQ = 16;
  int TXTC = 17;
  int Chars = 18;
  int LSTC = 19;
  int TAGC = 20;
  int EQ = 21;
  int Letter = 22;
  int Digit = 23;
  int MiscName = 24;
  int NameChar = 25;
  int LetterName = 26;
  int Prefix = 27;
  int PrefixName = 28;
  int Name = 29;
  int DirectLiteral = 30;

  int ElementSect = 0;
  int ValueSect = 1;
  int ListSect = 2;
  int TextSect = 3;
  int DEFAULT = 4;

  String[] tokenImage = {
    "<EOF>",
    "\"<\"",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\f\"",
    "\"{\"",
    "\"(\"",
    "<SINGLE_LINE_COMMENT>",
    "<SGML_COMMENT>",
    "<SGML_COMMENT2>",
    "<MULTI_LINE_COMMENT>",
    "<StringSQ>",
    "<StringDQ>",
    "<StringLQ>",
    "<StringVLQ>",
    "\"}\"",
    "<Chars>",
    "\")\"",
    "\">\"",
    "\"=\"",
    "<Letter>",
    "<Digit>",
    "<MiscName>",
    "<NameChar>",
    "<LetterName>",
    "<Prefix>",
    "<PrefixName>",
    "<Name>",
    "<DirectLiteral>",
  };

}
