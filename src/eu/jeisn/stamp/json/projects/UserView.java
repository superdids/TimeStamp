package eu.jeisn.stamp.json.projects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import eu.jeisn.stamp.models.User;

@XmlRootElement
public class UserView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String userName;
	public String name;
	
	public UserView() {
		
	}
	
	public UserView(User user) {
		userName = user.getUserName();
		name = user.getName();
	}
}
