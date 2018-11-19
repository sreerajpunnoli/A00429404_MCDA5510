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
        String transactionId_1id=  request.getParameter("transactionId36");
        int transactionId_1idTemp  = Integer.parseInt(transactionId_1id);
        com.mcda5510.assignment3.entity.Transaction getTransaction13mtemp = sampleTransactionWebserviceImplProxyid.getTransaction(transactionId_1idTemp);
if(getTransaction13mtemp == null){
%>
<%=getTransaction13mtemp %>
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
if(getTransaction13mtemp != null){
java.lang.String typecreatedBy16 = getTransaction13mtemp.getCreatedBy();
        String tempResultcreatedBy16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecreatedBy16));
        %>
        <%= tempResultcreatedBy16 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cardType:</TD>
<TD>
<%
if(getTransaction13mtemp != null){
java.lang.String typecardType18 = getTransaction13mtemp.getCardType();
        String tempResultcardType18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecardType18));
        %>
        <%= tempResultcardType18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getTransaction13mtemp != null){
java.lang.Integer typeid20 = getTransaction13mtemp.getId();
        String tempResultid20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeid20));
        %>
        <%= tempResultid20 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">quantity:</TD>
<TD>
<%
if(getTransaction13mtemp != null){
java.lang.Integer typequantity22 = getTransaction13mtemp.getQuantity();
        String tempResultquantity22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typequantity22));
        %>
        <%= tempResultquantity22 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">expDate:</TD>
<TD>
<%
if(getTransaction13mtemp != null){
java.lang.String typeexpDate24 = getTransaction13mtemp.getExpDate();
        String tempResultexpDate24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeexpDate24));
        %>
        <%= tempResultexpDate24 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nameOnCard:</TD>
<TD>
<%
if(getTransaction13mtemp != null){
java.lang.String typenameOnCard26 = getTransaction13mtemp.getNameOnCard();
        String tempResultnameOnCard26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenameOnCard26));
        %>
        <%= tempResultnameOnCard26 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">unitPrice:</TD>
<TD>
<%
if(getTransaction13mtemp != null){
java.lang.Float typeunitPrice28 = getTransaction13mtemp.getUnitPrice();
        String tempResultunitPrice28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeunitPrice28));
        %>
        <%= tempResultunitPrice28 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">totalPrice:</TD>
<TD>
<%
if(getTransaction13mtemp != null){
java.lang.Float typetotalPrice30 = getTransaction13mtemp.getTotalPrice();
        String tempResulttotalPrice30 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetotalPrice30));
        %>
        <%= tempResulttotalPrice30 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">createdOn:</TD>
<TD>
<%
if(getTransaction13mtemp != null){
java.util.Calendar typecreatedOn32 = getTransaction13mtemp.getCreatedOn();
        java.text.DateFormat dateFormatcreatedOn32 = java.text.DateFormat.getDateInstance();
        java.util.Date datecreatedOn32 = typecreatedOn32.getTime();
        String tempResultcreatedOn32 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatcreatedOn32.format(datecreatedOn32));
        %>
        <%= tempResultcreatedOn32 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cardNo:</TD>
<TD>
<%
if(getTransaction13mtemp != null){
java.lang.String typecardNo34 = getTransaction13mtemp.getCardNo();
        String tempResultcardNo34 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecardNo34));
        %>
        <%= tempResultcardNo34 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 38:
        gotMethod = true;
        String transactionId_2id=  request.getParameter("transactionId41");
        int transactionId_2idTemp  = Integer.parseInt(transactionId_2id);
        boolean removeTransaction38mtemp = sampleTransactionWebserviceImplProxyid.removeTransaction(transactionId_2idTemp);
        String tempResultreturnp39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(removeTransaction38mtemp));
        %>
        <%= tempResultreturnp39 %>
        <%
