import java.sql.Driver;
import java.sql.DriverManager;

public class Shop {
	private String  shopName;
	private int  shopId;
	

	
	public String getShopName() {
		return shopName;
	}



	public void setShopName(String shopName) {
		this.shopName = shopName;
	}



	public int getShopId() {
		return shopId;
	}



	public void setShopId(int shopId) {
		this.shopId = shopId;
	}



	public static boolean createShopTable() {
		String url = "jdbc:mysql://localhost:3306/Invoice";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Shop "+"(id INTEGER NOT NULL AUTO_INCREMENT, "+" shopName VARCHAR(80), "+" shopId INTEGER,  "+" PRIMARY KEY ( id ))";
				
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
	
	
	
	
	
	
	
	
	
	
	
	
	
}
