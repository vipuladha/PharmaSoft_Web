package web.pharmasoft.server.dao;

import java.util.List;

import web.pharmasoft.entity.User;
import web.pharmasoft.server.common.dao.BaseDAO;

public interface UserDAO extends BaseDAO<User>{

	public  List<User> getUserInfoList() throws Exception;
}
