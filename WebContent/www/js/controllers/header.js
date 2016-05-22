'use strict';

app.controller('HeaderController', function($scope, DataHTTPService) {
	
	$scope.state = '';
	
	$scope.$watch(DataHTTPService.getState, function(newValue, oldValue) {
		$scope.state = newValue;
	});
	
});