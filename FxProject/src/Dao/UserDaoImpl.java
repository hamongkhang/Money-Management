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

public class UserDaoImpl implements UserDao {

	@Override
	public UserDto getUserById(Integer id) {

		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE ID = '" + id + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getString("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				return userDto;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto getUserByUsername(String username) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE USERNAME = '" + username + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("Cus_ID"));
				userDto.setFirstname(rs.getString("FIRSTNAME"));
				userDto.setLastname(rs.getString("Lastname"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPassword(rs.getString("PHONENUMBER"));
				userDto.setGender(rs.getString("GENDER"));
				// userDto.setBirthday(rs.getString("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONENUMBER"));
				userDto.setAddress(rs.getString("ADRESST"));

				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
			List<UserDto> users = new ArrayList<>();
			while (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getString("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				users.add(userDto);
			}
			return users;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertUser(UserDto user) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionFactory.getConnection();
			// 2 Nhi vo admin2 2432000 0966624800 asdasd Female 246344364
			String queryString = "INSERT INTO CUSTOMER VALUE(Null, ?, ?, ?, ?, ?, ?, ?, ?,Null)";
			ps = connection.prepareStatement(queryString);
			System.out.println(user.getFirstname());
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getGender());
			ps.setString(8, user.getBirthday());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void deleteUser(String username) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM CUSTOMER WHERE Cus_ID = '" + username + "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateUser(UserDto user) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionFactory.getConnection();
			String queryString = "UPDATE CUSTOMER SET BIRTHDAY = ?, PHONE_NUMBER = ?, ADDRESS = ? WHERE Cus_ID = ?";
			ps = connection.prepareStatement(queryString);
			ps.setString(1, user.getBirthday());
			ps.setString(2, user.getPhoneNumber());
			ps.setString(3, user.getAddress());
			ps.setInt(4, user.getId());

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updatePassword(String username, String password) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			stmt.executeUpdate("UPDATE CUSTOMER SET UPASSWORD ='" + password + "' WHERE USERNAME = '" + username + "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public UserDto getUserByUserAndPass(String username, String password) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE USERNAME = '" + username + "'"
					+ " AND UPASSWORD = '" + password + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("Cus_ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPassword(rs.getString("UPASSWORD"));
				// userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONENUMBER"));
				userDto.setAddress(rs.getString("ADRESST"));
				System.out.println(userDto.getPassword());
				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto getUserByUserAndPhone(String username, String phonenumber) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE USERNAME = '" + username + "'"
					+ " AND PHONENUMBER = '" + phonenumber + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("Cus_ID"));
				userDto.setFirstname(rs.getString("FIRSTNAME"));
				userDto.setLastname(rs.getString("Lastname"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPassword(rs.getString("PHONENUMBER"));
				userDto.setBirthday(rs.getString("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONENUMBER"));
				userDto.setAddress(rs.getString("ADRESST"));

				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto getAdmin(String username, String password) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM badmin WHERE USERNAME = '" + username + "'" + " AND PASSWORD = '" + password + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPassword(rs.getString("PASSWORD"));
				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto getBanker(String username, String password) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Banker_information WHERE USERNAME = '" + username + "'"
					+ " AND PASSWORD = '" + password + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPassword(rs.getString("PASSWORD"));
				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto getNameByUsername(String username) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Firstname FROM Customer WHERE USERNAME = '" + username + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();

				userDto.setFirstname(rs.getString("FIRSTNAME"));

				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;

	}

	@Override
	public String getEnameByUsername(String username) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT NAME FROM Banker_information WHERE USERNAME = '" + username + "'");
			if (rs.next()) {
				String name;

				name = (rs.getString("NAME"));

				return name;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto addLoan(String username, String loan) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			stmt.executeUpdate("UPDATE  Customer set loanamout ='"+loan+"' where username='"+username+"'");
							
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	@Override
	public List<EmployeeDto> getSearch(String name) {
	
				Connection connection = ConnectionFactory.getConnection();
				try {
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER Where fisrtname='"+name+"'");
					List<EmployeeDto> employees = new ArrayList<>();
					while (rs.next()) {
						EmployeeDto employee = new EmployeeDto();
						employee.setId(rs.getInt("Cus_ID"));
						employee.setFirstName(rs.getString("FIRSTNAME"));
						employee.setLastName(rs.getString("LASTNAME"));
						//employee.setBirthDay(rs.getDate("BIRTHDAY"));
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
	public UserDto getUserByName(String username) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE  NAME = '" + username + "'"
				);
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("Cus_ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPassword(rs.getString("UPASSWORD"));
				// userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONENUMBER"));
				userDto.setAddress(rs.getString("ADRESST"));
				System.out.println(userDto.getPassword());
				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	
	}

}
