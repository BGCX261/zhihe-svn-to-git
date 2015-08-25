package org.jboss.seam.security.permission;

import static org.jboss.seam.ScopeType.APPLICATION;
import static org.jboss.seam.annotations.Install.BUILT_IN;

import java.util.HashMap;

import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Startup;
import org.jboss.seam.annotations.intercept.BypassInterceptors;
import org.jboss.seam.contexts.Contexts;

/**
 * 
 * seam����PermissionStore�ĸ������Ȩ�޵ļ��д洢��ά������ȡ���жϣ�����seam�Դ���Lpa��Drools����PermissionStore�о�Ч�ʶ����ߣ���ҳ���漰����Ȩ�޽���ʱ���ܻ���<br>
 * �����ڴ˽���seam PermissionStore�ĸ������ֻ�Ǵ�Ȩ�޿��ж�ȡ������hash�ݴ�permission��Ϣ�������ڴ˽���ά������ÿ��Ȩ���жϼ�Ϊһ��hash���ң�Ч�ʽϸ�<br>
 * Ȩ�޿���Ȩ����Ϣ�Ļ��棬���Ч�ʵ�ͬʱ����Ȩ��������Դ�Ĳ���
 *
 * @author kfzx-xiezc
 */
@Name("org.jboss.seam.security.lpsPermissionStore")
@Install(precedence = BUILT_IN, value=false) 
@Scope(APPLICATION)
@BypassInterceptors
@Startup
public class LpsPermissionStore {
	/**
	 * key-��ɫ����  value-permission hash.<br>
	 * permission hash:<br>
	 * key-target:action value-condition or null<AcPerm>
	 *
	 */
	private HashMap permissionMap = null;

	public HashMap getPermissionMap() {
		if(permissionMap == null){
			initPermissionMap();
		}
		return permissionMap;
	}
	private void initPermissionMap(){
		
	}
	
	public static LpsPermissionStore instance()
	   {
	      if ( !Contexts.isApplicationContextActive() )
	      {
	         throw new IllegalStateException("No active application context");
	      }
	   
	      LpsPermissionStore instance = (LpsPermissionStore) Component.getInstance(
	    		  LpsPermissionStore.class, ScopeType.APPLICATION);
	   
	      if (instance == null)
	      {
	         throw new IllegalStateException("No LpsPermissionStore could be created");
	      }
	   
	      return instance;
	   }
}
