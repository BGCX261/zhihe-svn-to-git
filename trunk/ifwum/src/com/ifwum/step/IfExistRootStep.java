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
 * 判断客户是否已经注册了根节点
 * 
 * @author xiezc
 *
 */
public class IfExistRootStep extends AbstractStep {

	public String execute() throws EXTException {
		try{
			
            GeneralDB gdb = GeneralDBFactory.getGeneralDB("security");
           
            /*
             * 直接调用SQL
             */
            SqlResult result = gdb.accessDatabase("select * from ORG_DEPT_MAP where DEPTH=1 and valid_flag=0");
           
            /*
             * 取得行数
             */
            int rowCount = result.getRowCount();
            
            if(rowCount == 0){//无记录返回创建根节点页面
            	return "0";
            }else{
            	//有记录返回树页面
            	return "1";
            }

}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "2";
	}

}
}
