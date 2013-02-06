/***********************************************************************
**
**  File: chimu/mondoOml/parser/OmlParser.java
**     IntegrationVersion: v0.2 [971205]
**
**  Copyright (c) 1997, ChiMu Corporation.
**  See the file COPYING for copying permission.
**
***********************************************************************/

package COM.chimu.mondoOml.parser;
import java.util.Stack;

public class OmlParser implements OmlParserConstants {

    public static void main(String args[]) {
        OmlParser parser;
        if (args.length == 0) {
            System.out.println("Oml Parser Version 0.1:  Reading from standard input . . .");
            parser = new OmlParser(new java.io.DataInputStream(System.in));
        } else if (args.length == 1) {
            System.out.println("Oml Parser Version 0.1:  Reading from file " + args[0] + " . . .");
            try {
                parser = new OmlParser(new java.io.DataInputStream(new java.io.FileInputStream(args[0])));
            } catch (java.io.FileNotFoundException e) {
                System.out.println("Oml Parser Version 0.1:  File " + args[0] + " not found.");
                return;
            }
        } else {
            System.out.println("Oml Parser Version 0.2:  Usage is one of:");
            System.out.println("         java COM.chimu.ocmlparser.OmlParser < inputfile");
            System.out.println("OR");
            System.out.println("         java COM.chimu.ocmlparser.OmlParser inputfile");
            return;
        }
        try {
            parser.setupForText();
            parser.TextItems();
            System.out.println("Oml Parser Version 0.1:  Oml Document parsed successfully.");

            SimpleNode rootNode = (SimpleNode) parser.jjtree.rootNode();
            rootNode.dump("");
            Visitor visitor = new DumpVisitorClass();
            visitor.visitSimpleNode(rootNode);

        } catch (ParseError e) {
            System.out.println("Oml Parser Version 0.1:  Encountered errors during parse.");
            System.out.println("Parsed the following tree:");
            SimpleNode rootNode = (SimpleNode) parser.jjtree.rootNode();
            rootNode.dump("");
        }
    }

    //******************************************
    //******************************************
    //******************************************

        /**
         * pushLexState and popLexState handle
         * the return from a lexical mode to its
         * enclosing state when the enclosing state
         * may vary.  This occurs for Element
         * because Elements can be within other Elements
         * (as a ParameterValue) or with Content.
         */
    void pushLexState() {
        stateStack[stackPos++] = lexState;
        // stateStack.push(new Integer(lexState));
        lexState = token_source.curLexState;
    }

    void popLexState() {
        lexState = stateStack[--stackPos];
        // lexState = ((Integer) stateStack.pop()).intValue();
        token_source.SwitchTo(lexState);
    }

    public JJTOmlParserState jjtree() {
        return jjtree;
    }

    public SimpleNode rootParseNode() {
        try {
            return (SimpleNode) this.jjtree.rootNode();
        } catch (Exception e) {};
        return null;
    }

    private int   lexState   = TextSect;
    private int[] stateStack = new int[100];
    private int   stackPos   = 0;

 //   private Stack stateStack = new Stack();

    //******************************************
    //******************************************
    //******************************************

    public void setupForContent() {
        lexState = TextSect;
        token_source.SwitchTo(lexState);
    }

    public void setupForText() {
        lexState = TextSect;
        token_source.SwitchTo(lexState);
    }

    public void setupForList() {
        lexState = ListSect;
        token_source.SwitchTo(lexState);
    }

    public void setupForElement() {
        lexState = ElementSect;
        token_source.SwitchTo(lexState);
    }


    //******************************************
    //******************************************
    //******************************************

