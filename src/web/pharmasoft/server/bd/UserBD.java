package web.pharmasoft.server.bd;

import java.util.List;

import web.pharmasoft.entity.User;
import web.pharmasoft.server.common.bd.BaseBD;

public interface UserBD extends BaseBD<User> {

	public  List<User> getUserInfoList() throws Exception;
}
