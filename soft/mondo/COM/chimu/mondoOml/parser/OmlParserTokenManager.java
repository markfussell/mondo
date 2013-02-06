/***********************************************************************
**
**  File: chimu/mondoOml/parser/OmlParserTokenManager.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;
import java.util.Stack;

public class OmlParserTokenManager implements OmlParserConstants
{
  protected static final String jjadd_escapes(String str) {
    String retval = "";
    char ch;
    for (int i = 0; i < str.length(); i++) {
      if ((ch = str.charAt(i)) == 0) continue;
      if (ch == '\b') {
        retval += "\\b";
      } else if (ch == '\t') {
        retval += "\\t";
      } else if (ch == '\n') {
        retval += "\\n";
      } else if (ch == '\f') {
        retval += "\\f";
      } else if (ch == '\r') {
        retval += "\\r";
      } else if (ch == '\"') {
        retval += "\\\"";
      } else if (ch == '\'') {
        retval += "\\\'";
      } else if (ch == '\\') {
        retval += "\\\\";
      } else if (ch < 0x20 || ch > 0x7e) {
        String s = "0000" + Integer.toString(ch, 16);
        retval += "\\u" + s.substring(s.length() - 4, s.length());
      } else {
        retval += ch;
      }
    }
    return retval;
  }

private final void jjMoveStringLiteralDfa0_4() throws java.io.IOException
{
   curPos = 1;
}
static final long[] jjbitVec0 = { 0xfffffffffffffffeL, 0xffffffffffffffffL,
              0xffffffffffffffffL, 0xffffffffffffffffL };
static final long[] jjbitVec2 = { 0x1L, 0x0L,
              0xffffffffffffffffL, 0xffffffffffffffffL };
private final void jjMoveNfa_1(int[] oldStates, int[] newStates)
{
   int j, k;
   MainLoop :
   for (;;)
   {
      if (curChar < 64)
      {
         int i = jjnewStateCnt;
         jjnewStateCnt = 0;
         jjround++;
         long l = 1L << curChar;
         do
         {
            switch(oldStates[--i])
            {
               case 40:
                  if ((0x800000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates25;
                     break;
                  }
                  else continue;
               case 41:
                  if ((0xffffffffffffdbffL & l) != 0L)
                  {
                     jjnextStates = jjstates25;
                     break;
                  }
                  else continue;
               case 42:
                  if ((0x2400L & l) != 0L)
                  {
                     if (jjcurKind > 9)
                        jjcurKind = 9;
                     continue;
                  }
                  else continue;
               case 44:
                  if ((0x2000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 43;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 43:
                  if ((0x400L & l) != 0L)
                  {
                     if (jjcurKind > 9)
                        jjcurKind = 9;
                     continue;
                  }
                  else continue;
               case 5:
                  if ((0x200000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 0;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 0:
                  if ((0x200000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates2;
                     break;
                  }
                  else continue;
               case 1:
                  if ((0xffffdfffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates2;
                     break;
                  }
                  else continue;
               case 2:
                  if ((0x200000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates1;
                     break;
                  }
                  else continue;
               case 3:
                  if ((0xffffdfffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates0;
                     break;
                  }
                  else continue;
               case 12:
                  if ((0x200000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 11;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 11:
                  if ((0x200000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 6;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 6:
                  if ((0x200000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates6;
                     break;
                  }
                  else continue;
               case 7:
                  if ((0xffffdfffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates6;
                     break;
                  }
                  else continue;
               case 8:
                  if ((0x200000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates5;
                     break;
                  }
                  else continue;
               case 9:
                  if ((0xffffdfffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates4;
                     break;
                  }
                  else continue;
               case 45:
                  if ((0x40000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates28;
                     break;
                  }
                  else continue;
               case 46:
                  if ((0xfffffbffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates28;
                     break;
                  }
                  else continue;
               case 47:
                  if ((0x40000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates27;
                     break;
                  }
                  else continue;
               case 48:
                  if ((0xffff7bffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates26;
                     break;
                  }
                  else continue;
               case 49:
                  if ((0xfffffbffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates26;
                     break;
                  }
                  else continue;
               case 50:
                  if ((0x800000000000L & l) != 0L)
                  {
                     if (jjcurKind > 12)
                        jjcurKind = 12;
                     continue;
                  }
                  else continue;
               case 13:
                  if ((0x8000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 14:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 16:
                  if ((0x8400000000L & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 18:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates10;
                     break;
                  }
                  else continue;
               case 19:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 20:
                  if ((0xf000000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 21;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 21:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates11;
                     break;
                  }
                  else continue;
               case 17:
                  if ((0x8000000000L & l) != 0L)
                  {
                     if (jjcurKind > 13)
                        jjcurKind = 13;
                     continue;
                  }
                  else continue;
               case 22:
                  if ((0x400000000L & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 23:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 25:
                  if ((0x8400000000L & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 27:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates15;
                     break;
                  }
                  else continue;
               case 28:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 29:
                  if ((0xf000000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 30;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 30:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates16;
                     break;
                  }
                  else continue;
               case 26:
                  if ((0x400000000L & l) != 0L)
                  {
                     if (jjcurKind > 14)
                        jjcurKind = 14;
                     continue;
                  }
                  else continue;
               case 53:
                     newStates[jjnewStateCnt + 0] = 53;
                     newStates[jjnewStateCnt + 1] = 54;
                     jjnewStateCnt += 2;
                     continue;
               case 57:
                     jjnextStates = jjstates32;
                     break;
               case 59:
                     jjnextStates = jjstates32;
                     break;
               case 61:
                     jjnextStates = jjstates32;
                     break;
               case 63:
                     jjnextStates = jjstates32;
                     break;
               case 66:
                     jjnextStates = jjstates32;
                     break;
               case 31:
                  if ((0x8fff7c7affffd9ffL & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 32:
                  if ((0x8fff7c7affffd9ffL & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 34:
                  if ((0x8400000000L & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 35:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates20;
                     break;
                  }
                  else continue;
               case 36:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 37:
                  if ((0xf000000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 38;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 38:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates21;
                     break;
                  }
                  else continue;
               case 10:
                  if ((0x200000000000L & l) != 0L)
                  {
                     if (jjcurKind > 11)
                        jjcurKind = 11;
                     jjnextStates = jjstates5;
                     break;
                  }
                  else continue;
               case 4:
                  if ((0x200000000000L & l) != 0L)
                  {
                     if (jjcurKind > 10)
                        jjcurKind = 10;
                     jjnextStates = jjstates1;
                     break;
                  }
                  else continue;
               case 39:
                  if ((0x800000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 40;
                     newStates[jjnewStateCnt + 1] = 45;
                     jjnewStateCnt += 2;
                     continue;
                  }
                  else continue;
               default : continue;
            }
            j = jjnextStates.length;
            do
            {
               if (jjrounds[k = jjnextStates[--j]] != jjround)
               {
                  jjrounds[k] = jjround;
                  newStates[jjnewStateCnt++] = k;
               }
            } while (j != 0);
         } while(i != 0);
      }
      else if (curChar < 128)
      {
         int i = jjnewStateCnt;
         jjnewStateCnt = 0;
         jjround++;
         long l = 1L << (curChar & 077);
         do
         {
            switch(oldStates[--i])
            {
               case 41:
                     newStates[jjnewStateCnt + 0] = 41;
                     newStates[jjnewStateCnt + 1] = 42;
                     newStates[jjnewStateCnt + 2] = 44;
                     jjnewStateCnt += 3;
                     continue;
               case 1:
                     jjnextStates = jjstates2;
                     break;
               case 3:
                     jjnextStates = jjstates0;
                     break;
               case 7:
                     jjnextStates = jjstates6;
                     break;
               case 9:
                     jjnextStates = jjstates4;
                     break;
               case 46:
                     jjnextStates = jjstates28;
                     break;
               case 48:
                     jjnextStates = jjstates26;
                     break;
               case 49:
                     jjnextStates = jjstates26;
                     break;
               case 14:
                  if ((0xffffffffefffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 15:
                  if ((0x10000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 16;
                     newStates[jjnewStateCnt + 1] = 18;
                     newStates[jjnewStateCnt + 2] = 20;
                     jjnewStateCnt += 3;
                     continue;
                  }
                  else continue;
               case 16:
                  if ((0x14404410000000L & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 23:
                  if ((0xffffffffefffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 24:
                  if ((0x10000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 25;
                     newStates[jjnewStateCnt + 1] = 27;
                     newStates[jjnewStateCnt + 2] = 29;
                     jjnewStateCnt += 3;
                     continue;
                  }
                  else continue;
               case 25:
                  if ((0x14404410000000L & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 52:
                  if ((0x8000000L & l) != 0L)
                  {
                     jjnextStates = jjstates31;
                     break;
                  }
                  else continue;
               case 53:
                  if ((0xffffffffdfffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates31;
                     break;
                  }
                  else continue;
               case 55:
                  if ((0x20000000L & l) != 0L)
                  {
                     if (jjcurKind > 15)
                        jjcurKind = 15;
                     continue;
                  }
                  else continue;
               case 83:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 82;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 82:
                  if ((0x10L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 81;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 81:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 80;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 80:
                  if ((0x100000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 79;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 79:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 56;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 56:
                  if ((0x8000000L & l) != 0L)
                  {
                     jjnextStates = jjstates32;
                     break;
                  }
                  else continue;
               case 57:
                  if ((0xffffffffdfffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates32;
                     break;
                  }
                  else continue;
               case 59:
                  if ((0xfffffffffffffff7L & l) != 0L)
                  {
                     jjnextStates = jjstates32;
                     break;
                  }
                  else continue;
               case 60:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 61;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 61:
                  if ((0xffffffffffffffefL & l) != 0L)
                  {
                     jjnextStates = jjstates32;
                     break;
                  }
                  else continue;
               case 64:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 62;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 62:
                  if ((0x10L & l) != 0L)
                  {
                     jjnextStates = jjstates34;
                     break;
                  }
                  else continue;
               case 63:
                  if ((0xfffffffffffffffdL & l) != 0L)
                  {
                     jjnextStates = jjstates32;
                     break;
                  }
                  else continue;
               case 68:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 67;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 67:
                  if ((0x10L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 65;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 65:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 66;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 66:
                  if ((0xffffffffffefffffL & l) != 0L)
                  {
                     jjnextStates = jjstates32;
                     break;
                  }
                  else continue;
               case 72:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 71;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 71:
                  if ((0x10L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 70;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 70:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 69;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 69:
                  if ((0x100000L & l) != 0L)
                  {
                     jjnextStates = jjstates34;
                     break;
                  }
                  else continue;
               case 78:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 77;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 77:
                  if ((0x10L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 76;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 76:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 75;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 75:
                  if ((0x100000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 73;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 73:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 74;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 74:
                  if ((0x20000000L & l) != 0L)
                  {
                     if (jjcurKind > 16)
                        jjcurKind = 16;
                     continue;
                  }
                  else continue;
               case 31:
                  if ((0xd7ffffffffffffffL & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 32:
                  if ((0xd7ffffffefffffffL & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 33:
                  if ((0x10000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 34;
                     newStates[jjnewStateCnt + 1] = 35;
                     newStates[jjnewStateCnt + 2] = 37;
                     jjnewStateCnt += 3;
                     continue;
                  }
                  else continue;
               case 34:
                  if ((0x14404410000000L & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 58:
                  if ((0x20000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 59;
                     newStates[jjnewStateCnt + 1] = 60;
                     newStates[jjnewStateCnt + 2] = 64;
                     newStates[jjnewStateCnt + 3] = 68;
                     newStates[jjnewStateCnt + 4] = 72;
                     newStates[jjnewStateCnt + 5] = 78;
                     jjnewStateCnt += 6;
                     continue;
                  }
                  else continue;
               case 54:
                  if ((0x20000000L & l) != 0L)
                  {
                     jjnextStates = jjstates30;
                     break;
                  }
                  else continue;
               case 51:
                  if ((0x8000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 52;
                     newStates[jjnewStateCnt + 1] = 83;
                     jjnewStateCnt += 2;
                     continue;
                  }
                  else continue;
               default : continue;
            }
            j = jjnextStates.length;
            do
            {
               if (jjrounds[k = jjnextStates[--j]] != jjround)
               {
                  jjrounds[k] = jjround;
                  newStates[jjnewStateCnt++] = k;
               }
            } while (j != 0);
         } while(i != 0);
      }
      else
      {
         int i = jjnewStateCnt;
         jjnewStateCnt = 0;
         jjround++;
         int i2 = (curChar & 0xff) >> 6;
         int i1 = ((curChar >> 8) & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         long l1 = 1L << ((curChar >> 8) & 077);
         Outer:
         do
         {
            switch(oldStates[--i])
            {
               case 41:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     newStates[jjnewStateCnt + 0] = 41;
                     newStates[jjnewStateCnt + 1] = 42;
                     newStates[jjnewStateCnt + 2] = 44;
                     jjnewStateCnt += 3;
                     continue;
               case 1:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates2;
                     break;
               case 3:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates0;
                     break;
               case 7:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates6;
                     break;
               case 9:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates4;
                     break;
               case 46:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates28;
                     break;
               case 48:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates26;
                     break;
               case 49:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates26;
                     break;
               case 14:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     newStates[jjnewStateCnt + 0] = 14;
                     newStates[jjnewStateCnt + 1] = 15;
                     newStates[jjnewStateCnt + 2] = 17;
                     jjnewStateCnt += 3;
                     continue;
               case 23:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     newStates[jjnewStateCnt + 0] = 23;
                     newStates[jjnewStateCnt + 1] = 24;
                     newStates[jjnewStateCnt + 2] = 26;
                     jjnewStateCnt += 3;
                     continue;
               case 53:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     newStates[jjnewStateCnt + 0] = 53;
                     newStates[jjnewStateCnt + 1] = 54;
                     jjnewStateCnt += 2;
                     continue;
               case 57:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates32;
                     break;
               case 59:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates32;
                     break;
               case 61:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates32;
                     break;
               case 63:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates32;
                     break;
               case 66:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates32;
                     break;
               case 31:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                  if (jjcurKind > 30)
                     jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
               case 32:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                  if (jjcurKind > 30)
                     jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
               default : continue;
            }
            j = jjnextStates.length;
            do
            {
               if (jjrounds[k = jjnextStates[--j]] != jjround)
               {
                  jjrounds[k] = jjround;
                  newStates[jjnewStateCnt++] = k;
               }
            } while (j != 0);
         } while(i != 0);
      }
      return;
   }
}
int[] StopStringLiteralDfa_1(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x40L) != 0L)
            return jjstates19;
         return null;
      default : 
         return null;
   }
}
void jjStartNfa_1(int pos, long active0)
{
   if ((jjstartStateSet = StopStringLiteralDfa_1(pos, active0)) != null)
   {
      jjnewStateCnt = jjstartStateSet.length;
      jjMoveNfa_1(jjstartStateSet, jjstateSet2);
      if (jjcurKind != 2147483647)
      {
         matchedToken.kind = jjcurKind;
         jjmatchedPos = pos + 1;
         jjcurKind = 2147483647;
      }
   }
   return;
}
long jjnewActive_10 = 0L, jjoldActive_10 = 0L;
private final void jjMoveStringLiteralDfa0_1() throws java.io.IOException
{
   ReturnLoop:
   for (;;)
   {
    MainLoop:
    for (;;)
    {
         switch(curChar)
         {
            case 60: 
               matchedToken.kind = 1;
               break ReturnLoop;
            case 40: 
               matchedToken.kind = 8;
               break ReturnLoop;
            case 32: 
               matchedToken.kind = 2;
               break ReturnLoop;
            case 123: 
               matchedToken.kind = 7;
               break ReturnLoop;
            case 13: 
               matchedToken.kind = 5;
               break ReturnLoop;
            case 12: 
               matchedToken.kind = 6;
               jjstartStateSet = jjstates19;
               break MainLoop;
            case 10: 
               matchedToken.kind = 4;
               break ReturnLoop;
            case 9: 
               matchedToken.kind = 3;
               break ReturnLoop;
            default : 
               curPos =  1;
               if (curChar < 128)
                  if ((jjstartStateSet = jjinitStates_1[curChar]) == null)
                     return;
               else 
                  jjstartStateSet = jjallInitStates_1;
               jjnewStateCnt = jjstartStateSet.length;
               jjMoveNfa_1(jjstartStateSet, jjstateSet2);
               if (jjcurKind != 2147483647)
               {
                  matchedToken.kind = jjcurKind;
                  jjcurKind = 2147483647;
               }
               return;
         }
    }
    curPos = 1;
    curChar = input_stream.readChar();
    jjnewStateCnt = jjstartStateSet.length;
    jjMoveNfa_1(jjstartStateSet, jjstateSet2);
    if (jjcurKind != 2147483647)
    {
       matchedToken.kind = jjcurKind;
       jjmatchedPos = 1;
       jjcurKind = 2147483647;
    }
    curPos = 2;
    return;
   }
   curPos = 1;
   return;
}
static final int[] jjstates0 = { 3, 2, };
static final int[] jjstates1 = { 3, 4, };
static final int[] jjstates2 = { 1, 2, };
static final int[] jjstates3 = { 0, };
static final int[] jjstates4 = { 9, 8, };
static final int[] jjstates5 = { 9, 10, };
static final int[] jjstates6 = { 7, 8, };
static final int[] jjstates7 = { 6, };
static final int[] jjstates8 = { 11, };
static final int[] jjstates9 = { 14, 15, 17, };
static final int[] jjstates10 = { 14, 15, 19, 17, };
static final int[] jjstates11 = { 19, };
static final int[] jjstates12 = { 21, };
static final int[] jjstates13 = { 16, 18, 20, };
static final int[] jjstates14 = { 23, 24, 26, };
static final int[] jjstates15 = { 23, 24, 28, 26, };
static final int[] jjstates16 = { 28, };
static final int[] jjstates17 = { 30, };
static final int[] jjstates18 = { 25, 27, 29, };
static final int[] jjstates19 = { 32, 33, };
static final int[] jjstates20 = { 32, 33, 36, };
static final int[] jjstates21 = { 36, };
static final int[] jjstates22 = { 38, };
static final int[] jjstates23 = { 34, 35, 37, };
static final int[] jjstates24 = { 43, };
static final int[] jjstates25 = { 41, 42, 44, };
static final int[] jjstates26 = { 49, 47, };
static final int[] jjstates27 = { 47, 48, 50, };
static final int[] jjstates28 = { 46, 47, };
static final int[] jjstates29 = { 40, 45, };
static final int[] jjstates30 = { 53, 55, };
static final int[] jjstates31 = { 53, 54, };
static final int[] jjstates32 = { 57, 58, };
static final int[] jjstates33 = { 61, };
static final int[] jjstates34 = { 63, };
static final int[] jjstates35 = { 62, };
static final int[] jjstates36 = { 66, };
static final int[] jjstates37 = { 65, };
static final int[] jjstates38 = { 67, };
static final int[] jjstates39 = { 69, };
static final int[] jjstates40 = { 70, };
static final int[] jjstates41 = { 71, };
static final int[] jjstates42 = { 74, };
static final int[] jjstates43 = { 73, };
static final int[] jjstates44 = { 75, };
static final int[] jjstates45 = { 76, };
static final int[] jjstates46 = { 77, };
static final int[] jjstates47 = { 59, 60, 64, 68, 72, 78, };
static final int[] jjstates48 = { 56, };
static final int[] jjstates49 = { 79, };
static final int[] jjstates50 = { 80, };
static final int[] jjstates51 = { 81, };
static final int[] jjstates52 = { 82, };
static final int[] jjstates53 = { 52, 83, };
static final int[] jjallInitStates_1 = { 5, 12, 13, 22, 31, 39, 51, };
static final int[] jjstates54 = { 31, };
static final int[] jjstates55 = { 12, 31, };
static final int[] jjstates56 = { 22, };
static final int[] jjstates57 = { 13, };
static final int[] jjstates58 = { 5, 31, };
static final int[] jjstates59 = { 39, };
static final int[] jjstates60 = { 31, 51, };
static final int[][] jjinitStates_1 = {
jjallInitStates_1, jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, null, null, 
jjstates54, jjstates54, null, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, null, jjstates55, jjstates56, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates57, null, 
null, jjstates54, jjstates54, jjstates54, jjstates58, 
jjstates54, jjstates59, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, null, 
null, null, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates60, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, null, jjstates54, null, 
jjstates54, jjstates54, };

private final void jjMoveNfa_0(int[] oldStates, int[] newStates)
{
   int j, k;
   MainLoop :
   for (;;)
   {
      if (curChar < 64)
      {
         int i = jjnewStateCnt;
         jjnewStateCnt = 0;
         jjround++;
         long l = 1L << curChar;
         do
         {
            switch(oldStates[--i])
            {
               case 45:
                  if ((0x800000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates69;
                     break;
                  }
                  else continue;
               case 46:
                  if ((0xffffffffffffdbffL & l) != 0L)
                  {
                     jjnextStates = jjstates69;
                     break;
                  }
                  else continue;
               case 47:
                  if ((0x2400L & l) != 0L)
                  {
                     if (jjcurKind > 9)
                        jjcurKind = 9;
                     continue;
                  }
                  else continue;
               case 49:
                  if ((0x2000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 48;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 48:
                  if ((0x400L & l) != 0L)
                  {
                     if (jjcurKind > 9)
                        jjcurKind = 9;
                     continue;
                  }
                  else continue;
               case 5:
                  if ((0x200000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 0;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 0:
                  if ((0x200000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates2;
                     break;
                  }
                  else continue;
               case 1:
                  if ((0xffffdfffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates2;
                     break;
                  }
                  else continue;
               case 2:
                  if ((0x200000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates1;
                     break;
                  }
                  else continue;
               case 3:
                  if ((0xffffdfffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates0;
                     break;
                  }
                  else continue;
               case 12:
                  if ((0x200000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 11;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 11:
                  if ((0x200000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 6;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 6:
                  if ((0x200000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates6;
                     break;
                  }
                  else continue;
               case 7:
                  if ((0xffffdfffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates6;
                     break;
                  }
                  else continue;
               case 8:
                  if ((0x200000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates5;
                     break;
                  }
                  else continue;
               case 9:
                  if ((0xffffdfffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates4;
                     break;
                  }
                  else continue;
               case 50:
                  if ((0x40000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates72;
                     break;
                  }
                  else continue;
               case 51:
                  if ((0xfffffbffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates72;
                     break;
                  }
                  else continue;
               case 52:
                  if ((0x40000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates71;
                     break;
                  }
                  else continue;
               case 53:
                  if ((0xffff7bffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates70;
                     break;
                  }
                  else continue;
               case 54:
                  if ((0xfffffbffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates70;
                     break;
                  }
                  else continue;
               case 55:
                  if ((0x800000000000L & l) != 0L)
                  {
                     if (jjcurKind > 12)
                        jjcurKind = 12;
                     continue;
                  }
                  else continue;
               case 13:
                  if ((0x8000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 14:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 16:
                  if ((0x8400000000L & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 18:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates10;
                     break;
                  }
                  else continue;
               case 19:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 20:
                  if ((0xf000000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 21;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 21:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates11;
                     break;
                  }
                  else continue;
               case 17:
                  if ((0x8000000000L & l) != 0L)
                  {
                     if (jjcurKind > 13)
                        jjcurKind = 13;
                     continue;
                  }
                  else continue;
               case 22:
                  if ((0x400000000L & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 23:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 25:
                  if ((0x8400000000L & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 27:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates15;
                     break;
                  }
                  else continue;
               case 28:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 29:
                  if ((0xf000000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 30;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 30:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates16;
                     break;
                  }
                  else continue;
               case 26:
                  if ((0x400000000L & l) != 0L)
                  {
                     if (jjcurKind > 14)
                        jjcurKind = 14;
                     continue;
                  }
                  else continue;
               case 58:
                     newStates[jjnewStateCnt + 0] = 58;
                     newStates[jjnewStateCnt + 1] = 59;
                     jjnewStateCnt += 2;
                     continue;
               case 62:
                     jjnextStates = jjstates76;
                     break;
               case 64:
                     jjnextStates = jjstates76;
                     break;
               case 66:
                     jjnextStates = jjstates76;
                     break;
               case 68:
                     jjnextStates = jjstates76;
                     break;
               case 71:
                     jjnextStates = jjstates76;
                     break;
               case 32:
                  if ((0x7ff600000000000L & l) != 0L)
                  {
                     if (jjcurKind > 29)
                        jjcurKind = 29;
                     newStates[jjnewStateCnt + 0] = 32;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 33:
                  if ((0x8000004200000000L & l) != 0L)
                  {
                     if (jjcurKind > 29)
                        jjcurKind = 29;
                     newStates[jjnewStateCnt + 0] = 34;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 35:
                  if ((0x7ff600000000000L & l) != 0L)
                  {
                     if (jjcurKind > 29)
                        jjcurKind = 29;
                     newStates[jjnewStateCnt + 0] = 35;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 36:
                  if ((0x8fff7c7affffd9ffL & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates64;
                     break;
                  }
                  else continue;
               case 37:
                  if ((0x8fff7c7affffd9ffL & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates64;
                     break;
                  }
                  else continue;
               case 39:
                  if ((0x8400000000L & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates64;
                     break;
                  }
                  else continue;
               case 40:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates65;
                     break;
                  }
                  else continue;
               case 41:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates64;
                     break;
                  }
                  else continue;
               case 42:
                  if ((0xf000000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 43;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 43:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates66;
                     break;
                  }
                  else continue;
               case 10:
                  if ((0x200000000000L & l) != 0L)
                  {
                     if (jjcurKind > 11)
                        jjcurKind = 11;
                     jjnextStates = jjstates5;
                     break;
                  }
                  else continue;
               case 4:
                  if ((0x200000000000L & l) != 0L)
                  {
                     if (jjcurKind > 10)
                        jjcurKind = 10;
                     jjnextStates = jjstates1;
                     break;
                  }
                  else continue;
               case 44:
                  if ((0x800000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 45;
                     newStates[jjnewStateCnt + 1] = 50;
                     jjnewStateCnt += 2;
                     continue;
                  }
                  else continue;
               default : continue;
            }
            j = jjnextStates.length;
            do
            {
               if (jjrounds[k = jjnextStates[--j]] != jjround)
               {
                  jjrounds[k] = jjround;
                  newStates[jjnewStateCnt++] = k;
               }
            } while (j != 0);
         } while(i != 0);
      }
      else if (curChar < 128)
      {
         int i = jjnewStateCnt;
         jjnewStateCnt = 0;
         jjround++;
         long l = 1L << (curChar & 077);
         do
         {
            switch(oldStates[--i])
            {
               case 46:
                     newStates[jjnewStateCnt + 0] = 46;
                     newStates[jjnewStateCnt + 1] = 47;
                     newStates[jjnewStateCnt + 2] = 49;
                     jjnewStateCnt += 3;
                     continue;
               case 1:
                     jjnextStates = jjstates2;
                     break;
               case 3:
                     jjnextStates = jjstates0;
                     break;
               case 7:
                     jjnextStates = jjstates6;
                     break;
               case 9:
                     jjnextStates = jjstates4;
                     break;
               case 51:
                     jjnextStates = jjstates72;
                     break;
               case 53:
                     jjnextStates = jjstates70;
                     break;
               case 54:
                     jjnextStates = jjstates70;
                     break;
               case 14:
                  if ((0xffffffffefffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 15:
                  if ((0x10000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 16;
                     newStates[jjnewStateCnt + 1] = 18;
                     newStates[jjnewStateCnt + 2] = 20;
                     jjnewStateCnt += 3;
                     continue;
                  }
                  else continue;
               case 16:
                  if ((0x14404410000000L & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 23:
                  if ((0xffffffffefffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 24:
                  if ((0x10000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 25;
                     newStates[jjnewStateCnt + 1] = 27;
                     newStates[jjnewStateCnt + 2] = 29;
                     jjnewStateCnt += 3;
                     continue;
                  }
                  else continue;
               case 25:
                  if ((0x14404410000000L & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 57:
                  if ((0x8000000L & l) != 0L)
                  {
                     jjnextStates = jjstates75;
                     break;
                  }
                  else continue;
               case 58:
                  if ((0xffffffffdfffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates75;
                     break;
                  }
                  else continue;
               case 60:
                  if ((0x20000000L & l) != 0L)
                  {
                     if (jjcurKind > 15)
                        jjcurKind = 15;
                     continue;
                  }
                  else continue;
               case 88:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 87;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 87:
                  if ((0x10L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 86;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 86:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 85;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 85:
                  if ((0x100000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 84;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 84:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 61;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 61:
                  if ((0x8000000L & l) != 0L)
                  {
                     jjnextStates = jjstates76;
                     break;
                  }
                  else continue;
               case 62:
                  if ((0xffffffffdfffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates76;
                     break;
                  }
                  else continue;
               case 64:
                  if ((0xfffffffffffffff7L & l) != 0L)
                  {
                     jjnextStates = jjstates76;
                     break;
                  }
                  else continue;
               case 65:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 66;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 66:
                  if ((0xffffffffffffffefL & l) != 0L)
                  {
                     jjnextStates = jjstates76;
                     break;
                  }
                  else continue;
               case 69:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 67;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 67:
                  if ((0x10L & l) != 0L)
                  {
                     jjnextStates = jjstates77;
                     break;
                  }
                  else continue;
               case 68:
                  if ((0xfffffffffffffffdL & l) != 0L)
                  {
                     jjnextStates = jjstates76;
                     break;
                  }
                  else continue;
               case 73:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 72;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 72:
                  if ((0x10L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 70;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 70:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 71;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 71:
                  if ((0xffffffffffefffffL & l) != 0L)
                  {
                     jjnextStates = jjstates76;
                     break;
                  }
                  else continue;
               case 77:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 76;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 76:
                  if ((0x10L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 75;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 75:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 74;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 74:
                  if ((0x100000L & l) != 0L)
                  {
                     jjnextStates = jjstates77;
                     break;
                  }
                  else continue;
               case 83:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 82;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 82:
                  if ((0x10L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 81;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 81:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 80;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 80:
                  if ((0x100000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 78;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 78:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 79;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 79:
                  if ((0x20000000L & l) != 0L)
                  {
                     if (jjcurKind > 16)
                        jjcurKind = 16;
                     continue;
                  }
                  else continue;
               case 31:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (jjcurKind > 29)
                        jjcurKind = 29;
                     jjnextStates = jjstates61;
                     break;
                  }
                  else continue;
               case 32:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (jjcurKind > 29)
                        jjcurKind = 29;
                     jjnextStates = jjstates61;
                     break;
                  }
                  else continue;
               case 34:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (jjcurKind > 29)
                        jjcurKind = 29;
                     jjnextStates = jjstates62;
                     break;
                  }
                  else continue;
               case 35:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (jjcurKind > 29)
                        jjcurKind = 29;
                     jjnextStates = jjstates62;
                     break;
                  }
                  else continue;
               case 36:
                  if ((0xd7ffffffffffffffL & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates64;
                     break;
                  }
                  else continue;
               case 37:
                  if ((0xd7ffffffefffffffL & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates64;
                     break;
                  }
                  else continue;
               case 38:
                  if ((0x10000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 39;
                     newStates[jjnewStateCnt + 1] = 40;
                     newStates[jjnewStateCnt + 2] = 42;
                     jjnewStateCnt += 3;
                     continue;
                  }
                  else continue;
               case 39:
                  if ((0x14404410000000L & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates64;
                     break;
                  }
                  else continue;
               case 63:
                  if ((0x20000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 64;
                     newStates[jjnewStateCnt + 1] = 65;
                     newStates[jjnewStateCnt + 2] = 69;
                     newStates[jjnewStateCnt + 3] = 73;
                     newStates[jjnewStateCnt + 4] = 77;
                     newStates[jjnewStateCnt + 5] = 83;
                     jjnewStateCnt += 6;
                     continue;
                  }
                  else continue;
               case 59:
                  if ((0x20000000L & l) != 0L)
                  {
                     jjnextStates = jjstates74;
                     break;
                  }
                  else continue;
               case 56:
                  if ((0x8000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 57;
                     newStates[jjnewStateCnt + 1] = 88;
                     jjnewStateCnt += 2;
                     continue;
                  }
                  else continue;
               default : continue;
            }
            j = jjnextStates.length;
            do
            {
               if (jjrounds[k = jjnextStates[--j]] != jjround)
               {
                  jjrounds[k] = jjround;
                  newStates[jjnewStateCnt++] = k;
               }
            } while (j != 0);
         } while(i != 0);
      }
      else
      {
         int i = jjnewStateCnt;
         jjnewStateCnt = 0;
         jjround++;
         int i2 = (curChar & 0xff) >> 6;
         int i1 = ((curChar >> 8) & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         long l1 = 1L << ((curChar >> 8) & 077);
         Outer:
         do
         {
            switch(oldStates[--i])
            {
               case 46:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     newStates[jjnewStateCnt + 0] = 46;
                     newStates[jjnewStateCnt + 1] = 47;
                     newStates[jjnewStateCnt + 2] = 49;
                     jjnewStateCnt += 3;
                     continue;
               case 1:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates2;
                     break;
               case 3:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates0;
                     break;
               case 7:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates6;
                     break;
               case 9:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates4;
                     break;
               case 51:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates72;
                     break;
               case 53:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates70;
                     break;
               case 54:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates70;
                     break;
               case 14:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     newStates[jjnewStateCnt + 0] = 14;
                     newStates[jjnewStateCnt + 1] = 15;
                     newStates[jjnewStateCnt + 2] = 17;
                     jjnewStateCnt += 3;
                     continue;
               case 23:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     newStates[jjnewStateCnt + 0] = 23;
                     newStates[jjnewStateCnt + 1] = 24;
                     newStates[jjnewStateCnt + 2] = 26;
                     jjnewStateCnt += 3;
                     continue;
               case 58:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     newStates[jjnewStateCnt + 0] = 58;
                     newStates[jjnewStateCnt + 1] = 59;
                     jjnewStateCnt += 2;
                     continue;
               case 62:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates76;
                     break;
               case 64:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates76;
                     break;
               case 66:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates76;
                     break;
               case 68:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates76;
                     break;
               case 71:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates76;
                     break;
               case 36:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                  if (jjcurKind > 30)
                     jjcurKind = 30;
                     jjnextStates = jjstates64;
                     break;
               case 37:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                  if (jjcurKind > 30)
                     jjcurKind = 30;
                     jjnextStates = jjstates64;
                     break;
               default : continue;
            }
            j = jjnextStates.length;
            do
            {
               if (jjrounds[k = jjnextStates[--j]] != jjround)
               {
                  jjrounds[k] = jjround;
                  newStates[jjnewStateCnt++] = k;
               }
            } while (j != 0);
         } while(i != 0);
      }
      return;
   }
}
int[] StopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x40L) != 0L)
            return jjstates64;
         return null;
      default : 
         return null;
   }
}
void jjStartNfa_0(int pos, long active0)
{
   if ((jjstartStateSet = StopStringLiteralDfa_0(pos, active0)) != null)
   {
      jjnewStateCnt = jjstartStateSet.length;
      jjMoveNfa_0(jjstartStateSet, jjstateSet2);
      if (jjcurKind != 2147483647)
      {
         matchedToken.kind = jjcurKind;
         jjmatchedPos = pos + 1;
         jjcurKind = 2147483647;
      }
   }
   return;
}
long jjnewActive_00 = 0L, jjoldActive_00 = 0L;
private final void jjMoveStringLiteralDfa0_0() throws java.io.IOException
{
   ReturnLoop:
   for (;;)
   {
    MainLoop:
    for (;;)
    {
         switch(curChar)
         {
            case 62: 
               matchedToken.kind = 20;
               break ReturnLoop;
            case 61: 
               matchedToken.kind = 21;
               break ReturnLoop;
            case 60: 
               matchedToken.kind = 1;
               break ReturnLoop;
            case 40: 
               matchedToken.kind = 8;
               break ReturnLoop;
            case 32: 
               matchedToken.kind = 2;
               break ReturnLoop;
            case 123: 
               matchedToken.kind = 7;
               break ReturnLoop;
            case 13: 
               matchedToken.kind = 5;
               break ReturnLoop;
            case 12: 
               matchedToken.kind = 6;
               jjstartStateSet = jjstates64;
               break MainLoop;
            case 10: 
               matchedToken.kind = 4;
               break ReturnLoop;
            case 9: 
               matchedToken.kind = 3;
               break ReturnLoop;
            default : 
               curPos =  1;
               if (curChar < 128)
                  if ((jjstartStateSet = jjinitStates_0[curChar]) == null)
                     return;
               else 
                  jjstartStateSet = jjallInitStates_0;
               jjnewStateCnt = jjstartStateSet.length;
               jjMoveNfa_0(jjstartStateSet, jjstateSet2);
               if (jjcurKind != 2147483647)
               {
                  matchedToken.kind = jjcurKind;
                  jjcurKind = 2147483647;
               }
               return;
         }
    }
    curPos = 1;
    curChar = input_stream.readChar();
    jjnewStateCnt = jjstartStateSet.length;
    jjMoveNfa_0(jjstartStateSet, jjstateSet2);
    if (jjcurKind != 2147483647)
    {
       matchedToken.kind = jjcurKind;
       jjmatchedPos = 1;
       jjcurKind = 2147483647;
    }
    curPos = 2;
    return;
   }
   curPos = 1;
   return;
}
static final int[] jjstates61 = { 32, };
static final int[] jjstates62 = { 35, };
static final int[] jjstates63 = { 34, };
static final int[] jjstates64 = { 37, 38, };
static final int[] jjstates65 = { 37, 38, 41, };
static final int[] jjstates66 = { 41, };
static final int[] jjstates67 = { 39, 40, 42, };
static final int[] jjstates68 = { 48, };
static final int[] jjstates69 = { 46, 47, 49, };
static final int[] jjstates70 = { 54, 52, };
static final int[] jjstates71 = { 52, 53, 55, };
static final int[] jjstates72 = { 51, 52, };
static final int[] jjstates73 = { 45, 50, };
static final int[] jjstates74 = { 58, 60, };
static final int[] jjstates75 = { 58, 59, };
static final int[] jjstates76 = { 62, 63, };
static final int[] jjstates77 = { 68, };
static final int[] jjstates78 = { 72, };
static final int[] jjstates79 = { 78, };
static final int[] jjstates80 = { 64, 65, 69, 73, 77, 83, };
static final int[] jjstates81 = { 84, };
static final int[] jjstates82 = { 85, };
static final int[] jjstates83 = { 86, };
static final int[] jjstates84 = { 87, };
static final int[] jjstates85 = { 57, 88, };
static final int[] jjallInitStates_0 = { 5, 12, 13, 22, 31, 33, 36, 44, 56, };
static final int[] jjstates86 = { 12, 33, 36, };
static final int[] jjstates87 = { 33, 36, };
static final int[] jjstates88 = { 5, 36, };
static final int[] jjstates89 = { 44, };
static final int[] jjstates90 = { 31, 36, };
static final int[] jjstates91 = { 36, 56, };
static final int[][] jjinitStates_0 = {
jjallInitStates_0, jjstates21, jjstates21, jjstates21, jjstates21, jjstates21, 
jjstates21, jjstates21, jjstates21, null, null, 
jjstates21, jjstates21, null, jjstates21, jjstates21, 
jjstates21, jjstates21, jjstates21, jjstates21, jjstates21, 
jjstates21, jjstates21, jjstates21, jjstates21, jjstates21, 
jjstates21, jjstates21, jjstates21, jjstates21, jjstates21, 
jjstates21, null, jjstates86, jjstates56, jjstates21, 
jjstates21, jjstates21, jjstates87, jjstates57, null, 
null, jjstates21, jjstates21, jjstates21, jjstates88, 
jjstates21, jjstates89, jjstates21, jjstates21, jjstates21, 
jjstates21, jjstates21, jjstates21, jjstates21, jjstates21, 
jjstates21, jjstates21, jjstates21, jjstates21, null, 
null, null, jjstates87, jjstates21, jjstates90, 
jjstates90, jjstates90, jjstates90, jjstates90, jjstates90, 
jjstates90, jjstates90, jjstates90, jjstates90, jjstates90, 
jjstates90, jjstates90, jjstates90, jjstates90, jjstates90, 
jjstates90, jjstates90, jjstates90, jjstates90, jjstates90, 
jjstates90, jjstates90, jjstates90, jjstates90, jjstates90, 
jjstates91, jjstates21, jjstates21, jjstates21, jjstates21, 
jjstates21, jjstates90, jjstates90, jjstates90, jjstates90, 
jjstates90, jjstates90, jjstates90, jjstates90, jjstates90, 
jjstates90, jjstates90, jjstates90, jjstates90, jjstates90, 
jjstates90, jjstates90, jjstates90, jjstates90, jjstates90, 
jjstates90, jjstates90, jjstates90, jjstates90, jjstates90, 
jjstates90, jjstates90, null, jjstates21, null, 
jjstates21, jjstates21, };

private final void jjMoveNfa_3(int[] oldStates, int[] newStates)
{
   int j, k;
   MainLoop :
   for (;;)
   {
      if (curChar < 64)
      {
         int i = jjnewStateCnt;
         jjnewStateCnt = 0;
         jjround++;
         long l = 1L << curChar;
         do
         {
            switch(oldStates[--i])
            {
               case 0:
                  if ((0xefffffffffffffffL & l) != 0L)
                  {
                     if (jjcurKind > 18)
                        jjcurKind = 18;
                     jjnextStates = jjstates92;
                     break;
                  }
                  else continue;
               case 2:
                  if ((0x1000008400000000L & l) != 0L)
                  {
                     if (jjcurKind > 18)
                        jjcurKind = 18;
                     jjnextStates = jjstates92;
                     break;
                  }
                  else continue;
               case 3:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     if (jjcurKind > 18)
                        jjcurKind = 18;
                     jjnextStates = jjstates95;
                     break;
                  }
                  else continue;
               case 4:
                  if ((0xf000000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 5;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 5:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 6;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 6:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     if (jjcurKind > 18)
                        jjcurKind = 18;
                     jjnextStates = jjstates92;
                     break;
                  }
                  else continue;
               case 7:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     if (jjcurKind > 18)
                        jjcurKind = 18;
                     jjnextStates = jjstates94;
                     break;
                  }
                  else continue;
               default : continue;
            }
            j = jjnextStates.length;
            do
            {
               if (jjrounds[k = jjnextStates[--j]] != jjround)
               {
                  jjrounds[k] = jjround;
                  newStates[jjnewStateCnt++] = k;
               }
            } while (j != 0);
         } while(i != 0);
      }
      else if (curChar < 128)
      {
         int i = jjnewStateCnt;
         jjnewStateCnt = 0;
         jjround++;
         long l = 1L << (curChar & 077);
         do
         {
            switch(oldStates[--i])
            {
               case 0:
                  if ((0xdfffffffefffffffL & l) != 0L)
                  {
                     if (jjcurKind > 18)
                        jjcurKind = 18;
                     jjnextStates = jjstates92;
                     break;
                  }
                  else continue;
               case 1:
                  if ((0x10000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 2;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 2:
                  if ((0x2014404410000000L & l) != 0L)
                  {
                     if (jjcurKind > 18)
                        jjcurKind = 18;
                     jjnextStates = jjstates92;
                     break;
                  }
                  else continue;
               default : continue;
            }
            j = jjnextStates.length;
            do
            {
               if (jjrounds[k = jjnextStates[--j]] != jjround)
               {
                  jjrounds[k] = jjround;
                  newStates[jjnewStateCnt++] = k;
               }
            } while (j != 0);
         } while(i != 0);
      }
      else
      {
         int i = jjnewStateCnt;
         jjnewStateCnt = 0;
         jjround++;
         int i2 = (curChar & 0xff) >> 6;
         int i1 = ((curChar >> 8) & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         long l1 = 1L << ((curChar >> 8) & 077);
         Outer:
         do
         {
            switch(oldStates[--i])
            {
               case 0:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                  if (jjcurKind > 18)
                     jjcurKind = 18;
                     newStates[jjnewStateCnt + 0] = 0;
                     newStates[jjnewStateCnt + 1] = 1;
                     newStates[jjnewStateCnt + 2] = 3;
                     newStates[jjnewStateCnt + 3] = 4;
                     jjnewStateCnt += 4;
                     continue;
               default : continue;
            }
         } while(i != 0);
      }
      return;
   }
}
int[] StopStringLiteralDfa_3(int pos, long active0)
{
   switch (pos)
   {
      default : 
         return null;
   }
}
void jjStartNfa_3(int pos, long active0)
{
   if ((jjstartStateSet = StopStringLiteralDfa_3(pos, active0)) != null)
   {
      jjnewStateCnt = jjstartStateSet.length;
      jjMoveNfa_3(jjstartStateSet, jjstateSet2);
      if (jjcurKind != 2147483647)
      {
         matchedToken.kind = jjcurKind;
         jjmatchedPos = pos + 1;
         jjcurKind = 2147483647;
      }
   }
   return;
}
long jjnewActive_30 = 0L, jjoldActive_30 = 0L;
private final void jjMoveStringLiteralDfa0_3() throws java.io.IOException
{
   ReturnLoop:
   for (;;)
   {
    MainLoop:
    for (;;)
    {
         switch(curChar)
         {
            case 60: 
               matchedToken.kind = 1;
               break ReturnLoop;
            case 125: 
               matchedToken.kind = 17;
               break ReturnLoop;
            default : 
               curPos =  1;
               if (curChar < 128)
                  if ((jjstartStateSet = jjinitStates_3[curChar]) == null)
                     return;
               else 
                  jjstartStateSet = jjallInitStates_3;
               jjnewStateCnt = jjstartStateSet.length;
               jjMoveNfa_3(jjstartStateSet, jjstateSet2);
               if (jjcurKind != 2147483647)
               {
                  matchedToken.kind = jjcurKind;
                  jjcurKind = 2147483647;
               }
               return;
         }
    }
   }
   curPos = 1;
   return;
}
static final int[] jjstates92 = { 0, 1, 3, 4, };
static final int[] jjstates93 = { 5, };
static final int[] jjstates94 = { 0, 1, 3, 4, 7, };
static final int[] jjstates95 = { 0, 1, 4, 7, };
static final int[] jjstates96 = { 2, };
static final int[] jjallInitStates_3 = jjstates92;
static final int[] jjstates97 = { 0, 3, 4, };
static final int[] jjstates98 = { 0, 3, };
static final int[] jjstates99 = { 1, };
static final int[][] jjinitStates_3 = {
jjstates92, jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates97, jjstates97, jjstates97, 
jjstates97, jjstates98, jjstates98, jjstates98, jjstates98, 
jjstates3, jjstates3, jjstates3, jjstates3, null, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates99, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, jjstates3, 
jjstates3, jjstates3, jjstates3, jjstates3, null, 
jjstates3, jjstates3, };

private final void jjMoveNfa_2(int[] oldStates, int[] newStates)
{
   int j, k;
   MainLoop :
   for (;;)
   {
      if (curChar < 64)
      {
         int i = jjnewStateCnt;
         jjnewStateCnt = 0;
         jjround++;
         long l = 1L << curChar;
         do
         {
            switch(oldStates[--i])
            {
               case 40:
                  if ((0x800000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates25;
                     break;
                  }
                  else continue;
               case 41:
                  if ((0xffffffffffffdbffL & l) != 0L)
                  {
                     jjnextStates = jjstates25;
                     break;
                  }
                  else continue;
               case 42:
                  if ((0x2400L & l) != 0L)
                  {
                     if (jjcurKind > 9)
                        jjcurKind = 9;
                     continue;
                  }
                  else continue;
               case 44:
                  if ((0x2000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 43;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 43:
                  if ((0x400L & l) != 0L)
                  {
                     if (jjcurKind > 9)
                        jjcurKind = 9;
                     continue;
                  }
                  else continue;
               case 5:
                  if ((0x200000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 0;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 0:
                  if ((0x200000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates2;
                     break;
                  }
                  else continue;
               case 1:
                  if ((0xffffdfffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates2;
                     break;
                  }
                  else continue;
               case 2:
                  if ((0x200000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates1;
                     break;
                  }
                  else continue;
               case 3:
                  if ((0xffffdfffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates0;
                     break;
                  }
                  else continue;
               case 12:
                  if ((0x200000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 11;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 11:
                  if ((0x200000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 6;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 6:
                  if ((0x200000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates6;
                     break;
                  }
                  else continue;
               case 7:
                  if ((0xffffdfffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates6;
                     break;
                  }
                  else continue;
               case 8:
                  if ((0x200000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates5;
                     break;
                  }
                  else continue;
               case 9:
                  if ((0xffffdfffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates4;
                     break;
                  }
                  else continue;
               case 45:
                  if ((0x40000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates28;
                     break;
                  }
                  else continue;
               case 46:
                  if ((0xfffffbffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates28;
                     break;
                  }
                  else continue;
               case 47:
                  if ((0x40000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates27;
                     break;
                  }
                  else continue;
               case 48:
                  if ((0xffff7bffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates26;
                     break;
                  }
                  else continue;
               case 49:
                  if ((0xfffffbffffffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates26;
                     break;
                  }
                  else continue;
               case 50:
                  if ((0x800000000000L & l) != 0L)
                  {
                     if (jjcurKind > 12)
                        jjcurKind = 12;
                     continue;
                  }
                  else continue;
               case 13:
                  if ((0x8000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 14:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 16:
                  if ((0x8400000000L & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 18:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates10;
                     break;
                  }
                  else continue;
               case 19:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 20:
                  if ((0xf000000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 21;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 21:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates11;
                     break;
                  }
                  else continue;
               case 17:
                  if ((0x8000000000L & l) != 0L)
                  {
                     if (jjcurKind > 13)
                        jjcurKind = 13;
                     continue;
                  }
                  else continue;
               case 22:
                  if ((0x400000000L & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 23:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 25:
                  if ((0x8400000000L & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 27:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates15;
                     break;
                  }
                  else continue;
               case 28:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 29:
                  if ((0xf000000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 30;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 30:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates16;
                     break;
                  }
                  else continue;
               case 26:
                  if ((0x400000000L & l) != 0L)
                  {
                     if (jjcurKind > 14)
                        jjcurKind = 14;
                     continue;
                  }
                  else continue;
               case 53:
                     newStates[jjnewStateCnt + 0] = 53;
                     newStates[jjnewStateCnt + 1] = 54;
                     jjnewStateCnt += 2;
                     continue;
               case 57:
                     jjnextStates = jjstates32;
                     break;
               case 59:
                     jjnextStates = jjstates32;
                     break;
               case 61:
                     jjnextStates = jjstates32;
                     break;
               case 63:
                     jjnextStates = jjstates32;
                     break;
               case 66:
                     jjnextStates = jjstates32;
                     break;
               case 31:
                  if ((0x8fff7c7affffd9ffL & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 32:
                  if ((0x8fff7c7affffd9ffL & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 34:
                  if ((0x8400000000L & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 35:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates20;
                     break;
                  }
                  else continue;
               case 36:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 37:
                  if ((0xf000000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 38;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 38:
                  if ((0xff000000000000L & l) != 0L)
                  {
                     jjnextStates = jjstates21;
                     break;
                  }
                  else continue;
               case 10:
                  if ((0x200000000000L & l) != 0L)
                  {
                     if (jjcurKind > 11)
                        jjcurKind = 11;
                     jjnextStates = jjstates5;
                     break;
                  }
                  else continue;
               case 4:
                  if ((0x200000000000L & l) != 0L)
                  {
                     if (jjcurKind > 10)
                        jjcurKind = 10;
                     jjnextStates = jjstates1;
                     break;
                  }
                  else continue;
               case 39:
                  if ((0x800000000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 40;
                     newStates[jjnewStateCnt + 1] = 45;
                     jjnewStateCnt += 2;
                     continue;
                  }
                  else continue;
               default : continue;
            }
            j = jjnextStates.length;
            do
            {
               if (jjrounds[k = jjnextStates[--j]] != jjround)
               {
                  jjrounds[k] = jjround;
                  newStates[jjnewStateCnt++] = k;
               }
            } while (j != 0);
         } while(i != 0);
      }
      else if (curChar < 128)
      {
         int i = jjnewStateCnt;
         jjnewStateCnt = 0;
         jjround++;
         long l = 1L << (curChar & 077);
         do
         {
            switch(oldStates[--i])
            {
               case 41:
                     newStates[jjnewStateCnt + 0] = 41;
                     newStates[jjnewStateCnt + 1] = 42;
                     newStates[jjnewStateCnt + 2] = 44;
                     jjnewStateCnt += 3;
                     continue;
               case 1:
                     jjnextStates = jjstates2;
                     break;
               case 3:
                     jjnextStates = jjstates0;
                     break;
               case 7:
                     jjnextStates = jjstates6;
                     break;
               case 9:
                     jjnextStates = jjstates4;
                     break;
               case 46:
                     jjnextStates = jjstates28;
                     break;
               case 48:
                     jjnextStates = jjstates26;
                     break;
               case 49:
                     jjnextStates = jjstates26;
                     break;
               case 14:
                  if ((0xffffffffefffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 15:
                  if ((0x10000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 16;
                     newStates[jjnewStateCnt + 1] = 18;
                     newStates[jjnewStateCnt + 2] = 20;
                     jjnewStateCnt += 3;
                     continue;
                  }
                  else continue;
               case 16:
                  if ((0x14404410000000L & l) != 0L)
                  {
                     jjnextStates = jjstates9;
                     break;
                  }
                  else continue;
               case 23:
                  if ((0xffffffffefffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 24:
                  if ((0x10000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 25;
                     newStates[jjnewStateCnt + 1] = 27;
                     newStates[jjnewStateCnt + 2] = 29;
                     jjnewStateCnt += 3;
                     continue;
                  }
                  else continue;
               case 25:
                  if ((0x14404410000000L & l) != 0L)
                  {
                     jjnextStates = jjstates14;
                     break;
                  }
                  else continue;
               case 52:
                  if ((0x8000000L & l) != 0L)
                  {
                     jjnextStates = jjstates31;
                     break;
                  }
                  else continue;
               case 53:
                  if ((0xffffffffdfffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates31;
                     break;
                  }
                  else continue;
               case 55:
                  if ((0x20000000L & l) != 0L)
                  {
                     if (jjcurKind > 15)
                        jjcurKind = 15;
                     continue;
                  }
                  else continue;
               case 83:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 82;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 82:
                  if ((0x10L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 81;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 81:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 80;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 80:
                  if ((0x100000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 79;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 79:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 56;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 56:
                  if ((0x8000000L & l) != 0L)
                  {
                     jjnextStates = jjstates32;
                     break;
                  }
                  else continue;
               case 57:
                  if ((0xffffffffdfffffffL & l) != 0L)
                  {
                     jjnextStates = jjstates32;
                     break;
                  }
                  else continue;
               case 59:
                  if ((0xfffffffffffffff7L & l) != 0L)
                  {
                     jjnextStates = jjstates32;
                     break;
                  }
                  else continue;
               case 60:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 61;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 61:
                  if ((0xffffffffffffffefL & l) != 0L)
                  {
                     jjnextStates = jjstates32;
                     break;
                  }
                  else continue;
               case 64:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 62;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 62:
                  if ((0x10L & l) != 0L)
                  {
                     jjnextStates = jjstates34;
                     break;
                  }
                  else continue;
               case 63:
                  if ((0xfffffffffffffffdL & l) != 0L)
                  {
                     jjnextStates = jjstates32;
                     break;
                  }
                  else continue;
               case 68:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 67;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 67:
                  if ((0x10L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 65;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 65:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 66;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 66:
                  if ((0xffffffffffefffffL & l) != 0L)
                  {
                     jjnextStates = jjstates32;
                     break;
                  }
                  else continue;
               case 72:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 71;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 71:
                  if ((0x10L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 70;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 70:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 69;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 69:
                  if ((0x100000L & l) != 0L)
                  {
                     jjnextStates = jjstates34;
                     break;
                  }
                  else continue;
               case 78:
                  if ((0x8L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 77;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 77:
                  if ((0x10L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 76;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 76:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 75;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 75:
                  if ((0x100000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 73;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 73:
                  if ((0x2L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 74;
                     jjnewStateCnt += 1;
                     continue;
                  }
                  else continue;
               case 74:
                  if ((0x20000000L & l) != 0L)
                  {
                     if (jjcurKind > 16)
                        jjcurKind = 16;
                     continue;
                  }
                  else continue;
               case 31:
                  if ((0xd7ffffffffffffffL & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 32:
                  if ((0xd7ffffffefffffffL & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 33:
                  if ((0x10000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 34;
                     newStates[jjnewStateCnt + 1] = 35;
                     newStates[jjnewStateCnt + 2] = 37;
                     jjnewStateCnt += 3;
                     continue;
                  }
                  else continue;
               case 34:
                  if ((0x14404410000000L & l) != 0L)
                  {
                     if (jjcurKind > 30)
                        jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
                  }
                  else continue;
               case 58:
                  if ((0x20000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 59;
                     newStates[jjnewStateCnt + 1] = 60;
                     newStates[jjnewStateCnt + 2] = 64;
                     newStates[jjnewStateCnt + 3] = 68;
                     newStates[jjnewStateCnt + 4] = 72;
                     newStates[jjnewStateCnt + 5] = 78;
                     jjnewStateCnt += 6;
                     continue;
                  }
                  else continue;
               case 54:
                  if ((0x20000000L & l) != 0L)
                  {
                     jjnextStates = jjstates30;
                     break;
                  }
                  else continue;
               case 51:
                  if ((0x8000000L & l) != 0L)
                  {
                     newStates[jjnewStateCnt + 0] = 52;
                     newStates[jjnewStateCnt + 1] = 83;
                     jjnewStateCnt += 2;
                     continue;
                  }
                  else continue;
               default : continue;
            }
            j = jjnextStates.length;
            do
            {
               if (jjrounds[k = jjnextStates[--j]] != jjround)
               {
                  jjrounds[k] = jjround;
                  newStates[jjnewStateCnt++] = k;
               }
            } while (j != 0);
         } while(i != 0);
      }
      else
      {
         int i = jjnewStateCnt;
         jjnewStateCnt = 0;
         jjround++;
         int i2 = (curChar & 0xff) >> 6;
         int i1 = ((curChar >> 8) & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         long l1 = 1L << ((curChar >> 8) & 077);
         Outer:
         do
         {
            switch(oldStates[--i])
            {
               case 41:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     newStates[jjnewStateCnt + 0] = 41;
                     newStates[jjnewStateCnt + 1] = 42;
                     newStates[jjnewStateCnt + 2] = 44;
                     jjnewStateCnt += 3;
                     continue;
               case 1:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates2;
                     break;
               case 3:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates0;
                     break;
               case 7:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates6;
                     break;
               case 9:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates4;
                     break;
               case 46:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates28;
                     break;
               case 48:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates26;
                     break;
               case 49:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates26;
                     break;
               case 14:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     newStates[jjnewStateCnt + 0] = 14;
                     newStates[jjnewStateCnt + 1] = 15;
                     newStates[jjnewStateCnt + 2] = 17;
                     jjnewStateCnt += 3;
                     continue;
               case 23:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     newStates[jjnewStateCnt + 0] = 23;
                     newStates[jjnewStateCnt + 1] = 24;
                     newStates[jjnewStateCnt + 2] = 26;
                     jjnewStateCnt += 3;
                     continue;
               case 53:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     newStates[jjnewStateCnt + 0] = 53;
                     newStates[jjnewStateCnt + 1] = 54;
                     jjnewStateCnt += 2;
                     continue;
               case 57:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates32;
                     break;
               case 59:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates32;
                     break;
               case 61:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates32;
                     break;
               case 63:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates32;
                     break;
               case 66:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                     jjnextStates = jjstates32;
                     break;
               case 31:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                  if (jjcurKind > 30)
                     jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
               case 32:
                  MatchLoop:
                  for(;;)
                  {
                     switch((curChar >> 8))
                     {
                        case 0:
                           if ((jjbitVec2[i2] & l2) == 0L)
                              continue Outer;
                           break MatchLoop;
                        default : break;
                     }
                     if ((jjbitVec0[i1] & l1) != 0L)
                           break MatchLoop;
                     continue Outer;
                  }
                  if (jjcurKind > 30)
                     jjcurKind = 30;
                     jjnextStates = jjstates19;
                     break;
               default : continue;
            }
            j = jjnextStates.length;
            do
            {
               if (jjrounds[k = jjnextStates[--j]] != jjround)
               {
                  jjrounds[k] = jjround;
                  newStates[jjnewStateCnt++] = k;
               }
            } while (j != 0);
         } while(i != 0);
      }
      return;
   }
}
int[] StopStringLiteralDfa_2(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x40L) != 0L)
            return jjstates19;
         return null;
      default : 
         return null;
   }
}
void jjStartNfa_2(int pos, long active0)
{
   if ((jjstartStateSet = StopStringLiteralDfa_2(pos, active0)) != null)
   {
      jjnewStateCnt = jjstartStateSet.length;
      jjMoveNfa_2(jjstartStateSet, jjstateSet2);
      if (jjcurKind != 2147483647)
      {
         matchedToken.kind = jjcurKind;
         jjmatchedPos = pos + 1;
         jjcurKind = 2147483647;
      }
   }
   return;
}
long jjnewActive_20 = 0L, jjoldActive_20 = 0L;
private final void jjMoveStringLiteralDfa0_2() throws java.io.IOException
{
   ReturnLoop:
   for (;;)
   {
    MainLoop:
    for (;;)
    {
         switch(curChar)
         {
            case 60: 
               matchedToken.kind = 1;
               break ReturnLoop;
            case 41: 
               matchedToken.kind = 19;
               break ReturnLoop;
            case 40: 
               matchedToken.kind = 8;
               break ReturnLoop;
            case 32: 
               matchedToken.kind = 2;
               break ReturnLoop;
            case 123: 
               matchedToken.kind = 7;
               break ReturnLoop;
            case 13: 
               matchedToken.kind = 5;
               break ReturnLoop;
            case 12: 
               matchedToken.kind = 6;
               jjstartStateSet = jjstates19;
               break MainLoop;
            case 10: 
               matchedToken.kind = 4;
               break ReturnLoop;
            case 9: 
               matchedToken.kind = 3;
               break ReturnLoop;
            default : 
               curPos =  1;
               if (curChar < 128)
                  if ((jjstartStateSet = jjinitStates_2[curChar]) == null)
                     return;
               else 
                  jjstartStateSet = jjallInitStates_2;
               jjnewStateCnt = jjstartStateSet.length;
               jjMoveNfa_2(jjstartStateSet, jjstateSet2);
               if (jjcurKind != 2147483647)
               {
                  matchedToken.kind = jjcurKind;
                  jjcurKind = 2147483647;
               }
               return;
         }
    }
    curPos = 1;
    curChar = input_stream.readChar();
    jjnewStateCnt = jjstartStateSet.length;
    jjMoveNfa_2(jjstartStateSet, jjstateSet2);
    if (jjcurKind != 2147483647)
    {
       matchedToken.kind = jjcurKind;
       jjmatchedPos = 1;
       jjcurKind = 2147483647;
    }
    curPos = 2;
    return;
   }
   curPos = 1;
   return;
}
static final int[] jjallInitStates_2 = jjallInitStates_1;
static final int[][] jjinitStates_2 = {
jjallInitStates_1, jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, null, null, 
jjstates54, jjstates54, null, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, null, jjstates55, jjstates56, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates57, null, 
null, jjstates54, jjstates54, jjstates54, jjstates58, 
jjstates54, jjstates59, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, null, 
null, null, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates60, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, jjstates54, jjstates54, jjstates54, 
jjstates54, jjstates54, null, jjstates54, null, 
jjstates54, jjstates54, };

public static final String[] jjstrLiteralImages = {
null, "\74", null, null, null, null, null, "\173", "\50", null, null, null, 
null, null, null, null, null, "\175", null, "\51", "\76", "\75", null, null, null, 
null, null, null, null, null, null, };
public static final String[] lexStateNames = {
   "ElementSect", 
   "ValueSect", 
   "ListSect", 
   "TextSect", 
   "DEFAULT", 
};
static final long[] jjtoToken = 
{
0x603fe182L,
};
static final long[] jjtoSkip = 
{
0x1e7cL,
};
static final long[] jjtoSpecial = 
{
0x1e00L,
};
private ASCII_UCodeESC_CharStream input_stream;
private int[] jjrounds = new int[89];
private int[] jjstateSet1 = new int[89];
private int[] jjstateSet2 = new int[89];
private int[] jjnextStates;
int curPos;
StringBuffer image;
int jjimageLen;
int lengthOfMatch;
protected char curChar;
int jjcurKind = 2147483647;
OmlParserTokenManager jjme;
public OmlParserTokenManager(ASCII_UCodeESC_CharStream stream)
{
input_stream = stream;
jjme = this;
}
public OmlParserTokenManager(ASCII_UCodeESC_CharStream stream, int lexState)
{
input_stream = stream;
jjme = this;
   if (lexState >= 5 || lexState < 0)
   {
      System.out.println("Error: Ignoring invalid lexical state : " + lexState + ". Starting lexer in DEFAULT state.");
      curLexState = defaultLexState;
   }
   else
      curLexState = lexState;
}
public void ReInit(ASCII_UCodeESC_CharStream stream)
{
int i;
jjcurKind = 2147483647;
curPos = jjmatchedPos = jjnewStateCnt = jjround = 0;
jjstartStateSet = null;
curChar = (char)0;
jjEOFSeen = false;
curLexState = defaultLexState;
input_stream = stream;
for (i = 89; i-- > 0;)
   jjrounds[i] = 0;
}
public void ReInit(ASCII_UCodeESC_CharStream stream, int lexState)
{
int i;
jjcurKind = 2147483647;
curPos = jjmatchedPos = jjnewStateCnt = jjround = 0;
jjstartStateSet = null;
curChar = (char)0;
jjEOFSeen = false;
   if (lexState >= 5 || lexState < 0)
   {
      System.out.println("Error: Ignoring invalid lexical state : " + lexState + ". Reinitialzing lexer in DEFAULT state.");
      curLexState = defaultLexState;
   }
   else
      curLexState = lexState;
input_stream = stream;
for (i = 89; i-- > 0;)
   jjrounds[i] = 0;
}
public void SwitchTo(int lexState)
{
   if (lexState >= 5 || lexState < 0)
      System.out.println("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.");
   else
      curLexState = lexState;
}


int curLexState = 4;
int defaultLexState = 4;
int jjnewStateCnt;
int jjround;
private boolean jjEOFSeen = false;
int[] jjtmpStates = jjstateSet1;
int jjmatchedPos;
Token matchedToken;
Token jjspecialToken;
private int[] jjstartStateSet;

public Token getNextToken() throws ParseError
{
  matchedToken = new Token();

  EOFLoop : for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      matchedToken.endLine = matchedToken.beginLine = input_stream.getBeginLine();
      matchedToken.endColumn = matchedToken.beginColumn = input_stream.getBeginColumn();
      matchedToken.kind = 0;
      matchedToken.image = "";
      matchedToken.specialToken = jjspecialToken;
      jjspecialToken = null;
      return matchedToken;
   }
   image = null;
   jjimageLen = 0;

   try
   {
    for (;;)
    {
     switch(curLexState)
     {
     case 0:
     {
      matchedToken.kind = 2147483647;
      jjmatchedPos = 0;
      jjMoveStringLiteralDfa0_0();
      while (jjnewStateCnt != 0)
      {
         curChar = input_stream.readChar();
         jjMoveNfa_0(jjstateSet1 = jjstateSet2, jjstateSet2 = jjtmpStates);
         jjtmpStates = jjstateSet1;
         if (jjcurKind != 2147483647)
         {
            matchedToken.kind = jjcurKind;
            jjcurKind = 2147483647;
            jjmatchedPos = curPos++;
         }
         else
            curPos++;
      }
      break;
      }
     case 1:
     {
      matchedToken.kind = 2147483647;
      jjmatchedPos = 0;
      jjMoveStringLiteralDfa0_1();
      while (jjnewStateCnt != 0)
      {
         curChar = input_stream.readChar();
         jjMoveNfa_1(jjstateSet1 = jjstateSet2, jjstateSet2 = jjtmpStates);
         jjtmpStates = jjstateSet1;
         if (jjcurKind != 2147483647)
         {
            matchedToken.kind = jjcurKind;
            jjcurKind = 2147483647;
            jjmatchedPos = curPos++;
         }
         else
            curPos++;
      }
      break;
      }
     case 2:
     {
      matchedToken.kind = 2147483647;
      jjmatchedPos = 0;
      jjMoveStringLiteralDfa0_2();
      while (jjnewStateCnt != 0)
      {
         curChar = input_stream.readChar();
         jjMoveNfa_2(jjstateSet1 = jjstateSet2, jjstateSet2 = jjtmpStates);
         jjtmpStates = jjstateSet1;
         if (jjcurKind != 2147483647)
         {
            matchedToken.kind = jjcurKind;
            jjcurKind = 2147483647;
            jjmatchedPos = curPos++;
         }
         else
            curPos++;
      }
      break;
      }
     case 3:
     {
      matchedToken.kind = 2147483647;
      jjmatchedPos = 0;
      jjMoveStringLiteralDfa0_3();
      while (jjnewStateCnt != 0)
      {
         curChar = input_stream.readChar();
         jjMoveNfa_3(jjstateSet1 = jjstateSet2, jjstateSet2 = jjtmpStates);
         jjtmpStates = jjstateSet1;
         if (jjcurKind != 2147483647)
         {
            matchedToken.kind = jjcurKind;
            jjcurKind = 2147483647;
            jjmatchedPos = curPos++;
         }
         else
            curPos++;
      }
      break;
      }
     case 4:
     {
      matchedToken.kind = 2147483647;
      jjmatchedPos = 0;
      jjMoveStringLiteralDfa0_4();
      break;
      }
     }

      if (matchedToken.kind != 2147483647)
      {
         if (jjmatchedPos + 1 < curPos)
            input_stream.backup(curPos - jjmatchedPos - 1);

         if ((jjtoToken[matchedToken.kind >> 6] &
             (1L << (matchedToken.kind & 077))) != 0L)
         {
            TokenLexicalActions();
            matchedToken.specialToken = jjspecialToken;
            jjspecialToken = null;
            return matchedToken;
         }
         else
         {
            if ((jjtoSpecial[matchedToken.kind >> 6] &
                (1L << (matchedToken.kind & 077))) != 0L)
            {
               if ((matchedToken.image = jjstrLiteralImages[matchedToken.kind]) == null)
                  matchedToken.image = input_stream.GetImage();
               matchedToken.beginLine = input_stream.getBeginLine();
               matchedToken.beginColumn = input_stream.getBeginColumn();
               matchedToken.endLine = input_stream.getEndLine();
               matchedToken.endColumn = input_stream.getEndColumn();
               if (jjspecialToken == null)
                  jjspecialToken = matchedToken;
               else
               {
                  matchedToken.specialToken = jjspecialToken;
                  jjspecialToken = (jjspecialToken.next = matchedToken);
               }
               matchedToken = new Token();
            }
            continue EOFLoop;
         }
      }
      else
      {
         jjme.error_line = input_stream.getEndLine();
         jjme.error_column = input_stream.getEndColumn();
         input_stream.backup(1);
         jjme.error_after = curPos <= 1 ? "" : jjadd_escapes(input_stream.GetImage());
         jjme.LexicalError();

         throw new ParseError();
      }
    }
   }
   catch (java.io.IOException e)
   {
      switch(curLexState)
      {
         default : break;
      }
      if (matchedToken.kind != 2147483647 && matchedToken.kind != 0)
      {
         if (jjmatchedPos + 1 < curPos)
            input_stream.backup(curPos - jjmatchedPos - 1);

         if ((jjtoToken[matchedToken.kind >> 6] &
             (1L << (matchedToken.kind & 077))) != 0L)
         {
            TokenLexicalActions();
            matchedToken.specialToken = jjspecialToken;
            jjspecialToken = null;
            return matchedToken;
         }
         else
         {
            if ((jjtoSpecial[matchedToken.kind >> 6] &
                (1L << (matchedToken.kind & 077))) != 0L)
            {
               if ((matchedToken.image = jjstrLiteralImages[matchedToken.kind]) == null)
                  matchedToken.image = input_stream.GetImage();
               matchedToken.beginLine = input_stream.getBeginLine();
               matchedToken.beginColumn = input_stream.getBeginColumn();
               matchedToken.endLine = input_stream.getEndLine();
               matchedToken.endColumn = input_stream.getEndColumn();
               if (jjspecialToken == null)
                  jjspecialToken = matchedToken;
               else
               {
                  matchedToken.specialToken = jjspecialToken;
                  jjspecialToken = (jjspecialToken.next = matchedToken);
               }
               matchedToken = new Token();
            }
            continue EOFLoop;
         }
      }

      jjme.error_line = input_stream.getEndLine();
      jjme.error_column = input_stream.getEndColumn();
      input_stream.backup(1);
      jjEOFSeen = true;
      jjme.error_after = curPos <= 1 ? "" : jjadd_escapes(input_stream.GetImage());
      jjme.LexicalError();

      throw new ParseError();
   }
  }
}

protected int error_line, error_column;
protected String error_after;
protected void LexicalError()
{
   System.err.println("Lexical error at line " +
        error_line + ", column " +
        error_column + ".  Encountered: " +
        (jjEOFSeen ? "<EOF>" : ("\"" + jjadd_escapes(String.valueOf(curChar)) + "\"") + " (" + (int)curChar + "), ") +
        "after : \"" + jjme.error_after + "\"");
}
final void TokenLexicalActions()
{
   if ((matchedToken.image = jjstrLiteralImages[matchedToken.kind]) == null)
      matchedToken.image = input_stream.GetImage();
   matchedToken.beginLine = input_stream.getBeginLine();
   matchedToken.beginColumn = input_stream.getBeginColumn();
   matchedToken.endLine = input_stream.getEndLine();
   matchedToken.endColumn = input_stream.getEndColumn();

   switch(matchedToken.kind)
   {
      case 1 :
         curLexState = 0;
         break;
      case 7 :
         curLexState = 3;
         break;
      case 8 :
         curLexState = 2;
         break;
      case 21 :
         curLexState = 1;
         break;
      default : 
         break;
   }
}
}
