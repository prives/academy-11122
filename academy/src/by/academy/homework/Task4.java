package by.academy.homework;

public class Task4 {
public static void main(String[] args) {
	int i=2;
	int b =1000_000;
	int a =2;
	int c = 1;
	while(  c < b) {
	c =  (int) Math.pow(a, i++);
	

	System.out.println(i);
	System.out.println(c);
	}
 
	
}
}
