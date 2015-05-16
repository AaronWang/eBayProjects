<%@ page errorPage="errorPage.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.ebay.sample.itemSpecificsDemo.Global"%>
<%@ page import="com.ebay.sample.itemSpecificsDemo.bean.ListItem" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category List</title>
</head>

  <script language="javascript">

  function validate() {
     var index = document.forms['CategoryList'].catId.selectedIndex;
     if (index < 0) {
        alert("Please select category first!");
        return false;
     } 
     return true;
  }
  
  <!-- 
  function submitForm() {
    document.forms['CategoryList'].submit();
  }
  -->
  
  </script>
  
<body>

<%! 
static final String cat_line_fmt = "<option Value=\"{0}\">{1}</option>\n";

//construct category list html
public String addCategories(javax.servlet.http.HttpServletRequest request) {
	StringBuffer sb = new StringBuffer();
	ArrayList<ListItem> items = (ArrayList<ListItem>)request.getAttribute("ItemList");
	
	for(ListItem item : items) {
	    String line = java.text.MessageFormat.format(cat_line_fmt,
	    	    new Object[] {item.getValue(), item.getName()});
	        sb.append(line);
	}
	
	return sb.toString();
}

%>



<!--<%
String attrGroup = (String)request.getAttribute("AttrGroup");
if(attrGroup == null) attrGroup = "All";
%> -->

    <form name="CategoryList" id="CategoryList" method="post" action="CategoryListServlet">
      <table border="0" align="center" width="600">
        <tr>
            <td align="center"><img src="ebay.gif"></td>
        </tr>
        <tr>
            <td align="center"><b>Select Category:</b></td>
        </tr>
        <tr>
            <td></td>
        </tr>
        <tr>
            <td align="center">
                <select id="catId" name="catId" size="20" style="width:350px;"">
                        <%= addCategories(request) %>
                </select>
            </td>
        </tr>
        <%if (request.getAttribute("NoCat") != null) { %>
        <tr>
            <td align="center"><font color='red'>No Category Found</font></td>
        </tr>
        
        <%} else { %>
        <tr>
            <td align="center">Category Found</td>
        </tr>
        <% } %>
        <tr>
            <td></td>
        </tr>
        
        <!--<tr>
            <td align="center">
                <input type="radio" name="attrGroup" id="attrGroup" value="All" <%=("All".equals(attrGroup)?"checked":"")%> onclick="javascript:submitForm()">All
                <input type="radio" name="attrGroup" id="attrGroup" value="AOnly" <%=("AOnly".equals(attrGroup)?"checked":"")%> onclick="javascript:submitForm()">Attributes Only
                <input type="radio" name="attrGroup" id="attrGroup" value="SOnly" <%=("SOnly".equals(attrGroup)?"checked":"")%> onclick="javascript:submitForm()">ItemSpecifics Only
                <input type="radio" name="attrGroup" id="attrGroup" value="Both" <%=("Both".equals(attrGroup)?"checked":"")%> onclick="javascript:submitForm()">Both
            </td>
        </tr> -->
        
        <tr>
            <td></td>
        </tr>
        
       <!-- <tr>
                <td align="center"align="center">A-Attributes Set Available</td>
        </tr>
        <tr>
          		<td align="center">S-Item Specifics Available</td>
        </tr> -->
        
      </table>
     
      <table border="0" align="center" width="600">
        <tr>
          <td align="center">
            <input type="submit" name="ListInCat" value="Continue" onclick="javascript:return validate()"/>
            &nbsp;&nbsp;
          </td>
        </tr>
      </table>
      </form>
</body>
</html>