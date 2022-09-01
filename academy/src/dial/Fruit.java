package dial;
import java.util.Objects;

public class Fruit extends Product{
	
	private String ripeness;
	private double weight;

	public Fruit () {
		super ();
	}
	public void setRipeness (String ripeness) {
		this.ripeness=ripeness;
	}
	public String getRipeness() {
		return ripeness;
	}
	public void setWeight (double weight) {
		this.weight=weight;
	}
	public double getWeight() {
		return weight;
	}
	
	public Fruit (String name, double price, double quantity, String ripeness, double weight) {
		super(name, price, quantity);
		this.ripeness = ripeness;
		this.weight = weight;
	}
	
	@Override
	public double discount() {
		if (quantity>=10) {
			return 0.75;
		}
		else {
		return 1;
		}		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ripeness, weight);
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
		Fruit other = (Fruit) obj;
		return Objects.equals(ripeness, other.ripeness)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}
	
	public String toString() {
		StringBuilder stbF = new StringBuilder();
		stbF.append("[Продукт:");
		stbF.append(name);
		stbF.append(", цена=");
		stbF.append(price);
		stbF.append(", количество=");
		stbF.append(quantity);
		stbF.append(", зрелость=");
		stbF.append(ripeness);
		stbF.append(", вес=");
		stbF.append(weight);
		stbF.append("]");
		return stbF.toString();
	}
}