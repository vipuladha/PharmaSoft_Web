package web.pharmasoft.controller;

import java.util.List;

import web.pharmasoft.entity.User;
import web.pharmasoft.server.common.ServiceLocatorBean;
import web.pharmasoft.service.UserService;

public class TestMainController {

	static UserService userService = (UserService) ServiceLocatorBean.findCommonBean("userService");
	
	public static void main(String[] args) {
		try {
			List<User> list = userService.getUserInfoList() ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
