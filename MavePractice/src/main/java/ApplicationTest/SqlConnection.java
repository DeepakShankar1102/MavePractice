package ApplicationTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection extends Pages {

	
	public Connection connection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
	Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/information", "root","dP_k99j@");	 
	return con;
	
	}


}
