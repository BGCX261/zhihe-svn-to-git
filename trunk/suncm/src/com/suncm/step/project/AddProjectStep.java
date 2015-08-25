package com.suncm.step.project;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jbpm.api.Deployment;
import org.jbpm.api.DeploymentQuery;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessInstance;

import com.ifw.exception.EXTException;
import com.suncm.pojo.SuncmProjectCate;
import com.suncm.pojo.SuncmProjectExt;
import com.suncm.pojo.SuncmProjectExtId;
import com.suncm.pojo.SuncmProjectInfo;
import com.suncm.step.common.WebCommonStep;
import com.suncm.um.SuncmUser;
import com.suncm.util.HibernateUtil;
import com.suncm.util.JbpmUtil;
import com.suncm.util.SystemConfig;

/**
 * �Ȳ�������������ɹ��󱣴���Ŀ������Ϣ
 * 
 * @author xiezc
 * 
 */
public class AddProjectStep extends WebCommonStep {

	public String execute() throws EXTException {

		try {
			HashMap dynamicData  = (HashMap)getSessionObjParam("dynamicData");
			String pCateId = (String)dynamicData.get("pCateId");
			String projectName = (String)dynamicData.get("projectName");
			HttpServletRequest req = (HttpServletRequest) getObjectParam("ifw_req");

			// 1.��ʼ����������ʹ��������ʼ�󱣴���Ϣ�����������Ҳ�ǲ��ɼ���
			Session hsession = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			hsession.beginTransaction();
			SuncmProjectCate spc = (SuncmProjectCate)hsession.createQuery(
					"from SuncmProjectCate where projectCateId='" + pCateId
							+ "'").uniqueResult();
			hsession.getTransaction().commit();
			// �����Ŀ����Ĺ�������Ϣ
			ProcessDefinitionQuery pdq = JbpmUtil.getRepositoryService()
					.createProcessDefinitionQuery();
			pdq.deploymentId(spc.getWflid());
			ProcessDefinition pd = pdq.uniqueResult();
			ProcessInstance pi = JbpmUtil.getExecutionService()
					.startProcessInstanceById(pd.getId());
			
			
			//2.������Ŀ����Ϣ
			hsession = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = hsession.beginTransaction();
			SuncmProjectInfo sp = new SuncmProjectInfo();
			sp.setSuncmProjectCate(spc);
			sp.setProjectName(projectName);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			sp.setCreatedate(sdf.format(new Date()));
			SuncmUser su = (SuncmUser) getSessionObjParam("suncm_user");
			sp.setCreateUser(su.getUserId());
			if (su.getDepartments() != null && su.getDepartments().length != 0)
				sp.setCreateDep(su.getDepartments()[0]);
			sp.setExecutionId(pi.getId());
			hsession.save(sp);
			tx.commit();
			//���ύ�����������
			Iterator e = getFlow().getModel().keySet().iterator();
			String name = null;
			
			hsession = HibernateUtil.getSessionFactory().getCurrentSession();
			hsession.beginTransaction();
			while(e.hasNext()){
				name = (String)e.next();
				if(name.startsWith("input")){
					//input��ͷ���Ƕ����ֶΣ���Ҫ�����洢
					int pageNo = Integer.parseInt(name.replaceAll("input", ""));
					SuncmProjectExt spe = new SuncmProjectExt();
					SuncmProjectExtId spei = new SuncmProjectExtId();
					spei.setProjectId(sp.getProjectId());
					spei.setPageNo(pageNo);
					spe.setId(spei);
					spe.setPropertyValue(getStringParam(name));
					String propertyName = (String)hsession
					.createQuery(
							"select spp.propertyName from SuncmProcatePageset spp where spp.id.projectCateId=:id and spp.id.pageNo=:No")
					.setString("id", pCateId).setInteger("No",
							pageNo).uniqueResult();
					spe.setPropertyName(propertyName);
					hsession.save(spe);
				}
			}
			hsession.getTransaction().commit();

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
