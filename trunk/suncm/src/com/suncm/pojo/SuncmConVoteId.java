package com.suncm.pojo;

// Generated 2010-2-12 22:14:29 by Hibernate Tools 3.2.4.GA

/**
 * SuncmConVoteId generated by hbm2java
 */
public class SuncmConVoteId implements java.io.Serializable {

	private String conId;
	private String userId;
	private String projectId;

	public SuncmConVoteId() {
	}

	public SuncmConVoteId(String conId, String userId, String projectId) {
		this.conId = conId;
		this.userId = userId;
		this.projectId = projectId;
	}

	public String getConId() {
		return this.conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SuncmConVoteId))
			return false;
		SuncmConVoteId castOther = (SuncmConVoteId) other;

		return ((this.getConId() == castOther.getConId()) || (this.getConId() != null
				&& castOther.getConId() != null && this.getConId().equals(
				castOther.getConId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null
						&& castOther.getUserId() != null && this.getUserId()
						.equals(castOther.getUserId())))
				&& ((this.getProjectId() == castOther.getProjectId()) || (this
						.getProjectId() != null
						&& castOther.getProjectId() != null && this
						.getProjectId().equals(castOther.getProjectId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getConId() == null ? 0 : this.getConId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getProjectId() == null ? 0 : this.getProjectId().hashCode());
		return result;
	}

}
