package eu.jeisn.stamp.sweetProjectFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.models.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Custom view for projects")
@XmlRootElement
public class CustomProjectsView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="Projects to be serialized")
	public List<CustomProjectView> projects = new ArrayList<>();
	
	public CustomProjectsView(List<Project> arg) {
		if(arg != null && arg.size() > 0) {
			for(Project project : arg) {
				projects.add(new CustomProjectView(project));
			}
		}
	}
}
