import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mysql.cj.xdevapi.Statement;


public class Invoice {

	private String customerName;
	private int phoneNumber;
	private String invoiceDate;
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
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
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
		String sqlDB = "CREATE TABLE Invoice "+"(id INTEGER NOT NULL AUTO_INCREMENT, "+"customerName VARCHAR(80),"+" phoneNumber INTEGER, "+" invoiceDate date, "+" numberItems INTEGER, "+" totalAmount INTEGER, "+" paidAmoun INTEGER,"+"balance INTEGER,"+ " Items_id INTEGER "+"REFERENCES Items(id),"+" PRIMARY KEY ( id ))";
				
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
	
	
	
	
	public static void insertIntoInvoiceTable() throws InstantiationException, IllegalAccessException, ClassNotFoundException {


		Scanner sa = new Scanner(System.in);
		System.out.println("PLS Enter Database URL");
		String url = sa.next();
		
		System.out.println("PLS Enter userName");
		String user = sa.next();
		
		System.out.println("PLS Enter password");
		String pass = sa.next();
		
		Scanner s0 = new Scanner(System.in);
		System.out.println(" itemName :");
		String item_Name=s0.next();	
		
		
		Scanner s1 = new Scanner(System.in);
		System.out.println(" customerName :");
		String customer_Name=s1.next();	
		
		Scanner s2 = new Scanner(System.in);
		System.out.println(" phoneNumber :");
		int phone_Number=s2.nextInt();
		
		Scanner s3 = new Scanner(System.in);
		System.out.println(" invoiceDate :");
		String invoice_Date=s3.next();
		
		
		
		Scanner s4= new Scanner(System.in);
		System.out.println(" numberItems :");
		int number_Items=s4.nextInt();
		
		
		Scanner s5= new Scanner(System.in);
		System.out.println(" totalAmount :");
		int total_Amount=s5.nextInt();
		
		
		Scanner s6= new Scanner(System.in);
		System.out.println(" paidAmoun :");
		int paid_Amoun=s6.nextInt();
		
		Scanner s7= new Scanner(System.in);
		System.out.println(" balance :");
		int balance=s7.nextInt();
		
		System.out.println(" item Id :");
		int item_Id=s7.nextInt();
		
		String sql = "select id  from Items where itemName ='" +item_Name  + "'";
		Connection con = null;
		
		
		
		
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			DriverManager.registerDriver(driver);
			
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = con.prepareStatement(sql);
		
			try {
				int shop_id = 1;
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					shop_id = rs.getInt("id");
				}
				sql = "INSERT INTO Invoice(customerName,phoneNumber,invoiceDate,numberItems,totalAmount,paidAmoun,balance,Items_id)VALUES(?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pstmt3 = con.prepareStatement(sql);
				//	pstmt3.setString(1, item_Name);
					pstmt3.setString(1, customer_Name);
					pstmt3.setInt(2, phone_Number);
					pstmt3.setString(3, invoice_Date);
					pstmt3.setInt(4, number_Items);
					pstmt3.setInt(5, total_Amount);
					pstmt3.setInt(6, paid_Amoun);
					pstmt3.setInt(7, balance);
					pstmt3.setInt(8, item_Id);
					pstmt3.executeUpdate();
					System.out.println("added successfully");
					Driver driver1 = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					DriverManager.registerDriver(driver1);
					con = DriverManager.getConnection(url, user, pass);
					Statement st = (Statement) con.createStatement();
					int m = ((java.sql.Statement) st).executeUpdate(sql);
					if (m >= 1) {
						System.out.println("Inserte table in database is success...");
					} else {
						System.out.println(" table already Inserte in given database...");
					}
					con.close();
				} catch (Exception ex) {
					System.err.println(ex);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	

	
	
	
	
	
	
	
	
	
	
	}
	
	

