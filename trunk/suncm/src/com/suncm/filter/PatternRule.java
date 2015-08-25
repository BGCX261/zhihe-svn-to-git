/*
 * Created on 2005-6-28
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.suncm.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.css.security.ConfigManager;
import com.css.util.StringHelper;

/**
 * @author Administrator
 *
 * check permission url's pattern
 */
public class PatternRule {
	
	/**
     * A list of some exclude Pattern objects. If any logger name 
     * match any pattern in the list, the appender should not 
     * output the logger's items. 
     */
    protected List excludePatterns = new ArrayList();
    
    /**
     * 
     */
    public PatternRule(ConfigManager config)
    {
        /*
         * The log name list need to exclude when output log info to Console.
         * Format of exlcude list looks like:
         * 
         * user,user*
         */
        //String excludeNames = "*.js,*.css,*.gif,*.jpg,*.png";
    	String excludeNames =  config.getExtendNames() ;
        StringTokenizer st = new StringTokenizer(excludeNames, ",");
        while (st.hasMoreTokens())
        {
            String exclude = translatePattern(st.nextToken());
            Pattern pattern = Pattern.compile(exclude);
            excludePatterns.add(pattern);
        }
                
    }  
    
    /**
     * The valid exclude pattern looks like:
     * 
     *  user* - matches userSystem
     *  u?er  - matches user or ufer
     *  
     *  But java's regx expression is different from the rules. The 
     *  character '.' indicates any character, and the character '*' 
     *  indicates one or more times of the character in front of 
     *  '*'. ,so it looks like:
     *  
     *  user.* - 
     *  u.er   - 
     *  
     *  
     * We have to do this to translate the pattern string from
     * our rules to java's rules. 
     *  
     * @param string
     * @return
     */
    private String translatePattern(String pattern)
    {
        pattern = StringHelper.replaceString(pattern, ".", "\\.");
        pattern = StringHelper.replaceString(pattern, "*", ".*");
        pattern = StringHelper.replaceString(pattern, "?", ".");
        
        return pattern.trim();
    }
    
    
    /**
     * Tests whether the log item can output? if need output return true;
     * @param item
     * @return
     */
    public boolean doFilter(String name)
    {
        /*
         * if the logger's name matches any pattern in exclude pattern list,
         * we should't output it.
         */
        for (int i = 0; i < excludePatterns.size(); i++)
        {
            Pattern pattern = (Pattern) excludePatterns.get(i);
            Matcher matcher = pattern.matcher(name);
            if (matcher.matches())
            {
            	//Logger.getLogger().debug("Pattern:" + pattern.pattern());
                return false;
            }
        }
        
        return true;
    }
    
	public static void main(String[] args) {
	}
}
