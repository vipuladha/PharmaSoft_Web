package web.pharmasoft.server.common.bd;

import java.io.Serializable;
import java.util.List;

public interface BaseBD<T extends Serializable>{
	
	void saveOrupdate(T entity)  throws Exception;
	
	T findById(final int id) throws Exception;
	
	T findById(final String id) throws Exception;
	
    List<T> findAll() throws Exception;

    Serializable create(final T entity) throws Exception;

    T update(final T entity) throws Exception;

    int deleteById(String idField, Object value) throws Exception;

}
