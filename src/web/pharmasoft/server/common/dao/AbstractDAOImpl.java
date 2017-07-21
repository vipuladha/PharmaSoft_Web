package web.pharmasoft.server.common.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AbstractDAOImpl {
	
	private static SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}
