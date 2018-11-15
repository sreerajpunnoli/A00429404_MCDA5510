<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleTransactionWebserviceImplProxyid" scope="session" class="com.mcda5510.assignment3.service.TransactionWebserviceImplProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleTransactionWebserviceImplProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleTransactionWebserviceImplProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleTransactionWebserviceImplProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.mcda5510.assignment3.service.TransactionWebserviceImpl getTransactionWebserviceImpl10mtemp = sampleTransactionWebserviceImplProxyid.getTransactionWebserviceImpl();
if(getTransactionWebserviceImpl10mtemp == null){
%>
<%=getTransactionWebserviceImpl10mtemp %>
<%
}else{
        if(getTransactionWebserviceImpl10mtemp!= null){
        String tempreturnp11 = getTransactionWebserviceImpl10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String createdBy_2id=  request.getParameter("createdBy18");
            java.lang.String createdBy_2idTemp = null;
        if(!createdBy_2id.equals("")){
         createdBy_2idTemp  = createdBy_2id;
        }
        String cardType_3id=  request.getParameter("cardType20");
            java.lang.String cardType_3idTemp = null;
        if(!cardType_3id.equals("")){
         cardType_3idTemp  = cardType_3id;
        }
        String id_4id=  request.getParameter("id22");
            java.lang.Integer id_4idTemp = null;
        if(!id_4id.equals("")){
         id_4idTemp  = java.lang.Integer.valueOf(id_4id);
        }
        String quantity_5id=  request.getParameter("quantity24");
            java.lang.Integer quantity_5idTemp = null;
        if(!quantity_5id.equals("")){
         quantity_5idTemp  = java.lang.Integer.valueOf(quantity_5id);
        }
        String expDate_6id=  request.getParameter("expDate26");
            java.lang.String expDate_6idTemp = null;
        if(!expDate_6id.equals("")){
         expDate_6idTemp  = expDate_6id;
        }
        String nameOnCard_7id=  request.getParameter("nameOnCard28");
            java.lang.String nameOnCard_7idTemp = null;
        if(!nameOnCard_7id.equals("")){
         nameOnCard_7idTemp  = nameOnCard_7id;
        }
        String unitPrice_8id=  request.getParameter("unitPrice30");
            java.lang.Float unitPrice_8idTemp = null;
        if(!unitPrice_8id.equals("")){
         unitPrice_8idTemp  = java.lang.Float.valueOf(unitPrice_8id);
        }
        String totalPrice_9id=  request.getParameter("totalPrice32");
            java.lang.Float totalPrice_9idTemp = null;
        if(!totalPrice_9id.equals("")){
         totalPrice_9idTemp  = java.lang.Float.valueOf(totalPrice_9id);
        }
        String createdOn_10id=  request.getParameter("createdOn34");
            java.util.Calendar createdOn_10idTemp = null;
        if(!createdOn_10id.equals("")){
        java.text.DateFormat dateFormatcreatedOn34 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempcreatedOn34  = dateFormatcreatedOn34.parse(createdOn_10id);
         createdOn_10idTemp = new java.util.GregorianCalendar();
        createdOn_10idTemp.setTime(dateTempcreatedOn34);
        }
        String cardNo_11id=  request.getParameter("cardNo36");
            java.lang.String cardNo_11idTemp = null;
        if(!cardNo_11id.equals("")){
         cardNo_11idTemp  = cardNo_11id;
        }
        %>
        <jsp:useBean id="com1mcda55101assignment31entity1Transaction_1id" scope="session" class="com.mcda5510.assignment3.entity.Transaction" />
        <%
        com1mcda55101assignment31entity1Transaction_1id.setCreatedBy(createdBy_2idTemp);
        com1mcda55101assignment31entity1Transaction_1id.setCardType(cardType_3idTemp);
        com1mcda55101assignment31entity1Transaction_1id.setId(id_4idTemp);
        com1mcda55101assignment31entity1Transaction_1id.setQuantity(quantity_5idTemp);
        com1mcda55101assignment31entity1Transaction_1id.setExpDate(expDate_6idTemp);
        com1mcda55101assignment31entity1Transaction_1id.setNameOnCard(nameOnCard_7idTemp);
        com1mcda55101assignment31entity1Transaction_1id.setUnitPrice(unitPrice_8idTemp);
        com1mcda55101assignment31entity1Transaction_1id.setTotalPrice(totalPrice_9idTemp);
        com1mcda55101assignment31entity1Transaction_1id.setCreatedOn(createdOn_10idTemp);
        com1mcda55101assignment31entity1Transaction_1id.setCardNo(cardNo_11idTemp);
        boolean updateTransaction13mtemp = sampleTransactionWebserviceImplProxyid.updateTransaction(com1mcda55101assignment31entity1Transaction_1id);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateTransaction13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 38:
        gotMethod = true;
        String transactionId_12id=  request.getParameter("transactionId41");
        int transactionId_12idTemp  = Integer.parseInt(transactionId_12id);
        boolean removeTransaction38mtemp = sampleTransactionWebserviceImplProxyid.removeTransaction(transactionId_12idTemp);
        String tempResultreturnp39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(removeTransaction38mtemp));
        %>
        <%= tempResultreturnp39 %>
        <%
break;
case 43:
        gotMethod = true;
        String createdBy_14id=  request.getParameter("createdBy48");
            java.lang.String createdBy_14idTemp = null;
        if(!createdBy_14id.equals("")){
         createdBy_14idTemp  = createdBy_14id;
        }
        String cardType_15id=  request.getParameter("cardType50");
            java.lang.String cardType_15idTemp = null;
        if(!cardType_15id.equals("")){
         cardType_15idTemp  = cardType_15id;
        }
        String id_16id=  request.getParameter("id52");
            java.lang.Integer id_16idTemp = null;
        if(!id_16id.equals("")){
         id_16idTemp  = java.lang.Integer.valueOf(id_16id);
        }
        String quantity_17id=  request.getParameter("quantity54");
            java.lang.Integer quantity_17idTemp = null;
        if(!quantity_17id.equals("")){
         quantity_17idTemp  = java.lang.Integer.valueOf(quantity_17id);
        }
        String expDate_18id=  request.getParameter("expDate56");
            java.lang.String expDate_18idTemp = null;
        if(!expDate_18id.equals("")){
         expDate_18idTemp  = expDate_18id;
        }
        String nameOnCard_19id=  request.getParameter("nameOnCard58");
            java.lang.String nameOnCard_19idTemp = null;
        if(!nameOnCard_19id.equals("")){
         nameOnCard_19idTemp  = nameOnCard_19id;
        }
        String unitPrice_20id=  request.getParameter("unitPrice60");
            java.lang.Float unitPrice_20idTemp = null;
        if(!unitPrice_20id.equals("")){
         unitPrice_20idTemp  = java.lang.Float.valueOf(unitPrice_20id);
        }
        String totalPrice_21id=  request.getParameter("totalPrice62");
            java.lang.Float totalPrice_21idTemp = null;
        if(!totalPrice_21id.equals("")){
         totalPrice_21idTemp  = java.lang.Float.valueOf(totalPrice_21id);
        }
        String createdOn_22id=  request.getParameter("createdOn64");
            java.util.Calendar createdOn_22idTemp = null;
        if(!createdOn_22id.equals("")){
        java.text.DateFormat dateFormatcreatedOn64 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempcreatedOn64  = dateFormatcreatedOn64.parse(createdOn_22id);
         createdOn_22idTemp = new java.util.GregorianCalendar();
        createdOn_22idTemp.setTime(dateTempcreatedOn64);
        }
        String cardNo_23id=  request.getParameter("cardNo66");
            java.lang.String cardNo_23idTemp = null;
        if(!cardNo_23id.equals("")){
         cardNo_23idTemp  = cardNo_23id;
        }
        %>
        <jsp:useBean id="com1mcda55101assignment31entity1Transaction_13id" scope="session" class="com.mcda5510.assignment3.entity.Transaction" />
        <%
        com1mcda55101assignment31entity1Transaction_13id.setCreatedBy(createdBy_14idTemp);
        com1mcda55101assignment31entity1Transaction_13id.setCardType(cardType_15idTemp);
        com1mcda55101assignment31entity1Transaction_13id.setId(id_16idTemp);
        com1mcda55101assignment31entity1Transaction_13id.setQuantity(quantity_17idTemp);
        com1mcda55101assignment31entity1Transaction_13id.setExpDate(expDate_18idTemp);
        com1mcda55101assignment31entity1Transaction_13id.setNameOnCard(nameOnCard_19idTemp);
        com1mcda55101assignment31entity1Transaction_13id.setUnitPrice(unitPrice_20idTemp);
        com1mcda55101assignment31entity1Transaction_13id.setTotalPrice(totalPrice_21idTemp);
        com1mcda55101assignment31entity1Transaction_13id.setCreatedOn(createdOn_22idTemp);
        com1mcda55101assignment31entity1Transaction_13id.setCardNo(cardNo_23idTemp);
        boolean createTransaction43mtemp = sampleTransactionWebserviceImplProxyid.createTransaction(com1mcda55101assignment31entity1Transaction_13id);
        String tempResultreturnp44 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(createTransaction43mtemp));
        %>
        <%= tempResultreturnp44 %>
        <%
