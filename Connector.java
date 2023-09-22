package BankDatabaseWithJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
public class Connector {
  static Connection conn;
  public static Connection createConn() {
	 try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  String url = "jdbc:mysql://localhost:3306/BankDetails";
		  String user = "root";
		  String pass = "1234";
		  conn = DriverManager.getConnection(url,user,pass);
	} 
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  return conn;
  }
}
