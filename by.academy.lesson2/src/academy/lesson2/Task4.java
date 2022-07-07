package academy.lesson2;
import java.util.Scanner;
import java.util.Random;

public class Task4 {

	public static void main(String[] args) {
		int n=0;
		int cardsForOne = 5;
		
		String[] suits = {"Пик", "Бубен", "Черв", "Треф"};
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
				"Валет", "Королева", "Король", "Туз"};
		
		int cards = suits.length*ranks.length;
		
		
		
		Scanner scan = new Scanner(System.in);
		
		
		for(;;) {
			
			System.out.println("Введите количество игроков");
			n = scan.nextInt();
			
			if (n == 0) {
				System.out.println("Вы ввели число 0!");
				break;
			} else if (n<0) {
				System.out.println("Вы ввели отрицательное число!");
			} else if (cardsForOne*n > cards) {
				System.out.println("Вы ввели слишком большое число, карт на всех не хватит!");
			} else {
				break;
			}
		}
		
		
		scan.close();
		
		String[] deck = new String[cards];
		for (int i=0; i<ranks.length; i++) {
			for (int j=0; j<suits.length; j++) {
				deck[suits.length*i + j] = ranks[i] +" "+ suits[j];
			}
		}
		
		Random rand = new Random();
		
		
		for (int k=0; k<deck.length; k++) {
			int index = rand.nextInt(52);
			String card = deck[index];
			deck[index] = deck[k];
			deck[k] = card;
		}
		
		for (int y = 0; y<n*cardsForOne; y++) {
			System.out.print(deck[y] + " ");
			if ((y+1)%cardsForOne == 0)
				System.out.println();
		}		
	}
}
