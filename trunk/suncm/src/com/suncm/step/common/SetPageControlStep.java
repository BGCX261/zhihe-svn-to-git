package com.suncm.step.common;

import javax.servlet.http.HttpSession;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import com.ifw.base.AbstractStep;
import com.ifw.base.IFWConstants;
import com.ifw.exception.EXTException;
import com.suncm.util.SystemConfig;
/**
 * ����������ҳ�����÷�ҳ������ҳ����ʾ������ť�Ŀ���
 * 
 * session���뷭ҳ����ֶεĺ��壬������session�ֶζ��岻Ҫ�ظ�
 * pageNum:��ǰ�ǵڼ�ҳ
 * pageData:��ǰ��ѯ����Ļ���
 * 
 * @author xiezc
 *
 */
public class SetPageControlStep extends WebCommonStep {

	public String execute() throws EXTException {
			HttpSession session = (HttpSession)getObjectParam("ifw_session");
		try{
			//��������
			String pageActType=getStringParam("pageActType");
			//������
			int totalNum = ((Integer)session.getAttribute("pageTotalNum")).intValue();
			//��ҳ��
			int totalPageNum = ((Integer)session.getAttribute("totalPageNum")).intValue();
			int numPerPage = Integer.parseInt(SystemConfig.getConfig("numPerPage"));
			//session�������ͣ���ֹsession������ҳ��չʾ�������Ͳ�һ��
			String dataId = (String)session.getAttribute("dataId");
			if(!dataId.equals(this.getFlow().getFlowName())){//��������ʱ��Ҫ�Դ��������и�ֵ

				this.setSessionParam("tranErrorCode", "C000001");
				this.setSessionParam("tranErrorDispMsg", SystemConfig
						.getErrorDisp("C000001"));
				this.setSessionParam("tranErrorMsg", dataId+this.getFlow().getFlowName());
				this.setSessionParam("tranErrorLocation", this.getStepID());
				return "-1";
			}
			
			//��ǰҳ���������һ�ν�����ֶ�Ϊnull
			int pageNum = 0;
			//���������Ϊ0ֱ�ӷ���
			if(totalNum == 0){
				return "0";
			}
			//���㵱ǰҳ
			if(pageActType.equals("0")){//�״β�ѯ
				pageNum=1;
				session.setAttribute("pageNum", 1);
			}else if(pageActType.equals("1")){//�Ϸ�ҳ
				pageNum = Integer.parseInt(getStringParam("pageNumReq"));
				session.setAttribute("pageNum", --pageNum);
			}else if(pageActType.equals("2")){//�·�ҳ
				pageNum = Integer.parseInt(getStringParam("pageNumReq"));
				session.setAttribute("pageNum", ++pageNum);
			}else if(pageActType.equals("3")){//��ҳ
				pageNum=1;
				session.setAttribute("pageNum", 1);
			}else if(pageActType.equals("4")){//βҳ
				pageNum=totalPageNum;
				session.setAttribute("pageNum", pageNum);
			}
			
			
			//������ʼ����ֹλ��
			session.setAttribute("beginNum", (pageNum-1)*numPerPage);
			session.setAttribute("endNum", pageNum*numPerPage-1);
			
			//����ҳ�����־λ
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
