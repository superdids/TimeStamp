package eu.jeisn.stamp.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Table(name="participation")
@Entity
//@IdClass(Participation.class) 
@XmlRootElement
public class Participation implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ParticipationId participationId;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name="user_id")
	private User user;

	@ManyToOne
	@MapsId("projectId")
	@JoinColumn(name="project_id")
	private Project project;

	public Participation() {

	}

	public Participation(ParticipationId participationId, User user, Project project) {
		this.participationId = participationId;
		this.user = user;
		this.project = project;
	}

	public ParticipationId getParticipationId() {
		return participationId;
	}

	public void setParticipationId(ParticipationId participationId) {
		this.participationId = participationId;
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
}
