package web.pharmasoft.server.common.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import web.pharmasoft.util.LoggerUtils;


@SuppressWarnings("unchecked")
public class BaseDAOImpl<T extends Serializable> implements BaseDAO<T> {	

	private SessionFactory sessionFactory;
	
	private Class<T> clazz;	
	
	public BaseDAOImpl(Class<T> clazz) {
		super();
		this.clazz= clazz; 
	}

	protected Class<T> getClazz(){
		return this.clazz;
	}
	public final SessionFactory getSessionFactory() {
		return sessionFactory;
	}	
	
	public void setSessionFactory(SessionFactory sessionFactory) {	
		this.sessionFactory = sessionFactory;
	}
		
	@Override
	public final T findById(int id)  throws Exception{
		LoggerUtils.debug(this.getClass()+".findById() called.");
		return (T) getCurrentSession().get(clazz, id);
	}

	@Override
	public final List<T> findAll()  throws Exception{
		LoggerUtils.debug(this.getClass()+".findAll() called.");	
		return getCurrentSession().createQuery("from "+clazz.getName()).list();
	}

	@Override
	public final Serializable create(T entity)  throws Exception{
		LoggerUtils.debug(this.getClass()+".create() called.");
		return getCurrentSession().save(entity);
	}

	@Override
	public final T update(T entity)  throws Exception{
		LoggerUtils.debug(this.getClass()+".update() called.");
		return (T) getCurrentSession().merge(entity);
	}

	@Override
	public final int deleteById(String idField, Object value)  throws Exception{
		LoggerUtils.debug(this.getClass()+".delete() called.");
		Query q = getCurrentSession().createQuery("delete " + clazz.getName() + " where "+idField+" = :id").setParameter("id", value);
	    return q.executeUpdate();
	}
	
	public final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public final void saveOrupdate(T entity)  throws Exception{
		LoggerUtils.debug(this.getClass()+".saveOrUpdate() called.");
		getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public T findById(String id) throws Exception {		
		LoggerUtils.debug(this.getClass()+".findById(String) called.");
		return (T) getCurrentSession().get(clazz, id);
	}
}
