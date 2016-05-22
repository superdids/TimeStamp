package eu.jeisn.stamp.sweetProjectFormat;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.models.Project;
import io.swagger.annotations.ApiModel;

@ApiModel(description="Custom view for a project")
@XmlRootElement
public class CustomProjectView implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public CustomProjectView(Project project) {
		
	}
}
