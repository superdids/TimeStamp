'use strict';

app.controller('APIController', function($scope, $http) {
	$scope.url = $scope.swaggerUrl = 'http://localhost:8080/Stamp/api/swagger.json';

	$scope.isLoading = false;

	$scope.data = [];

	$http.get($scope.url).then(function(response) {
		$scope.data = response.data;
	});

	$scope.error = '';

	$scope.myErrorHandler = function(data, status){
		$scope.error = status+': '+data;
	};

/*
	$scope.myTransform = function(request){
	    request.headers['api_key'] = 's5hredf5hy41er8yhee58';
	};*/
});