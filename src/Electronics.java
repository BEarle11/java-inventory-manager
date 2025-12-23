
public class Electronics extends Product {
	int warranty;
	public Electronics(String productID, double price, String name, int quantity,int warranty ) {
		super(productID, price, name, quantity);
		this.warranty=warranty;
	}
	public Electronics(String productID, String name, double price, int quantity, int warranty) {
		super(productID, price, name, quantity);
		this.warranty=warranty;
	}
	public String toString() {
		return ("Electronic|| ")+super.toString()+(" Warranty: "+warranty);
	}
	public String getCategory() {
		return "Electronics";
	}

}
