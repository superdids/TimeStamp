package eu.jeisn.stamp.json.projects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.models.Project;
import eu.jeisn.stamp.models.Task;

@XmlRootElement
public class ProjectView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Integer id;
	public String name;
	public Date toDate;
	public Date fromDate;
	public List<TaskView> tasks = new ArrayList<>();
	
	public ProjectView() {
		
	}
	
	public ProjectView(Project project) {
		id = project.getId();
		name = project.getName();
		toDate = project.getToDate();
		fromDate = project.getFromDate();
		if(project.getTasks() != null && project.getTasks().size() > 0) {
			for(Task task : project.getTasks()) {
				tasks.add(new TaskView(task));
			}
		}
	}
	
}
