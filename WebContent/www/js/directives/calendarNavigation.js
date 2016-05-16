'use strict';

app.controller('CalendarNavigationController', function($scope) {
	var vm = this;
	vm.viewDate = vm.viewDate;
});


app.directive('calendarNavigation', function() {
	
	return {
		templateUrl: 'www/templates/directives/calendarNavigation.html',
		restrict: 'E',
		scope: {
			viewDate: '='
		},
		controller: 'CalendarNavigationController as vm',
		bindToController: true
	};
});