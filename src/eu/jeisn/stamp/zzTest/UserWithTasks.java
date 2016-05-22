package eu.jeisn.stamp.zzTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.json.projects.TaskView;
import eu.jeisn.stamp.models.Task;
import eu.jeisn.stamp.models.User;
import eu.jeisn.stamp.utils.DateUtils;

@XmlRootElement
public class UserWithTasks implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String userName;
	public String name;
	
	public Map<String, List<CustomTask>> tasks;
	
	@SuppressWarnings("unused")
	private UserWithTasks() {}
	
	public UserWithTasks(User user, List<Task> tsks) {
		this.userName = user.getUserName();
		this.name = user.getName();

		tasks = DateUtils.filterCustomByWeek(tsks);
	}
}
