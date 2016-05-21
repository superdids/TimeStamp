package eu.jeisn.stamp.json.projectpost;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Custom view of a task sent from the client")
@XmlRootElement
public class TaskPost implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="Start time of the task")
	public Date fromDate;
	@ApiModelProperty(value="End time of the task")
	public Date toDate;
	@ApiModelProperty(value="The user-owner of this task")
	public String userName;
	
	public TaskPost() {
		
	}
}
