package eu.jeisn.stamp.json.projects;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.models.Task;

@XmlRootElement
public class TaskView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Integer id;
	public Date toDate;
	public Date fromDate;
	public UserView user;
	
	public TaskView() {
		
	}
	
	public TaskView(Task task) {
		id = task.getId();
		toDate = task.getToDate();
		fromDate = task.getFromDate();
		user = new UserView(task.getUser());
	}
}
