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
        String createdBy_3id=  request.getParameter("createdBy43");
            java.lang.String createdBy_3idTemp = null;
        if(!createdBy_3id.equals("")){
         createdBy_3idTemp  = createdBy_3id;
        }
        String cardType_4id=  request.getParameter("cardType45");
            java.lang.String cardType_4idTemp = null;
        if(!cardType_4id.equals("")){
         cardType_4idTemp  = cardType_4id;
        }
        String id_5id=  request.getParameter("id47");
            java.lang.Integer id_5idTemp = null;
        if(!id_5id.equals("")){
         id_5idTemp  = java.lang.Integer.valueOf(id_5id);
        }
        String quantity_6id=  request.getParameter("quantity49");
            java.lang.Integer quantity_6idTemp = null;
        if(!quantity_6id.equals("")){
         quantity_6idTemp  = java.lang.Integer.valueOf(quantity_6id);
        }
        String expDate_7id=  request.getParameter("expDate51");
            java.lang.String expDate_7idTemp = null;
        if(!expDate_7id.equals("")){
         expDate_7idTemp  = expDate_7id;
        }
        String nameOnCard_8id=  request.getParameter("nameOnCard53");
            java.lang.String nameOnCard_8idTemp = null;
        if(!nameOnCard_8id.equals("")){
         nameOnCard_8idTemp  = nameOnCard_8id;
        }
        String unitPrice_9id=  request.getParameter("unitPrice55");
            java.lang.Float unitPrice_9idTemp = null;
        if(!unitPrice_9id.equals("")){
         unitPrice_9idTemp  = java.lang.Float.valueOf(unitPrice_9id);
        }
        String totalPrice_10id=  request.getParameter("totalPrice57");
            java.lang.Float totalPrice_10idTemp = null;
        if(!totalPrice_10id.equals("")){
         totalPrice_10idTemp  = java.lang.Float.valueOf(totalPrice_10id);
        }
        String createdOn_11id=  request.getParameter("createdOn59");
            java.util.Calendar createdOn_11idTemp = null;
        if(!createdOn_11id.equals("")){
        java.text.DateFormat dateFormatcreatedOn59 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempcreatedOn59  = dateFormatcreatedOn59.parse(createdOn_11id);
         createdOn_11idTemp = new java.util.GregorianCalendar();
        createdOn_11idTemp.setTime(dateTempcreatedOn59);
        }
        String cardNo_12id=  request.getParameter("cardNo61");
            java.lang.String cardNo_12idTemp = null;
        if(!cardNo_12id.equals("")){
         cardNo_12idTemp  = cardNo_12id;
        }
        %>
        <jsp:useBean id="com1mcda55101assignment31entity1Transaction_2id" scope="session" class="com.mcda5510.assignment3.entity.Transaction" />
        <%
        com1mcda55101assignment31entity1Transaction_2id.setCreatedBy(createdBy_3idTemp);
        com1mcda55101assignment31entity1Transaction_2id.setCardType(cardType_4idTemp);
        com1mcda55101assignment31entity1Transaction_2id.setId(id_5idTemp);
        com1mcda55101assignment31entity1Transaction_2id.setQuantity(quantity_6idTemp);
        com1mcda55101assignment31entity1Transaction_2id.setExpDate(expDate_7idTemp);
        com1mcda55101assignment31entity1Transaction_2id.setNameOnCard(nameOnCard_8idTemp);
        com1mcda55101assignment31entity1Transaction_2id.setUnitPrice(unitPrice_9idTemp);
        com1mcda55101assignment31entity1Transaction_2id.setTotalPrice(totalPrice_10idTemp);
        com1mcda55101assignment31entity1Transaction_2id.setCreatedOn(createdOn_11idTemp);
        com1mcda55101assignment31entity1Transaction_2id.setCardNo(cardNo_12idTemp);
        boolean createTransaction38mtemp = sampleTransactionWebserviceImplProxyid.createTransaction(com1mcda55101assignment31entity1Transaction_2id);
        String tempResultreturnp39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(createTransaction38mtemp));
        %>
        <%= tempResultreturnp39 %>
        <%
break;
case 63:
        gotMethod = true;
        String createdBy_14id=  request.getParameter("createdBy68");
            java.lang.String createdBy_14idTemp = null;
        if(!createdBy_14id.equals("")){
         createdBy_14idTemp  = createdBy_14id;
        }
        String cardType_15id=  request.getParameter("cardType70");
            java.lang.String cardType_15idTemp = null;
        if(!cardType_15id.equals("")){
         cardType_15idTemp  = cardType_15id;
        }
        String id_16id=  request.getParameter("id72");
            java.lang.Integer id_16idTemp = null;
        if(!id_16id.equals("")){
         id_16idTemp  = java.lang.Integer.valueOf(id_16id);
        }
        String quantity_17id=  request.getParameter("quantity74");
            java.lang.Integer quantity_17idTemp = null;
        if(!quantity_17id.equals("")){
         quantity_17idTemp  = java.lang.Integer.valueOf(quantity_17id);
        }
        String expDate_18id=  request.getParameter("expDate76");
            java.lang.String expDate_18idTemp = null;
        if(!expDate_18id.equals("")){
         expDate_18idTemp  = expDate_18id;
        }
        String nameOnCard_19id=  request.getParameter("nameOnCard78");
            java.lang.String nameOnCard_19idTemp = null;
        if(!nameOnCard_19id.equals("")){
         nameOnCard_19idTemp  = nameOnCard_19id;
        }
        String unitPrice_20id=  request.getParameter("unitPrice80");
            java.lang.Float unitPrice_20idTemp = null;
        if(!unitPrice_20id.equals("")){
         unitPrice_20idTemp  = java.lang.Float.valueOf(unitPrice_20id);
        }
        String totalPrice_21id=  request.getParameter("totalPrice82");
            java.lang.Float totalPrice_21idTemp = null;
        if(!totalPrice_21id.equals("")){
         totalPrice_21idTemp  = java.lang.Float.valueOf(totalPrice_21id);
        }
        String createdOn_22id=  request.getParameter("createdOn84");
            java.util.Calendar createdOn_22idTemp = null;
        if(!createdOn_22id.equals("")){
        java.text.DateFormat dateFormatcreatedOn84 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempcreatedOn84  = dateFormatcreatedOn84.parse(createdOn_22id);
         createdOn_22idTemp = new java.util.GregorianCalendar();
        createdOn_22idTemp.setTime(dateTempcreatedOn84);
        }
        String cardNo_23id=  request.getParameter("cardNo86");
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
        boolean updateTransaction63mtemp = sampleTransactionWebserviceImplProxyid.updateTransaction(com1mcda55101assignment31entity1Transaction_13id);
        String tempResultreturnp64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateTransaction63mtemp));
        %>
        <%= tempResultreturnp64 %>
        <%
break;
case 88:
        gotMethod = true;
        String transactionId_24id=  request.getParameter("transactionId91");
        int transactionId_24idTemp  = Integer.parseInt(transactionId_24id);
        boolean removeTransaction88mtemp = sampleTransactionWebserviceImplProxyid.removeTransaction(transactionId_24idTemp);
        String tempResultreturnp89 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(removeTransaction88mtemp));
        %>
        <%= tempResultreturnp89 %>
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