<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"></link>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body ng-app="fectchUsers">
<div ng-controller="fecthUsersController">
<button ng-click="getData()">Display Data</button>
<table>
<thead>
<th>First Name</th>
<th>Last Name</th>
<th>Email Id</th>
<th>Edit</th>
<th>Delete</th>
</thead>
<tbody>
<tr ng-repeat="user in userDetails">
<td>{{user.fname}}</td>
<td>{{user.lname}}</td>
<td>{{user.email}}</td>
<td><a href="">edit</a></td>
<td><a href="">delete</a></td>
</tr>
</tbody>
</table>
</div>
</body>
<script type="text/javascript">
var app=angular.module("fectchUsers", []);
app.controller("fecthUsersController", function($scope,$http) {
	$scope.getData=function()
	{
	$http.get("http://localhost:8080/LoginApp/getAllUsers")
	.success(function(data,headers)
	{
		alert(data);
		$scope.userDetails=data;
	}).error(function(data,status,headers)
	{
		alert(data);
		alert(headers);
	});
	};
})

</script>
</html>