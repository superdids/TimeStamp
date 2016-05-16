package eu.jeisn.stamp.json.projectpost;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TaskPost implements Serializable {

	private static final long serialVersionUID = 1L;

	public Date fromDate;
	public Date toDate;
	public String userName;
	
	public TaskPost() {
		
	}
}
