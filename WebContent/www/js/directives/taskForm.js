'use strict';

app.controller('TaskFormController', function($scope) {

	var vm = this;
	$scope.users = vm.users;
	$scope.projects = vm.projects || [];
	$scope.day = 0;
	$scope.mytime= new Date();
	//TimePicker
	$scope.hstep = 1;
	$scope.mstep = 15;

	$scope.options = {
			hstep: [1, 2, 3],
			mstep: [1, 5, 10, 15, 25, 30]
	};
	
	$scope.submitTask = function() {
		console.log('Task submitted.');
	};
});

app.directive('taskForm', function() {

	return {
		templateUrl: 'www/templates/directives/taskForm.html',
		restrict: 'E',
		scope: {
			users: '@',
			projects: '@'
		},
		controller: 'TaskFormController as vm',
		bindToController: true
	};
});