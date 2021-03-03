package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dto.EmployeeDto;
import Dto.UserDto;
import model.User;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public EmployeeDto getEmployeeById(Integer id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE Cus_ID = '" + id + "'");

			if (rs.next()) {
				EmployeeDto employee = new EmployeeDto();
				employee.setId(rs.getInt("Cus_"
						+ "ID"));
				employee.setFirstName(rs.getString("FIRST_NAME"));
				employee.setLastName(rs.getString("LAST_NAME"));
				employee.setBirthDay(rs.getString("BIRTH_DAY"));
				employee.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				employee.setGender(rs.getString("GENDER"));
				employee.setSalary(rs.getDouble("SALARY"));
				employee.setAddress(rs.getString("ADDRESS"));

				return employee;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
			List<EmployeeDto> employees = new ArrayList<>();
			while (rs.next()) {
				EmployeeDto employee = new EmployeeDto();
				employee.setId(rs.getInt("Cus_ID"));
			
				employee.setFirstName(rs.getString("FIRSTNAME"));
				employee.setLastName(rs.getString("LASTNAME"));
				employee.setBirthDay(rs.getString("dateofbirth"));
				employee.setPhoneNumber(rs.getString("PHONENUMBER"));
				employee.setGender(rs.getString("GENDER"));
				employee.setAddress(rs.getString("ADRESST"));
				employee.setLa(rs.getString("loanamout"));
				employees.add(employee);
			}

			return employees;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertEmployee(EmployeeDto employee) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "INSERT INTO EMPLOYEE VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(queryString);
		
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getBirthday());
			ps.setString(4, employee.getPhoneNumber());
			ps.setString(5, employee.getGender());
			ps.setDouble(6, employee.getSalary());
			ps.setString(7, employee.getAddress());

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(Integer id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM EMPLOYEE WHERE ID = '" + id + "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(EmployeeDto employee) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "UPDATE EMPLOYEE SET FIRST_NAME = ?, LAST_NAME = ?, BIRTH_DAY = ?, PHONE_NUMBER = ?, GENDER = ?, SALARY = ?, ADDRESS = ? WHERE ID = ?";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getBirthday());
			ps.setString(4, employee.getPhoneNumber());
			ps.setString(5, employee.getGender());
			ps.setDouble(6, employee.getSalary());
			ps.setString(7, employee.getAddress());
			ps.setInt(8, employee.getId());
			
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public EmployeeDto getEmployeeByCode(String code) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE CODE = '" + code + "'");

			if (rs.next()) {
				EmployeeDto employee = new EmployeeDto();
				employee.setId(rs.getInt("ID"));
				employee.setFirstName(rs.getString("FIRST_NAME"));
				employee.setLastName(rs.getString("LAST_NAME"));
				employee.setBirthDay(rs.getString("BIRTH_DAY"));
				employee.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				employee.setGender(rs.getString("GENDER"));
				employee.setSalary(rs.getDouble("SALARY"));
				employee.setAddress(rs.getString("ADDRESS"));

				return employee;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}


	@Override
	public List<User> search(User user) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			
			StringBuffer query = new StringBuffer("SELECT * FROM Customer");
			query.append(" WHERE TRUE ");
			if (user.getFirstName() != null&&!"".equals(user.getFirstName
					())) {
				query.append(" AND FIRSTNAME LIKE '%" + user.getFirstName() + "%'");
			}
			if (user.getAddress() != null) {
				query.append(" AND ADDRESS LIKE '%" + user.getAddress() + "%' ");
			}
			/*if (user.getBirthday() != null) {
				query.append(" AND BIRTHDAY = '" + user.getBirthday() + "'");
			}*/
			ResultSet rs = stmt.executeQuery(query.toString());
			
			List<User> list = new ArrayList<>();
			while (rs.next()) {
				User userDto = new User();
				userDto.setId(rs.getInt("Cus_ID"));
				
				userDto.setFirstName(rs.getString("FIRSTNAME"));
				userDto.setLastName(rs.getString("LASTNAME"));
				userDto.setDateOfBirth(rs.getString("dateofbirth"));
				userDto.setPhoneNumber(rs.getString("PHONENUMBER"));
				userDto.setGender(rs.getString("GENDER"));
				userDto.setAddress(rs.getString("ADRESST"));
				userDto.setLa(rs.getString("loanamout"));
			
				list.add(userDto);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;


}

	@Override
	public List<EmployeeDto> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "UPDATE Customer SET FIRSTNAME = ?, LASTNAME = ?, PHONENUMBER = ?, gender = ?, adresst = ? WHERE CUS_ID = ?";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getDateOfBirth());
			ps.setString(3, user.getPhoneNumber());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getCode().toString());
			
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
}


