// JavaScript Document

var loginApp = angular.module('sampleApp', []);

loginApp.config(['$routeProvider',
  function($routeProvider) {
	 
    $routeProvider.
      when('/add', {
		  
	templateUrl: 'JSP/addUser.jsp',
	controller: 'addUserController'
      }).
      when('/getAll', {
	templateUrl: 'JSP/dispAllUsers.jsp',
	controller: 'fecthUsersController'
      }).
      otherwise({
	redirectTo: 'home'
      });
}]);