break;
case 68:
        gotMethod = true;
        String transactionId_24id=  request.getParameter("transactionId91");
        int transactionId_24idTemp  = Integer.parseInt(transactionId_24id);
        com.mcda5510.assignment3.entity.Transaction getTransaction68mtemp = sampleTransactionWebserviceImplProxyid.getTransaction(transactionId_24idTemp);
if(getTransaction68mtemp == null){
%>
<%=getTransaction68mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">createdBy:</TD>
<TD>
<%
if(getTransaction68mtemp != null){
java.lang.String typecreatedBy71 = getTransaction68mtemp.getCreatedBy();
        String tempResultcreatedBy71 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecreatedBy71));
        %>
        <%= tempResultcreatedBy71 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cardType:</TD>
<TD>
<%
if(getTransaction68mtemp != null){
java.lang.String typecardType73 = getTransaction68mtemp.getCardType();
        String tempResultcardType73 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecardType73));
        %>
        <%= tempResultcardType73 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getTransaction68mtemp != null){
java.lang.Integer typeid75 = getTransaction68mtemp.getId();
        String tempResultid75 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeid75));
        %>
        <%= tempResultid75 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">quantity:</TD>
<TD>
<%
if(getTransaction68mtemp != null){
java.lang.Integer typequantity77 = getTransaction68mtemp.getQuantity();
        String tempResultquantity77 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typequantity77));
        %>
        <%= tempResultquantity77 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">expDate:</TD>
