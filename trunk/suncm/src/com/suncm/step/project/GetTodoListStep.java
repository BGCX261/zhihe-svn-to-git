package com.suncm.step.project;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jbpm.api.Deployment;
import org.jbpm.api.DeploymentQuery;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;

import com.ifw.exception.EXTException;
import com.suncm.pojo.SuncmProjectCate;
import com.suncm.pojo.SuncmProjectInfo;
import com.suncm.step.common.WebCommonStep;
import com.suncm.um.SuncmUser;
import com.suncm.util.DispBeanTodoListWrapper;
import com.suncm.util.HibernateUtil;
import com.suncm.util.JbpmUtil;
import com.suncm.util.SystemConfig;

/**
 * 获得待当前用户处理的任务列表，将executionid拼成下一步需要的字符串
 * 
 * @author xiezc
 * 
 */
public class GetTodoListStep extends WebCommonStep {

	public String execute() throws EXTException {

		try {
			SuncmUser su = (SuncmUser) getSessionObjParam("suncm_user");
			List<Task> taskListGroup = JbpmUtil.getTaskService()
					.findGroupTasks(su.getUserId());
			List<Task> taskListPersonal = JbpmUtil.getTaskService()
					.findPersonalTasks(su.getUserId());
			ArrayList resultList = new ArrayList(10);
			Session hsession = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			hsession.beginTransaction();
			for (Task task : taskListGroup) {
				System.out.println(task.getExecutionId());
				if (task.getExecutionId().equals("VacationRequest.30037")) {
					System.out.println(task.getExecutionId());
				}
				Object[] result = (Object[]) hsession
						.createQuery(
								"from SuncmProjectInfo spi,SuncmProjectCate spc where spi.executionId=:id and spc.projectCateId = spi.suncmProjectCate.projectCateId ")
						.setString("id", task.getExecutionId()).uniqueResult();

				if (result == null) {
					continue;
				}
				DispBeanTodoListWrapper dbtlw = new DispBeanTodoListWrapper(
						(SuncmProjectCate) result[1],
						(SuncmProjectInfo) result[0], task.getAssignee(), task
								.getCreateTime(), task.getName(), task.getId());
				resultList.add(dbtlw);
			}

			for (Task task : taskListPersonal) {
				Object[] result = (Object[]) hsession
						.createQuery(
								"from SuncmProjectInfo spi,SuncmProjectCate spc where spi.executionId=:id and spc.projectCateId = spi.suncmProjectCate.projectCateId ")
						.setString("id", task.getExecutionId()).uniqueResult();
				if (result == null) {
					continue;
				}
				DispBeanTodoListWrapper dbtlw = new DispBeanTodoListWrapper(
						(SuncmProjectCate) result[1],
						(SuncmProjectInfo) result[0], task.getAssignee(), task
								.getCreateTime(), task.getName(),task.getId());
				resultList.add(dbtlw);
			}
			hsession.getTransaction().commit();
			setSessionParam("pageData", resultList);
			return "0";

		} catch (Throwable t) {

			this.setSessionParam("tranErrorCode", "C000002");
			this.setSessionParam("tranErrorDispMsg", SystemConfig
					.getErrorDisp("C000002"));
			this.setSessionParam("tranErrorMsg", t.getMessage());
			this.setSessionParam("tranErrorLocation", this.getStepID());
			t.printStackTrace();

			return "-1";
		}

	}
}
