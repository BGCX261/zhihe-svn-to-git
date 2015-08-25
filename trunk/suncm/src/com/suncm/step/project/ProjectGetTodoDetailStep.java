package com.suncm.step.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
 * 获得项目基本信息，并准备处理页面需要的其他信息
 * 
 * @author xiezc
 * 
 */
public class ProjectGetTodoDetailStep extends WebCommonStep {

	public String execute() throws EXTException {
		InputStream jspStream = null;
		try {
			String projectId = getStringParam("projectId");
			String taskId = getStringParam("taskId");
			Session hsession = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			hsession.beginTransaction();
			List result = hsession
					.createQuery(
							"from SuncmProjectInfo spi,SuncmProjectCate spc where spi.projectId=:id and spi.suncmProjectCate.projectCateId=spc.projectCateId")
					.setString("id", projectId).list();
			SuncmProjectInfo spi = (SuncmProjectInfo) ((Object[]) result.get(0))[0];
			hsession.getTransaction().commit();
			Task task = JbpmUtil.getTaskService().getTask(taskId);
			jspStream = JbpmUtil.getRepositoryService().getResourceAsStream(
					spi.getSuncmProjectCate().getWflid(),
					task.getFormResourceName());
		
			
			setSessionParam("taskFormStream", jspStream);
			setSessionParam("projectData", spi);
			return "0";

		} catch (Throwable t) {
			if (jspStream != null) {

				try {
					jspStream.close();
				} catch (IOException e) {
					// 
					e.printStackTrace();
				}
			}
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
