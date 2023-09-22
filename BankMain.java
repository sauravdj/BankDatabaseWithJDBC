package BankDatabaseWithJDBC;
import java.util.Scanner;
public class BankMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ch,accNo;
		String custName;
		double balance, amount;
		boolean ans;
		BankAcc ba;
		System.out.println("***********Bank Management************");
		System.out.println("1. Create new account"
		+ "\n2. Delete account"
		+ "\n3. Show Particular User Account"
		+ "\n4. Deposit Account"
		+ "\n5. Withdrawal Account"
		+ "\n6. Show all bank accounts"
		+ "\n7. Exit");
		System.out.println("====================================");
		do {
			
			System.out.println("Enter your choice: ");
			ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch){
			case 1:
				System.out.println("Enter Customer name: ");
				custName = sc.nextLine();
				System.out.println("Enter initial balance: ");
				balance = sc.nextDouble();
				ba = new BankAcc(custName, balance);
				ans = AccOperations.createAcc(ba);
				if(ans)
					System.out.println("Account created Successfully :)");
				else
					System.out.println("Something went wrong, Try again");
				break;
			case 2:
				
				System.out.println("Enter Account number to delete: ");
				accNo = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Account holder name1: ");
				custName = sc.nextLine();
				ba = new BankAcc(accNo, custName);
				ans = AccOperations.deleteAcc(ba);
				if(ans)
					System.out.println("Account deleted Successfully :)");
				else
					System.out.println("Something went wrong, Try again");
				break;
			case 6:
				ba = new BankAcc();
				ans = AccOperations.showAllAcc(ba);
				break;
			case 3:
				System.out.println("Enter Account number: ");
				accNo = sc.nextInt();
				sc.nextLine();
				
				ba = new BankAcc(accNo);
				ans = AccOperations.showAcc(ba);
				if(!ans)
					System.out.println("Something went wrong, Try again");
				break;
			case 4:
				System.out.println("Enter Account number: ");
				accNo = sc.nextInt();
				sc.nextLine();
				
				ba = new BankAcc(accNo);
				sc.nextLine();
				System.out.println("Enter amount to be deposited: ");
				amount = sc.nextDouble();
				ans = AccOperations.depositeBalance(ba,amount);
				if(ans)
					System.out.println("Account deposited Successfully :)");
				else
					System.out.println("Something went wrong, Try again");
				break;
			case 5:
				System.out.println("Enter Account number: ");
				accNo = sc.nextInt();
				sc.nextLine();
			
				ba = new BankAcc(accNo);
				sc.nextLine();
				System.out.println("Enter amount to be withdraw: ");
				amount = sc.nextDouble();
				ans = AccOperations.withdrawBalance(ba,amount);
				if(ans)
					System.out.println("Account Withdrawal Successfully :)");
				else
					System.out.println("Something went wrong check your balance, Try again");
				break;
			case 7:
				System.out.println("Thanks For Using My Bank :) ");
				break;
				
			}
			System.out.println("==============================\n");
		}while(ch != 7);
	  sc.close();	
	}

}