    void elementCloseMismatchError(String openName, String closeName, Token beginTok, Token endTok) {
        int beginLine   = beginTok.beginLine;
        int beginColumn = beginTok.beginColumn;
        int endLine     = endTok.endLine;
        int endColumn   = endTok.endColumn;

        System.err.println(
                "Element opened with "+openName+" but closed with "+closeName+
                " ("+beginLine+":"+beginColumn+"->"+endLine+":"+endColumn+
                ") "
            );
    }
  protected JJTOmlParserState jjtree = new JJTOmlParserState();

/*****************************************
 * OML GRAMMAR STARTS HERE *
 *****************************************/



//******************************************
//******************************************
//******************************************
  final public SimpleNode Element() throws ParseError {
Token tok;
    Token beginTok, endTok;
    String openName, closeName;
    SimpleNode  node  = null;
jjtree.openIndefiniteNode(AST_Element.jjtCreate("Element"));
    beginTok = jj_consume_token(TAGO);
                   try {
AST_Element jjtThis = (AST_Element)jjtree.currentNode();
pushLexState();
} finally {
}
    tok = jj_consume_token(Name);
              try {
AST_Element jjtThis = (AST_Element)jjtree.currentNode();
jjtThis.setName(tok.image); openName = tok.image.toUpperCase();
} finally {
}
    label_1:
    while (true) {
      if (jj_mask_0[getToken(1).kind]) {
        ;
      } else {
        jj_expLA1[0] = jj_gen;
        break label_1;
      }
      if (jj_mask_2[getToken(1).kind]) {
        node = Parameter();
      } else {
        jj_expLA1[2] = jj_gen;
        if (jj_mask_1[getToken(1).kind]) {
          UnnamedParameter();
                                             try {
AST_Element jjtThis = (AST_Element)jjtree.currentNode();
node = null;
} finally {
}
        } else {
          jj_expLA1[1] = jj_gen;
          jj_consume_token(-1);
          throw new ParseError();
        }
      }
    }
    endTok = jj_consume_token(TAGC);
                     try {
AST_Element jjtThis = (AST_Element)jjtree.currentNode();
popLexState();

        if (node != null) {  //We have a potention closing label
            AST_Parameter parameter = (AST_Parameter) node;
            if ( parameter.hasNoValue() ) {
                closeName = parameter.name.toUpperCase();
                if (! closeName.equals(openName) ) {
                    elementCloseMismatchError(openName, closeName, beginTok, endTok);
                }
            }
        }
} finally {
}
jjtree.closeIndefiniteNode();
  try {
AST_Element jjtThis = (AST_Element)jjtree.currentNode();
return jjtThis;
} finally {
jjtree.updateCurrentNode(1);
}
  }

  static boolean[] jj_mask_0 = new boolean[31];
  static {
    jj_mask_0[TAGO] =
    jj_mask_0[TXTO] =
    jj_mask_0[LSTO] =
    jj_mask_0[StringSQ] =
    jj_mask_0[StringDQ] =
    jj_mask_0[StringLQ] =
    jj_mask_0[StringVLQ] =
    jj_mask_0[Name] = true;
  }
  static boolean[] jj_mask_1 = new boolean[31];
  static {
    jj_mask_1[TAGO] =
    jj_mask_1[TXTO] =
    jj_mask_1[LSTO] =
    jj_mask_1[StringSQ] =
    jj_mask_1[StringDQ] =
    jj_mask_1[StringLQ] =
    jj_mask_1[StringVLQ] = true;
  }
  static boolean[] jj_mask_2 = new boolean[31];
  static {
    jj_mask_2[Name] = true;
  }
  
  final public SimpleNode Parameter() throws ParseError {
Token tok;
    Token value = null;
    Node  node = null;
jjtree.openIndefiniteNode(AST_Parameter.jjtCreate("Parameter"));
    tok = jj_consume_token(Name);
              try {
AST_Parameter jjtThis = (AST_Parameter)jjtree.currentNode();
jjtThis.setName(tok.image);
} finally {
}
    if (jj_mask_3[getToken(1).kind]) {
      jj_consume_token(EQ);
      Value();
    } else {
      jj_expLA1[3] = jj_gen;
      ;
    }
jjtree.closeIndefiniteNode();
  try {
AST_Parameter jjtThis = (AST_Parameter)jjtree.currentNode();
return jjtThis;
} finally {
jjtree.updateCurrentNode(1);
}
  }

  static boolean[] jj_mask_3 = new boolean[31];
  static {
    jj_mask_3[EQ] = true;
  }
  