<TD>
<%
if(getTransaction68mtemp != null){
java.lang.String typeexpDate79 = getTransaction68mtemp.getExpDate();
        String tempResultexpDate79 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeexpDate79));
        %>
        <%= tempResultexpDate79 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nameOnCard:</TD>
<TD>
<%
if(getTransaction68mtemp != null){
java.lang.String typenameOnCard81 = getTransaction68mtemp.getNameOnCard();
        String tempResultnameOnCard81 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenameOnCard81));
        %>
        <%= tempResultnameOnCard81 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">unitPrice:</TD>
<TD>
<%
if(getTransaction68mtemp != null){
java.lang.Float typeunitPrice83 = getTransaction68mtemp.getUnitPrice();
        String tempResultunitPrice83 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeunitPrice83));
        %>
        <%= tempResultunitPrice83 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">totalPrice:</TD>
<TD>
<%
if(getTransaction68mtemp != null){
java.lang.Float typetotalPrice85 = getTransaction68mtemp.getTotalPrice();
        String tempResulttotalPrice85 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetotalPrice85));
        %>
        <%= tempResulttotalPrice85 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">createdOn:</TD>
<TD>
<%
if(getTransaction68mtemp != null){
java.util.Calendar typecreatedOn87 = getTransaction68mtemp.getCreatedOn();
        java.text.DateFormat dateFormatcreatedOn87 = java.text.DateFormat.getDateInstance();
        java.util.Date datecreatedOn87 = typecreatedOn87.getTime();
        String tempResultcreatedOn87 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatcreatedOn87.format(datecreatedOn87));
        %>
        <%= tempResultcreatedOn87 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cardNo:</TD>
<TD>
<%
if(getTransaction68mtemp != null){
java.lang.String typecardNo89 = getTransaction68mtemp.getCardNo();
        String tempResultcardNo89 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecardNo89));
        %>
        <%= tempResultcardNo89 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>