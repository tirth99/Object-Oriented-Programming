import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sequence<E> {
	private E[] array;

	public Sequence(E[] array) {
		this.array = array;
	}

	public Iterator<E> getIterator() {
		return new Iterator<E>() {

			private int currentElement = 0;
			@Override
			public boolean hasNext() {
					return currentElement < array.length;
			}

			@Override
			public E next() {
				if(hasNext()) {
					return array[currentElement++];
				}
				else {
					throw new NoSuchElementException();
				}
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
