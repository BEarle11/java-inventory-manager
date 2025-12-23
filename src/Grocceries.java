
public class Grocceries extends Product {
	int warranty;
	public Grocceries(String productID, double price, String name, int quantity) {
		super(productID, price, name, quantity);
		// TODO Auto-generated constructor stub
	}
	public Grocceries(String productID, double price, String name, int quantity, int warranty) {
		super(productID, price, name, quantity);
		this.warranty=warranty;
	}
	public Grocceries(String productID, String name, double price, int quantity, double e) {
		super(productID, price, name, quantity);
	}
	public Grocceries(String productID, double price, String name, int quantity, double weight) {
		super(productID, price, name, quantity);
	}
	@Override
	public String toString() {
		return ("Gorccery|| ")+super.toString();
	}
	public String getCategory() {
		return "Grocceries";
	}

}
