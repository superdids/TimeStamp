var app = angular.module('app', ['ui.router', 'ui.bootstrap', 'mwl.calendar', 'chart.js', 'googlechart', 'swaggerUi', 'ngSanitize']);

app.config(function($urlRouterProvider, $stateProvider, moment, calendarConfig) {

	$stateProvider.state('app', {
		url: '',
		abstract: true,
		views: {
			'header@': {
				templateUrl: 'www/templates/header.html',
				controller: 'HeaderController'
			}
		}
	}).state('login', {
		url: '/Login', 
		views: {
			'content@': {
				templateUrl: 'www/templates/login.html',
				controller: 'LoginController'
			}
		}
	}).state('app.timesheet', {
		url: '/TimeStamp',
		views: {
			'content@': {
				templateUrl: 'www/templates/timeStamp.html',
				controller: 'TimeSheetController'
			}
		}
	}).state('app.api', {
		url: '/API',
		views: {
			'content@': {
				templateUrl: 'www/templates/api.html',
				controller: 'APIController'
			}
		}
	});

	$urlRouterProvider.otherwise("/Login");

	moment.updateLocale('en', {
		week: {
			dow: 1
		}
	});

	calendarConfig.templates.timeStampCalendar = 'www/templates/custom/calendar.html';
	calendarConfig.templates.timeStampCalendarWeek = 'www/templates/custom/week.html';
});


app.run(function($rootScope, $state, AuthorizationService, DataHTTPService) {
	$rootScope.$on('$stateChangeStart', function(event, next, current) {

		DataHTTPService.setState(next.url);
		
		if(next.url == '/Login') {
			AuthorizationService.setUser('');
			return;
		}

		if(next.url == '/TimeStamp') {
			if(AuthorizationService.getUser() === '') {
				event.preventDefault();
				$state.go('login');
			} else {
				DataHTTPService.getUsersHTTP();
				DataHTTPService.getProjectsHTTP();
			}
		}
	});
});

