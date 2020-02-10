public class Tester
{
	public static void main(String[] args)
	{
		int[] a = new int[] { 5, 4, 1, 9, 2, 6 };
		Arrays.swapLargestAndSmallest(a);
		System.out.println(java.util.Arrays.toString(a));
		System.out.println("Expected: [5, 4, 9, 1, 2, 6]");
		a = new int[] {1, 4, 1, 9, 2, 6};
		Arrays.swapLargestAndSmallest(a);
		System.out.println(java.util.Arrays.toString(a));
		System.out.println("Expected: [9, 4, 1, 1, 2, 6]");
		a = new int[] {1, 4, 2, 9, 9, 6};
		Arrays.swapLargestAndSmallest(a);
		System.out.println(java.util.Arrays.toString(a));
		System.out.println("Expected: [9, 4, 2, 1, 9, 6]");
		a = new int[] {1};
		Arrays.swapLargestAndSmallest(a);
		System.out.println(java.util.Arrays.toString(a));
		System.out.println("Expected: [1]");
	}
}