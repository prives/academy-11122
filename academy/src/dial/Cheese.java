package dial;


import java.util.Objects;

public class Cheese extends Product{
	
	private String countryProduce;
	private double richness;

	public Cheese () {
		super ();
	}
	public void setRichness (double richness) {
		this.richness=richness;
	}
	public double getRichness() {
		return richness;
	}
	public void setCountryProduce (String countryProduce) {
		this.countryProduce=countryProduce;
	}
	public String getCountryProduce() {
		return countryProduce;
	}
	
	public Cheese (String name, double price, double quantity, String countryProduce,double richness) {
		super(name, price, quantity);
		this.countryProduce = countryProduce;
		this.richness = richness;
	}
	
	@Override
	public double discount() {
		if (quantity>=5) {
			return 0.85;
		}
		else {
		return 1;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(countryProduce, richness);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cheese other = (Cheese) obj;
		return Objects.equals(countryProduce, other.countryProduce)
				&& Double.doubleToLongBits(richness) == Double.doubleToLongBits(other.richness);
	}
	
	public String toString() {
		StringBuilder stbC = new StringBuilder();
		stbC.append("[Продукт:");
		stbC.append(name);
		stbC.append(", цена=");
		stbC.append(price);
		stbC.append(", количество=");
		stbC.append(quantity);
		stbC.append(", страна производитель=");
		stbC.append(countryProduce);
		stbC.append(", жирность=");
		stbC.append(richness);
		stbC.append("]");
		return stbC.toString();
	}
}
