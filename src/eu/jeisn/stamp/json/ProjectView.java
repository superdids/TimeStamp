package eu.jeisn.stamp.json;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.models.Project;

@XmlRootElement
public class ProjectView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Integer id;
	public String name;
	public Date toDate;
	public Date fromDate;
	
	public ProjectView() {
		
	}
	
	public ProjectView(Project project) {
		id = project.getId();
		name = project.getName();
		toDate = project.getToDate();
		fromDate = project.getFromDate();
	}
	
}
