import java.util.Scanner;
import java.io.IOException;
public class Main {

	public static void main(String[] args) {
		InventoryManagementSystem ims = new InventoryManagementSystem();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		while (running) {
		System.out.println("\n=== E-Commerce Inventory System ===");
		System.out.println("1. Add Product");
		System.out.println("2. Display All Products");
		System.out.println("3. Search Product by Name");
		System.out.println("4. Sort Products by Price");
		System.out.println("5. Update Stock for a Product");
		System.out.println("6. Save Data to File");
		System.out.println("7. Load Data from File");
		System.out.println("8. Remove Product");
		System.out.println("9. Exit");
		System.out.print("Select an option: ");
		int option = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		switch (option) {
		case 1:
		System.out.print("Enter product type (Electronics, Clothing, Groceries): ");
		String type = scanner.nextLine();
		System.out.print("Enter product ID: ");
		String id = scanner.nextLine();
		System.out.print("Enter product name: ");
		String name = scanner.nextLine();
		System.out.print("Enter price: ");
		double price = scanner.nextDouble();
		System.out.print("Enter quantity: ");
		int quantity = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		Product product = null;
		switch (type.toLowerCase()) {
		case "electronics":
		System.out.print("Enter warranty period in months: ");
		int warrantyPeriod = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		product = new Electronics(id, price, name, quantity, warrantyPeriod);
		break;
		case "clothing":
			System.out.print("Enter size: ");
			String size = scanner.nextLine();
			System.out.print("Enter color: ");
			String color = scanner.nextLine();
			product = new Clothing(id, price, name, quantity, size, color);
			break;
			case "groceries":
			System.out.print("Enter weight: ");
			double weight = scanner.nextDouble();
			scanner.nextLine(); // Consume newline
			product = new Grocceries(id, price, name, quantity, weight);
			break;
			default:
			System.out.println("Invalid product type.");
			break;
			}
			if (product != null) {
			ims.addProduct(product);
			System.out.println("Product added successfully.");
			}
			break;
			case 2:
			System.out.println("Displaying all products:");
			ims.displayAllProducts();
			break;
			case 3:
			System.out.print("Enter product name to search: ");
			String searchName = scanner.nextLine();
			Product foundProduct = ims.searchProductByName(searchName);
			System.out.println(foundProduct != null ? foundProduct : "Product not found.");
			break;
			case 4:
			System.out.println("Sorting products by price:");
			ims.sortProductsByPrice();
			break;
			case 5:
			System.out.print("Enter product ID to update stock: ");
			String updateId = scanner.nextLine();
			System.out.print("Enter the quantity to add (or subtract): ");
			int updateQuantity = scanner.nextInt();
			scanner.nextLine(); // Consume newline
			Product updateProduct = ims.searchProductById(updateId);
			if (updateProduct != null) {
			updateProduct.updateStock(updateQuantity);
			System.out.println("Updated Product Details: " + updateProduct);
			} else {
			System.out.println("Product not found.");
			}
			break;
			case 6:
			try {
				ims.saveDataToFile("output.txt");
				System.out.println("\nData saved to file: output.txt");
				} catch (IOException e) {
				e.printStackTrace();
				}
			break;
			case 7:
			try {
			ims.loadDataFromFile("productsList.txt");
			System.out.println("Data loaded from file and displaying all products:");
			ims.displayAllProducts();
			} catch (IOException e) {
			System.out.println("Error loading data from file: " + e.getMessage());
			}
			break;
			case 8:
			System.out.print("Enter product ID to remove: ");
			String removeId = scanner.nextLine();
			ims.removeProduct(removeId);
			System.out.println("Product removed, if it existed.");
			break;
			case 9:
			running = false;
			System.out.println("Exiting...");
			break;
			default:
			System.out.println("Invalid option. Please try again.");
			break;
			}
			}
			scanner.close();
			}
}
			
			






