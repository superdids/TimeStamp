'use strict';

app.filter('filterViewDate', function(moment) {
	return function(input) {
		
		var obj = moment(input);
		var week = obj.format('WW')
		var startOfWeek = obj.startOf('week').format('DD-MM');
		var endOfWeek = obj.endOf('week').format('DD-MM');
		var year = obj.format('YYYY');
		
		return 'Week: ' + week + ' | ' + startOfWeek + ' - ' + endOfWeek + ' | ' + year;
	};
});