import java.sql.Driver;
import java.sql.DriverManager;

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
	
	
	
	
	
	public static boolean createInvoiceTable() {
		String url = "jdbc:mysql://localhost:3306/Invoice";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Items "+"(id INTEGER NOT NULL AUTO_INCREMENT, "+"itemID INTEGER,"+" itemName VARCHAR(80), "+" unitPrice VARCHAR(80), "+" quantity INTEGER, "+" qtyAmount INTEGER, "+" PRIMARY KEY ( id ))";
				
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