  final public SimpleNode UnnamedParameter() throws ParseError {
jjtree.openIndefiniteNode(AST_UnnamedParameter.jjtCreate("UnnamedParameter"));
    DelimitedValue();
jjtree.closeIndefiniteNode();
  try {
AST_UnnamedParameter jjtThis = (AST_UnnamedParameter)jjtree.currentNode();
return jjtThis;
} finally {
jjtree.updateCurrentNode(1);
}
  }

//******************************************
//******************************************
//******************************************
  final public SimpleNode Value() throws ParseError {
Node  node = null;
    if (jj_mask_5[getToken(1).kind]) {
      node = DirectValue();
    } else {
      jj_expLA1[5] = jj_gen;
      if (jj_mask_4[getToken(1).kind]) {
        node = DelimitedValue();
      } else {
        jj_expLA1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseError();
      }
    }
                                                     try {
return (SimpleNode) node;
} finally {
}
  }

  static boolean[] jj_mask_4 = new boolean[31];
  static {
    jj_mask_4[TAGO] =
    jj_mask_4[TXTO] =
    jj_mask_4[LSTO] =
    jj_mask_4[StringSQ] =
    jj_mask_4[StringDQ] =
    jj_mask_4[StringLQ] =
    jj_mask_4[StringVLQ] = true;
  }
  static boolean[] jj_mask_5 = new boolean[31];
  static {
    jj_mask_5[DirectLiteral] = true;
  }
  
  final public SimpleNode DirectValue() throws ParseError {
Token value = null;
jjtree.openIndefiniteNode(AST_DirectValue.jjtCreate("DirectValue"));
   try {
AST_DirectValue jjtThis = (AST_DirectValue)jjtree.currentNode();
pushLexState();
} finally {
}
    value = jj_consume_token(DirectLiteral);
                         try {
AST_DirectValue jjtThis = (AST_DirectValue)jjtree.currentNode();
popLexState();
} finally {
}
jjtree.closeIndefiniteNode();
  try {
AST_DirectValue jjtThis = (AST_DirectValue)jjtree.currentNode();
jjtThis.setValue(value.image);  return jjtThis;
} finally {
jjtree.updateCurrentNode(1);
}
  }

  final public SimpleNode DelimitedValue() throws ParseError {
Node  node = null;
   try {
pushLexState();
} finally {
}
    if (jj_mask_9[getToken(1).kind]) {
      node = StringLiteral();
    } else {
      jj_expLA1[9] = jj_gen;
      if (jj_mask_8[getToken(1).kind]) {
        node = Element();
      } else {
        jj_expLA1[8] = jj_gen;
        if (jj_mask_7[getToken(1).kind]) {
          node = List();
        } else {
          jj_expLA1[7] = jj_gen;
          if (jj_mask_6[getToken(1).kind]) {
            node = Text();
          } else {
            jj_expLA1[6] = jj_gen;
            jj_consume_token(-1);
            throw new ParseError();
          }
        }
      }
    }
                                                                              try {
popLexState();
} finally {
}
   try {
return (SimpleNode) node;
} finally {
}
  }

