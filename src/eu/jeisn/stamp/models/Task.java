package eu.jeisn.stamp.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Table(name="task")
@Entity
@XmlRootElement
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="from_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date fromDate;

	@Column(name="to_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date toDate;
	
	@ManyToOne
	@JoinColumn(name="usr")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="project")
	private Project project;
	
	public Task() {
		
	}
	
	public Task(Date fromDate, Date toDate, User user, Project project) {
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.user = user;
		this.project = project;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", fromDate=" + fromDate + ", toDate=" + toDate + ", user=" + user + "]";
	}
}
