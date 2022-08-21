package homework4;
import java.util.Arrays;

public class ArrayT<T> {
	private int index = 0;
	T[] array;

	public ArrayT() {
		this.array = (T[]) (new Object[16]);
	}

	public ArrayT(int size) {
		this.array = (T[]) (new Object[size]);
	}

	public void add(T obj) {
		if (index == array.length) {
			grow();
		}
		array[index++] = (T) array;
	}

	public void grow() {
		int newLength = (int) (array.length == 0 ? 1 : array.length * 1.5);
		T[] newT = (T[]) (new Object[newLength]);
		System.arraycopy(array, 0, newT, 0, array.length);
		array = newT;
	}

	public void getIndex(int index) {
		for (int i = 0; i < array.length; i++) {
			if (index == i) {
				System.out.println(Arrays.toString((T[]) array[i]));
			}
		}

	}

	public T getLast() {
		return array[array.length - 1];

	}

	public T getFirst() {
		return array[0];
	}

	public int getSize() {
		return array.length;
	}

	public void remove(int index) {
		index = index - 1;
		T[] newT = (T[]) (new Object[array.length - 1]);
		System.arraycopy(array, 0, newT, 0, index);
		System.arraycopy(array, index + 1, newT, index, array.length - index - 1);
		array = newT;
	}

	public void remove(T obj) {
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (obj == array[i]) {
				index = i;
			}
		}
		T[] newT = (T[]) (new Object[array.length - 1]);
		System.arraycopy(array, 0, newT, 0, index);
		System.arraycopy(array, index + 1, newT, index, array.length - index - 1);
		array = newT;

	}

	public int lastElement() {
		int last = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				last = i - 1;
			}
		}
		return last;
	}

}