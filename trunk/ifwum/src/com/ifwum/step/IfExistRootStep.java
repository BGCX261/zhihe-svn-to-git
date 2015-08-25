package com.ifwum.step;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.css.sql.GeneralDB;
import com.css.sql.GeneralDBFactory;
import com.css.sql.SqlResult;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * �жϿͻ��Ƿ��Ѿ�ע���˸��ڵ�
 * 
 * @author xiezc
 *
 */
public class IfExistRootStep extends AbstractStep {

	public String execute() throws EXTException {
		try{
			
            GeneralDB gdb = GeneralDBFactory.getGeneralDB("security");
           
            /*
             * ֱ�ӵ���SQL
             */
            SqlResult result = gdb.accessDatabase("select * from ORG_DEPT_MAP where DEPTH=1 and valid_flag=0");
           
            /*
             * ȡ������
             */
            int rowCount = result.getRowCount();
            
            if(rowCount == 0){//�޼�¼���ش������ڵ�ҳ��
            	return "0";
            }else{
            	//�м�¼������ҳ��
            	return "1";
            }

}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "2";
	}

}
}
