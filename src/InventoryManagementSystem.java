import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class InventoryManagementSystem {
HashMap<String,Product> products = new HashMap<>();
private int productCount = 0;

// adds product to hashmap
public void addProduct(Product p) {
	products.put(p.getProductID(), p);
}

// removes product from hashmap 
public void removeProduct(String s) {
	products.remove(s);
}
// writes hashmap data to txt file 
public void saveDataToFile(String s)throws IOException {
	try {
		FileWriter fw;
		// checks whihc file to write to
		if (s=="inventory_test.txt") 
			fw = new FileWriter("inventory_test.txt");
		else
			fw = new FileWriter("output.txt");  //if file is already there, this will blow it away
        PrintWriter pw = new PrintWriter(fw);
        for (String key:products.keySet()) {
            Product p =products.get(key);
            pw.println(p.getCategory()+"|"+p.productID+"|"+p.name+"|"+p.price+"|"+p.quantity+"|"+p.warranty);
            
        }
        pw.close();
        }
    catch(Exception e){
            System.out.println("Can't open file");
            }
}
// returns the id that corresponds to name string if it exits in hashmap
public Product searchProductByName(String s) {
	for (String key:products.keySet()) {
		if(s.equals(products.get(key).getName())) {
			return products.get(key);
		}
	}
	System.out.println("Product can not be found");
	return null;
}
// uses bubble sort to add and sort price values in an arraylist
// then it puts the values in a linkedhashmap that holds the order of the values
// linked hashmap is then printed out 
public void sortProductsByPrice() {
	ArrayList<Product> productList= new ArrayList<>(products.values());
	for (int i=0;i<productList.size()-1;i++) {
		for (int j=0;j<productList.size()-1-i;j++) {
			if(productList.get(j).price>productList.get(j+1).price) {
				Product temp=productList.get(j);
				productList.set(j,productList.get(j+1));
				productList.set(j+1, temp);
			}
		}
	}
	// make sorted hashmap 
	LinkedHashMap<String,Product> priceSortedProducts = new LinkedHashMap<>();
	for (Product product:productList) {
		for (String key:products.keySet()) {
			if(products.get(key).equals(product)) {
				priceSortedProducts.put(key,product);
				break;
			}
		}
	}
	System.out.println(products.size()+" sorted units: ");
	for (String key:priceSortedProducts.keySet()) {
		System.out.println(priceSortedProducts.get(key).toString());
	}
	// replace hashmap with sorted hashmap
	products.clear();
	products.putAll(priceSortedProducts);
}
// prints all the elements in the hashmap
public void displayAllProducts() {
	System.out.println(products.size()+" units: ");
	for (String key:products.keySet()) {
		System.out.println(products.get(key).toString());
	}
}
// uses the parse data method to read data from file and insert into hashmap
public void loadDataFromFile(String fileName) throws IOException {
	try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		String line;
		while ((line = br.readLine()) != null) {
			String[] parts = parseProduct(line);
			if (parts.length >=5) {
				try {
					String category= parts[0].trim();
					String code= parts[1].trim();
					String name= parts[2].trim();
					double price=Double.parseDouble(parts[3].trim());
					int stock= Integer.parseInt(parts[4].trim());
					int warranty=Integer.parseInt(parts[5].trim());
					if (category.equals("Electronics")&&parts.length == 6) {
						products.put(code,new Electronics(code,price,name,stock,warranty));
						productCount++;
					}
					else if (category.equals("Clothing")&&parts.length == 6) {
						products.put(code,new Clothing(code,price,name,stock,warranty));
						productCount++;
					}
					else if (category.equals("Groceries")&&parts.length == 6) {
						products.put(code,new Grocceries(code,price,name,stock,warranty));
						productCount++;
					}
					else {
						System.out.println("Invalid product format: "+line);
					}
	} 
				catch (NumberFormatException e) {
					System.out.println(productCount+"Error parsing product information: " + line);
	}
	}		
	}
	} 
	 catch (IOException e) {
	System.out.println("I/O error: " + e.getMessage());
	}
}
// finds delimiters and seperates the data into strings
private String[] parseProduct(String line) {
	if (line.contains(",")) {
		return line.split(",");
		} 	
	else if (line.contains("|")) {
		
		return line.split("\\|");
		} 
	else if (line.contains(";")) {

		return line.split(";");
		} 
	else {

		return new String[]{};
}
}
// finds product using key 
public Product searchProductById(String s) {
	for (String key:products.keySet()) {
		if(s.equals(products.get(key).getProductID())) {
			return products.get(key);
		}
	}
	System.out.println("Product can not be found");
	return null;
}

}
		