package com.suncm.um;

import org.jbpm.api.identity.User;
import org.jbpm.pvm.internal.identity.impl.UserImpl;

import com.suncm.util.JbpmUtil;
import com.suncm.util.OperFailException;
import com.suncm.util.SystemConfig;

public class JbpmUserFacade implements ISuncmUmFacade {

	public SuncmUser getUser(String userId, String password)
			throws OperFailException {
		
		// ͨ��web service �����û�ϵͳ������û���Ϣ�ݴ浽session��
		User user = JbpmUtil.getIdentityService().findUserById(userId);
		if (user == null) {
			OperFailException ofe = new OperFailException();
			ofe.setTranErrorMsg(userId + "������");
			ofe.setTranErrorCode("C000006");
			ofe.setTranErrorDispMsg(SystemConfig
					.getErrorDisp("C000006"));
			ofe.setTranErrorLocation("JbpmUserFacade.getUser");
			throw ofe;
		}
		String passwordApp = ((UserImpl) user).getPassword();
		if (!(password != null && passwordApp != null && passwordApp
				.equals(password))) {

			OperFailException ofe = new OperFailException();
			ofe.setTranErrorMsg(userId + "|" + password + "�������");
			ofe.setTranErrorCode("C000007");
			ofe.setTranErrorDispMsg(SystemConfig
					.getErrorDisp("C000007"));
			ofe.setTranErrorLocation("JbpmUserFacade.getUser1");
			throw ofe;
			}

		SuncmUser su = new SuncmUser();
		su.setUserId(user.getId());
		su.setUserName(user.getFamilyName() + user.getGivenName());
		su.setRoles(JbpmUtil.getIdentityService().findGroupIdsByUser(user.getId()));
		
		return su;
	}

}
