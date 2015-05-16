<%@ page errorPage="errorPage.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ebay.sample.itemSpecificsDemo.Global"%>
<%@ page import="com.ebay.soap.eBLBaseComponents.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Return Policy</title>
</head>
<body>

<%
Boolean returnPolicyEnabled = (Boolean)request.getAttribute("ReturnPolicyEnabled");
String title = "Return policy is " + (returnPolicyEnabled.booleanValue()?"":"not ") + "enabled for this category.";
%>

<form name="APIForm" id="APIForm" method="post" action="ReturnPolicyServlet" >

  <table align="center"  border="0">

    <tr><td><img src="ebay.gif"></td></tr>

    <tr><td><%=title%></td></tr>
    
	<tr>
         <td>&nbsp;</td>
    </tr>
    
    <!-- specify return policy -->
    <%if(returnPolicyEnabled.booleanValue()){ %>
    
	<tr>
      <td>
      	  <table>
          		<tr><td><b>Seller ReturnProfile:</b></td></tr>
          </table>
		 <table width="500">
        	<tr>
        	   <td width="150px">Return ProfileId</td>	
        	   <td><input name="ReturnProfileId" type="text" value="" id="ReturnProfileId" style="width:150px;" /></td>
        	</tr>
        	<tr>
        	   <td width="150px">Return ProfileName</td>
        	   <td><input name="ReturnProfileName" type="text" value="" id="ReturnProfileName" style="width:150px;" /></td>
        	</tr>
        </table> 
        
      </td>
    </tr>
	
	<%} %>
	
	<tr>
         <td>&nbsp;</td>
    </tr>
    
    <tr>
      <td align="center">
        <input type="submit" name="btSubmit" id="btSubmit" value="Continue"/>
      </td>
    </tr>
	
  </table>

</form>

</body>
</html>