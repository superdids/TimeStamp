'use strict';

app.controller('TimeSheetController', function($scope, AuthorizationService, moment, DataHTTPService) {

	$scope.user = AuthorizationService.getUser();
	$scope.viewDate = new Date();

	$scope.projects = [];
	
	$scope.$watch(DataHTTPService.getProjects, function(newValue, oldValue) {
		$scope.projects = newValue;
	});
	
	$scope.isCellOpen = true;

	$scope.users = [];
	
	$scope.$watch(DataHTTPService.getUsers, function(newValue, oldValue) {
		$scope.users = newValue;
		
	});

	$scope.projectForm = {
		name: '',	
	};
	
	$scope.submitProject = function() {
		console.log('sui');
	};

	$scope.usersTasksView = [];


	$scope.eventClicked = function(event) {
		console.log(JSON.stringify(event, null, 4));
	};

	//Datepicker
//	$scope.today = function() {
//		$scope.dt = new Date();
//	};
//	$scope.today();
//
//	$scope.clear = function() {
//		$scope.dt = null;
//	};
//
//	$scope.inlineOptions = {
//			customClass: getDayClass,
//			minDate: new Date(),
//			showWeeks: true
//	};
//
//	$scope.dateOptions = {
//			dateDisabled: disabled,
//			formatYear: 'yy',
//			maxDate: new Date(2020, 5, 22),
//			minDate: new Date(),
//			startingDay: 1
//	};
//
//	$scope.toggleMin = function() {
//		$scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
//		$scope.dateOptions.minDate = $scope.inlineOptions.minDate;
//	};
//
//	$scope.toggleMin();
//
//	function disabled(data) {
//		var date = data.date,
//		mode = data.mode;
//		return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
//	};
//
//
//	$scope.open1 = function() {
//		$scope.popup1.opened = true;
//	};
//
//	$scope.open2 = function() {
//		$scope.popup2.opened = true;
//	};
//
//	$scope.setDate = function(year, month, day) {
//		$scope.dt = new Date(year, month, day);
//	};
//
//	$scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
//	$scope.format = $scope.formats[0];
//	$scope.altInputFormats = ['M!/d!/yyyy'];
//
//	$scope.popup1 = {
//			opened: false
//	};
//
//	$scope.popup2 = {
//			opened: false
//	};
//	var tomorrow = new Date();
//	tomorrow.setDate(tomorrow.getDate() + 1);
//	var afterTomorrow = new Date();
//	afterTomorrow.setDate(tomorrow.getDate() + 1);
//	$scope.events = [
//	                 {
//	                	 date: tomorrow,
//	                	 status: 'full'
//	                 },
//	                 {
//	                	 date: afterTomorrow,
//	                	 status: 'partially'
//	                 }
//	                 ];
//
//	function getDayClass(data) {
//		var date = data.date,
//		mode = data.mode;
//		if (mode === 'day') {
//			var dayToCheck = new Date(date).setHours(0,0,0,0);
//
//			for (var i = 0; i < $scope.events.length; i++) {
//				var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);
//
//				if (dayToCheck === currentDay) {
//					return $scope.events[i].status;
//				}
//			}
//		}
//
//		return '';
//	}
//	
	//TimePicker
//	  $scope.hstep = 1;
//	  $scope.mstep = 15;
//
//	  $scope.options = {
//	    hstep: [1, 2, 3],
//	    mstep: [1, 5, 10, 15, 25, 30]
//	  };

	  //$scope.ismeridian = true;
});