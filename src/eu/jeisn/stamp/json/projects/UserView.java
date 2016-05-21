package eu.jeisn.stamp.json.projects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.models.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Custom view of a user to be sent to clients")
@XmlRootElement
public class UserView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="A unique username")
	public String userName;
	@ApiModelProperty(value="The user's full name")
	public String name;
	
	public UserView() {
		
	}
	
	public UserView(User user) {
		userName = user.getUserName();
		name = user.getName();
	}
}
