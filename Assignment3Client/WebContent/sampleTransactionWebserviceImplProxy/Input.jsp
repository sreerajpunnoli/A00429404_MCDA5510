<%@page contentType="text/html;charset=UTF-8"%>
<HTML>
<HEAD>
<TITLE>Inputs</TITLE>
</HEAD>
<BODY>
<H1>Inputs</H1>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

boolean valid = true;

if(methodID != -1) methodID = Integer.parseInt(method);
switch (methodID){ 
case 2:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 5:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">endpoint:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="endpoint8" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 10:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 13:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">transactionId:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="transactionId36" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 38:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">transaction:</TD>
<TR HIDDEN="TRUE">
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">createdBy:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="createdBy43" SIZE=20></TD>
</TR>
<TR HIDDEN="TRUE">
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cardType:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cardType45" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="id47" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">quantity:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="quantity49" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">expDate:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="expDate51" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nameOnCard:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="nameOnCard53" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">unitPrice:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="unitPrice55" SIZE=20></TD>
</TR>
<TR HIDDEN="TRUE">
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">totalPrice:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="totalPrice57" SIZE=20></TD>
</TR>
<TR HIDDEN="TRUE">
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">createdOn:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="createdOn59" SIZE=20></TD>
<%
java.text.DateFormat dateFormatcreatedOn59 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampcreatedOn59  = new java.util.GregorianCalendar();
java.util.Date datecreatedOn59 = gcExampcreatedOn59.getTime();
String tempResultcreatedOn59 = dateFormatcreatedOn59.format(datecreatedOn59);
%>
<TD ALIGN="left">
</TR>
<TR HIDDEN="TRUE">
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultcreatedOn59 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cardNo:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cardNo61" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 63:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">transaction:</TD>
<TR HIDDEN="TRUE">
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">createdBy:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="createdBy68" SIZE=20></TD>
</TR>
<TR HIDDEN="TRUE">
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cardType:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cardType70" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="id72" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">quantity:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="quantity74" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">expDate:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="expDate76" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nameOnCard:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="nameOnCard78" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">unitPrice:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="unitPrice80" SIZE=20></TD>
</TR>
<TR HIDDEN="TRUE">
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">totalPrice:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="totalPrice82" SIZE=20></TD>
</TR>
<TR HIDDEN="TRUE">
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">createdOn:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="createdOn84" SIZE=20></TD>
<%
java.text.DateFormat dateFormatcreatedOn84 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampcreatedOn84  = new java.util.GregorianCalendar();
java.util.Date datecreatedOn84 = gcExampcreatedOn84.getTime();
String tempResultcreatedOn84 = dateFormatcreatedOn84.format(datecreatedOn84);
%>
<TD ALIGN="left">
</TR>
<TR HIDDEN="TRUE">
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultcreatedOn84 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cardNo:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cardNo86" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 88:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">transactionId:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="transactionId91" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 1111111111:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">URLString:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="url1111111111" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 1111111112:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
}
if (valid) {
%>
Select a method to test.
<%
}
%>

</BODY>
</HTML>
