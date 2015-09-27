// Code goes here

var MainController = function($scope){
  $scope.message = "Post Your ADD";
  $scope.overtopmsg = "Now you can post your ADD at any time, any where !!!";
  $scope.color="black"
}
var SuccessController = function($scope){	
	
	$scope.message = "Post your ADD";
	$scope.overtopmsg = "Your ADD successfully posted";
	$scope.color="green"
}

var ErrorController = function($scope){	
	
	$scope.message = "Post your ADD";
	$scope.overtopmsg = "Error in posting ADD, Please try again";
	$scope.color="red"
}


var LoginController = function($scope){
	  $scope.message = "Post Your ADD";
	  $scope.overtopmsg = "Now you can post your ADD at any time, any where !!!";
	  $scope.color="black";
	  $scope.header="LOGIN";
	  $scope.errmsg="Please provide valid login details";
	  $scope.username="User name";
	  $scope.pwd="Password";
	  $scope.btnvalue="Login";
	  $scope.regmsg="Don't have an account,  create now, it is simple";
	  
	}

var RegisterController = function($scope){
	  $scope.message = "Post Your ADD";
	  $scope.overtopmsg = "Now you can post your ADD at any time, any where !!!";
	  $scope.color="black";
	  $scope.header="Create an Account";
	  $scope.errmsg="Sorry! Username already exists, Please try with new one";
	  $scope.username="User name";
	  $scope.pwd="Password";
	  $scope.btnvalue="Register";
	 
	  
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
	
	