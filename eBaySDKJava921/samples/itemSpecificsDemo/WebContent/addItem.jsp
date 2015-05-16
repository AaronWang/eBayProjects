<%@ page errorPage="errorPage.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ebay.sample.itemSpecificsDemo.model.*" %>
<%@ page import="com.ebay.sample.itemSpecificsDemo.Global"%>
<%@ page import="com.ebay.soap.eBLBaseComponents.*" %>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item</title>
</head>
<body>

<%

SiteFacade sf = (SiteFacade)session.getAttribute(Global.SK_SITEFACADE);
CategoryFacade cf = (CategoryFacade)session.getAttribute(Global.SK_CATEGORYFACADE);
SiteCodeType site = Global.apiContext.getSite();
String currency = Global.getCurrencyOfSite(site).toString();

Map<SiteCodeType, GeteBayDetailsResponseType> eBayDetailsMap = sf.getEBayDetailsMap();
GeteBayDetailsResponseType eBayDetails = eBayDetailsMap.get(site);
ShippingServiceDetailsType[] shippingServiceDetails = eBayDetails.getShippingServiceDetails();
shippingServiceDetails = Global.filterShippingService(shippingServiceDetails);

ShippingLocationDetailsType[] shippingLocationDetails = eBayDetails.getShippingLocationDetails();

Map<ListingTypeCodeType,Integer> listingDurationReferenceMap = cf.getListingDurationReferenceMap();
Map<Integer,String[]> listingDurationMap = cf.getListingDurationMap();

String pageError = (String)request.getAttribute("PageError");
if (pageError == null) {
	pageError = "";
}

%>

<script>
var listingTypeDurationMap = {
<%
for(Iterator<ListingTypeCodeType> j = listingDurationReferenceMap.keySet().iterator();j.hasNext(); ){ 
	ListingTypeCodeType key = j.next();
	out.print(key.value()+":{");
	Integer durationSetId = listingDurationReferenceMap.get(key);
    String[] durations = listingDurationMap.get(durationSetId);
    for( int k = 0;k < durations.length ; ){
    	out.print("option"+k+":\""+durations[k]+"\"");
    	k++;
    	if(k < durations.length){
    		out.print(",");
    	}else{
    		break;
    	}
    }
    if(j.hasNext()){
    	out.print("},");
	}else{
		out.print("}");
		break;
	}
}
%>
};

