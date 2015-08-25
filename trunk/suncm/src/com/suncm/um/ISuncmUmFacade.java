package com.suncm.um;

import com.suncm.util.OperFailException;

/**
 * 系统的前提和假设是用户信息来源不定，通过此接口屏蔽用户信息获得的差异性
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
	 *             表示处理过程中发生了异常,如用户不存在，密码错误等
	 */
	public SuncmUser getUser(String userId, String password)
			throws OperFailException;

}
