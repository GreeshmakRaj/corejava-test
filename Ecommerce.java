import java.util.HashMap;
import java.util.Scanner;

public class Ecommerce {

	static HashMap<String,String> customer = new HashMap<>();
	static HashMap<String, Integer> product = new HashMap<>();
	static HashMap<String, Integer> orders = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		
		while(true){
			System.out.println(" 1.Regitser \n 2.Create Product \n 3.Create Order \n 5.Exit ");
			int option = sc.nextInt();
			switch(option){
			case 1: registerUser();
			break;
			case 2: createProduct();
			break;
			case 3: createOrder();
			break;
//			case 4: login();
//			break;
			case 5: System.exit(1);
			}
		}
		
		
	}
	
	//user login
	private static String login() {
		// TODO Auto-generated method stub
		System.out.println("Login: \nenter the user name: ");
		String name = sc.next();
		System.out.println("enter password: ");
		String pass = sc.next();
		if (customer.containsKey(name)) {
			String password = customer.get(name);
			System.out.println("Logged in successfully");
		}
		else{
			System.out.println("Invalid credentials");
			System.exit(0);
		}
		return name;
	}


	private static void createOrder() {
		// TODO Auto-generated method stub
		String res = login();
		int price = searchProduct();
//		orders.put(res, price);
		
		/** 
		 * checks if the user has already ordered some products 
		 * if yes then the total price updated
		 */
		if(orders.containsKey(res)){
			int currPrice = orders.get(res);
			price = currPrice + price;
			orders.remove(res);
			orders.put(res, price);
		}
		else{
			orders.put(res, price);
		}
		System.out.println("total price of all orders of "+res+" is "+price);
	}

	
	// to find the price of a particular product
	private static int searchProduct() {
		// TODO Auto-generated method stub
		int price = 0;
		System.out.println("enter the product name: ");
		String name = sc.next();
		if (product.containsKey(name)) {
			price = product.get(name);
		}
		return price;
	}


	private static void createProduct() {
		// TODO Auto-generated method stub
		System.out.println("enter product name: ");
		String pname = sc.next();
		System.out.println("enter product price: ");
		Integer price = sc.nextInt();
		product.put(pname, price);
	}


	public static void registerUser(){
		System.out.println("enter the name: ");
		String name = sc.next();
		System.out.println("enter password: ");
		String pass = sc.next();
		customer.put(name, pass);
	}
}