function onChangeListingType(value){
	var element = document.getElementById("ItemDuration");
	var options = listingTypeDurationMap[value];
	var length = 0;
	for( var option in options){
		element.options[length] = new Option(options[option],options[option],false,false);
		length++;
	}
	element.options.length = length;
}
</script>
<form id="AddItem" method="post" action="AddItemServlet">
<table border="0" cellpadding="2" cellspacing="2" width="700" align="center">
  <tr style="FONT-WEIGHT: bold; FONT-SIZE: large; COLOR: #000099">
    <td>Specify information of your item</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
   <tr>
     <td>
	     <span id="Label1">Currency: </span>
	     <span id="Currency"><%=currency%></span>
     </td>
   </tr>
   <tr>
     <td>
       <table>
         <tr>
           <td width="150px"><b>Title:</b></td>
           <td>
               <input id="ItemTitle" name="ItemTitle" type="text" style="width:350px;" value="SDK Attributes"/>
           </td>
         </tr>
       </table>
     </td>
   </tr>
   <tr>
      <td>
       <table>
         <tr>
	       <td width="150px"><b>Subtitle:</b></td>
	       <td>
	         <input id="SubTitle" name="SubTitle" type="text" style="width:350px;" value=""/>
	       </td>
         </tr>
       </table>
     </td>
   </tr>
   <tr>
     <td>
       <table>
         <tr>
	        <td width="150px"><b>Description:</b></td>
	        <td>
	          <textarea id="Description" name="Description" style="height:88px;width:350px;"/>Description of item with attributes by Java SDK.</textarea>
	        </td>
         </tr>
       </table>
     </td>
   </tr>
   
   <tr>
     <td>
       <table>
         <tr>
             <td width="150px"><b>Starting Price:</b></td>
             <td>
                 <input type="text" id="StartPrice" name="StartPrice" style="width:150px;" value="2.0"/>
             </td>
         </tr>
       </table>
     </td>
   </tr>
   <tr>
     <td>
       <table>
         <tr>
           <td width="150px"><b>Buy It Now price:</b></td>
           <td>
               <input name="BuyItNowPrice" type="text" value="10.0" id="BuyItNowPrice" style="width:150px;" /> &nbsp;(Optional)
           </td>
         </tr>
       </table>
     </td>
   </tr>
   <tr>
     <td>
       <table>
         <tr>
           <td width="150px"><b>Location:</b></td>
           <td>
               <input name="ItemLocation" type="text" value="San Jose, CA" id="ItemLocation" style="width:150px;" />
           </td>
         </tr>
       </table>
     </td>
   </tr>
   
   <tr>
     <td>
       <table>
         <tr>
           <td width="150px"><b>Quantity:</b></td>
           <td>
             <input name="Quantity" type="text" value="1" id="Quantity" style="width:150px;" />
           </td>
         </tr>
       </table>
     </td>
   </tr>
   
   <tr>
     <td>
       <table>
         <tr>
           <td style="WIDTH: 150px"><b>Listing Type:</b></td>
           <td>
             <select name="ListingType" id="ListingType" style="width:150px;" onChange="javascript:onChangeListingType(this.value)">
             <%
                ListingTypeCodeType firstListingType = null;
                for(Iterator<ListingTypeCodeType> j = listingDurationReferenceMap.keySet().iterator(); j.hasNext();){ 
	             	ListingTypeCodeType key = j.next();
	             	if(firstListingType==null){//cache first listing type
	             		firstListingType = key;
             	}
             %>
             	 <option value="<%= key.value() %>" ><%= key.value() %></option>
             <%} %>
	         </select>
           </td>
         </tr>
       </table>
     </td>
   </tr>
   <tr>
     <td>
       <table>
         <tr>
           <td style="WIDTH: 150px"><b>Duration:</b></td>
           <td>
             <select name="ItemDuration" id="ItemDuration" style="width:150px;">
             <%
             Integer durationSetId = listingDurationReferenceMap.get(firstListingType);
             String[] durations = listingDurationMap.get(durationSetId);
             for(int j=0;j<durations.length;j++){
             %>
               <option value="<%=durations[j] %>" ><%=durations[j] %></option>
             <%} %>
	         </select>
           </td>
         </tr>
       </table>
     </td>
   </tr>
   
   
   <!-- item condition -->
       <%if (cf.getConditionEnabled() == ConditionEnabledCodeType.ENABLED || 
    		cf.getConditionEnabled() == ConditionEnabledCodeType.REQUIRED) {
    	   
           ConditionValuesType conditionValues = cf.getConditionValues();
           ConditionType[] conditions = conditionValues.getCondition();
    	%>
   <tr>
     <td>
       <table>
         <tr>
           <td style="WIDTH: 150px"><b>Condition:</b></td>
           <td>
             <select name="ItemCondition" id="ItemCondition" style="width:150px;">
             <%
             for(int j=0;j<conditions.length;j++){
             %>
               <option value="<%=conditions[j].getID() %>" ><%=conditions[j].getDisplayName()%></option>
             <%} %>
	         </select>
           </td>
           <td><a href="<%=conditionValues.getConditionHelpURL()%>">Condition Help</a></td>
         </tr>
       </table>
     </td>
   </tr>    		
    		
       <% } %>
   
  <!-- Payment options -->
    <tr>
      <td>
        <table>
          <tr><td><b>Seller PaymentProfile:</b></td></tr>
        </table>
        
        <table width="500">
        	<tr>
        	   <td width="150px">Payment ProfileId</td>	
        	   <td><input name="PaymentProfileId" type="text" value="" id="PaymentProfileId" style="width:150px;" /></td>
        	</tr>
        	<tr>
        	   <td width="150px">Payment ProfileName</td>
        	   <td><input name="PaymentProfileName" type="text" value="" id="PaymentProfileName" style="width:150px;" /></td>
        	</tr>
        </table>
        
      </td>
    </tr>
    
    <tr>
      <td>
      	  <table>
          		<tr><td><b>Seller ShippingProfile:</b></td></tr>
          </table>
		 <table width="500">
        	<tr>
        	   <td width="150px">Shipping ProfileId</td>	
        	   <td><input name="ShippingProfileId" type="text" value="" id="ShippingProfileId" style="width:150px;" /></td>
        	</tr>
        	<tr>
        	   <td width="150px">Shipping ProfileName</td>
        	   <td><input name="ShippingProfileName" type="text" value="" id="ShippingProfileName" style="width:150px;" /></td>
        	</tr>
        </table> 
        
      </td>
    </tr>
    
   <!-- <tr>
      <td colspan="2">
	        <table width="100%" style="BACKGROUND-COLOR: #ccffff">
	          <tr>
	            <td>
	              <b>Motor Specifics</b>
	            </td>
	          </tr>
	          <tr>
	            <td width="50%">
	                    Subtitle:&nbsp;
	                    <input id="MotorSubtitle" name="MotorSubtitle" type="text" style="width:100px;" value="motor"/>
	            </td>
	            <td>
	                    Deposit Amount:&nbsp; &nbsp;
	                    <input id="MotorDepositAmount" name="MotorDepositAmount" type="text" style="width:100px;" value=""/>
	            </td>
	          </tr>
	        </table>
      </td>
    </tr> -->
    
  <tr>
    <td>&nbsp;</td>
  </tr>
  
  <tr>
    <td>
      <input type="submit" name="BtnAddItem" value="List Item to eBay" id="BtnAddItem" />
    </td>
  </tr>
      <tr>
        <td>
          <span id="StatusText" style="color:Red;width:357px;"><%=pageError%></span>
        </td>
      </tr>
	
	<tr>
            <td STYLE="font-style: italic;color: green">          
                The Business Policies API and related Trading API fields are available in sandbox. It will be  available in production for a limited number of sellers with Version 775. 100 percent of sellers will be ramped up to use Business Polcies in July 2012
             </td> 
     </tr>
</table>
</form>
</body>
</html>