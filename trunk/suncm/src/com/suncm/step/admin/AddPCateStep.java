package com.suncm.step.admin;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jbpm.api.Deployment;
import org.jbpm.api.DeploymentQuery;

import com.ifw.exception.EXTException;
import com.suncm.pojo.SuncmProjectCate;
import com.suncm.step.common.WebCommonStep;
import com.suncm.util.HibernateUtil;
import com.suncm.util.JbpmUtil;
import com.suncm.util.SystemConfig;

/**
 * 先部署工作流，部署成功后保存项目分类信息
 * 
 * @author xiezc
 * 
 */
public class AddPCateStep extends WebCommonStep {

	public String execute() throws EXTException {

		try {
			String pCateName = getStringParam("pCateName");
			String wflName = getStringParam("wflName");
			String wflFile = getStringParam("wflFile");
			String deploymentId = null;
			// 1.部署JBPM工作流
			if (wflFile.endsWith("xml")) {
				deploymentId = JbpmUtil.getRepositoryService()
						.createDeployment().addResourceFromFile(
								new File(wflFile)).deploy();
			} else if (wflFile.endsWith("ar")) {
				FileInputStream fileInputStream = new FileInputStream(wflFile);
				ZipInputStream zipInputStream = new ZipInputStream(
						fileInputStream);
				deploymentId = JbpmUtil.getRepositoryService()
						.createDeployment().addResourcesFromZipInputStream(
								zipInputStream).deploy();
				try {
					zipInputStream.close();
					fileInputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				this.setSessionParam("tranErrorCode", "C000004");
				this.setSessionParam("tranErrorDispMsg", SystemConfig
						.getErrorDisp("C000004"));
				this.setSessionParam("tranErrorMsg", wflFile);
				this.setSessionParam("tranErrorLocation", this.getStepID());
			}
			// 2.保存项目模板
			Session hsession = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			Transaction tx = hsession.beginTransaction();
			SuncmProjectCate spc = new SuncmProjectCate();
			spc.setProjectCateName(pCateName);
			spc.setWflid(deploymentId);
			spc.setWflname(wflName);
			hsession.save(spc);
			tx.commit();

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