  static boolean[] jj_mask_6 = new boolean[31];
  static {
    jj_mask_6[TXTO] = true;
  }
  static boolean[] jj_mask_7 = new boolean[31];
  static {
    jj_mask_7[LSTO] = true;
  }
  static boolean[] jj_mask_8 = new boolean[31];
  static {
    jj_mask_8[TAGO] = true;
  }
  static boolean[] jj_mask_9 = new boolean[31];
  static {
    jj_mask_9[StringSQ] =
    jj_mask_9[StringDQ] =
    jj_mask_9[StringLQ] =
    jj_mask_9[StringVLQ] = true;
  }
  
//******************************************
//******************************************
//******************************************
  final public SimpleNode StringLiteral() throws ParseError {
Token value = null;
jjtree.openIndefiniteNode(AST_String.jjtCreate("String"));
    if (jj_mask_13[getToken(1).kind]) {
      value = jj_consume_token(StringSQ);
jjtree.closeIndefiniteNode();
  try {
AST_String jjtThis = (AST_String)jjtree.currentNode();
jjtThis.setValue_unquote(value.image,1); return jjtThis;
} finally {
jjtree.updateCurrentNode(1);
}
    } else {
      jj_expLA1[13] = jj_gen;
      if (jj_mask_12[getToken(1).kind]) {
        value = jj_consume_token(StringDQ);
jjtree.closeIndefiniteNode();
  try {
AST_String jjtThis = (AST_String)jjtree.currentNode();
jjtThis.setValue_unquote(value.image,1); return jjtThis;
} finally {
jjtree.updateCurrentNode(1);
}
      } else {
        jj_expLA1[12] = jj_gen;
        if (jj_mask_11[getToken(1).kind]) {
          value = jj_consume_token(StringLQ);
jjtree.closeIndefiniteNode();
  try {
AST_String jjtThis = (AST_String)jjtree.currentNode();
jjtThis.setValue_unquoteDChar(value.image,'['); return jjtThis;
} finally {
jjtree.updateCurrentNode(1);
}
        } else {
          jj_expLA1[11] = jj_gen;
          if (jj_mask_10[getToken(1).kind]) {
            value = jj_consume_token(StringVLQ);
jjtree.closeIndefiniteNode();
  try {
AST_String jjtThis = (AST_String)jjtree.currentNode();
jjtThis.setValue_unquoteDChar(value.image,'['); return jjtThis;
} finally {
jjtree.updateCurrentNode(1);
}
          } else {
            jj_expLA1[10] = jj_gen;
            jj_consume_token(-1);
            throw new ParseError();
          }
        }
      }
    }
  }

  static boolean[] jj_mask_10 = new boolean[31];
  static {
    jj_mask_10[StringVLQ] = true;
  }
  static boolean[] jj_mask_11 = new boolean[31];
  static {
    jj_mask_11[StringLQ] = true;
  }
  static boolean[] jj_mask_12 = new boolean[31];
  static {
    jj_mask_12[StringDQ] = true;
  }
  static boolean[] jj_mask_13 = new boolean[31];
  static {
    jj_mask_13[StringSQ] = true;
  }
  
//******************************************
//******************************************
//******************************************
  final public SimpleNode List() throws ParseError {
SimpleNode  node  = null;
    jj_consume_token(LSTO);
          try {
pushLexState();
} finally {
}
    node = ListItems();
    jj_consume_token(LSTC);
                           try {
popLexState();  return (SimpleNode) node;
} finally {
}
  }

  final public SimpleNode ListItems() throws ParseError {
SimpleNode  node  = null;
jjtree.openIndefiniteNode(AST_List.jjtCreate("List"));
    label_2:
    while (true) {
      if (jj_mask_14[getToken(1).kind]) {
        ;
      } else {
        jj_expLA1[14] = jj_gen;
        break label_2;
      }
      node = Value();
                   try {
AST_List jjtThis = (AST_List)jjtree.currentNode();
jjtThis.appendNode(node);
} finally {
}
    }
jjtree.closeIndefiniteNode();
  try {
AST_List jjtThis = (AST_List)jjtree.currentNode();
return jjtThis;
} finally {
jjtree.updateCurrentNode(1);
}
  }

  static boolean[] jj_mask_14 = new boolean[31];
  static {
    jj_mask_14[TAGO] =
    jj_mask_14[TXTO] =
    jj_mask_14[LSTO] =
    jj_mask_14[StringSQ] =
    jj_mask_14[StringDQ] =
    jj_mask_14[StringLQ] =
    jj_mask_14[StringVLQ] =
    jj_mask_14[DirectLiteral] = true;
  }
  
//******************************************
//******************************************
//******************************************
  final public SimpleNode Text() throws ParseError {
Token       value = null;
    SimpleNode  node  = null;
    jj_consume_token(TXTO);
          try {
pushLexState();
} finally {
}
    node = TextItems();
    jj_consume_token(TXTC);
                           try {
popLexState();  return (SimpleNode) node;
} finally {
}
  }

