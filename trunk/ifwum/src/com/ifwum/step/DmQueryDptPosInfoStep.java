package com.ifwum.step;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.attr.AttrManager;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.org.Position;
import com.css.security.org.PositionManager;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * 访问权限管理系统，根据部门id查询部门岗位信息,将部门已有岗位从所有岗位列表中删除
 * 
 * @author xiezc
 *
 */
public class DmQueryDptPosInfoStep extends AbstractStep {

	public String execute() throws EXTException {
		String dptId=getStringParam("dptId");
		ArrayList nowDptPosList = new ArrayList();
		ArrayList allPosList = new ArrayList();
		try{
			Organization org = SecurityConfiguration.getSecurityFactory().getOrganization(Long.parseLong(dptId));
			Department nowDpt = (Department)org.getDepartment(Long.parseLong(dptId));
			Iterator iter = nowDpt.getPositions();
			while(iter.hasNext()){
				nowDptPosList.add(iter.next());
			}
		    setObjectParam("nowDptPos", nowDptPosList);
		    
		    PositionManager pm = SecurityConfiguration.getSecurityFactory().getPositionManager();
		    Iterator allPosIter = pm.getPositions();
		    boolean isHave = false;
		    while(allPosIter.hasNext()){
		    	Position pa = (Position)allPosIter.next();
		    	for(int i = 0;i < nowDptPosList.size();i++){
		    		Position pDpt = (Position)nowDptPosList.get(i);
		    		if(pDpt.getPositionId() == pa.getPositionId()){
		    			isHave = true;
		    			break;
		    		}
		    	}
		    	if(!isHave){
		    		allPosList.add(pa);
		    	}
		    	isHave = false;
			}
		    
		    setObjectParam("allPos", allPosList);
		    
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "1";
	}

}
}
