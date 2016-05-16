package eu.jeisn.stamp.json.projectpost;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProjectPost implements Serializable {

	private static final long serialVersionUID = 1L;

	public String name;
	public Date fromDate;
	public Date toDate;
	public List<TaskPost> tasks;
	public List<UserPost> users;
	
	public ProjectPost() {
		
	}
}
