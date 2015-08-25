package com.suncm.um;

import java.util.List;

/**
 * 系统定位于在企业现有系统基础上提供扩展，所以假定用户信息全部来自外系统，通过web service,socket等方式获得
 * 用户信息全部抽象在这样一个类中
 * 
 * @author xiezc
 *
 */
public class SuncmUser {
	private String userId;
	private String userName;
	private List<String> roles;//用户所属的所有角色，每一项都是角色id
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	private String[] departments;//用户所属的所有部门，每一项都是部门id
	private String[] positions;//用户所属的所有岗位 ，每一项都是岗位id
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String[] getDepartments() {
		return departments;
	}
	public void setDepartments(String[] departments) {
		this.departments = departments;
	}
	public String[] getPositions() {
		return positions;
	}
	public void setPositions(String[] positions) {
		this.positions = positions;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return userName;
	}
	
}
