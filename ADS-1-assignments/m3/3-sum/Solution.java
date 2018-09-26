import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
class Solution {
	int[] arr;
	int n;
	Solution() {
		arr = new int[n];
	}
	public static void threeSum(int[] array) {
		Arrays.sort(array);
		// System.out.println(Arrays.toString(array));
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				for (int k = j + 1; i < array.length; k++) {
			    if ((array[i] + array[j] + array[k]) == 0) {
			    	count++;
			    }
			}
		}
	}
		System.out.println(count);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inp = sc.nextInt();
		int[] arr = new int[inp];
		for (int i = 0; i < inp; i++) {
			arr[i] = sc.nextInt();
		}
		threeSum(arr);
	}
}