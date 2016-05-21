package eu.jeisn.stamp.json.projects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.models.Project;
import eu.jeisn.stamp.models.Task;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Custom view of a project to be sent to a client")
@XmlRootElement
public class ProjectView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="The identification of the project")
	public Integer id;
	@ApiModelProperty(value="The name of the project")
	public String name;
	@ApiModelProperty(value="Start date of the project")
	public Date toDate;
	@ApiModelProperty(value="End date of the project")
	public Date fromDate;
	@ApiModelProperty(value="The associated tasks to the project")
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
