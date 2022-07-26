package homework3;
import java.util.Objects;


public class Milk {
	
	  private String percentFat;

	    public Milk(String name, double price, int quality) {
	        super(name, price, quality);
	    }

	    public String getPercentFat() {
	        return percentFat;
	    }

	    public void setPercentFat(String percentFat) {
	        this.percentFat = percentFat;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Milk milk = (Milk) o;
	        return Objects.equals(percentFat, milk.percentFat);
	    }

	    @Override
	    public String toString() {
	        return "Milk{" +
	                "percentFat='" + percentFat + '\'' +
	                ", price=" + price +
	                ", name='" + name + '\'' +
	                ", quality=" + quality +
	                '}';
	    }

	    @Override
	    double discount() {
	        return 0.8;
	    }

}
