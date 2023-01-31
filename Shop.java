import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class Shop {
	private String  shopName;
//	private int  shopId;
	private int telephone;
	private String Fax;
	private String  email; 
	   

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

//	public int getShopId() {
//		return shopId;
//	}
//
//	public void setShopId(int shopId) {
//		this.shopId = shopId;
//	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static boolean createShopTable() {
		String url = "jdbc:mysql://localhost:3306/Invoice";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Shop "+"(id INTEGER NOT NULL AUTO_INCREMENT, "+" shopName VARCHAR(80), "+" telephone INTEGER,"+" Fax VARCHAR(80), "+" email VARCHAR(80),  "+" PRIMARY KEY ( id ))";
				
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
	

	
	public static void insertIntoShopTable() {

		String url = "jdbc:mysql://localhost:3306/Invoice";
		String username = "root";
		String password = "root";

		Scanner sa = new Scanner(System.in);
//		System.out.println("Enter how many rows you want:");
//		int user = sa.nextInt();
		
		System.out.println("PLS Enter shop Name ");
		String shop_Name = sa.next();
	
		System.out.println("PLS Enter telephone");
		int telephone = sa.nextInt();
		
		System.out.println("PLS Enter Fax ");
		String Fax = sa.next();
		
		System.out.println("PLS Enter email ");
		String email = sa.next();
		
		//for (int i = 1; i <= 1; i++) {

			String sql = "INSERT INTO  Shop(shopName,telephone,Fax,email )"+" VALUES ('" + shop_Name+ "'," +telephone +",'"+Fax+"','"+email +"' )";
					
			java.sql.Connection conn = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

