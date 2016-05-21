package eu.jeisn.stamp.json.projectpost;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Custom view of projects sent from a client")
@XmlRootElement
public class ProjectPost implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="Name of the project")
	public String name;
	@ApiModelProperty(value="Project start date")
	public Date fromDate;
	@ApiModelProperty(value="Project end date")
	public Date toDate;
	@ApiModelProperty(value="Tasks associated to the project")
	public List<TaskPost> tasks;
	@ApiModelProperty(value="Users associated to the project")
	public List<UserPost> users;
	
	public ProjectPost() {
		
	}
}
