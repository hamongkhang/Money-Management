package Dao;

import java.util.List;

import Dto.LDto;
import model.Loan;



public interface loan {
	
	
	
	public List<LDto> getAllUsers();
	
	
	public void addloan(LDto a,String user);

}
