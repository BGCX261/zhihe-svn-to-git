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
 * 创建根机构，security实际上提供了一个虚的根节点root，所有其他节点都认为是root的子结点，所以此处直接挂接到root下
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
			
			if (r.equals(Result.SUCCESS)){//创建成功，返回结果页面
				return "0";
			}else{
				setStringParam("errorMsg", r.getFullMessage());
				return "1";
			}
            //GeneralDB gdb = GeneralDBFactory.getGeneralDB("security");
            
            
           //数据库中初始默认增加了一条root数据，此处不再手工添加
            /*
             * 直接调用SQL
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
             * 取得行数
             */
            //int rowCount = result.getEffectedRowCount();
            
            //if(rowCount == 0){
            	//return "1";
            //}else{
            	
            	//return "0";
            //}
}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "1";
	}

}
}
