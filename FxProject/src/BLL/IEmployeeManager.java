package BLL;

import java.util.List;

import Dto.EmployeeDto;
import model.User;

public interface IEmployeeManager {
	
	public List<User> getAllEmployees();
	public EmployeeDto  getNameofEmployee(String username);

}
