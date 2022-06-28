package by.academy.homework;

import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		int age;
		double price;

		Scanner in = new Scanner(System.in);

		System.out.print("Введите сумму покупки в магазине: ");
		price = in.nextDouble();

		System.out.print("Введите возраст покупателя: ");
		age = in.nextInt();

		if (price < 100) {
			System.out.println(price * 0.95);
		} else if (price >= 100 && price < 200) {
			System.out.println(price * 0.93);
		} else if (price >= 200 && price < 300) {
			if (age > 18) {
				System.out.println(price * 0.84);
			} else {
				System.out.println(price * 0.91);
			}
		} else if (price >= 300 && price < 400) {
			System.out.println(price * 0.85);
		} else {
			System.out.println(price * 0.8);
		}
		in.close();
	}
}
