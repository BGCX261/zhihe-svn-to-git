package com.suncm.util;

import org.jbpm.api.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ManagementService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;

/**
 * JBPM工具类，获得processEngine以及对应的各类service
 * 
 * @author time
 * 
 * 
 */
public class JbpmUtil {

	protected static ProcessEngine processEngine = null;

	protected static RepositoryService repositoryService;
	protected static ExecutionService executionService;
	protected static ManagementService managementService;
	protected static TaskService taskService;
	protected static HistoryService historyService;
	protected static IdentityService identityService;

	static {
		if (processEngine == null) {
			processEngine = Configuration.getProcessEngine();

			repositoryService = processEngine.get(RepositoryService.class);
			executionService = processEngine.getExecutionService();
			historyService = processEngine.getHistoryService();
			managementService = processEngine.getManagementService();
			taskService = processEngine.getTaskService();
			identityService = processEngine.getIdentityService();
		}
	}

	public static ProcessEngine getProcessEngine() {
		return processEngine;
	}

	public static RepositoryService getRepositoryService() {
		return repositoryService;
	}

	public static ExecutionService getExecutionService() {
		return executionService;
	}

	public static ManagementService getManagementService() {
		return managementService;
	}

	public static TaskService getTaskService() {
		return taskService;
	}

	public static HistoryService getHistoryService() {
		return historyService;
	}

	public static IdentityService getIdentityService() {
		return identityService;
	}


}
