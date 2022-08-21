package homtwork5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
public class Task4 implements Iterator {

	@Override
    public boolean hasNext () {
        return false;
    }

    @Override
    public Object next () {
        return null;
    }
    public static void main(String[] args) {


        ArrayList<Double> marks = new ArrayList<>();

        for (int i=0; i <= 100; i++) {
            marks.add(Math.random() * 10);
        }
        Iterator<Double> it = marks.iterator();
        double k=0;
       while (it.hasNext()) {
            if (it.next() > k) {
                k = it.next();
            }
        }



    }
}
