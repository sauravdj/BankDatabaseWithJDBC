package BankDatabaseWithJDBC;
public class BankAcc {
	private String custName;
	private long accNo;
	private double balance;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public BankAcc(String custName, long accNo, double balance) {
		super();
		this.custName = custName;
		this.accNo = accNo;
		this.balance = balance;
	}
	public BankAcc(String custName, double balance) {
		super();
		this.custName = custName;
		this.balance = balance;
	}
	public BankAcc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAcc( long accNo, String custName) {
		super();
		this.custName = custName;
		this.accNo = accNo;
	}
	public BankAcc(long accNo) {
		super();
		this.accNo = accNo;
	}
	
}
