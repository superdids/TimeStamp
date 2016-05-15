package eu.jeisn.stamp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParticipationId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="project_id")
	private Integer projectId;
	
	@Column(name="user_id")
	private String userId;
	
	public ParticipationId() {
		
	}
	
	public ParticipationId(Integer projectId, String userId) {
		this.projectId = projectId;
		this.userId = userId;
	}
	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return projectId + userId.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj == null) {
			return false;
		}
		
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		ParticipationId other = (ParticipationId) obj;
		if(projectId == null) {
			if(other.projectId != null) {
				return false;
			}
		} else if(!projectId.equals(other.projectId)) {
			return false;
		}
		
		if(userId == null) {
			if(other.userId != null) {
				return false;
			}
		} else if(!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}
}
