package com.suncm.um;

import java.util.List;

/**
 * ϵͳ��λ������ҵ����ϵͳ�������ṩ��չ�����Լٶ��û���Ϣȫ��������ϵͳ��ͨ��web service,socket�ȷ�ʽ���
 * �û���Ϣȫ������������һ������
 * 
 * @author xiezc
 *
 */
public class SuncmUser {
	private String userId;
	private String userName;
	private List<String> roles;//�û����������н�ɫ��ÿһ��ǽ�ɫid
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	private String[] departments;//�û����������в��ţ�ÿһ��ǲ���id
	private String[] positions;//�û����������и�λ ��ÿһ��Ǹ�λid
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
