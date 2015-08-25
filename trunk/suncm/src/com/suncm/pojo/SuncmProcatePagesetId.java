package com.suncm.pojo;

// Generated 2010-2-12 22:14:29 by Hibernate Tools 3.2.4.GA

/**
 * SuncmProcatePagesetId generated by hbm2java
 */
public class SuncmProcatePagesetId implements java.io.Serializable {

	private String projectCateId;
	private int pageNo;

	public SuncmProcatePagesetId() {
	}

	public SuncmProcatePagesetId(String projectCateId, int pageNo) {
		this.projectCateId = projectCateId;
		this.pageNo = pageNo;
	}

	public String getProjectCateId() {
		return this.projectCateId;
	}

	public void setProjectCateId(String projectCateId) {
		this.projectCateId = projectCateId;
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
		if (!(other instanceof SuncmProcatePagesetId))
			return false;
		SuncmProcatePagesetId castOther = (SuncmProcatePagesetId) other;

		return ((this.getProjectCateId() == castOther.getProjectCateId()) || (this
				.getProjectCateId() != null
				&& castOther.getProjectCateId() != null && this
				.getProjectCateId().equals(castOther.getProjectCateId())))
				&& (this.getPageNo() == castOther.getPageNo());
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getProjectCateId() == null ? 0 : this.getProjectCateId()
						.hashCode());
		result = 37 * result + this.getPageNo();
		return result;
	}

}
