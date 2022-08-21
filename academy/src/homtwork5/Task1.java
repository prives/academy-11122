package homtwork5;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Task1 {

	 public static void main(String[] args) {
	        List<String> list1 = List.of("a", "b", "c", "d", "b", "c");

	        Set<String> noDoubles = new HashSet<>(list1);

	        for (String s: noDoubles) {
	            System.out.println(s);
	        }
	    }
	}
