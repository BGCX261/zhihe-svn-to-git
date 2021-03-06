package com.suncm.pojo;

// Generated 2010-2-12 22:14:29 by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;

/**
 * SuncmProjectInfo generated by hbm2java
 */
public class SuncmProjectInfo implements java.io.Serializable {

	private String projectId;
	private SuncmProjectCate suncmProjectCate;
	private String projectName;
	private int projectStatus;
	private int isdelete;
	private String createdate;
	private String auditdate;
	private String createUser;
	private String createDep;
	private String forext1;
	private String forext2;
	private String projectFinal;
	private String executionId;
	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	private Set<SuncmConProject> suncmConProjects = new HashSet<SuncmConProject>(
			0);
	private Set<SuncmProjectExt> suncmProjectExts = new HashSet<SuncmProjectExt>(
			0);

	public SuncmProjectInfo() {
	}

	public SuncmProjectInfo(String projectId,
			SuncmProjectCate suncmProjectCate, int projectStatus, int isdelete) {
		this.projectId = projectId;
		this.suncmProjectCate = suncmProjectCate;
		this.projectStatus = projectStatus;
		this.isdelete = isdelete;
	}

	public SuncmProjectInfo(String projectId,
			SuncmProjectCate suncmProjectCate, String projectName,
			int projectStatus, int isdelete, String createdate,
			String auditdate, String createUser, String createDep,
			String forext1, String forext2, String projectFinal,
			Set<SuncmConProject> suncmConProjects,
			Set<SuncmProjectExt> suncmProjectExts) {
		this.projectId = projectId;
		this.suncmProjectCate = suncmProjectCate;
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.isdelete = isdelete;
		this.createdate = createdate;
		this.auditdate = auditdate;
		this.createUser = createUser;
		this.createDep = createDep;
		this.forext1 = forext1;
		this.forext2 = forext2;
		this.projectFinal = projectFinal;
		this.suncmConProjects = suncmConProjects;
		this.suncmProjectExts = suncmProjectExts;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public SuncmProjectCate getSuncmProjectCate() {
		return this.suncmProjectCate;
	}

	public void setSuncmProjectCate(SuncmProjectCate suncmProjectCate) {
		this.suncmProjectCate = suncmProjectCate;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectStatus() {
		return this.projectStatus;
	}

	public void setProjectStatus(int projectStatus) {
		this.projectStatus = projectStatus;
	}

	public int getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public String getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getAuditdate() {
		return this.auditdate;
	}

	public void setAuditdate(String auditdate) {
		this.auditdate = auditdate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateDep() {
		return this.createDep;
	}

	public void setCreateDep(String createDep) {
		this.createDep = createDep;
	}

	public String getForext1() {
		return this.forext1;
	}

	public void setForext1(String forext1) {
		this.forext1 = forext1;
	}

	public String getForext2() {
		return this.forext2;
	}

	public void setForext2(String forext2) {
		this.forext2 = forext2;
	}

	public String getProjectFinal() {
		return this.projectFinal;
	}

	public void setProjectFinal(String projectFinal) {
		this.projectFinal = projectFinal;
	}

	public Set<SuncmConProject> getSuncmConProjects() {
		return this.suncmConProjects;
	}

	public void setSuncmConProjects(Set<SuncmConProject> suncmConProjects) {
		this.suncmConProjects = suncmConProjects;
	}

	public Set<SuncmProjectExt> getSuncmProjectExts() {
		return this.suncmProjectExts;
	}

	public void setSuncmProjectExts(Set<SuncmProjectExt> suncmProjectExts) {
		this.suncmProjectExts = suncmProjectExts;
	}

}
