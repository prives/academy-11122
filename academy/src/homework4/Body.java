package homework4;

public class Body {

	Heart heart;
	Lungs lungs;

	public Body() {
		this.heart=new Heart();
		this.lungs=new Lungs();
		
	}

	class Heart {
		public void live() {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				if (i % 10_000 == 0) {
					System.out.println("Knock-knock-knockin' on heaven's door");
				}
			}
		}
	}

	class Lungs {
		public void live() {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				if (i % 5000 == 0) {
					System.out.println("breathe in");
				}
				if (i % 10_000 == 0) {
					System.out.println("breathe out");
				}
			}

		}
	}

	public void live() {
		heart.live();
		lungs.live();
		System.out.println("\"You stand on the shore and feel the salty smell of the wind that blows from the sea. \r\n"
				+ "And I believe that you are free, and life has only begun.\".\r\n" + "");
	}
	public static void main(String[] args) {
		Body body=new Body();
		body.live();
	}
}