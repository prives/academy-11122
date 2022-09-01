package dial;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
				 		
		User user1=new User ();
		User user2=new User ();
			
		Scanner sc= new Scanner(System.in);	
		
		System.out.println("Реализация задания №3:");
		System.out.println("Введите дату:");
		String data=sc.next();
		RegexDeal d = new RegexDeal(data);
		System.out.println(d.result);
		
		
		System.out.println("Реализация задания №4:");
			if(d.regexA(data)==true) {
				DateTimeFormatter formatterDTa=DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US);
				LocalDate lda=LocalDate.parse(data, formatterDTa);	
				System.out.println("День: "+lda.getDayOfMonth());
				System.out.println("Месяц: "+lda.getMonth());
				System.out.println("Year: "+lda.getYear());
			}
			if(d.regexB(data)==true) {
				DateTimeFormatter formatterDTb=DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.US);
				LocalDate ldb=LocalDate.parse(data, formatterDTb);	
				System.out.println("День: "+ldb.getDayOfMonth());
				System.out.println("Месяц: "+ldb.getMonth());
				System.out.println("Year: "+ldb.getYear());
				}
			else {
				System.out.println("Введенная дата не соответствует не одному из патернов dd-MM-yyyy(dd/MM/yyyy).");
			}
	
		System.out.println("Введите ваше имя (покупатель):");
		String name=sc.next();
		user1.setNickname(name);
		
		System.out.println("Введите количество денежных средств в наличии:");
		double money=sc.nextDouble();
		user1.setMoney(money);
		user2.setNickname("Seller1");
		
		
		System.out.println("Реализация заданий №5 и №9 phone/email:");
		boolean isValidPhone = false;		
		do {
			System.out.println("Введите номер мобильного телефона:");  
			String phone=sc.next();			
			isValidPhone = user1.setValidPhone(phone);
		} while (isValidPhone==false); 
		
//		System.out.println("Реализация задания №5 AmericanPhoneValidator:");
//		System.out.println("Введите номер мобильного телефона:");
//		String phone=sc.next();
//		user1.setValidAmericanPhone(phone);			
		
		boolean isValidEmail = false;		
		do {
			System.out.println("Введите email:");  
			String email=sc.next();			
			isValidEmail = user1.setValidEmail(email);
		} while (isValidEmail==false); 
			
							
		System.out.println("Реализация задания №8:");
		System.out.println("Введите дату вашего рождения согласно шаблону dd/MM/yyyy(dd-MM-yyyy):");
		String dateOfBirth=sc.next();
		user1.setDateOfBirth(dateOfBirth);
			
		System.out.println("Основная реализация:");	
					
		Wine wine1=new Wine("Вино Riesling", 25, 4, 2, "белое");
		Wine wine2=new Wine("Вино Vina Maipo", 35, 1, 2, "белое");
		Wine wine3=new Wine("Вино Torres San Valentin Garnacha", 32, 3, 3, "красное");
		Cheese cheese1=new Cheese ("Сыр Mascarpone", 5.6, 5, "Republic of Belarus", 0.78);
		Cheese cheese2=new Cheese ("Сыр Сливочный", 3.29, 1, "Republic of Belarus", 0.65);
		Cheese cheese3=new Cheese ("Сыр Классический", 3.12, 5, "Republic of Belarus", 0.60);
		Fruit fruit1= new Fruit ("Фрукт Банан", 4.50, 5, "неспелые", 2.5);
		Fruit fruit2= new Fruit ("Фрукт Яблоко", 3.25, 6, "спелые", 1.5);
		Fruit fruit3= new Fruit ("Фрукт Апельсин", 5.34, 4, "спелые", 1.8);
		Fruit fruit4= new Fruit ("Фрукт Персик", 8.79, 2, "неспелые", 0.6);
		
		Product[] productList = new Product[10];	
		
		productList[0]=wine1;
		productList[1]=wine2;
		productList[2]=wine3;
		productList[3]=cheese1;
		productList[4]=cheese2;
		productList[5]=cheese3;
		productList[6]=fruit1;
		productList[7]=fruit2;
		productList[8]=fruit3;
		productList[9]=fruit4;
		

		Deal deal = new Deal();
//		Deal deal = new Deal(user2, user1, products);		
		
		deal.setBuyer(user1);
		deal.setSeller(user2);
		
		int n=-1;	
		boolean skip=false;		
		String answer="0";
		
		do {
			System.out.println("0: Если хотите выйти из меню и завершить выбор товаров");
			System.out.println("+: Если хотите добавить товар в корзину");
			System.out.println("-: Если хотите удалить товар из корзины");			
			answer=sc.next();
			switch(answer) {
				case "+": {
					System.out.println("Меню товаров:");
					for (int i=0; i<productList.length; i++)	{
						System.out.println(i+1+": "+productList[i].getName()+"-"+productList[i].getPrice()+" BYN");
						}	
					System.out.println("0: Если хотите выйти в основное меню");					
					do {
						skip=false;
						System.out.println("Введите номер товара из меню:");			
						if(sc.hasNextInt()) {
							n=sc.nextInt();
							
							if(n==0) {
//								System.out.println("Корзина с товарами сформирована");	
								break;
							}
							if(n<1 || n>productList.length) {
								System.out.println("Введен неверный номер товара. Повторите ввод номера товара из меню.");
								skip=true;
								continue;
							}
							
							for (int i=0;i<deal.getProducts().length;i++) {
								if (deal.getProduct(i)==productList[n-1] && deal.getProducts().length>0) {
									skip=true;
									System.out.println("Данный товар уже добавлен в корзину");
									break;
								}
							}
							
							if (skip==true) {
								continue;
							}
							  
							System.out.println("Введите необходимое количество данного товара:");
							if (sc.hasNextDouble()) {
								double q=sc.nextDouble();
								deal.addProduct(productList[n-1]);
								productList[n-1].setQuantity(q);
								break;
							}
							else {
								System.out.println("Количество товара может быть целым или дробным");
							}
						}
						else {
							System.out.println("Номер товара может быть только целым числом");
						}	 
					}	while (n>=1 && n<=productList.length || skip==true);   					
					break;
				}
				case "-":{
					System.out.println("Меню товаров:");
					do {
						skip=false;
						System.out.println("Введите номер товара из меню:");			
						if(sc.hasNextInt()) {
							n=sc.nextInt();
							
							if(n==0) {
//								System.out.println("Корзина с товарами сформирована");	
								break;
							}
							if(n<1 || n>productList.length) {
								System.out.println("Введен неверный номер товара. Повторите ввод номера товара из меню.");
								skip=true;
								continue;
							}
							
							for (int i=0;i<deal.getProducts().length;i++) {
								if (deal.getProduct(i)==productList[n-1] && deal.getProducts().length>0) {
									deal.removeProduct(productList[n-1]);
									productList[n-1].setQuantity(0);
									skip=false;									
									break;
								}
							}							
						}
						else {
							System.out.println("Номер товара может быть только целым числом");
						}	 
					}	while (skip==true);   		
					break;
				}
				case "0":{
					System.out.println("Корзина с товарами сформирована");
					break;
				}
				default: {
					System.out.println("Введена некорректная команда. Повторите ввод");
					answer="continue";
				}
			}
		} while (answer.equals("+") || answer.equals("-") || answer.equals("continue"));		

		System.out.println(Arrays.toString(deal.getProducts()));
		
					
		deal.deal();
		deal.check();
		deal.savewritecheck();
		
		
		
		
		
		
		
		sc.close();	
	}	 	
}