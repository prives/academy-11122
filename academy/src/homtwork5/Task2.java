package homtwork5;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Task2 {

	  public static void main(String[] args) {
	        ArrayList<Integer> list1 = new ArrayList<>();

	        for (int j = 1; j <= 100000; j++) {
	            list1.add(j);
	        }

	        Instant start1 = Instant.now();
	        Random random_method = new Random();
	        for (int i = 1; i <= 100000; i++) {
	            int index = random_method.nextInt(100000);
	            list1.get(index);
	        }
	        Instant end1 = Instant.now();
	        System.out.println(Duration.between(start1, end1));

	        LinkedList<Integer> list2 = new LinkedList<>();
	        for (int j = 1; j <= 100000; j++) {
	            list2.add(j);
	        }
	        Instant start2 = Instant.now();
	        Random random_method2 = new Random();
	        for (int i = 1; i <= 100000; i++) {
	            int index2 = random_method2.nextInt(100000);
	            list2.get(index2);
	        }
	        Instant end2 = Instant.now();
	        System.out.println(Duration.between(start2, end2));

	    }
	}