break;
case 43:
        gotMethod = true;
        String createdBy_4id=  request.getParameter("createdBy48");
            java.lang.String createdBy_4idTemp = null;
        if(!createdBy_4id.equals("")){
         createdBy_4idTemp  = createdBy_4id;
        }
        String cardType_5id=  request.getParameter("cardType50");
            java.lang.String cardType_5idTemp = null;
        if(!cardType_5id.equals("")){
         cardType_5idTemp  = cardType_5id;
        }
        String id_6id=  request.getParameter("id52");
            java.lang.Integer id_6idTemp = null;
        if(!id_6id.equals("")){
         id_6idTemp  = java.lang.Integer.valueOf(id_6id);
        }
        String quantity_7id=  request.getParameter("quantity54");
            java.lang.Integer quantity_7idTemp = null;
        if(!quantity_7id.equals("")){
         quantity_7idTemp  = java.lang.Integer.valueOf(quantity_7id);
        }
        String expDate_8id=  request.getParameter("expDate56");
            java.lang.String expDate_8idTemp = null;
        if(!expDate_8id.equals("")){
         expDate_8idTemp  = expDate_8id;
        }
        String nameOnCard_9id=  request.getParameter("nameOnCard58");
            java.lang.String nameOnCard_9idTemp = null;
        if(!nameOnCard_9id.equals("")){
         nameOnCard_9idTemp  = nameOnCard_9id;
        }
        String unitPrice_10id=  request.getParameter("unitPrice60");
            java.lang.Float unitPrice_10idTemp = null;
        if(!unitPrice_10id.equals("")){
         unitPrice_10idTemp  = java.lang.Float.valueOf(unitPrice_10id);
        }
        String totalPrice_11id=  request.getParameter("totalPrice62");
            java.lang.Float totalPrice_11idTemp = null;
        if(!totalPrice_11id.equals("")){
         totalPrice_11idTemp  = java.lang.Float.valueOf(totalPrice_11id);
        }
        String createdOn_12id=  request.getParameter("createdOn64");
            java.util.Calendar createdOn_12idTemp = null;
        if(!createdOn_12id.equals("")){
        java.text.DateFormat dateFormatcreatedOn64 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempcreatedOn64  = dateFormatcreatedOn64.parse(createdOn_12id);
         createdOn_12idTemp = new java.util.GregorianCalendar();
        createdOn_12idTemp.setTime(dateTempcreatedOn64);
        }
        String cardNo_13id=  request.getParameter("cardNo66");
            java.lang.String cardNo_13idTemp = null;
        if(!cardNo_13id.equals("")){
         cardNo_13idTemp  = cardNo_13id;
        }
        %>
        <jsp:useBean id="com1mcda55101assignment31entity1Transaction_3id" scope="session" class="com.mcda5510.assignment3.entity.Transaction" />
        <%
        com1mcda55101assignment31entity1Transaction_3id.setCreatedBy(createdBy_4idTemp);
        com1mcda55101assignment31entity1Transaction_3id.setCardType(cardType_5idTemp);
        com1mcda55101assignment31entity1Transaction_3id.setId(id_6idTemp);
        com1mcda55101assignment31entity1Transaction_3id.setQuantity(quantity_7idTemp);
        com1mcda55101assignment31entity1Transaction_3id.setExpDate(expDate_8idTemp);
        com1mcda55101assignment31entity1Transaction_3id.setNameOnCard(nameOnCard_9idTemp);
        com1mcda55101assignment31entity1Transaction_3id.setUnitPrice(unitPrice_10idTemp);
        com1mcda55101assignment31entity1Transaction_3id.setTotalPrice(totalPrice_11idTemp);
        com1mcda55101assignment31entity1Transaction_3id.setCreatedOn(createdOn_12idTemp);
        com1mcda55101assignment31entity1Transaction_3id.setCardNo(cardNo_13idTemp);
        boolean createTransaction43mtemp = sampleTransactionWebserviceImplProxyid.createTransaction(com1mcda55101assignment31entity1Transaction_3id);
        String tempResultreturnp44 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(createTransaction43mtemp));
        %>
        <%= tempResultreturnp44 %>
        <%
