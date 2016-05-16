package eu.jeisn.stamp.json.projectpost;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserPost implements Serializable {

	private static final long serialVersionUID = 1L;

	public String userName;
	public String name;
	
	public UserPost() {
		
	}
}
