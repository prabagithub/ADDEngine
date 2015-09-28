<%@ page import="com.add.domain.*" %>
<html ng-app>
  <head>
    <script src="https://code.angularjs.org/1.3.0-beta.5/angular.js" 
    data-require="angular.js@*" data-semver="2.0.0-alpha.31"></script>
    <link href="style.css" rel="stylesheet" />
    <script src="script.js"></script>
  </head>
 <body ng-controller="Step2Contoller">
<% 
String username = null;
if(null != request.getAttribute("username")){
	username = (String)request.getAttribute("username");
}
Client client = (Client) request.getAttribute("client");%>
<jsp:include page="top.jsp">
<jsp:param value="<%=username %>" name="username"/>
</jsp:include>
<div class="branding container_12">         
<form enctype="multipart/form-data" action = "UploadServlet" method="post">
<div class="content">
	<table>
	<tr>
	<td>Business Unit Name </td>
  <td></td>
	  	<td class="verizoncolor"><input type="text" disabled="disabled" value="<%= client.getOrgName() %>"/></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>Address Line1 </td>
  <td></td>
	  	<td class="verizoncolor"><input type="text" disabled="disabled" value="<%= client.getAddr1() %>"/></td>
	
	<td>Address Line2</td>
  <td></td>
	  	<td class="verizoncolor"><input type="text" disabled="disabled" value="<%= client.getAddr2() %>"/></td>
	
	<td>Address Line3</td>
  <td></td>
	  	<td class="verizoncolor"><input type="text" disabled="disabled" value="<%= client.getAddr3() %>"/></td>
	</tr>
	<tr></tr>
	
		<tr>
	<td>City </span></td>
  <td></td>
	  	<td class="verizoncolor"><input type="text" disabled="disabled" value="<%= client.getCity() %>"/></td>
	
	<td>State </td>
  <td></td>
	  	<td class="verizoncolor"><input type="text" disabled="disabled" value="<%= client.getState() %>"/></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>Country </td>
  <td></td>
	  	<td class="verizoncolor"><input type="text" disabled="disabled" value="<%=client.getCountry() %>"/></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>Pin code / Zip Code </td>
  <td></td>
	  	<td class="verizoncolor"><input type="text" disabled="disabled" value="<%=client.getPostalCode() %>"/></td>
	</tr>
	<tr></tr>
	
	<tr>
	<td>AD Description </td>
  <td></td>
  <td colspan="4" class="verizoncolor"><textarea rows="5" cols="50" id="desc" name="desc" disabled="disabled" ><%=client.getAddDesc() %></textarea>
	  	</td>
	</tr>
	<tr></tr>			

<tr></tr>
	
	<tr>
	<td>Attachment (optional)</td>
  <td></td>
	  <td><input type="file" name="filename" id="filename"/>
	</tr>
	<tr></tr>			
	
		<tr>
	<td></td>
  <td></td>
	  	<td>
	  	   <input type="submit" class="button red xlarge" style="color:white;" value="Post-ADD"/>	  	   
	  	   </td>
	  	   
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
