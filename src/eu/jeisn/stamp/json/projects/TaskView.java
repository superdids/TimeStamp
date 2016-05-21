package eu.jeisn.stamp.json.projects;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.models.Task;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Custom view of a task to be sent to clients")
@XmlRootElement
public class TaskView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="The identification of the task")
	public Integer id;
	@ApiModelProperty(value="Start time of the task")
	public Date toDate;
	@ApiModelProperty(value="End time of the task")
	public Date fromDate;
	@ApiModelProperty(value="The associated user to the task")
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
