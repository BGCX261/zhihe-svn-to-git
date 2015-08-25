package com.ifwum.step;

import com.css.security.SecurityConfiguration;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.permission.Resource;
import com.css.security.permission.ResourceTree;
import com.css.security.result.Result;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ��ɾ��ĳ������
 * 
 * @author xiezc
 *
 */
public class RemDelResStep extends AbstractStep {

	public String execute() throws EXTException {
		String resId=getStringParam("resId");
		
		try{
			ResourceTree tree = SecurityConfiguration.getSecurityFactory().getDefaultResourceTree();
			
			Resource rs = tree.getResource(Long.parseLong(resId));
			Resource parent = tree.getResource(rs.getParentId());
			Result r = parent.deleteChild(rs);
			
			if (r.equals(Result.SUCCESS)){//ɾ���ɹ������ؽ��ҳ��
				return "0";
			}else{
				setStringParam("errorMsg", r.getFullMessage());
				return "1";
			}
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}
