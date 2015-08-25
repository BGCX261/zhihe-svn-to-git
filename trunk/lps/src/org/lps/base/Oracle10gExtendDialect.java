package org.lps.base;

import org.hibernate.Hibernate;
import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;

public class Oracle10gExtendDialect extends Oracle10gDialect {
	public Oracle10gExtendDialect(){
		super();
		registerFunction("convert_gbk", new SQLFunctionTemplate(Hibernate.STRING, "?1") );
	}

}