break;
case 68:
        gotMethod = true;
        String createdBy_15id=  request.getParameter("createdBy73");
            java.lang.String createdBy_15idTemp = null;
        if(!createdBy_15id.equals("")){
         createdBy_15idTemp  = createdBy_15id;
        }
        String cardType_16id=  request.getParameter("cardType75");
            java.lang.String cardType_16idTemp = null;
        if(!cardType_16id.equals("")){
         cardType_16idTemp  = cardType_16id;
        }
        String id_17id=  request.getParameter("id77");
            java.lang.Integer id_17idTemp = null;
        if(!id_17id.equals("")){
         id_17idTemp  = java.lang.Integer.valueOf(id_17id);
        }
        String quantity_18id=  request.getParameter("quantity79");
            java.lang.Integer quantity_18idTemp = null;
        if(!quantity_18id.equals("")){
         quantity_18idTemp  = java.lang.Integer.valueOf(quantity_18id);
        }
        String expDate_19id=  request.getParameter("expDate81");
            java.lang.String expDate_19idTemp = null;
        if(!expDate_19id.equals("")){
         expDate_19idTemp  = expDate_19id;
        }
        String nameOnCard_20id=  request.getParameter("nameOnCard83");
            java.lang.String nameOnCard_20idTemp = null;
        if(!nameOnCard_20id.equals("")){
         nameOnCard_20idTemp  = nameOnCard_20id;
        }
        String unitPrice_21id=  request.getParameter("unitPrice85");
            java.lang.Float unitPrice_21idTemp = null;
        if(!unitPrice_21id.equals("")){
         unitPrice_21idTemp  = java.lang.Float.valueOf(unitPrice_21id);
        }
        String totalPrice_22id=  request.getParameter("totalPrice87");
            java.lang.Float totalPrice_22idTemp = null;
        if(!totalPrice_22id.equals("")){
         totalPrice_22idTemp  = java.lang.Float.valueOf(totalPrice_22id);
        }
        String createdOn_23id=  request.getParameter("createdOn89");
            java.util.Calendar createdOn_23idTemp = null;
        if(!createdOn_23id.equals("")){
        java.text.DateFormat dateFormatcreatedOn89 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempcreatedOn89  = dateFormatcreatedOn89.parse(createdOn_23id);
         createdOn_23idTemp = new java.util.GregorianCalendar();
        createdOn_23idTemp.setTime(dateTempcreatedOn89);
        }
        String cardNo_24id=  request.getParameter("cardNo91");
            java.lang.String cardNo_24idTemp = null;
        if(!cardNo_24id.equals("")){
         cardNo_24idTemp  = cardNo_24id;
        }
        %>
        <jsp:useBean id="com1mcda55101assignment31entity1Transaction_14id" scope="session" class="com.mcda5510.assignment3.entity.Transaction" />
        <%
        com1mcda55101assignment31entity1Transaction_14id.setCreatedBy(createdBy_15idTemp);
        com1mcda55101assignment31entity1Transaction_14id.setCardType(cardType_16idTemp);
        com1mcda55101assignment31entity1Transaction_14id.setId(id_17idTemp);
        com1mcda55101assignment31entity1Transaction_14id.setQuantity(quantity_18idTemp);
        com1mcda55101assignment31entity1Transaction_14id.setExpDate(expDate_19idTemp);
        com1mcda55101assignment31entity1Transaction_14id.setNameOnCard(nameOnCard_20idTemp);
        com1mcda55101assignment31entity1Transaction_14id.setUnitPrice(unitPrice_21idTemp);
        com1mcda55101assignment31entity1Transaction_14id.setTotalPrice(totalPrice_22idTemp);
        com1mcda55101assignment31entity1Transaction_14id.setCreatedOn(createdOn_23idTemp);
        com1mcda55101assignment31entity1Transaction_14id.setCardNo(cardNo_24idTemp);
        boolean updateTransaction68mtemp = sampleTransactionWebserviceImplProxyid.updateTransaction(com1mcda55101assignment31entity1Transaction_14id);
        String tempResultreturnp69 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateTransaction68mtemp));
        %>
        <%= tempResultreturnp69 %>
        <%
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