package homework3;
import java.util.Objects;
public class Bread extends Product{
	
	
	 private String type;
	    public Bread(String name, double price, int quality) {
	        super(name, price, quality);
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    @Override
	    public String toString() {
	        return "Bread{" +
	                "type='" + type + '\'' +
	                ", price=" + price +
	                ", name='" + name + '\'' +
	                ", quality=" + quality +
	                '}';
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Bread bread = (Bread) o;
	        return Objects.equals(type, bread.type);
	    }

	    @Override
	    double discount() {
	        return 0.7;
	    }
}
