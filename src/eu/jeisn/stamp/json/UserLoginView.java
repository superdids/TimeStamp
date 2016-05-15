package eu.jeisn.stamp.json;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserLoginView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String userName;
	public String password;

	public UserLoginView() {
		
	}
}
