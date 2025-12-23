
public class Clothing extends Product{
	String size;
	String color;
	public Clothing(String productID ,double price, String name, int quantity,String size,String color) {
		super(productID, price, name, quantity);
		this.size=size;
		this.color=color;
		
	}
	public Clothing(String productID, double price, String name, int quantity, int warranty) {
		super(productID, price, name, quantity);
	}
	public Clothing(String productID, String name, double price, int quantity, String size, String color) {
		super(productID, price, name, quantity);
		this.size=size;
		this.color=color;
	}
	public String toString() {
		return ("Clothing|| ")+super.toString()+("Size: "+size+" Color: "+color);
	}
	public String getCategory() {
		return "Clothing";
	}

}
