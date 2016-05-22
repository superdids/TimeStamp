'use strict';

app.controller('ChartsController', function($scope, moment, ChartPreparatorService) {
	var vm = this;
	$scope.project = vm.project;
	vm.viewDate = vm.viewDate;

	$scope.dates = [];
	
	$scope.entryFound = false;
	$scope.weekYear = '';
	
	
	
	$scope.labels = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
	
	$scope.generateLabels = function() {
		$scope.dates = ChartPreparatorService.generateLabels(vm.viewDate);
		$scope.weekYear = ChartPreparatorService.generateYearWeekByViewDate(vm.viewDate);
		$scope.entryFound = !($scope.project.users.length == 0 || $scope.project.users[0].tasks[$scope.weekYear] === undefined);
	};
	
	$scope.generateData = function() {
		$scope.series = ChartPreparatorService.generateSeries($scope.project.users);
		$scope.data = ChartPreparatorService.generateData($scope.project.users, $scope.weekYear, $scope.dates);
	};
	
	
	
	$scope.$watch('vm.viewDate', function(newValue, oldValue) {
		vm.viewDate = newValue;
		$scope.generateLabels();
		if(!$scope.entryFound || $scope.project.users.length === 0) {
			console.log('returning');
			return;
		}
		$scope.generateData();
	});
	

	
	
	//$scope.series = ['Series A', 'Series B', 'C'];
	  $scope.data = [
	    [65, 59, 80, 81, 56, 55, 40],
	    [28, 48, 40, 19, 86, 27, 90],
	    [28, 48, 40, 19, 86, 27, 90],
	    [65, 48, 80, 19, 56, 27, 40]
	  ];
	 /*$scope.labels = ["January", "February", "March", "April", "May", "June", "July"];
	  
	  $scope.onClick = function (points, evt) {
	    console.log(points, evt);
	  };*/
});


app.directive('chartsView', function() {

	return {
		templateUrl: 'www/templates/directives/charts.html',
		restrict: 'E',
		scope: {
			project: '=',
			viewDate: '='
		},
		controller: 'ChartsController as vm',
		bindToController: true
	};
});