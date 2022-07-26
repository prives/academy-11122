package trying;


import trying.deal.Product;

public class Cheese    extends Product { {

	
	
	private double hardness;
	private double richness;
	private double cost;

	public void setRichness(double richness) {
		this.richness = richness;
	}

	public double getRichness() {
		return richness;
	}

	public void setHardness(double hardness) {
		this.hardness = hardness;
	}

	public double getHardness() {
		return hardness;
	}

	@Override
	public double discount() {
		if(richness>20) {
			return 0.6;
		}
		return 1;
	}
	

}
