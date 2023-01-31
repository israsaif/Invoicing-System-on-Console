import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class Items {
  
	private int  itemID;
	private String  itemName;
	private String  unitPrice;
	private int quantity;
	private int qtyAmount;
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQtyAmount() {
		return qtyAmount;
	}
	public void setQtyAmount(int qtyAmount) {
		this.qtyAmount = qtyAmount;
	}
	
	
	
	
	
	public static boolean createItemsTable() {
		String url = "jdbc:mysql://localhost:3306/Invoice";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Items "+"(id INTEGER NOT NULL AUTO_INCREMENT, "+"itemID INTEGER,"+" itemName VARCHAR(80), "+" unitPrice VARCHAR(80), "+" quantity INTEGER, "+" qtyAmount INTEGER,"+" Shop_id INTEGER "+"REFERENCES Shop(id),"+" PRIMARY KEY ( id ))";
				
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
	
	
	public static void insertIntoItemsTable()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Scanner sa = new Scanner(System.in);
		System.out.println("PLS Enter Database URL");
		String url = sa.next();
		
		System.out.println("PLS Enter userName");
		String user = sa.next();
		
		System.out.println("PLS Enter password");
		String pass = sa.next();
		
		System.out.println("PLS Enter item ID ");
		int item_Id = sa.nextInt();
		
		System.out.println("PLS Enter item Name");
		String item_Name = sa.next();
		
		System.out.println("PLS Enter unit Price");
		String unitPrice = sa.next();
		
		System.out.println("PLS Enter quantity");
		int quantity = sa.nextInt();
		
		System.out.println("PLS Enter qtyAmount");
		int qtyAmount = sa.nextInt();
		
		System.out.println("PLS Enter shop name you want");
		String name = sa.next();
		
		String sql = "select id  from Shop where ShopName ='" + name + "'";
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
				sql = "INSERT INTO Items(itemId,itemName,unitPrice,quantity,qtyAmount,Shop_id)VALUES(?,?,?,?,?,?)";
				try {
					PreparedStatement pstmt3 = con.prepareStatement(sql);
					pstmt3.setInt(1, item_Id);
					pstmt3.setString(2, item_Name);
					pstmt3.setString(3, unitPrice);
					pstmt3.setInt(4, quantity);
					pstmt3.setInt(5, qtyAmount);
					pstmt3.setInt(6, shop_id);
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
	
	
	public static void deleteByItems() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String url = "jdbc:mysql://localhost:3306/Invoice";
		String username = "root";
		String password = "root";
		Connection conn = null;
		Statement stmt = null;
		try {
//			try {
				
//			} catch (Exception e) {
//				System.out.println(e);
//			}
			Driver driver =(Driver)Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			Statement st =(Statement) conn.createStatement();
//			System.out.println("Connection is created successfully:");
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please Enter any id to delete  :");
			int userinput = scanner.nextInt();

			

			String sql = "delete from Items where id ='" + userinput + "'";
			int result = ((java.sql.Statement) st).executeUpdate(sql);
			System.out.println("Record has been delete in the table successfully..................");
		} catch (SQLException excep) {
			excep.printStackTrace();
		
		}
//		} catch (Exception excep) {
//			excep.printStackTrace();
//		}
	}
}
//		} finally {
//			try {
//				if (stmt != null)
//					conn.close();
//			} catch (SQLException se) {
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//		System.out.println("Please check it in the MySQL Table. Record is now delete.......");
//	}

	
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
