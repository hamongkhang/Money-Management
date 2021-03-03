package BLL;

public interface CustomerManager {

		
		public boolean checkLogin(String username, String password);
		public boolean checkForgin(String username, String phonenumber);
		public boolean checkAdminLogin(String text, String text2);
		public boolean checkBankerLogin(String text, String text2);
}
