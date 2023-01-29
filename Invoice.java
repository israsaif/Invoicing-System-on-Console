import java.sql.Driver;
import java.sql.DriverManager;

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
		String sqlDB = "CREATE TABLE Invoice " + "(id INTEGER NOT NULL AUTO_INCREMENT, " + "customerName  VARCHAR(80), "
				+ " phoneNumber INTEGER, "+ " invoiceDate INTEGER, "+ " numberItems INTEGER, "+" totalAmount INTEGER "+" paidAmoun INTEGER,"
				+"balance INTEGER ,";
			
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
