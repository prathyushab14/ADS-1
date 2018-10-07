import java.util.Scanner;
/**
 * Merge class.
 */
class Merge {
    /**
     * cutoff to insertion sort.
     */
    private final int v = 7;
    /**
     * Constructs the object.
     * Time complexity of this method is O(1).
     */
    Merge() {
    }
    /**
     * Method to merge two arrays.
     * Time complexity of this method is O(N).
     * @param      arr  The array
     * @param      aux    The auxiliary
     * @param      lo     The lower value
     * @param      mid    The middle value
     * @param      hi     The higher value
     */
    public void merge(final Comparable[] arr, final Comparable[] aux,
        final int lo, final int mid, final int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = arr[j++];
            } else if (j > hi) {
                aux[k] = arr[i++];
            } else if (less(arr[j], arr[i])) {
                aux[k] = arr[j++];
            } else {
                aux[k] = arr[i++];
            }
        }
    }
    /**
     * Arranges the array in ascending order.
     * Time complexity of this method is O(N).
     * @param      arr      array.
     */
    public void sort(final Comparable[] arr) {
        Comparable[] aux = arr.clone();
        sort(aux, arr, 0, arr.length - 1);
    }
    /**
     * Method for sorting.
     * Time complexity of sorting is O(log(N)).
     * @param      arr  The array
     * @param      aux    The auxiliary array
     * @param      lo     The lower value
     * @param      hi     The higher value
     */
    public void sort(final Comparable[] arr, final Comparable[] aux,
        final int lo, final int hi) {
        if (hi <= lo + v) {
            insertionSort(aux, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, arr, lo, mid);
        sort(aux, arr, mid + 1, hi);
        if (!less(arr[mid + 1], arr[mid])) {
            for (int i = lo; i <= hi; i++) {
                aux[i] = arr[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(arr, aux, lo, mid, hi);
    }
    /**
     * Method for insertion sort.
     * Time complexity of insertion sort is O(N^2/2).
     * @param      arr    array.
     * @param      lo    The lower value
     * @param      hi    The higher value
     */
    public void insertionSort(final Comparable[] arr,
        final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(arr[j], arr[j - 1]); j--) {
                exch(arr, j, j - 1);
            }
        }
    }
    /**
     * Method to check which one is smaller.
     * Time complextiy of this method is O(1).
     * @param      i     Element.
     * @param      j     Element.
     *
     * @return     Boolean value.
     */
    public boolean less(final Comparable i, final Comparable j) {
        return i.compareTo(j) < 0;
    }
    /**
     * {Method to exchange two elements in the array}.
     * Time complexity of this method is O(N).
     * @param      arr     Array
     * @param      i     Integer i
     * @param      j     Integer j
     */
    public void exch(final Comparable[] arr,
        final int i, final int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     * {Method to print the values of the Comparable array}.
     * Time complexity of this method is O(N).
     * @param      arr     {Name of object array}
     *
     * @return     {String}
     */
    public String display(final Comparable[] arr) {
        String str = "[";
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        str += arr[i] + "]";
        return str;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     * Time complexity of this method is O(1).
     */
    private Solution() {
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Merge m = new Merge();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            m.sort(tokens);
            System.out.println(m.display(tokens));
            System.out.println();
        }
    }
}
