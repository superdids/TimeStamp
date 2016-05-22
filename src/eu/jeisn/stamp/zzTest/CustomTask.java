package eu.jeisn.stamp.zzTest;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.models.Task;
import eu.jeisn.stamp.utils.DateUtils;

@XmlRootElement
public class CustomTask implements Serializable {
	
	public Integer id;
	public Date toDate;	
	public Date fromDate;
	public int hours;
	
	public CustomTask() {
		
	}
	
	public CustomTask(Task task) {
		id = task.getId();
		toDate = task.getToDate();
		fromDate = task.getFromDate();
		hours = DateUtils.getHours(fromDate, toDate);
	}
}
