'use strict';

app.controller('TimeStampCalendarWeekCtrl', function($scope, $sce, moment, calendarHelper, calendarConfig) {

	var vm = this;

	vm.showTimes = calendarConfig.showTimesOnWeekView;
	vm.$sce = $sce;

	$scope.$on('calendar.refreshView', function() {
		vm.dayViewSplit = vm.dayViewSplit || 30;
		vm.dayViewHeight = calendarHelper.getDayViewHeight(
				vm.dayViewStart,
				vm.dayViewEnd,
				vm.dayViewSplit
		);
		
		/*angular.forEach(vm.users, function(user, index) {
			vm.users[index].view = calendarHelper.getWeekView(user.events, vm.viewDate);
		});*/


		vm.view = calendarHelper.getWeekView([], vm.viewDate);
	});

	vm.weekDragged = function(event, daysDiff, minuteChunksMoved) {

		var newStart = moment(event.startsAt).add(daysDiff, 'days');
		var newEnd = moment(event.endsAt).add(daysDiff, 'days');

		if (minuteChunksMoved) {
			var minutesDiff = minuteChunksMoved * vm.dayViewSplit;
			newStart = newStart.add(minutesDiff, 'minutes');
			newEnd = newEnd.add(minutesDiff, 'minutes');
		}

		delete event.tempStartsAt;

		vm.onEventTimesChanged({
			calendarEvent: event,
			calendarNewEventStart: newStart.toDate(),
			calendarNewEventEnd: event.endsAt ? newEnd.toDate() : null
		});
	};

	vm.eventDropped = function(event, date) {
		var daysDiff = moment(date).diff(moment(event.startsAt), 'days');
		vm.weekDragged(event, daysDiff);
	};

	vm.weekResized = function(event, edge, daysDiff) {

		var start = moment(event.startsAt);
		var end = moment(event.endsAt);
		if (edge === 'start') {
			start.add(daysDiff, 'days');
		} else {
			end.add(daysDiff, 'days');
		}

		vm.onEventTimesChanged({
			calendarEvent: event,
			calendarNewEventStart: start.toDate(),
			calendarNewEventEnd: end.toDate()
		});

	};

	vm.tempTimeChanged = function(event, minuteChunksMoved) {
		var minutesDiff = minuteChunksMoved * vm.dayViewSplit;
		event.tempStartsAt = moment(event.startsAt).add(minutesDiff, 'minutes').toDate();
	};

})
.directive('timeStampCalendarWeek', function(calendarConfig) {

	return {
		templateUrl: calendarConfig.templates.timeStampCalendarWeek,
		restrict: 'E',
		require: '^timeStampCalendar',
		scope: {
			users: '=',
			viewDate: '=',
			onEventClick: '=',
			onEventTimesChanged: '=',
			dayViewStart: '=',
			dayViewEnd: '=',
			dayViewSplit: '=',
			onTimespanClick: '='
		},
		controller: 'TimeStampCalendarWeekCtrl as vm',
		link: function(scope, element, attrs, calendarCtrl) {
			scope.vm.calendarCtrl = calendarCtrl;
		},
		bindToController: true
	};

});