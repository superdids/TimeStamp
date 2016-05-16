'use strict';

app.controller('LoginController', function($scope, $state, LoginService, AuthorizationService, DataHTTPService) {
	$scope.result = {};
	$scope.user = {
			userName: 'didaub',
			password: 'Sommer2016'
	};

	$scope.valid = function() {
		return $scope.user.userName.length === 6;
	};

	$scope.submit = function() {
		LoginService.postUser($scope.user).then(function(response) {
			
			AuthorizationService.setUser(response.data.user);
			if(response.data.projects) {
				DataHTTPService.setProjects(response.data.projects);
			}
			
			if(response.data.users) {
				DataHTTPService.setUsers(response.data.users);
			}
			
			$state.go('app.timesheet');
		});
	};
});