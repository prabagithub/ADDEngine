
<div class="container">
<div class="loginContainer">
<div class="loginheader">
<h1>{{header}}</h1>
</div>
<table class="logintable">
<% if(null != request.getAttribute("error") && (boolean) request.getAttribute("error")){
%>

<tr>
<td colspan="2"><span class="red">{{errmsg}}</span></td>
</tr>
<%} %>
<tr>
<td >{{username}}</td>
<td><input type="text" name="username" id="username"/>
</td>
</tr>
<tr>
</tr>
<tr>
<td>
{{pwd}}
</td>
<td><input type="password" id="pwd" name="pwd"/>
</td>
</tr>
<tr></tr>
<tr>
<td>
</td>
<td>
<input type="submit" class="button red xlarge" style="color:white;" value="{{btnvalue}}"/></td>
</tr>

<tr>
<td colspan="2"><a style="text-decoration:none;color:#B00000;"  href="{{filename}}">{{regmsg}}</a></td>
</tr>
</table>
</div>
</div>
</form>