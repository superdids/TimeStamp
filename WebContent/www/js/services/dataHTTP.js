'use strict';

app.factory('DataHTTPService', function($http, TimeStampConfig, moment) {
	var baseUrl = TimeStampConfig.baseUrl;
	
	var projects = [];
	
	var getProjects = function() {
		return projects;
	};
	
	var setProjects = function(p) {
		projects = p;
	};
	
	var getProjectsHTTP = function() {
		 $http.get(baseUrl + '/api/Projects').then(function(response) {
			 projects = response.data;
		 });
	};
	
	var postProjectHTTP = function(data) {
		$http.post(baseUrl + '/api/Projects', data).then(function(response) {
			projects.push(response.data);
		});
	};
	
	var users = [];
	
	var getUsers = function() {
		return users;
	};
	
	var setUsers = function(u) {
		users = u;
	};
	
	var getUsersHTTP = function() {
		$http.get(baseUrl + '/api/Users/').then(function(response) {
			users = response.data;
		});
	};
	
	return {
		getProjects: getProjects,
		setProjects: setProjects,
		getProjectsHTTP: getProjectsHTTP,
		postProjectHTTP: postProjectHTTP,
		getUsers: getUsers,
		setUsers: setUsers,
		getUsersHTTP: getUsersHTTP
	};
});