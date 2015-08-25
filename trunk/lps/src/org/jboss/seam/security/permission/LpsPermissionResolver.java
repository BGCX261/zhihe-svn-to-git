package org.jboss.seam.security.permission;

import static org.jboss.seam.ScopeType.SESSION;

import java.util.HashMap;
import java.util.Set;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Startup;
import org.jboss.seam.annotations.intercept.BypassInterceptors;
import org.lps.entity.OmEmployee;

/**
 * 
 * ��resolver������session�У���LpaPermissionStore��ȡ������û���صĲ��ַ�������ӿ�Ȩ�޽������ٶ�
 * 
 * @author kfzx-xiezc
 */
@Name("org.jboss.seam.security.lpsPermissionResolver")
@Scope(SESSION)
@BypassInterceptors
@Startup
public class LpsPermissionResolver implements PermissionResolver {
	
	private HashMap<String, String> userPermStore = null;

	@Override
	public void filterSetByAction(Set<Object> targets, String action) {
		// 
		
	}

	@Override
	public boolean hasPermission(Object target, String action) {
		if(userPermStore == null){
			//LpsPermissionStore lpaPermissionStore = LpsPermissionStore.instance();
			
			//lpaPermissionStore.getPermissionMap();
		}
		if(target instanceof OmEmployee){
			return true;
		}
		
		
		return true;
	}

	

}
