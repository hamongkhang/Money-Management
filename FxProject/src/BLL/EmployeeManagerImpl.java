package BLL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;
import Dao.EmployeeDao;
import Dao.EmployeeDaoImpl;
import Dto.EmployeeDto;
import Dto.UserDto;
import model.User;

public class EmployeeManagerImpl implements IEmployeeManager {
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public List<User> getAllEmployees() {
		List<EmployeeDto> employees = employeeDao.getAllEmployees();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		List<User> list = new ArrayList<>();
		
		for (EmployeeDto emp : employees) {
			User employee = new User();
			employee.setId(emp.getId());
	
			employee.setFirstName(emp.getFirstName());
			employee.setLastName(emp.getLastName());
			if(emp.getBirthday()!=null) {
			employee.setDateOfBirth(emp.getBirthday()/*dateFormat.format(emp.getBirthday())*/);
			}
			employee.setPhoneNumber(emp.getPhoneNumber());
			employee.setGender(emp.getGender());
		
			employee.setAddress(emp.getAddress());
			employee.setLa(emp.getLa());
			list.add(employee);
		}
		return list;
	}

	@Override
	public EmployeeDto getNameofEmployee(String username) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT banker_name FROM Banker_information WHERE USERNAME = '" + username + "'");
			if (rs.next()) {
				EmployeeDto userDto = new EmployeeDto();
	
				userDto.setFirstName(rs.getString("banker_name"));
				
			

				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
