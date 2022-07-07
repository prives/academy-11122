package academy.lesson2;

import java.util.Scanner;

public class Task2 {

	private static int diffWords(String st){
        StringBuffer u = new StringBuffer();
        char c; 
        for (int i=0;i<st.length();i++) { 
            c = st.charAt(i); 
            if (u.indexOf(String.valueOf(c))==-1) 
                u.append(c); 
        }
 
        return u.length();
    }
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
		
		String[] words = scan.nextLine().split(" ");

        String goal = words[0];
  
        for (int i=1;i<words.length;i++){
      
            if ( diffWords(words[i])<diffWords(goal)) 
                    goal = words[i];
        }

        System.out.println("Слово: "+goal+", число различных символов: "+diffWords(goal));
        
        scan.close();
    }
}
	
	
	

