import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
Scanner sa = new Scanner(System.in);
		
		boolean bigMenu = true;
		boolean subMenue1=true;
		boolean subMenue2 = true;
		
		while (bigMenu) {
		Menu.showMenu(1);
			String bb = sa.next();
			int option = Integer.parseInt(bb);

			switch (option) {

			case 1:
				while(subMenue1){
//					for(String x:Menu.showMenu(1))
					Menu.showMenu(2);
					
					Scanner saa = new Scanner(System.in);

					String bb1 = saa.next();
					int options = Integer.parseInt(bb1);

					switch (options){
					
	                 case 0:
						
						
						Shop shop = new Shop ();
						shop.createShopTable();
						
						
						
						
						
						break;
					case 1:
						
						
						Invoice invoice = new Invoice();
						invoice.insertIntoInvoiceTable();
						
						
					
						break;
						
					case 2:	
						
						Items items= new Items();
						items.insertIntoItemsTable();
						
						
						
						
					case 3:
						
						Shop Shop=new Shop();
						Shop.insertIntoShopTable();
						
						
						
						break;
						
						
					case 4:
						
						
						Shop shop1= new Shop();
						shop1.insertIntoShopTable();
						
						
						break;
						
						
                    case 5:
						
                    	 subMenue1=false;
                     	
                     	bigMenu = true;
                    	
						break;
					}
             
					
				}subMenue1=false; 
				break;
				
				
				
			case 2:
				while(subMenue2){
				Menu.showMenu(3);
					
					Scanner saa = new Scanner(System.in);
					String bb1 = saa.next();
					int options = Integer.parseInt(bb1);

					
					switch (options){
					
					case 0:
					
						
						Items items = new Items();
						items.createItemsTable();
						
						break;
						
						
					case 1:
						Items items2= new Items();
						items2.insertIntoItemsTable();
						
						break;
						
						
						
					case 2:
						Items itemsDelete = new Items();
						itemsDelete.deleteByItems();
						
						break;
						
						
						
					case 3:
					Items itemsUpdate=new Items();
						itemsUpdate.updateByItems();
						
						break;
						
					case 4:
						Items items4=new Items();
						items4.readFromTable();
						
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
				
				
				Invoice invoice5=new Invoice();
				invoice5.readFromInvoiceTable();
				break;

				
				
				
			case 6:
				Invoice invoice6=new Invoice();
				invoice6.getByIdInvoice();
				
				
				break;

				
				
				
			case 7:
				
	
				
				
				break;
				
				
				
			case 8:
				Scanner saa = new Scanner(System.in);
				System.out.println("Are you sure you want to exit?");
				String bb1 = saa.next();
				if(bb1.equals("yes")) {
					System.exit(0);
				}else {
					
					 bigMenu = true;
					 subMenue1=false;
					 subMenue2 = false;
				}

						 
					
					
			
			break;
		}	
			
		}bigMenu = false;


	}

}
