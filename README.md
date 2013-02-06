mondo
=====

Mondo was an object markup language (OML) that was trying to be simpler and more flexible than XML.  Effectively it was a more XML-like version of JSON but a bit better for textual content.

Note that the capital COM package prefix was actually the Sun/Javasoft defined standard back in the mid 1990s.


### BNF -- Non-Terminals
<TABLE>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod1">Element</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE>&lt;TAGO&gt; &lt;Name&gt; ( <A HREF="#prod2">Parameter</A> | <A HREF="#prod3">UnnamedParameter</A> )* &lt;TAGC&gt;</TD>
</TR>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod2">Parameter</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE>&lt;Name&gt; ( &lt;EQ&gt; <A HREF="#prod4">Value</A> )?</TD>
</TR>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod3">UnnamedParameter</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE><A HREF="#prod5">DelimitedValue</A></TD>
</TR>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod4">Value</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE>( <A HREF="#prod6">DirectValue</A> | <A HREF="#prod5">DelimitedValue</A> )</TD>
</TR>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod6">DirectValue</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE>&lt;DirectLiteral&gt;</TD>
</TR>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod5">DelimitedValue</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE>( <A HREF="#prod7">StringLiteral</A> | <A HREF="#prod1">Element</A> | <A HREF="#prod8">List</A> | <A HREF="#prod9">Text</A> )</TD>
</TR>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod7">StringLiteral</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE>( &lt;StringSQ&gt; | &lt;StringDQ&gt; | &lt;StringLQ&gt; | &lt;StringVLQ&gt; )</TD>
</TR>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod8">List</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE>&lt;LSTO&gt; <A HREF="#prod10">ListItems</A> &lt;LSTC&gt;</TD>
</TR>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod10">ListItems</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE>( <A HREF="#prod4">Value</A> )*</TD>
</TR>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod9">Text</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE>&lt;TXTO&gt; <A HREF="#prod11">TextItems</A> &lt;TXTC&gt;</TD>
</TR>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod11">TextItems</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE>( ( &lt;Chars&gt; | <A HREF="#prod1">Element</A> ) )*</TD>
</TR>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod12">ObjectListFile</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE><A HREF="#prod10">ListItems</A> &lt;EOF&gt;</TD>
</TR>
<TR>
<TD ALIGN=RIGHT VALIGN=BASELINE><A NAME="prod13">TextFile</A></TD>
<TD ALIGN=CENTER VALIGN=BASELINE>::=</TD>
<TD ALIGN=LEFT VALIGN=BASELINE><A HREF="#prod11">TextItems</A> &lt;EOF&gt;</TD>
</TR>
</TABLE>
