<%@ page errorPage="errorPage.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ebay.sample.itemSpecificsDemo.Global"%>
<%@ page import="com.ebay.sdk.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select eBay Site</title>
</head>

<%
if (Global.apiContext == null)
{
	RequestDispatcher view = request.getRequestDispatcher(Global.ServletSite);
	view.forward(request, response);
}
%>

<body>
    <form id="SelectSite" method="post" action="SiteServlet">
      <table cellSpacing="2" cellPadding="0" width="480" align="center" border="0">
        <tr>
          <td><img src="ebay.gif"></td>
          &nbsp;
          <td></td>
          <td><B><font size="5">ItemSpecificsDemo</font></B></td>
        </tr>
        <tr>
          <td></td>
          <td></td>
          <td style="font-SIZE: x-small; COLOR: blue; font-STYLE: italic; font-FAMILY: Tahoma">---Built upon eBay SDK for Java v<%=Global.apiContext.getWSDLVersion()%></td>
        </tr>
      </table>
      <br>
      <table cellSpacing="8" cellPadding="0" width="480" align="center" border="0">
        <tr>
        	<td>Select the site to which you want to list your item then continue.</td>
        </tr>
        <tr>
          <td><select id="eBaySite" name="eBaySite" style="width:200px;">
              <option Value="US" Selected="true">US</option>
              <option Value="eBayMotors">eBayMotors</option>
              <option Value="Canada">Canada</option>
              <option Value="UK">UnitedKingdom</option>
              <option Value="Australia">Australia</option>
              <option Value="Austria">Austria</option>
              <option Value="Belgium_French">BelgiumFrench</option>
              <option Value="France">France</option>
              <option Value="Poland">Poland</option>
              <option Value="India">India</option>
              <option Value="Germany">Germany</option>
              <option Value="Italy">Italy</option>
              <option Value="Belgium_Dutch">BelgiumDutch</option>
              <option Value="Netherlands">Netherlands</option>
              <option Value="Spain">Spain</option>
              <option Value="Switzerland">Switzerland</option>
              <option Value="HongKong">HongKong</option>
              <option Value="Singapore">Singapore</option>
              <option Value="Taiwan">Taiwan</option>
           </select></td>
        </tr>
        <tr>
        	<td>Enter category or leave blank to download categories and pick:</td>
        </tr>
        <tr>
                 <td><input maxLength="30" size="18" name="catId"></td>
        </tr>
        <tr>
                <td></td>
        </tr>
        <tr>
                <td><input type="submit" name="Continue" style="width:100px;" value="Continue"/></td>
        </tr>
        <tr>
                <td>&nbsp;</td>
        </tr>
        
      </table>
    </form>
</body>
</html>