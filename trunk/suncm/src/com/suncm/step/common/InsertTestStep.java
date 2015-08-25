package com.suncm.step.common;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ifw.exception.EXTException;
import com.suncm.pojo.SuncmJournal;
import com.suncm.util.HibernateUtil;
import com.suncm.util.SystemConfig;

public class InsertTestStep {

	public static void main(String args[]){
		Session hsession = HibernateUtil.getSessionFactory().getCurrentSession();

		hsession.beginTransaction();   
		Transaction tx = hsession.beginTransaction();
		
		SuncmJournal sj = new SuncmJournal();
		sj.setActime("1234`13");
		sj.setActionname("123");
		
		hsession.save(sj);
		tx.commit();
	}

}
