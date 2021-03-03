package Dao;

import java.util.List;

import Dto.EmployeeDto;
import model.User;

public interface EmployeeDao {
	
	public EmployeeDto getEmployeeById(Integer id);
	
	public List<EmployeeDto> getAllEmployees();
	
	public void insertEmployee(EmployeeDto employee);
	
	public void deleteEmployee(Integer id);
	
	public void updateEmployee(EmployeeDto employee);
	
	public EmployeeDto getEmployeeByCode(String code);

	List<EmployeeDto> search(String name);
	public List<User> search(User user) ;
	public void updateUser(User user);

}
