package trying;

public class Product {

	protected String product;
	protected int price;
	protected int quantity;
	protected int isTax;

	public void setProducts(String product) {
		this.product = product;
	}

	public String getProducts() {
		return product;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setIsTax(int isTax) {
		this.isTax = isTax;
	 }

	public int getIsTax() {
		return isTax;
	}

	public double discount() {
		if (quantity > 10) {
			return 0.4;
		}
		return 1;

	}

}
