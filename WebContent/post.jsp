<%@ page import="com.add.domain.*" %>
<html ng-app>
  <head>
    <script src="https://code.angularjs.org/1.3.0-beta.5/angular.js" 
    data-require="angular.js@*" data-semver="2.0.0-alpha.31"></script>
    <link href="style.css" rel="stylesheet" />
    <script src="script.js"></script>
  </head>
 <body ng-controller="SuccessController">
<% 
String username = null;
if(null != request.getSession().getAttribute("username")){
	username = (String)request.getSession().getAttribute("username");
}
Client client = (Client) request.getAttribute("client");%>
<jsp:include page="top.jsp">
<jsp:param value="<%=username %>" name="username"/>
</jsp:include>
<div class="branding container_12">         
<form>
<div class="content">
	<table>
	<tr>
	<td>Business Unit Name </td>
  <td></td>
	  	<td class="verizoncolor"><%= client.getOrgName() %></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>Address Line1 </td>
  <td></td>
	  	<td class="verizoncolor"><%= client.getAddr1() %></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td>Address Line2</td>
  <td></td>
	  	<td class="verizoncolor"><%= client.getAddr2() %></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td>Address Line3</td>
  <td></td>
	  	<td class="verizoncolor"><%= client.getAddr3() %></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td>City </span></td>
  <td></td>
	  	<td class="verizoncolor"><%= client.getCity() %></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td>State </td>
  <td></td>
	  	<td class="verizoncolor"><%= client.getState() %></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>Country </td>
  <td></td>
	  	<td class="verizoncolor"><%=client.getCountry() %></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>Pin code / Zip Code </td>
  <td></td>
	  	<td class="verizoncolor"><%=client.getPostalCode() %></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>AD Description </td>
  <td></td>
	  	<td class="verizoncolor"><%=client.getAddDesc() %></td>
	</tr>
	<tr></tr>			

<tr></tr>
	
	<tr>
	<td>Attachment </td>
  <td></td>
  <%if(null != client.getFileFullPath()){%>
  <td class="verizoncolor"><img src="images/image.jpg" style="height:20px;width:20px;" alt="NO Image"/></td>
  <% }else{%>
   <td class="verizoncolor">-No Attachment-</td>
  <%} %>	  	
	</tr>
	<tr></tr>			
		
	</table>
</div>

</form>
</div>
<div class="top">
<a href="home.jsp" class="button red xlarge"><span class="white">Back</span></a>
</div>
   
</body>

</html>
