package homework3;

public class Product {

	 protected double price;
	    protected String name;
	    protected int quality;

	    public Product(String name, double price, int quality) {
	        this.price = price;
	        this.name = name;
	        this.quality = quality;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getQuality() {
	        return quality;
	    }

	    public void setQuality(int quality) {
	        this.quality = quality;
	    }

	    abstract double discount();

	    public double calePrice (Product product){
	        double sum = product.price * product.quality * discount();
	        return sum;
	    }
	
}
