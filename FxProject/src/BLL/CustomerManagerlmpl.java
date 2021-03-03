package BLL;

import Dto.UserDto;
import Dao.UserDao;
import Dao.UserDaoImpl;

public class CustomerManagerlmpl implements CustomerManager {
	UserDao userDao = new UserDaoImpl();
	@Override
	public boolean checkLogin(String username, String password) {
		UserDto userDto = userDao.getUserByUserAndPass(username, password);
		if (userDto != null) {
			return true;
		} else {
			return false;
		}


	}

	
	
	@Override
	public boolean checkForgin(String username, String phonenumber) {
		UserDto userDto = userDao.getUserByUserAndPhone
				(username, phonenumber);
		if (userDto != null) {
			return true;
		} else {
		return false;}
	}



	@Override
	public boolean checkAdminLogin(String username, String password) {
		UserDto userDto = userDao.getAdmin(username, password);
		if (userDto != null) {
			return true;
		} else {
			return false;}
		
	}



	@Override
	public boolean checkBankerLogin(String username, String password) {
		UserDto userDto = userDao.getBanker(username, password);
		if (userDto != null) {
			return true;
		} else {
			return false;}
	}

}
