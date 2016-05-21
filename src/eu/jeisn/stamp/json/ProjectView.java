package eu.jeisn.stamp.json;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.models.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Custom project view")
@XmlRootElement
public class ProjectView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="Identification of the project")
	public Integer id;
	@ApiModelProperty(value="The project title")
	public String name;
	@ApiModelProperty(value="The start date of the project")
	public Date toDate;
	@ApiModelProperty(value="The end date of the project")
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
