package homtwork5;

public class Task6 {

	 public static void main(String[] args) {
	        double array[] = new double [8];
	        try {
	            for (int i = 0; i < 10; i++) {
	                array[i] = Math.random();
	            }
	        }
	        catch (ArrayIndexOutOfBoundsException exc) {
	            System.out.println("Array is to small, expand the array");
	        }
	    }
	}
