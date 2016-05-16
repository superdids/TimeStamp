'use strict';

app.factory('AuthorizationService', function() {

	return {
		getUser: function() {
			var user = sessionStorage.getItem('user');
			user = JSON.parse(user);
			if(Object.keys(user).length === 0 && JSON.stringify(user) === JSON.stringify({})) {
				return '';
			}
			return user;
		},
		setUser: function(arg) {
			if(arg == '') {
				sessionStorage.setItem('user', '');
			} else {
				sessionStorage.setItem('user', JSON.stringify(arg));
			}
		}
	};
});