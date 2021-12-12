package bankPackage;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(BackConfigClass.class);
		Bank bank = context.getBean("bankbean",Bank.class);
		//bank.displayBankInfo();
		BankDatabaseConnection bankdbconn = context.getBean("bankdbconn",BankDatabaseConnection.class);
		//bankdbconn.insert(bank);
		//bankdbconn.update(bank);
		bankdbconn.select();
		//bankdbconn.delete(bank);

		
	}

}
