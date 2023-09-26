package BankDatabaseWithJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class AccOperations {

	public static boolean createAcc(BankAcc ba){
		boolean flag = false;
		try {
			Connection conn = Connector.createConn();
			String q="insert into BankAccount(custName,balance) values (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(q);
			pstmt.setString(1, ba.getCustName());
			pstmt.setDouble(2, ba.getBalance());
			pstmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can not create account :(  ...");
		}
		return flag;
	}
	public static boolean showAllAcc(BankAcc ba) {
		boolean flag = false;
		try{
			Connection conn = Connector.createConn();
			String q="select * from BankAccount";
			Statement stmt = conn.createStatement();
			ResultSet set = stmt.executeQuery(q);
			while(set.next()){
				int accNo = set.getInt(1);
				String name = set.getString("custName");
				Double balance = set.getDouble("balance");
				System.out.println("=======================");
				System.out.println("Account no: "+accNo);
				System.out.println("Account holder name: "+name);
				System.out.println("Account Balance: "+balance);
			}
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can not fetch account details :(");
		}
		return flag;
	}
	public static boolean deleteAcc(BankAcc ba){
		boolean flag = false;
		try {
			Connection conn = Connector.createConn();
			String q="delete from BankAccount where accNo=?";
			PreparedStatement pstmt = conn.prepareStatement(q);
			pstmt.setLong(1,ba.getAccNo());
			
		    pstmt.executeUpdate();
			flag = true;
		} catch (Exception e){
			// TODO: handle exception
			System.err.println("Can not delete account details :(");
			
		}
		return flag;
	}
	public static boolean showAcc(BankAcc ba){
		boolean flag = false;
		try {
			Connection conn = Connector.createConn();
			String q="select * from BankAccount where accNo = ? ";
			PreparedStatement pstmt = conn.prepareStatement(q);
			pstmt.setLong(1,ba.getAccNo());
			ResultSet set = pstmt.executeQuery();
			while(set.next()){
				int accNo = set.getInt("accNo");
				String name = set.getString("custName");
				Double balance = set.getDouble("balance");
				System.out.println("=======================");
				System.out.println("Account no: "+accNo);
				System.out.println("Account holder name: "+name);
				System.out.println("Account Balance: "+balance);
				
			}
			flag = true;
		}catch (Exception e){
			// TODO: handle exception
			System.err.println("Can not fetch account details :(");
			
		}
		return flag;
	}
	public static boolean depositeBalance(BankAcc ba, double amount){
		boolean flag = false;
		try{
			Connection conn = Connector.createConn();
			String q="select * from BankAccount where accNo = ? ";
			PreparedStatement pstmt = conn.prepareStatement(q);
			pstmt.setLong(1,ba.getAccNo());
			
			ResultSet set = pstmt.executeQuery();
			set.next();
			
			double balance = set.getDouble("balance");
			double newBalance = balance + amount;
			
			String q1 = "update BankAccount set balance = ? where accNo = ?";	
			PreparedStatement pstmt1 = conn.prepareStatement(q1);
			pstmt1.setDouble(1,newBalance);
			pstmt1.setLong(2,ba.getAccNo());
			pstmt1.executeUpdate();
			flag = true;
            
		}catch (Exception e){
			// TODO: handle exception
			System.err.println("Can not deposite amount :(");
		}
		return flag;
	}
	public static boolean withdrawBalance(BankAcc ba, double amount){
		boolean flag = false;
		try{
			Connection conn = Connector.createConn();
			String q="select * from BankAccount where accNo = ?";
			PreparedStatement pstmt = conn.prepareStatement(q);
			pstmt.setLong(1,ba.getAccNo());
			
			ResultSet set = pstmt.executeQuery();
			set.next();
			
			double balance = set.getDouble("balance");
			if(amount < balance){
				double newBalance = balance - amount;
				String q1 = "update BankAccount set balance = ? where accNo = ?";	
				PreparedStatement pstmt1 = conn.prepareStatement(q1);
				pstmt1.setDouble(1, newBalance);
				pstmt1.setLong(2, ba.getAccNo());
				pstmt1.executeUpdate();
				flag = true;
			}
			else
				System.out.println("Insufficient balance can't be withdraw....");
			
		} catch (Exception e){
			// TODO: handle exception
			System.err.println("Something went wrong, can not withdraw amount :(");
		}
		return flag;
	}
}
