package homework3;

import javax.security.sasl.SaslClient;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class Deal {

	
	 private static Scanner scanner = new Scanner(System.in);

	    private User seller;
	    private User buyer;
	    private Product[] products;
	    private LocalDate deadlineDate = LocalDate.now().plusDays(10);

	    public Deal(User seller, User buyer, Product[] products) {
	        this.seller = seller;
	        this.buyer = buyer;
	        this.products = products;
	    }

	    public User getSeller() {
	        return seller;
	    }

	    public void setSeller(User seller) {
	        this.seller = seller;
	    }

	    public User getBuyer() {
	        return buyer;
	    }

	    public void setBuyer(User buyer) {
	        this.buyer = buyer;
	    }

	    public Product[] getProducts() {
	        return products;
	    }

	    public void setProducts(Product[] products) {
	        this.products = products;
	    }

	    public LocalDate getDeadlineDate() {
	        return deadlineDate;
	    }

	    @Override
	    public String toString() {
	        return "Deal{" +
	                "seller=" + seller +
	                ", buyer=" + buyer +
	                ", products=" + Arrays.toString(products) +
	                ", deadlineDate=" + deadlineDate +
	                '}';
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Deal deal = (Deal) o;
	        return Objects.equals(seller, deal.seller) && Objects.equals(buyer, deal.buyer) && Arrays.equals(products, deal.products) && Objects.equals(deadlineDate, deal.deadlineDate);
	    }

	    public Product[] addProducts(Product[] products) {
	        System.out.print("Введите количество продуктов, которые вы хотите добавить в корзину: ");
	        int n = scanner.nextInt();
	        Product[] newProducts = new Product[products.length + n];
	        for (int j = 0; j < products.length + n; j++) {
	            if (j < products.length) {
	                newProducts[j] = products[j];
	            } else {
	                while (true) {
	                    System.out.print("Введите название продукта: ");
	                    String nameProduct = scanner.next();
	                    System.out.print("Введите количество этого продукта: ");
	                    int quantity = scanner.nextInt();
	                    if (nameProduct.equals("Meat")) {
	                        newProducts[j] = new Meat("Meat", 100, quantity);
	                        break;
	                    } else if (nameProduct.equals("Bread")) {
	                        newProducts[j] = new Bread("Bread", 80, quantity);
	                        break;
	                    } else if (nameProduct.equals("Milk")) {
	                        newProducts[j] = new Milk("Milk", 60, quantity);
	                        break;
	                    } else {
	                        System.out.println("Я не знаю такого продукта. Повторите попытку.");
	                    }
	                }
	            }
	        }
	        return newProducts;
	    }

	    public Product[] deleteProduct(Product[] products){
	        boolean check = true;
	        Product[] newProducts = new Product[0];
	        while (true) {
	            if (products.length == 0) {
	                System.out.println("Ваша корзина пуста");
	                break;
	            }
	            newProducts = new Product[products.length - 1];
	            System.out.print("Введите название продукта, который вы хотите удалить: ");
	            String nameProduct = scanner.next();
	            for (int i = 0; i < products.length; i++) {
	                if ((nameProduct.equals("Meat") || nameProduct.equals("Milk") || nameProduct.equals("Bread"))
	                        && products[i].getName().equals(nameProduct)) {
	                    products[i] = null;
	                    check = false;
	                    for (int j = 0; j < products.length - 1; j++) {
	                        if (products[j] == null) {
	                            Product element = products[j + 1];
	                            products[j + 1] = products[j];
	                            products[j] = element;
	                        }
	                    }
	                    System.arraycopy(products, 0 , newProducts, 0, products.length - 1);
	                    break;
	                 }
	            }
	            if (check) {
	                System.out.println("Такого продукта нет в корзине. Повыторите попытку.");
	            }
	            else{
	                break;
	            }
	        }
	        return newProducts;
	    }

	    public void countingProducts(Product[] products) {
	        int sum = 0;
	        if (products.length == 0){
	            System.out.println("Ваша корзина пуста");
	        }
	        else {
	            for (int j = 0; j < products.length; j++) {
	                System.out.println(products[j].getName() + " " + products[j].calePrice(products[j]));
	                sum += products[j].calePrice(products[j]);
	            }
	        }
	        System.out.println("Итоговая цена: " + sum);
	    }

	    public double fullPrice(Product[] products) {
	        int sum = 0;
	        for (int i = 0; i < products.length; i++) {
	            if (products[i] != null) {
	                sum += products[i].calePrice(products[i]);
	            }
	        }
	        return sum;
	    }

	    public void bill (Deal deal){
	        System.out.println(deal.seller.getName());
	        if (products.length == 0){
	            System.out.println("Ваша корзина пуста");
	        }
	        else if (seller.getMoney() < fullPrice(products)){
	            System.out.println("Вы не можете купить данные продукы");
	        }
	        else {
	            for (int i = 0; i < deal.products.length; i++) {
	                    System.out.println(deal.products[i].getName() + " " + deal.products[i].calePrice(products[i]));
	            }
	        }
	        System.out.println("Итоговая цена: " + fullPrice(products));
	        deal.seller.setMoney(deal.seller.getMoney() + fullPrice(products));
	        deal.buyer.setMoney(deal.buyer.getMoney() - fullPrice(products));
	    }
	
}
