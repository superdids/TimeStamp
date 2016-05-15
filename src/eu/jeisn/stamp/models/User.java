package eu.jeisn.stamp.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Table(name="usr")
@Entity
@XmlRootElement
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="user_name")
	@Id
	private String userName;
	
	@Column(name="pwd")
	private String password;
	
	@Column(name="full_name")
	private String name;
	
	@OneToMany(mappedBy="user")
	private List<Task> tasks;
	
	@OneToMany(mappedBy="user")
	private List<Participation> participations;
	
	public User() {
		
	}
	
	public User(String userName, String password, String name) {
		this.userName = userName;
		this.password = password;
		this.name = name;
	}
	
	public User(String userName, String password, String name, List<Task> tasks, List<Participation> participations) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.tasks = tasks;
		this.participations = participations;
	}
	
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlTransient
	public List<Task> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	@XmlTransient
	public List<Participation> getParticipations() {
		return participations;
	}
	
	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}
}
