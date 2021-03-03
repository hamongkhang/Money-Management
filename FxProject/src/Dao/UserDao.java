package Dao;

import java.util.List;

import Dto.EmployeeDto;
import Dto.UserDto;

public interface UserDao {
	
	public UserDto getUserById(Integer id);

	public UserDto getUserByUsername(String username);
	
	public UserDto getNameByUsername(String username);
	public String getEnameByUsername(String username);
	public List<UserDto> getAllUsers();

	public void insertUser(UserDto user);

	public void deleteUser(String username);

	public void updateUser(UserDto user);
	public void updatePassword(String username,String password);
	
	public UserDto getUserByUserAndPass(String username, String password);
	
	public UserDto getUserByUserAndPhone(String username, String phonenumber);

	public UserDto getAdmin(String username, String password);

	public UserDto getBanker(String username, String password);
	public UserDto addLoan(String username, String string );
	public List<EmployeeDto> getSearch(String name);
	public UserDto getUserByName(String username);
	
	
}