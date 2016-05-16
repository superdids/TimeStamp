'use strict';

app.controller('ProjectFormController', function($scope, moment, DataHTTPService, PostPreparatorService) {

	var vm = this;
	$scope.viewDate = new Date();

	$scope.users = vm.users;

	$scope.submitProject = function() {
		var prepared = PostPreparatorService.prepareProjectPost({
			name: $scope.name,
			events: $scope.timeSelection
		});
		
		if(prepared.valid && prepared.valid === true) {
			DataHTTPService.postProjectHTTP(prepared.data);
			$scope.name = '';
			$scope.selectedUsers = [];
			$scope.timeSelection = {};
			$scope.currentWeek = {};
		}
	};

	$scope.selectedUsers = [];

	$scope.toggleSelectedUser = function(usr) {
		var idx = $scope.added(usr.userName)
		if(idx > -1) {
			$scope.selectedUsers.splice(idx, 1);
			$scope.selectedUserUpdated(usr, false);
		} else {
			usr = angular.copy(usr);
			usr.days = [];
			$scope.selectedUsers.push(usr);
			$scope.selectedUserUpdated(usr, true);
		}
	};

	$scope.added = function(userName) {
		return $scope.selectedUsers.map(function(user) {
			return user.userName;
		}).indexOf(userName);
	};

	$scope.timeSelection = {};
	$scope.currentWeek = {};

	$scope.selectedWeek = function() {
		return moment($scope.viewDate).format('YYYY') 
		+ Math.ceil(moment($scope.viewDate).dayOfYear() / 7).toString();
	};

	$scope.days = function() {
		var obj = moment($scope.viewDate).startOf('week').startOf('day');
		var days = [];
		days.push(obj.clone());
		days.push(obj.clone().day('Tuesday'));
		days.push(obj.clone().day('Wednesday'));
		days.push(obj.clone().day('Thursday'));
		days.push(obj.clone().day('Friday'));
		days.push(obj.clone().day('Saturday'));
		days.push(obj.clone().day('Sunday'));
		return days;
	};

	$scope.$watch('viewDate', function(newValue, oldValue) {

		var x = $scope.selectedWeek();
		if(!$scope.timeSelection[x]) {
			$scope.timeSelection[x] = {
					users: angular.copy($scope.selectedUsers),
					days: $scope.days()
			};
		}

		$scope.currentWeek = $scope.timeSelection[x];

	});

	$scope.selectedUserUpdated = function(user, added) {

		for(var key in $scope.timeSelection) {
			if($scope.timeSelection.hasOwnProperty(key)) {
				if($scope.timeSelection[key].users) {
					if(added) {
						$scope.timeSelection[key].users.push(angular.copy(user));
					} else {
						becauseElementIsFound:
							for(var x in $scope.timeSelection[key].users) {
								if($scope.timeSelection[key].users[x].userName === user.userName) {
									$scope.timeSelection[key].users.splice(x, 1);
									break becauseElementIsFound;
								}

							}
					}
				}
			}
		}
	};



});

app.directive('projectForm', function() {

	return {
		templateUrl: 'www/templates/directives/projectForm.html',
		restrict: 'E',
		scope: {
			users: '='
		},
		controller: 'ProjectFormController as vm',
		bindToController: true
	};
});