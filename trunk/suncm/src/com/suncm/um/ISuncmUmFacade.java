package com.suncm.um;

import com.suncm.util.OperFailException;

/**
 * ϵͳ��ǰ��ͼ������û���Ϣ��Դ������ͨ���˽ӿ������û���Ϣ��õĲ�����
 * 
 * @author kfzx-xiezc
 * 
 */
public interface ISuncmUmFacade {

	/**
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @throws OperFailException
	 *             ��ʾ��������з������쳣,���û������ڣ���������
	 */
	public SuncmUser getUser(String userId, String password)
			throws OperFailException;

}
