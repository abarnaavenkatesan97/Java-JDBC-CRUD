package bankPackage;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:bank-info.properties")
public class BackConfigClass {
	@Value("${bank.bankid}")
	public int bankid;
	@Value("${bank.bankname}")
	public String bankname;
	@Value("${bank.rateofinterest}")
	public float rateofinterest;
	@Value("${bank.numberofbranches}")
	public int numberofbranches;
	
	
	@Bean
	public Bank bankbean()   // Bean bankbean = new Bean()
	{
		Bank bank = new Bank(bankid,bankname,rateofinterest,numberofbranches);
		return bank;
	}
	
	@Bean
	public BankDatabaseConnection bankdbconn()
	{
		BankDatabaseConnection bankdbcon = new BankDatabaseConnection();
		return bankdbcon;
	}
	
	@Bean
	public Connection connectionMethod() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/bankschema";
		String uname = "root";
		String pwd = "Myroot@2114";
		Connection con = DriverManager.getConnection(url, uname, pwd);
		return con;
		
	}
	

}
