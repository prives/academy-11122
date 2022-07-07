package academy.lesson2;
import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Enter first word: ");
		
		String word1 = sc.nextLine();
		System.out.println("Enter second word: ");
		String word2 = sc.nextLine();
		String word3 = ((word1.substring(0, word1.length() / 2))
				+ (word2.substring(word2.length() / 2, word2.length())));
		
		
		System.out.println("First word: " + word1);
		System.out.println("Second word: " + word2);
		System.out.println("Final word: " + word3);
		
		
		
		
		sc.close();

	}

}
