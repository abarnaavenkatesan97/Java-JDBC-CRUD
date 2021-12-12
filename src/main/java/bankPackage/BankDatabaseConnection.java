package bankPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BankDatabaseConnection 
{
	@Autowired
	private Connection con;
	public void insert(Bank bank) throws SQLException
	{
		String sql = "INSERT INTO BANK VALUES (?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,bank.getBankid());
		stmt.setString(2,bank.getBankname());
		stmt.setFloat(3,bank.getRateofinterest());
		stmt.setInt(4,bank.getNumberofbranches());
		int rowsupdated = stmt.executeUpdate();
		System.out.println("No. of rows inserted: " + rowsupdated);
		
	}
	public void update(Bank bank) throws SQLException
	{
		String sql = "UPDATE BANK SET BANKNAME = ?,RATEOFINTEREST = ?,NUMBEROFBRANCHES = ?" + " WHERE BANKID = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,bank.getBankname());
		stmt.setFloat(2,bank.getRateofinterest());
		stmt.setInt(3,bank.getNumberofbranches());
		stmt.setInt(4,bank.getBankid());
		int numberofrowsupdated = stmt.executeUpdate();
		System.out.println("No. of rows updated: " + numberofrowsupdated);
		
	}
	public void select() throws SQLException
	{
		String sql = "SELECT * FROM BANK";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			System.out.println("Bank id : " + rs.getInt("bankid") + ",Bankname : " + rs.getString("bankname") + ",Rateofinterest : " + rs.getFloat("rateofinterest")
					+ ",Numberofbranches : " + rs.getInt("numberofbranches"));
			
		}
	}
	public void delete(Bank bank) throws SQLException
	{
		String sql = "DELETE FROM BANK WHERE BANKID = " + "?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,bank.getBankid());
		int rowsdeleted = stmt.executeUpdate();
		System.out.println("No. of rows deleted: " + rowsdeleted);
	} 

	
	

}
