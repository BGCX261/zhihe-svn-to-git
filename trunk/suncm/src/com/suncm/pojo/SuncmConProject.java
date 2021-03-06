package com.suncm.pojo;

// Generated 2010-2-12 22:14:29 by Hibernate Tools 3.2.4.GA

/**
 * SuncmConProject generated by hbm2java
 */
public class SuncmConProject implements java.io.Serializable {

	private SuncmConProjectId id;
	private SuncmConInfo suncmConInfo;
	private SuncmProjectInfo suncmProjectInfo;
	private int seqNo;

	public SuncmConProject() {
	}

	public SuncmConProject(SuncmConProjectId id, SuncmConInfo suncmConInfo,
			SuncmProjectInfo suncmProjectInfo, int seqNo) {
		this.id = id;
		this.suncmConInfo = suncmConInfo;
		this.suncmProjectInfo = suncmProjectInfo;
		this.seqNo = seqNo;
	}

	public SuncmConProjectId getId() {
		return this.id;
	}

	public void setId(SuncmConProjectId id) {
		this.id = id;
	}

	public SuncmConInfo getSuncmConInfo() {
		return this.suncmConInfo;
	}

	public void setSuncmConInfo(SuncmConInfo suncmConInfo) {
		this.suncmConInfo = suncmConInfo;
	}

	public SuncmProjectInfo getSuncmProjectInfo() {
		return this.suncmProjectInfo;
	}

	public void setSuncmProjectInfo(SuncmProjectInfo suncmProjectInfo) {
		this.suncmProjectInfo = suncmProjectInfo;
	}

	public int getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

}
