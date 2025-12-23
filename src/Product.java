
public class Product {
String productID;
String name;
double price;
int quantity;
int warranty;
public Product(String productID, double price,String name, int quantity) {
	this.productID=productID;
	this.name=name;
	this.price=price;
	this.quantity=quantity;
}
public String getCategory() {
	return "Product";
}
public String getProductID() {
	return productID;
}
public double getPrice() {
	return price;
}
public String getName() {
	return name;
}
public int getQuantity() {
	return quantity;
}

public void updateStock(int num) {
	quantity+=num;
}
@Override
public String toString() {
	return ("ProductID: "+productID+" Name: "+name+" Price: "+price+" Quantity: "+quantity);
}
}
