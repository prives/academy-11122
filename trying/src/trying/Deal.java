package trying;
import by.academy.deal.Product;
import by.academy.deal.User;
public class Deal {

	private String[] productname;
	private String LocalDateTime;
	private User buyer;
	private User seller;
	public void setProductName(String productname) {
		this.productname = productname.split(" ");

	}
//	void userBuyer(String a) {
//		buyer=a;
//		
//	}
	public String[] getProductName() {
		return productname;
	}
	public int deal(User seller,User buyer) {
		
				
		return 0;
		
		
	}
	public int fullPrice(Product price,Product product,Product quantity,Product isTax) {
		int fullPrice = 0;
		
		return fullPrice;
		
	}
	

}
