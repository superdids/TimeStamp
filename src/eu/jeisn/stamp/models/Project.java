package eu.jeisn.stamp.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Table(name="project")
@Entity
@XmlRootElement
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="project_name")
	private String name;
	
	@Column(name="to_date") 
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date toDate;
	
	@Column(name="from_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date fromDate;	
	
	@OneToMany(mappedBy="project")
	private List<Participation> participations;
	
	@OneToMany(mappedBy="project")
	private List<Task> tasks;

	public Project() {
		
	}
	
	public Project(String name, Date toDate, Date fromDate) {
		this.name = name;
		this.toDate = toDate;
		this.fromDate = fromDate;
	}
	
	public Project(String name, Date toDate, Date fromDate, List<Participation> participations, List<Task> tasks) {
		this.name = name;
		this.toDate = toDate;
		this.fromDate = fromDate;
		this.participations = participations;
		this.tasks = tasks;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@XmlTransient
	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}
	
	@XmlTransient
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}

