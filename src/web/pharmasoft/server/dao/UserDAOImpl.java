package web.pharmasoft.server.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web.pharmasoft.entity.User;
import web.pharmasoft.server.common.dao.BaseDAOImpl;

@Component
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO{

	public UserDAOImpl() {
		super(User.class);						
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public List<User> getUserInfoList() throws Exception {
		String sql = "SELECT * FROM user";

		SQLQuery query = getCurrentSession().createSQLQuery(sql);
		List<User> userList = query.addEntity(User.class).list();
		return userList;
	}

}
