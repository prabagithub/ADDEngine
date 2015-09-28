// Code goes here

var MainController = function($scope){
  $scope.message = "MAdFlyers";
  $scope.overtopmsg = "Now you can post your AD at any time, any where !!!";
  $scope.color="black"
}
var SuccessController = function($scope){	
	
	$scope.message = "MAdFlyers";
	$scope.overtopmsg = "Your AD successfully posted";
	$scope.color="green"
}

var ErrorController = function($scope){	
	
	$scope.message = "MAdFlyers";
	$scope.overtopmsg = "Error in posting AD, Please try again";
	$scope.color="red"
}

var Step2Contoller = function($scope){
	$scope.message = "MAdFlyers";
	$scope.overtopmsg = "It is now easy to attach your files";
	$scope.color="black"
}


var LoginController = function($scope){
	  $scope.message = "MAdFlyers";
	  $scope.overtopmsg = "Now you can post your AD at any time, any where !!!";
	  $scope.color="black";
	  $scope.header="LOGIN";
	  $scope.errmsg="Please provide valid login details";
	  $scope.username="User name";
	  $scope.pwd="Password";
	  $scope.btnvalue="Login";
	  $scope.regmsg="Don't have an account,  create now, it is simple";
	  $scope.filename="register.jsp";
	}

var RegisterController = function($scope){
	  $scope.message = "MAdFlyers";
	  $scope.overtopmsg = "Now you can post your AD at any time, any where !!!";
	  $scope.color="black";
	  $scope.header="Create an Account";
	  $scope.errmsg="Sorry! Username already exists, Please try with new one";
	  $scope.username="User name";
	  $scope.pwd="Password";
	  $scope.btnvalue="Register";
	  $scope.regmsg="Already have an account, click here to login";
	  $scope.filename="login.jsp"
	  
	}

function check(){
	
	var orgName = document.getElementById("orgName").value;
	var addr1 = document.getElementById("addr1").value;
	var city = document.getElementById("city").value;
	var state = document.getElementById("state").value;
	var country = document.getElementById("country").value;
	var pincode = document.getElementById("zip").value;
	var desc = document.getElementById("desc").value;
	
	if(isEmpty(orgName) && isEmpty(addr1) && isEmpty(city) && isEmpty(state)
			&& isEmpty(country) && isEmpty(pincode) && isEmpty(desc)){
		return true;
	}	
	alert("Please provide all the mandatory information")
	return false;
}

function isEmpty(arg1){
	if(null == arg1)
		return false;
	if(arg1.trim() == '')
		return false;
	return true;
}


function checkLogin(){
	
	var username = document.getElementById("username").value;
	var pwd = document.getElementById("pwd").value;
	
	if(!isEmpty(username)){
		alert("Please provide Username");
		return false;
		}
	if(!isEmpty(pwd)){
		alert("Please provide password");
		return false;
	}
	return true;
	}
	
	