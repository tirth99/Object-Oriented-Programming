public class Arrays {

	static void swapLargestAndSmallest(int[] array) {
		int smallestIndex = 0;
		int largestIndex = 0;

		for(int i = 0; i < array.length; i++) {
			if(array[i] < array[smallestIndex]) {
				smallestIndex = i;
			}
			if(array[i] > array[largestIndex]) {
				largestIndex = i;
			}
		}
		int tmp = array[largestIndex];
		array[largestIndex] = array[smallestIndex];
		array[smallestIndex] = tmp;
	}
}
