import java.sql.SQLException;
import java.util.Scanner;


public class Menu {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Scanner sa = new Scanner(System.in);
		
		boolean bigMenu = true;
		boolean subMenue1=true;
		boolean subMenue2 = true;
		
		while (bigMenu) {
			System.out.println("1.Shop Settings");
			System.out.println("2.Manage Shop Items");
			System.out.println("3.Create New Invoice");
			System.out.println("4.Report: Statistics");
			System.out.println("5.Report: All Invoices");
			System.out.println("6.Search (1) Invoice");
			System.out.println("7.Program Statistics");
			System.out.println("8.Exit");
			String bb = sa.next();
			int option = Integer.parseInt(bb);

			switch (option) {

			case 1:
				while(subMenue1){
					
					System.out.println("0.createShopTable");
					System.out.println("1.insertShopTable");
					System.out.println("2.Load Data invoice");
					System.out.println("3.Load Data Items");
					System.out.println("4.Set Shop Name");
					System.out.println("5.Set Invoice Header");
					System.out.println("6.Go Back");
					
					Scanner saa = new Scanner(System.in);

					String bb1 = saa.next();
					int options = Integer.parseInt(bb1);

					switch (options){
					
	                 case 0:
						
						
						Shop shop = new Shop ();
						shop.createShopTable();
						
						
						
						
						
						break;
					case 1:
						Shop Shop=new Shop();
						Shop.insertIntoShopTable();
						
						
						
						
						
						
					
						
						
					
						break;
						
					case 2:	
						
						Invoice invoice = new Invoice();
						invoice.insertIntoInvoiceTable();
						
						
						
						
						
					case 3:
						
						
						Items items= new Items();
						items.insertIntoItemsTable();
						
						
						
						
						
						
						
						break;
						
						
					case 4:
						
						
						Shop shop1= new Shop();
						shop1.insertIntoShopTable();
						
						
						
						
						
						
						
						
						break;
						
						
                    case 5:
						
                    	
                    	
                    	
						
						break;
						
						
						
                    case 6:	
                    	
                    	
                    subMenue1=false;
                    	
                    	bigMenu = true;
						
                    	break;
                    	
                    	
					}
				break;
				
				}subMenue1=false; 
				
				
				
				
			case 2:
				while(subMenue2){
					System.out.println("1.Add Items");
					System.out.println("2.Delete Items");
					System.out.println("3.Change Item Price");
					System.out.println("4.Report All Items");
					System.out.println("5. Go Back ");
					
					Scanner saa = new Scanner(System.in);
					String bb1 = saa.next();
					int options = Integer.parseInt(bb1);

					
					switch (options){
					
					
					
					
					case 1:
						Items items = new Items();
						items.createItemsTable();
						
						break;
						
						
						
					case 2:
						
						
						
						break;
						
						
						
					case 3:
						
						
						break;
						
					case 4:
						
						
						
						break;
						
						
					case 5:	
						subMenue2 = false;
						bigMenu = true;
						break;
						
					}
				break;
				}subMenue2= false;
				
				
				
				
				
				
				
				
				
			case 3:
				
				Invoice invoice = new Invoice();
				invoice.createInvoiceTable();
				
				
				
				
				break;
			case 4:
				
				
				break;

			case 5:
				
				break;

			case 6:
				
				break;

			case 7:
	
				break;
			case 8:
				
						 
					
					
			
			break;
		}	
			
		}bigMenu = false;
	

	}
	}
	
