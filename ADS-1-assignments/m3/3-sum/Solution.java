import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
    /**
     * { var_description.
     */
    private int[] arr;
    /**
     * { var_description}.
     */
    private int n;
    /**
     * Constructs the object.
     */
    Solution() {
        arr = new int[n];
    }
    /**
     * { function_description.
     *
     * @return size { description_of_the_return_value }
     */
    public int size() {
        return n;
    }
    /**
     * { function_description.
     *
     * @return  array   { description_of_the_return_value }
     */
    public int[] array() {
        return arr;
    }
    /**
     * three sum.
     *
     * @param      array  The array
     */
    public static void threeSum(final int[] array) {
        Arrays.sort(array);
        // System.out.println(Arrays.toString(array));
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                if (array[i] + array[j] + array[k] == 0) {
                    count++;
                }
            }
        }
    }
        System.out.println(count);
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        int[] arr = new int[inp];
        for (int i = 0; i < inp; i++) {
            arr[i] = sc.nextInt();
        }
        threeSum(arr);
    }
}