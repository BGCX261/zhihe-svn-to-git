package com.suncm.util;

import java.util.Date;

import com.suncm.pojo.SuncmProjectCate;
import com.suncm.pojo.SuncmProjectInfo;

/**
 * 由于todolist中数据来源众多，使用统一的disp bean进行统一管理
 * 
 * @author kfzx-xiezc
 *
 */
public class DispBeanTodoListWrapper {
	private SuncmProjectCate spc = null;
	private SuncmProjectInfo spi = null;
	private String assignee = null;
	private Date comeDate = null;
	private String taskId = null;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public Date getComeDate() {
		return comeDate;
	}
	public void setComeDate(Date comeDate) {
		this.comeDate = comeDate;
	}
	private String actionName = null;
	public DispBeanTodoListWrapper(SuncmProjectCate spc, SuncmProjectInfo spi,
			String assignee, Date comeDate, String actionName, String aTaskId) {
		super();
		this.spc = spc;
		this.spi = spi;
		this.assignee = assignee;
		this.comeDate = comeDate;
		this.actionName = actionName;
		this.taskId = aTaskId;
	}
	public SuncmProjectCate getSpc() {
		return spc;
	}
	public void setSpc(SuncmProjectCate spc) {
		this.spc = spc;
	}
	public SuncmProjectInfo getSpi() {
		return spi;
	}
	public void setSpi(SuncmProjectInfo spi) {
		this.spi = spi;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
}
