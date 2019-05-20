package org.hubotek.model.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hubotek.model.Project;

@SuppressWarnings("serial")
@Entity
@Table(name="google_project")
public class GoogleProject extends Project {

	@Column(name="project_id" , length=255 , insertable=true , updatable=false , nullable=false)
	private String projectId;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	
}
