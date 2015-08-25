package com.ifwum.step;

import com.css.security.SecurityConfiguration;
import com.css.security.SecurityManagerFactory;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ������������securityʵ�����ṩ��һ����ĸ��ڵ�root�����������ڵ㶼��Ϊ��root���ӽ�㣬���Դ˴�ֱ�ӹҽӵ�root��
 * 
 * @author xiezc
 *
 */
public class CreateDptStep extends AbstractStep {

	public String execute() throws EXTException {
		
		String deptcode = getStringParam("deptcode");
		String deptname = getStringParam("deptname");
		String typecode = getStringParam("typecode");
		String infocode = getStringParam("infocode");
		String parentId = getStringParam("parentId");
			
		try{
			Organization org = SecurityConfiguration.getSecurityFactory().getDefaultOrganization();
			
			Department root = (Department)org.getDepartment(Long.parseLong(parentId));
			Result r = root.createChild(deptname , deptcode , typecode , infocode) ;
			
			if (r.equals(Result.SUCCESS)){//�����ɹ������ؽ��ҳ��
				return "0";
			}else{
				setStringParam("errorMsg", r.getFullMessage());
				return "1";
			}
            //GeneralDB gdb = GeneralDBFactory.getGeneralDB("security");
            
            
           //���ݿ��г�ʼĬ��������һ��root���ݣ��˴������ֹ����
            /*
             * ֱ�ӵ���SQL
             */
            /*String createSQL = "insert into ORG_DEPT_MAP(" +
    		"PARENT_ID,DEPT_ID,DEPT_CODE,DEPT_NAME," +
    		"TYPE_CODE,INFO_CODE,DEPTH,VALID_FLAG,ORDER_NUM)" +
    		"values(-2,-1,'" + deptcode +"','" + deptname +"',"
    +typecode+		
    ","
    +infocode+
    ",1,1,1)";
            System.out.println(createSQL);
            SqlResult result = gdb.accessDatabase(createSQL);*/
           
            /*
             * ȡ������
             */
            //int rowCount = result.getEffectedRowCount();
            
            //if(rowCount == 0){
            	//return "1";
            //}else{
            	
            	//return "0";
            //}
}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}
