'use strict';

app.factory('ChartPreparatorService', function(moment) {
	
	var generateLabels = function(viewDate) {
		var startOfWeek = moment(viewDate).startOf('week').startOf('day');
		var count = 0;
		var dates = [];
		while(count < 7) {
			dates.push({
				index: startOfWeek.format('e'),
				date: startOfWeek.clone()
				}
			);
			startOfWeek.add(1, 'day');
			++count;
		}
		return dates;
	};
	
	var generateYearWeekByViewDate = function(viewDate) {
		return Math.ceil(moment(viewDate).dayOfYear() / 7).toString()
		+ moment(viewDate).format('YYYY');
	};
	
	var generateSeries = function(users) {
		var series = [];
		for(var i in users) {
			series.push(users[i].name);
		}
		return series;
	};
	
	var generateData = function(users, weekYear, dates) {
		var data = [];
		
		for(var i in users) {
			var tasks = [];
		
			for(var j in users[i].tasks[weekYear]) {
				var idx = 0;
				while(idx < 7 && moment(dates[idx].date).diff(moment(users[i].tasks[weekYear][j].fromDate), 'days') != 0) {
					++idx;
				}
				
				if(idx < 7) {
					tasks[idx] = users[i].tasks[weekYear][j].hours;
				}
				
			}
			data.push(tasks);
		}
		
		return data;
	};
	
	return {
		generateLabels: generateLabels,
		generateYearWeekByViewDate: generateYearWeekByViewDate,
		generateSeries: generateSeries,
		generateData: generateData
	};
});