  final public SimpleNode TextItems() throws ParseError {
Token       value = null;
    SimpleNode  node  = null;
jjtree.openIndefiniteNode(AST_Text.jjtCreate("Text"));
    label_3:
    while (true) {
      if (jj_mask_15[getToken(1).kind]) {
        ;
      } else {
        jj_expLA1[15] = jj_gen;
        break label_3;
      }
      if (jj_mask_17[getToken(1).kind]) {
        value = jj_consume_token(Chars);
      } else {
        jj_expLA1[17] = jj_gen;
        if (jj_mask_16[getToken(1).kind]) {
          node = Element();
        } else {
          jj_expLA1[16] = jj_gen;
          jj_consume_token(-1);
          throw new ParseError();
        }
      }
                                            try {
AST_Text jjtThis = (AST_Text)jjtree.currentNode();
if (value != null) {
                jjtThis.appendChars(value.image);
                value = null;
            };
            if (node != null) {
                jjtThis.appendNode(node);
                node = null;
            };
} finally {
}
    }
jjtree.closeIndefiniteNode();
  try {
AST_Text jjtThis = (AST_Text)jjtree.currentNode();
return jjtThis;
} finally {
jjtree.updateCurrentNode(1);
}
  }

  static boolean[] jj_mask_15 = new boolean[31];
  static {
    jj_mask_15[TAGO] =
    jj_mask_15[Chars] = true;
  }
  static boolean[] jj_mask_16 = new boolean[31];
  static {
    jj_mask_16[TAGO] = true;
  }
  static boolean[] jj_mask_17 = new boolean[31];
  static {
    jj_mask_17[Chars] = true;
  }
  
//******************************************
//******************************************
//******************************************
  final public void ObjectListFile() throws ParseError {
   try {
setupForList();
} finally {
}
    ListItems();
    jj_consume_token(0);
  }

/*
 * Program structuring syntax follows.
 */
//Disable the <EOF>??
  final public void TextFile() throws ParseError {
   try {
setupForText();
} finally {
}
    TextItems();
    jj_consume_token(0);
  }

  public OmlParserTokenManager token_source;
  public Token token;
  private OmlParser jj_me;
  private int jj_gen;
  private int[] jj_expLA1 = new int[18];

  public OmlParser(java.io.InputStream stream) {
    ASCII_UCodeESC_CharStream input_stream = new ASCII_UCodeESC_CharStream(stream, 1, 1);
    token_source = new OmlParserTokenManager(input_stream);
    token = new Token();
    jj_me = this;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_expLA1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
    ASCII_UCodeESC_CharStream input_stream = new ASCII_UCodeESC_CharStream(stream, 1, 1);
    token_source.ReInit(input_stream);
    token = new Token();
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_expLA1[i] = -1;
  }

  public OmlParser(OmlParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_me = this;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_expLA1[i] = -1;
  }

  public void ReInit(OmlParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_expLA1[i] = -1;
  }

  final private Token jj_consume_token(int kind) throws ParseError {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    jj_token_error_setup(token, kind);
    throw new ParseError();
  }

