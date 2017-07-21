package web.pharmasoft.server.bd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import web.pharmasoft.entity.User;
import web.pharmasoft.server.common.bd.BaseBDImpl;
import web.pharmasoft.server.dao.UserDAO;

@Component
@Transactional
public class UserBDImpl extends BaseBDImpl<User> implements UserBD{

	@Autowired
	public void setDao(UserDAO userDAO) {
		super.setDao(userDAO);
	}

	@Override
	public List<User> getUserInfoList() throws Exception {
		return ((UserDAO)getDao()).getUserInfoList();
	}

}
