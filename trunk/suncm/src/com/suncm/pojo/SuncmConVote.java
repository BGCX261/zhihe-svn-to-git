package com.suncm.pojo;

// Generated 2010-2-12 22:14:29 by Hibernate Tools 3.2.4.GA

/**
 * SuncmConVote generated by hbm2java
 */
public class SuncmConVote implements java.io.Serializable {

	private SuncmConVoteId id;
	private String voteIdea;
	private String voteType;
	private String voteTime;

	public SuncmConVote() {
	}

	public SuncmConVote(SuncmConVoteId id, String voteTime) {
		this.id = id;
		this.voteTime = voteTime;
	}

	public SuncmConVote(SuncmConVoteId id, String voteIdea, String voteType,
			String voteTime) {
		this.id = id;
		this.voteIdea = voteIdea;
		this.voteType = voteType;
		this.voteTime = voteTime;
	}

	public SuncmConVoteId getId() {
		return this.id;
	}

	public void setId(SuncmConVoteId id) {
		this.id = id;
	}

	public String getVoteIdea() {
		return this.voteIdea;
	}

	public void setVoteIdea(String voteIdea) {
		this.voteIdea = voteIdea;
	}

	public String getVoteType() {
		return this.voteType;
	}

	public void setVoteType(String voteType) {
		this.voteType = voteType;
	}

	public String getVoteTime() {
		return this.voteTime;
	}

	public void setVoteTime(String voteTime) {
		this.voteTime = voteTime;
	}

}