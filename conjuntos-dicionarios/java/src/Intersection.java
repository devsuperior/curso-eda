import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {

	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		for (int n : nums1) {
			set1.add(n);
		}
		
		Set<Integer> set2 = new HashSet<>();
		for (int n : nums2) {
			set2.add(n);
		}
		
		set1.retainAll(set2);
		
		int[] result = new int[set1.size()];
		int i = 0;
		for (int n : set1) {
			result[i] = n;
			i++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] result1 = intersection(new int[]{1,2,2,1}, new int[] {2,2});
		int[] result2 = intersection(new int[]{4,9,5}, new int[] {9,4,9,8,4});		
		System.out.println(Arrays.toString(result1));
		System.out.println(Arrays.toString(result2));
	}
}
