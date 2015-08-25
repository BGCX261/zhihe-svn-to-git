package org.lps.action.common;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

@Name("authenticator")
public class Authenticator
{
    @Logger private Log log;

    @In Identity identity;
    @In Credentials credentials;
    @In private Session hibernateSession;

    public boolean authenticate()
    {
        /*log.info("authenticating {0}", credentials.getUsername());
        //write your authentication logic here,
        //return true if the authentication was
        //successful, false otherwise
        List userList  = hibernateSession.createQuery("from UserInfo where username=:username and password=:password")
        .setParameter("username", credentials.getUsername())
        .setParameter("password", credentials.getPassword()).list();
        if(userList.size()  != 1){
        	return false;
        }
        
        UserInfo ui = (UserInfo)userList.get(0);
        
        Iterator  iter = ui.getUserRoleInfos().iterator();
        while(iter.hasNext()){
        	UserRoleInfo uri = (UserRoleInfo)iter.next();
        	identity.addRole(uri.getRoleInfo().getRolename());
        }*/
        return true;
    }

}
