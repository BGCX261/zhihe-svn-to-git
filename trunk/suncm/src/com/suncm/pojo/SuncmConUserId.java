package com.suncm.pojo;

// Generated 2010-2-12 22:14:29 by Hibernate Tools 3.2.4.GA

/**
 * SuncmConUserId generated by hbm2java
 */
public class SuncmConUserId implements java.io.Serializable {

	private String conId;
	private String userId;

	public SuncmConUserId() {
	}

	public SuncmConUserId(String conId, String userId) {
		this.conId = conId;
		this.userId = userId;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SuncmConUserId))
			return false;
		SuncmConUserId castOther = (SuncmConUserId) other;

		return ((this.getConId() == castOther.getConId()) || (this.getConId() != null
				&& castOther.getConId() != null && this.getConId().equals(
				castOther.getConId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null
						&& castOther.getUserId() != null && this.getUserId()
						.equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getConId() == null ? 0 : this.getConId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}