  final public Token getNextToken() throws ParseError {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) throws ParseError {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static final String jj_add_escapes(String str) {
    String retval = "";
    char ch;
    for (int i = 0; i < str.length(); i++) {
      ch = str.charAt(i);
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

  protected int error_line;
  protected int error_column;
  protected String error_string;
  protected String[] expected_tokens;

  protected void token_error() {
    System.out.println("");
    System.out.println("Parse error at line " + error_line + ", column " + error_column + ".  Encountered:");
    System.out.println("    \"" + jj_add_escapes(error_string) + "\"");
    System.out.println("");
    if (expected_tokens.length == 1) {
      System.out.println("Was expecting:");
    } else {
      System.out.println("Was expecting one of:");
    }
    for (int i = 0; i < expected_tokens.length; i++) {
      System.out.println("    " + expected_tokens[i]);
    }
    System.out.println("");
  }

  private java.util.Vector jj_errortokens = new java.util.Vector();

  final private void jj_token_error_setup(Token current, int kind) throws ParseError {
    jj_errortokens.removeAllElements();
    boolean[] la1tokens = new boolean[31];
    boolean[] mask = null;
    for (int i = 0; i < 31; i++) {
      la1tokens[i] = false;
    }
    if (kind >= 0) la1tokens[kind] = true;
    for (int i = 0; i < 18; i++) {
      if (jj_expLA1[i] == jj_gen) {
        switch (i) {
          case 0: mask = jj_mask_0; break;
          case 1: mask = jj_mask_1; break;
          case 2: mask = jj_mask_2; break;
          case 3: mask = jj_mask_3; break;
          case 4: mask = jj_mask_4; break;
          case 5: mask = jj_mask_5; break;
          case 6: mask = jj_mask_6; break;
          case 7: mask = jj_mask_7; break;
          case 8: mask = jj_mask_8; break;
          case 9: mask = jj_mask_9; break;
          case 10: mask = jj_mask_10; break;
          case 11: mask = jj_mask_11; break;
          case 12: mask = jj_mask_12; break;
          case 13: mask = jj_mask_13; break;
          case 14: mask = jj_mask_14; break;
          case 15: mask = jj_mask_15; break;
          case 16: mask = jj_mask_16; break;
          case 17: mask = jj_mask_17; break;
        }
        for (int j = 0; j < 31; j++) {
          if (mask[j]) la1tokens[j] = true;
        }
      }
    }
    if (la1tokens[0]) {
      jj_errortokens.addElement(tokenImage[0] + " ");
    }
    for (int i = 1; i < 31; i++) {
      if (la1tokens[i]) {
        jj_errortokens.addElement(tokenImage[i] + " ...");
      }
    }
    expected_tokens = new String[jj_errortokens.size()];
    for (int i = 0; i < jj_errortokens.size(); i++) {
      expected_tokens[i] = (String)(jj_errortokens.elementAt(i));
    }
    error_line = current.beginLine;
    error_column = current.beginColumn;
    if (current.kind == 0) {
      error_string = tokenImage[0];
    } else {
      error_string = current.image;
    }
    jj_me.token_error();
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

    //******************************************
    //******************************************
    //******************************************

}
final class JJTOmlParserState {
  /* JJTree builds the AST bottom up.  It constructs nodes and places
     them on a stack.  When all the children have been assembled, they
     are added to their parent and popped from the stack. */
  private JJTOmlParserNodeStack nodes;

  /* The current node is kept on the top of this stack so that user
     actions can always refer to it. */
  private java.util.Stack current_nodes;

  /* We keep track of whether a node was actually created.  Definite
     and indefinite nodes always are, but GT nodes are only closed and
     pushed on the stack if their conditions are true. */
  private boolean node_created;

  JJTOmlParserState() {
    nodes = new JJTOmlParserNodeStack();
    current_nodes = new java.util.Stack();
  }

  /* Determine whether the current node was actually closed and pushed */
  boolean nodeCreated() {
    return node_created;
  }

  /* Called when the current node has been completely finished with.
     Makes a new node the current node. */
  void updateCurrentNode(int n) {
    for (int i = 0; i < n; ++i) {
      current_nodes.pop();
    }
  }

  /* Call this to reinitialize the node stack.  */
  void reset() {
    nodes.empty();
    current_nodes = new java.util.Stack();
  }

  /* Return the root node of the AST. */
  Node rootNode() {
    return nodes.elementAt(0);
  }

  /* Return the most recently constructed node. */
  Node currentNode() {
    return (Node)current_nodes.peek();
  }

  /* Push a node on to the stack. */
  void pushNode(Node n) {
    nodes.push(n);
  }

  /* Return the node on the top of the stack, and remove it from the
     stack.  */
  Node popNode() {
    return nodes.pop();
  }

  /* Return the node currently on the top of the stack. */
  Node peekNode() {
    return nodes.peek();
  }

  /* An indefinite node has an unspecified number of children.  When
     it is closed it collects up all nodes that have been pushed since
     it was begun and becomes their parent, and then it is pushed on
     to the stack. */

  void openIndefiniteNode(Node n) {
    current_nodes.push(n);
    nodes.mark();
  }

  void closeIndefiniteNode() {
    Node n = currentNode();
    n.jjtOpen();
    for (JJTOmlParserNodeEnum e = nodes.elementsSinceLastMark();
          e.hasMoreElements(); ) {
      Node c = (Node)e.nextElement();
      c.jjtSetParent(n);
      n.jjtAddChild(c);
    }
    nodes.popToLastMark();
    n.jjtClose();
    nodes.push(n);
    node_created = true;
  }

  /* A definite node is constructed from a fixed number of children.
     That number of nodes are popped from the stack and made the
     children of the definite node.  Then the definite node is pushed
     on to the stack. */

  void openDefiniteNode(Node n) {
    current_nodes.push(n);
  }

  void closeDefiniteNode(int num) {
    Node n = currentNode();
    n.jjtOpen();
    for (JJTOmlParserNodeEnum e = nodes.elementsTop(num); e.hasMoreElements(); ) {
      Node c = (Node)e.nextElement();
      c.jjtSetParent(n);
      n.jjtAddChild(c);
    }
    nodes.popTop(num);
    n.jjtClose();
    nodes.push(n);
    node_created = true;
  }

  /* A GT (Greater Than) node is constructed if more than the
     specified number of nodes have been pushed since it was begun.
     All those nodes are made children of the the GT node, which is
     then pushed on to the stack.  If fewer have been pushed the node
     is not constructed and they are left on the stack. */

  void openGTNode(Node n) {
    current_nodes.push(n);
    nodes.mark();
  }

  void closeGTNode(int num) {
    if (nodes.numElementsSinceLastMark() > num) {
      closeIndefiniteNode();
    } else {
      nodes.removeLastMark();
      node_created = false;
    }
  }
}

final class JJTOmlParserNodeStack {
  private Node[] nodeStack;
  private int[] markStack;
  private int nodeSP;
  private int markSP;

  JJTOmlParserNodeStack() {
    nodeStack = new Node[500];
    markStack = new int[500];
    nodeSP = 0;
    markSP = 0;
  }

  void empty() {
    if (nodeSP > 0) {
      while (--nodeSP >= 0) {
         nodeStack[nodeSP] = null;
      }
    }
    nodeSP = 0;
    markSP = 0;
  }

  Node elementAt(int i) {
    return nodeStack[i];
  }

  Node elementFromTop(int i) {
    return nodeStack[nodeSP - i - 1];
  }

  void push(Node n) {
    if (nodeSP == nodeStack.length) {
      Node[] ns = new Node[nodeStack.length * 2];
      System.arraycopy(nodeStack, 0, ns, 0, nodeStack.length);
      nodeStack = ns;
    }
    nodeStack[nodeSP++] = n;
  }

  Node pop() {
    Node n = nodeStack[--nodeSP];
    nodeStack[nodeSP] = null;
    return n;
  }

  Node peek() {
    return nodeStack[nodeSP - 1];
  }

  void mark() {
    if (markSP == markStack.length) {
      int[] ms = new int[markStack.length * 2];
      System.arraycopy(markStack, 0, ms, 0, markStack.length);
      markStack = ms;
    }
    markStack[markSP++] = nodeSP;
  }

  void removeLastMark() {
    --markSP;
  }

  int numElementsSinceLastMark() {
    return nodeSP - markStack[markSP - 1];
  }

  JJTOmlParserNodeEnum elementsSinceLastMark() {
    return new JJTOmlParserNodeEnum(nodeStack, nodeSP, markStack[markSP - 1]);
  }

  void popToLastMark() {
    --markSP;
    while (nodeSP > markStack[markSP]) {
      nodeStack[--nodeSP] = null;
    }
  }

  JJTOmlParserNodeEnum elementsTop(int n) {
    return new JJTOmlParserNodeEnum(nodeStack, nodeSP, nodeSP - n);
  }

  void popTop(int n) {
    for (int i = 0; i < n; ++i) {
      nodeStack[--nodeSP] = null;
    }
  }
}

final class JJTOmlParserNodeEnum implements java.util.Enumeration {
  private Node[] nodes;
  private int topSP, index;

  JJTOmlParserNodeEnum(Node[] s, int top, int start) {
    nodes = s;
    topSP = top;
    index = start;
  }

  public boolean hasMoreElements() {
    return index < topSP;
  }

  public Object nextElement() {
    return nodes[index++];
  }
}
