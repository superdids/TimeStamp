package eu.jeisn.stamp.json.projectpost;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Custom view of a user sent from the client")
@XmlRootElement
public class UserPost implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="A unique username")
	public String userName;
	@ApiModelProperty(value="The user's full name")
	public String name;
	
	public UserPost() {
		
	}
}
