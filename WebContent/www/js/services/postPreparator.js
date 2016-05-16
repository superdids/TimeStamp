'use strict';

app.factory('PostPreparatorService', function(moment) {

	var prepareProjectPost = function(data) {
		
		var preparedPost = {};
		preparedPost.name = data.name;
		preparedPost.tasks = [];
		preparedPost.users = [];
		
		var fromDate = undefined;
		var toDate = undefined;
		var selectedWeek = undefined;
		var tasks = 0;
		for(var key in data.events) {
			if(data.events.hasOwnProperty(key)) {
				if(selectedWeek === undefined) {
					selectedWeek = moment().week(key.substring(4,5)).startOf('week');
					fromDate = selectedWeek.clone();
					toDate = selectedWeek.clone().endOf('week');
				} else {
					selectedWeek = moment().week(key.substring(4,5)).startOf('week');
				}

				if(preparedPost.users.length === 0) {
					preparedPost.users = angular.copy(data.events[key].users);
					angular.forEach(preparedPost.users, function(user, index) {
						delete preparedPost.users[index].days;
					});
				}
				
				for(var x in data.events[key].users) {
					if(data.events[key].users[x].days) {
						for(var y in data.events[key].users[x].days) {
							if(data.events[key].users[x].days[y] && data.events[key].users[x].days[y] !== null) {
								++tasks;
								var taskFrom = data.events[key].days[y].clone();
								var taskTo = data.events[key].days[y].clone().add(data.events[key].users[x].days[y], 'hour')
								preparedPost.tasks.push({
									fromDate: taskFrom.format(),
									toDate: taskTo.format(),
									userName: data.events[key].users[x].userName
								});
								
								if(taskFrom.isBefore(fromDate)) {
									fromDate = taskFrom.clone();
								}
								if(toDate.isBefore(taskTo)) {
									toDate = taskTo.clone();
								}
							}
						}

					}

				}
			}
		}
		preparedPost.fromDate = fromDate.format();
		preparedPost.toDate = toDate.format();
		
		return {
			valid: tasks > 0 && data.name !== undefined,
			data: preparedPost
		};

	};

	return {
		prepareProjectPost: prepareProjectPost
	};
});