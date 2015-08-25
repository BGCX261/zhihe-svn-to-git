package com.suncm.step.common;

import javax.servlet.http.HttpSession;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import com.ifw.base.AbstractStep;
import com.ifw.base.IFWConstants;
import com.ifw.exception.EXTException;
import com.suncm.util.SystemConfig;
/**
 * 根据条数和页数设置翻页参数和页面显示各个按钮的开关
 * 
 * session中与翻页相关字段的含义，各交易session字段定义不要重复
 * pageNum:当前是第几页
 * pageData:当前查询结果的缓存
 * 
 * @author xiezc
 *
 */
public class SetPageControlStep extends WebCommonStep {

	public String execute() throws EXTException {
			HttpSession session = (HttpSession)getObjectParam("ifw_session");
		try{
			//动作类型
			String pageActType=getStringParam("pageActType");
			//总条数
			int totalNum = ((Integer)session.getAttribute("pageTotalNum")).intValue();
			//总页数
			int totalPageNum = ((Integer)session.getAttribute("totalPageNum")).intValue();
			int numPerPage = Integer.parseInt(SystemConfig.getConfig("numPerPage"));
			//session数据类型，防止session缓存与页面展示数据类型不一致
			String dataId = (String)session.getAttribute("dataId");
			if(!dataId.equals(this.getFlow().getFlowName())){//发生错误时需要对错误代码进行赋值

				this.setSessionParam("tranErrorCode", "C000001");
				this.setSessionParam("tranErrorDispMsg", SystemConfig
						.getErrorDisp("C000001"));
				this.setSessionParam("tranErrorMsg", dataId+this.getFlow().getFlowName());
				this.setSessionParam("tranErrorLocation", this.getStepID());
				return "-1";
			}
			
			//当前页数，如果第一次进入此字段为null
			int pageNum = 0;
			//如果总条数为0直接返回
			if(totalNum == 0){
				return "0";
			}
			//计算当前页
			if(pageActType.equals("0")){//首次查询
				pageNum=1;
				session.setAttribute("pageNum", 1);
			}else if(pageActType.equals("1")){//上翻页
				pageNum = Integer.parseInt(getStringParam("pageNumReq"));
				session.setAttribute("pageNum", --pageNum);
			}else if(pageActType.equals("2")){//下翻页
				pageNum = Integer.parseInt(getStringParam("pageNumReq"));
				session.setAttribute("pageNum", ++pageNum);
			}else if(pageActType.equals("3")){//首页
				pageNum=1;
				session.setAttribute("pageNum", 1);
			}else if(pageActType.equals("4")){//尾页
				pageNum=totalPageNum;
				session.setAttribute("pageNum", pageNum);
			}
			
			
			//计算起始，终止位置
			session.setAttribute("beginNum", (pageNum-1)*numPerPage);
			session.setAttribute("endNum", pageNum*numPerPage-1);
			
			//计算页面各标志位
			if(pageNum<totalPageNum){
				session.setAttribute("dispNext", "1");
				session.setAttribute("dispLast", "1");
			}else{
				session.setAttribute("dispNext", "0");
				session.setAttribute("dispLast", "0");
			}
			if(pageNum==1){
				session.setAttribute("dispPre", "0");
				session.setAttribute("dispFirst", "0");
			}else{
				session.setAttribute("dispPre", "1");
				session.setAttribute("dispFirst", "1");
			}
			
			return "0";
			
		}catch(Throwable t){

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
