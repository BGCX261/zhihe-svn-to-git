package org.lps.base;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;

public class MySQL5ExtendDialect extends MySQL5Dialect {
	public MySQL5ExtendDialect(){
		super();
		registerFunction("convert_gbk", new SQLFunctionTemplate(Hibernate.STRING, "convert(?1 using gbk)") );
		registerKeyword("using");
		registerKeyword("gbk");
	}

}
