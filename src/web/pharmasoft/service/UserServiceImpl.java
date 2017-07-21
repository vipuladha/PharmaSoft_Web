package web.pharmasoft.service;

import java.util.List;

import org.springframework.stereotype.Service;

import web.pharmasoft.entity.User;
import web.pharmasoft.server.bd.UserBD;
import web.pharmasoft.server.common.ServiceLocatorBean;

@Service
public class UserServiceImpl implements UserService{

	UserBD userBD = (UserBD) ServiceLocatorBean.findBean("userBD");
	
	@Override
	public List<User> getUserInfoList() throws Exception {
		List<User> userList = null;
		try {	
			userList = userBD.getUserInfoList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

}
