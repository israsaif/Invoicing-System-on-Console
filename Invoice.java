import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class Invoice {

	private String customerName;
	private int phoneNumber;
	private int invoiceDate;
	private int numberItems;
	private int totalAmount;
	private int paidAmoun ;
	private int balance ;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(int invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public int getNumberItems() {
		return numberItems;
	}
	public void setNumberItems(int numberItems) {
		this.numberItems = numberItems;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getPaidAmoun() {
		return paidAmoun;
	}
	public void setPaidAmoun(int paidAmoun) {
		this.paidAmoun = paidAmoun;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public static boolean createInvoiceTable() {
		String url = "jdbc:mysql://localhost:3306/Invoice";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Invoice "+"(id INTEGER NOT NULL AUTO_INCREMENT, "+"customerName VARCHAR(80),"+" phoneNumber INTEGER, "+" invoiceDate INTEGER, "+" numberItems INTEGER, "+" totalAmount INTEGER, "+" paidAmoun INTEGER,"+"balance INTEGER,"+ " Items_id INTEGER "+"REFERENCES Items(id),"+" PRIMARY KEY ( id ))";
				
		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			java.sql.Statement st = conn.createStatement();
			int m = st.executeUpdate(sqlDB);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				return true;
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return false;
	}
	
	
	
	
	public static void insertIntoInvoiceTable() {

		String url = "jdbc:mysql://localhost:3306/Invoice";
		String username = "root";
		String password = "root";

		
		
		
		
		
		Scanner sa = new Scanner(System.in);
		System.out.println(" customerName :");
		String customerName=sa.next();	
		
		Scanner s1 = new Scanner(System.in);
		System.out.println(" phoneNumber :");
		int phoneNumber=s1.nextInt();
		
		Scanner s2 = new Scanner(System.in);
		System.out.println(" invoiceDate :");
		int invoiceDate=s2.nextInt();
		
		
		
		Scanner s3= new Scanner(System.in);
		System.out.println(" numberItems :");
		int numberItems=s3.nextInt();
		
		
		Scanner s4= new Scanner(System.in);
		System.out.println(" totalAmount :");
		int totalAmount=s4.nextInt();
		
		
		Scanner s5= new Scanner(System.in);
		System.out.println(" paidAmoun :");
		int paidAmoun=s5.nextInt();
		
		Scanner s6= new Scanner(System.in);
		System.out.println(" balance :");
		int balance=s6.nextInt();
		
		

//		String customerName = "  ";
//		Integer phoneNumber = 13344788;
//		Integer invoiceDate = 2023-01-12;
//		Integer numberItems = 1345;
//		Integer totalAmount = 89;
//		Integer paidAmoun = 567;
//		Integer balance = 5769;
		int user = sa.nextInt();
		for (int i = 1; i <= user; i++) {

			String sql = "INSERT INTO  Invoice VALUES ('" +  customerName + "',"+phoneNumber  +","+phoneNumber  +","+invoiceDate+","+numberItems+","+totalAmount+","+paidAmoun+","+balance
					+ ")";
			
			
			java.sql.Connection conn = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection(url, username, password);
				java.sql.Statement st = conn.createStatement();
				int m = st.executeUpdate(sql);
				if (m >= 1) {
					System.out.println("inserted data successfuly...");

				} else {
					System.out.println(" faild inserted data...");
				}
				conn.close();
			} catch (Exception ex) {
				System.err.println(ex);
			}

		}
	}

	
	
	
	
	
	
	
	
	
	
	}
	
	

