package homework3;

import java.util.Objects;

public class Meat {
	
	 private String sort;

	    public Meat(String name, double price,int quality) {
	        super(name, price, quality);
	    }

	    public String getType() {
	        return sort;
	    }

	    public void setType(String sort) {
	        this.sort = sort;
	    }

	    @Override
	    public String toString() {
	        return "Meat{" +
	                "sort='" + sort + '\'' +
	                ", price=" + price +
	                ", name='" + name + '\'' +
	                ", quality=" + quality +
	                '}';
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Meat meat = (Meat) o;
	        return Objects.equals(sort, meat.sort);
	    }

	    @Override
	    double discount() {
	        return 0.9;
	    }

}
