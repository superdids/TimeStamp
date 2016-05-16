'use strict';

app.factory('LoginService', function($http, TimeStampConfig) {
	var baseUrl = TimeStampConfig.baseUrl;
	
	var postUser = function(user) {
		return $http.post(baseUrl + '/api/Login', user);
	};
	
	return {
		postUser: postUser
	};
});