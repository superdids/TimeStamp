package eu.jeisn.stamp.json;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Custom user view with his / her name omitted")
@XmlRootElement
public class UserLoginView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="Unique username")
	public String userName;
	@ApiModelProperty(value="The user's password")
	public String password;

	public UserLoginView() {
		
	}
}
