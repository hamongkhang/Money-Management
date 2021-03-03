package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dto.LDto;
import model.Loan;

public class loanimpl implements loan {

	@Override
	public List<LDto> getAllUsers() {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM LOANTB");
			List<LDto> l = new ArrayList<>();
			while (rs.next()) {
			LDto ls =new LDto();
				ls.setFirstname(rs.getString("FIRSTNAME"));
				ls.setIdcard(rs.getString("IDCARD"));
				ls.setLimit(rs.getString("LIMITS"));
				ls.setLoana(rs.getString("LOANAMOUNT"));
				ls.setThechap(rs.getString("THECHAP"));
				ls.setType(rs.getString("TYPEL"));
			l.add(ls);
			}
			return l;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void addloan(LDto a,String user) {
		// TODO Auto-generated method stub

		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "INSERT INTO LOANTB VALUES('"+user+"', ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(queryString);
		   
			ps.setString(1,a.getFirstname());
			ps.setString(2,a.getIdcard());
			ps.setString(3,a.getLimit());
			ps.setString(4,a.getLoana());
			ps.setString(5,a.getThechap());
			ps.setString(6,a.getType());
	

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

}
