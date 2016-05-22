package eu.jeisn.stamp.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import eu.jeisn.stamp.json.projects.TaskView;
import eu.jeisn.stamp.models.Task;
import eu.jeisn.stamp.zzTest.CustomTask;

public class DateUtils {

	public static String yearWeek(Date date) {
		LocalDateTime ldt = toNewDate(date);
		int week = getWeek(ldt);
		int year = ldt.getYear();
		return (week > 9 ? week : "0" + week) + "" + year;
	}


	public static Map<String, List<TaskView>> filterByWeek(List<TaskView> tasks) {
		Map<String, List<TaskView>> result = new HashMap<>();

		if(tasks != null && tasks.size() > 0) {
			for(TaskView task : tasks) {
				String yw = yearWeek(task.fromDate);
				List<TaskView> tmp = null;
				if((tmp = result.get(yw)) == null) {
					tmp = new ArrayList<TaskView>();
				}
				tmp.add(task);
				result.put(yw, tmp);
			}
		}

		return new TreeMap<String, List<TaskView>>(result);
	}

	public static Map<String, List<CustomTask>> filterCustomByWeek(List<Task> tasks) {
		Map<String, List<CustomTask>> result = new HashMap<>();

		if(tasks != null && tasks.size() > 0) {
			for(Task task : tasks) {
				String yw = yearWeek(task.getFromDate());
				List<CustomTask> tmp = null;
				if((tmp = result.get(yw)) == null) {
					tmp = new ArrayList<CustomTask>();
				}
				tmp.add(new CustomTask(task));
				result.put(yw, tmp);
			}
		}

		return new TreeMap<String, List<CustomTask>>(result);
	}
	
	public static LocalDateTime toNewDate(Date date) {
		Instant instant = Instant.ofEpochMilli(date.getTime());
		LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
		return ldt;
	}

	public static Date toOldDate(LocalDateTime ldt) {
		Instant instant = ldt.toInstant(ZoneOffset.UTC);
		Date date = Date.from(instant);
		return date;
	}
	
	public static int getWeek(LocalDateTime ldt) {
		WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
		int weekNumber = ldt.get(weekFields.weekOfWeekBasedYear());
		
//		TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
		return weekNumber - 1;
	}
	
	public static int getHours(Date from, Date to) {
		LocalDateTime ldtFrom = toNewDate(from);
		LocalDateTime ldtTo = toNewDate(to);
		int hoursDiff = (int) ChronoUnit.HOURS.between(ldtFrom, ldtTo);
		return hoursDiff;
	}
	
}
