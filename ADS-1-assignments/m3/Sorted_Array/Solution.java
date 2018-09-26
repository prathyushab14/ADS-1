import java.util.Scanner;
import java.util.Arrays;
class Solution {
	Solution() {

    }
    public static void sortArr(int[] array1, int[] array2) {
    	int[] arr3 = new int[array1.length + array2.length];
    	int s = array1.length + array2.length;
    	int f = 0;
    	int l = 0;
    	int i = 0;
    	while (f < array1.length && l < array2.length) {
    		if (array1[f] < array2[l]) {
    			arr3[i++] = array1[f];
    			f++;
            } else if (array1[f] > array2[l]) {
                arr3[i++] = array2[l];
                l++;
            }
            if (array1.length > array2.length) {
            		arr3[i++] = array1[f++];
            }
            if (array2.length > array1.length) {
            		arr3[i++] = array2[l++];
            }
        }
        System.out.println(Arrays.toString(arr3).replace(" ","").replace("[","").replace("]",""));
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int arr1size = sc.nextInt();
    	int arr2size = sc.nextInt();
    	int[] arr1 = new int[arr1size];
    	int[] arr2 = new int[arr2size];
    	sc.nextLine();
    	String[] array1 = sc.nextLine().split(",");
    	String[] array2 = sc.nextLine().split(",");
    	for (int i = 0; i < arr1size; i++) {
    		arr1[i] = Integer.parseInt(array1[i]);
    	}
    	for (int i = 0; i < arr2size; i++) {
    		arr2[i] = Integer.parseInt(array2[i]);
    	}
    	sortArr(arr1, arr2);

    }
}