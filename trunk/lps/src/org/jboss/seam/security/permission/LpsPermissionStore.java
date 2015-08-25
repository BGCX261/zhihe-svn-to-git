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
 * seam中有PermissionStore的概念，便于权限的集中存储，维护，读取，判断，但是seam自带的Lpa和Drools两种PermissionStore感觉效率都不高，在页面涉及大量权限解析时可能会慢<br>
 * 所以在此借用seam PermissionStore的概念，但是只是从权限库中读取和利用hash暂存permission信息，并不在此进行维护，将每次权限判断简化为一次hash查找，效率较高<br>
 * 权限库中权限信息的缓存，提高效率的同时屏蔽权限数据来源的差异
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
	 * key-角色名称  value-permission hash.<br>
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
