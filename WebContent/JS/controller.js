/**
 * 
 */
var loginApp = angular.module('sampleApp', []);


loginApp.controller('addUserController', function($scope) 
		{
			 
			$scope.adduser=function()
			{
				alert("called..");
			}
			
		});


		loginApp.controller('fecthUsersController', function($scope) {

			$scope.message = 'This is Registration page';

		});




loginApp.controller('fecthUsersController', function($scope) {

	$scope.message = 'This is Registration page';

});
