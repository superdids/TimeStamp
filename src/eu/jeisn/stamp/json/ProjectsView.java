package eu.jeisn.stamp.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProjectsView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public UserView user;
	public List<UserView> users;
	public List<ProjectView> projects;
	
	public ProjectsView() {
		users = new ArrayList<UserView>();
		projects = new ArrayList<ProjectView>();
	}
}
