package eu.jeisn.stamp.zzTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.models.Project;
import eu.jeisn.stamp.models.Task;
import eu.jeisn.stamp.models.User;

@XmlRootElement
public class ProjectWithUsers implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Integer id;
	public String name;
	public Date fromDate;
	public Date toDate;
	public List<UserWithTasks> users = new ArrayList<UserWithTasks>();
	
	public ProjectWithUsers(Project project) {
		this.id = project.getId();
		this.name = project.getName();
		this.fromDate = project.getFromDate();
		this.toDate = project.getToDate();
	}
	
	public void addUser(User user, List<Task> tasks) {
		users.add(new UserWithTasks(user, tasks));
	}
	
}
