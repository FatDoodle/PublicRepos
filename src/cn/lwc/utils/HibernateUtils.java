package cn.lwc.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils{
	static Configuration cf;
	static SessionFactory sf;
	
	static{
		cf=new Configuration();
		cf.configure();
		sf=cf.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return sf;
	}

	public static Session getSession(){
		return sf.getCurrentSession();
	}
	public static void main(String[] args) {
		
	}

}
