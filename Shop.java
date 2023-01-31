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
	
	//public static void insertIntoShopTable()
//			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//		Scanner sa = new Scanner(System.in);
//		System.out.println("PLS Enter Database URL");
//		String url = sa.next();
//		
//		System.out.println("PLS Enter userName");
//		String user = sa.next();
//		
//		System.out.println("PLS Enter password");
//		String pass = sa.next();
//		
//		System.out.println("PLS Enter shop Name ");
//		String shop_Name = sa.next();
//	
//		System.out.println("PLS Enter telephone");
//		int telephone = sa.nextInt();
//		
//		System.out.println("PLS Enter Fax ");
//		String Fax = sa.next();
//		
//		System.out.println("PLS Enter email ");
//		String email = sa.next();
//		
//		
//		
//		
//		System.out.println("PLS Enter shop name you want");
//		String name = sa.next();
//		
//		String sql = "select id  from Shop where ShopName ='" + name + "'";
//		Connection con = null;
//		try {
//			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//			
//			DriverManager.registerDriver(driver);
//			
//			con = DriverManager.getConnection(url, user, pass);
//			PreparedStatement pstmt = con.prepareStatement(sql);
//		
//			try {
//				int shop_id = 0;
//				ResultSet rs = pstmt.executeQuery();
//				if (rs.next()) {
//					shop_id = rs.getInt("id");
//				}
//				sql = "INSERT INTO Shop(shop_Name,telephone,Fax,email)VALUES(?,?,?,?)";
//				try {
//					PreparedStatement pstmt3 = con.prepareStatement(sql);
//					pstmt3.setString(1, shop_Name);
//					pstmt3.setInt(2, telephone);
//					pstmt3.setString(3, Fax);
//					pstmt3.setString(4, email);
//					pstmt3.executeUpdate();
//					System.out.println("added successfully");
//					Driver driver1 = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//					DriverManager.registerDriver(driver1);
//					con = DriverManager.getConnection(url, user, pass);
//					Statement st = (Statement) con.createStatement();
//					int m = ((java.sql.Statement) st).executeUpdate(sql);
//					if (m >= 1) {
//						System.out.println("Inserte table in database is success...");
//					} else {
//						System.out.println(" table already Inserte in given database...");
//					}
//					con.close();
//				} catch (Exception ex) {
//					System.err.println(ex);
//				}
//			} catch (SQLException e) {
//				System.out.println(e);
//			}
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//	}
//	
	
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

