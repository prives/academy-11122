package academy.lesson2;

import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		
       
		Scanner sc1 = new Scanner(System.in);
		
		
        System.out.println("Enter first word: ");
        String wordOne = sc1.nextLine();
        
        
        Scanner sc2 = new Scanner(System.in);
        
        System.out.println("Enter first word: ");
        String wordTwo = sc2.nextLine();
        
        
        boolean b;
        
        
        if (wordOne.length() != wordTwo.length()) {
            System.out.println(b = false);
        } else {
            char[] result1 = wordOne.toCharArray();
            char[] result2 = wordTwo.toCharArray();
            
            
            int wordOneResult = 0;
            
            for (int i = 0; i < result1.length; i++) {
                wordOneResult = wordOneResult + result1[i];
            }      
            
            
            
                     int wordTwoResult = 0;
                     
            for (int j = 0; j < result2.length; j++) {
                wordTwoResult = wordTwoResult + result2[j]++;
            }
            
            
            if (wordOneResult - wordTwoResult == 0) {
                System.out.println("true");
            } else {
              
            	           System.out.println("false");
            }
        }
    }
}