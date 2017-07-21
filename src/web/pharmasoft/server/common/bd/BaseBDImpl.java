package web.pharmasoft.server.common.bd;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import web.pharmasoft.server.common.dao.BaseDAO;




@Transactional
public class BaseBDImpl<T extends Serializable> implements BaseBD<T>{

	private BaseDAO<T> dao;
	
	public BaseDAO<T> getDao() {
		return dao;
	}

	public void setDao(BaseDAO<T> dao) {
		this.dao = dao;
	}

	@Override
	public final T findById(int id)  throws Exception{
		return dao.findById(id);
	}

	@Override
	public final List<T> findAll()  throws Exception{
		return dao.findAll();
	}

	@Override
	public final Serializable create(T entity)  throws Exception{
		return dao.create(entity);
	}

	@Override
	public final T update(T entity)  throws Exception{
		return dao.update(entity);
	}

	@Override
	public final int deleteById(String idField, Object value)  throws Exception{
		return dao.deleteById(idField, value);
	}
	
	public final void saveOrupdate(T entity)  throws Exception{
		dao.saveOrupdate(entity);
	}

	@Override
	public T findById(String id) throws Exception {
		return dao.findById(id);
	}
}
