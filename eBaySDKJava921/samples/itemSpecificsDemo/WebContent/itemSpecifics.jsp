<%@ page errorPage="errorPage.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.ebay.soap.eBLBaseComponents.*" %>
<%@ page import="com.ebay.sample.itemSpecificsDemo.Global"%>
<%@ page import="com.ebay.sample.itemSpecificsDemo.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Specifics</title>
</head>
<script language="javascript" src="itemSpecifics.js"></script>
<body>

<%
NameRecommendationType[] nrtArray = (NameRecommendationType[])request.getAttribute("Recommendations");
CategoryFacade cf = (CategoryFacade)session.getAttribute(Global.SK_CATEGORYFACADE);
%>

<form name="APIForm" id="APIForm" method="post" action="ItemSpecificsServlet" >

  <table align="center" border="0">

    <tr><td><img src="ebay.gif"></td></tr>

	<tr>
	<td align="center">
	<table border="0" align="left">
		<tr>
	    	<td valign="top">
	      		<span>
					<div id="CustomItemSpecificGroup">
					<%
					if(nrtArray!=null){
						for(int i=0;i<nrtArray.length;i++){
					%>
						<span id="SpecificLayer_a<%= i %>" style="margin-top: 8px">
	              			<div>
	                			<div id="TagName_a<%= i %>" style="margin-top: 15px">
	                  				<b><%= nrtArray[i].getName() %></b>
	                			</div>
	              				<div>
	                				<input type="text" id="itemSpecificValue_a<%= i %>" name="itemSpecificValue_a<%= i %>" style="width: 100px;POSITION: absolute">
	                				<select id="Option_a<%= i %>" name="Option_a<%= i %>" style="width: 120px;CLIP: rect(auto auto auto 103px); POSITION: absolute" onchange="optionSelect(this.name,this.value);"> 
	                					<option value=" ">Enter Your Own</option>
	                					<%
	                					ValueRecommendationType[] vrtArray = nrtArray[i].getValueRecommendation();
	                					for(int j=0; j<vrtArray.length; j++){
	                					%>
	                						<option value="<%= vrtArray[j].getValue() %>"><%= vrtArray[j].getValue() %></option> 
	                					<%} %>
	              					</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	              					<a href="javascript:void(0);" onclick="remove(this.id);return false;" id="Remove_a<%= i %>" class="navigation">
	                  					Remove
	                				</a>
	              				</div>
	              				
	              				<input type="hidden" id="itemSpecificName_a<%= i %>" name="itemSpecificName_a<%= i %>" value="<%=nrtArray[i].getName() %>"></input>
	             			</div>
	            		</span>
	            		<% 	
	            		}
					}
						%>
					</div>
				</span>
				<span>
					<div id="NewCustomItemSpecific">
						
					</div>
				</span>
				<span>
					<div id="tray" style="visibility: visible;">
						
						<div id="msg" style="display: none; visibility: hidden;"> If you want to add another item specific, please remove one of the existing specifics and add a new one. </div><div id="Addmore">
							<b>Add more Specifics</b>
						</div>
						<div id="SuggestedSectionLyr" style="padding-top: 10px; visibility: visible;">
							
						</div>
					</div>
				</span>
				
				
				<span>
					<div>
	           			<span id="AddCustomLnk" onclick="addNewSpecific();">
	              			<a href="javascript:void(0);">
	                			<img src="http://pics.qa.ebaystatic.com/aw/pics/buttons/btnOptionAdd.gif" hspace="1" border="0" align="absmiddle" />
	              			</a>
	              			<a href="javascript:void(0);"><b>Add a custom detail</b></a>
	            		</span>
	          		</div>
				</span>
			</td>
		</tr>
	</table>
	</td>
	</tr>
	
	<tr>
	 <td>
	<%if (cf.getConditionEnabled() == ConditionEnabledCodeType.ENABLED || 
    		cf.getConditionEnabled() == ConditionEnabledCodeType.REQUIRED) {%>
    	<font color='red'>Note:</font><br>This category is condition enabled, <br>please ignore item condition setting(if any) on this page.<br>
    	You can set item condition on AddItem page later.	
    <% }%>
	 </td>
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