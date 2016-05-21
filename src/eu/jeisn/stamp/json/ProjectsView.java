package eu.jeisn.stamp.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Custom view of projects")
@XmlRootElement
public class ProjectsView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="The logged in user")
	public UserView user;
	@ApiModelProperty(value="All users in the system, why do we have this??")
	public List<UserView> users;
	@ApiModelProperty(value="All projects related to the logged in user")
	public List<ProjectView> projects;
	
	public ProjectsView() {
		users = new ArrayList<UserView>();
		projects = new ArrayList<ProjectView>();
	}
}
