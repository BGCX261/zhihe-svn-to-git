package com.suncm.pojo;

// Generated 2010-2-12 22:14:29 by Hibernate Tools 3.2.4.GA

/**
 * SuncmProjectExtId generated by hbm2java
 */
public class SuncmProjectExtId implements java.io.Serializable {

	private String projectId;
	private int pageNo;

	public SuncmProjectExtId() {
	}

	public SuncmProjectExtId(String projectId, int pageNo) {
		this.projectId = projectId;
		this.pageNo = pageNo;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public int getPageNo() {
		return this.pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SuncmProjectExtId))
			return false;
		SuncmProjectExtId castOther = (SuncmProjectExtId) other;

		return ((this.getProjectId() == castOther.getProjectId()) || (this
				.getProjectId() != null
				&& castOther.getProjectId() != null && this.getProjectId()
				.equals(castOther.getProjectId())))
				&& (this.getPageNo() == castOther.getPageNo());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getProjectId() == null ? 0 : this.getProjectId().hashCode());
		result = 37 * result + this.getPageNo();
		return result;
	}

}