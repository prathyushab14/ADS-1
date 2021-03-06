import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * Class for minimum heap.
 *
 * @param      <Key>  The key
 */
class MinHeap<Key extends Comparable<Key>> {
    /**
     * Array of key type.
     */
    private Key[] pq;
    /**
     * no of elements.
     */
    private int n = 0;
    /**
     * Constructs the object.
     */
    MinHeap() {
    }
    /**
     * COnstructs the object.
     *
     * @param      maxN  The maximum n
     */
    MinHeap(final int maxN) {
        /**
         * Initializing array.
         */
        pq = (Key[]) new Comparable[maxN + 1];
    }
    /**
     * Constructs the object.
     *
     * @param      array  The array
     */
    MinHeap(final Comparable[] array) {
        /**
         * Initializing array.
         */
        this.pq = (Key[]) array;
        /**
         * initialzation of n.
         */
        this.n = array.length;
    }
    // /**
    //  * Initializes an empty priority queue with the given initial capacity,
    //  * using the given comparator.
    //  * @param  initCapacity the initial capacity of this priority queue
    //  * @param  comparatorr the order in which to compare the keys
    //  */
    // public MinHeap(final int initCapacity,
    // final Comparator<Key> comparatorr) {
    //     this.comparator = comparatorr;
    //     pq = (Key[]) new Object[initCapacity + 1];
    //     n = 0;
    // }
    /**
     * Time complexity of this method is O(1).
     */
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
     * time complexity of size method is O(1).
     */
    /**
     * Method to find array size.
     *
     * @return     size
     */
    public int size() {
        return n;
    }
    /**
     * time complexity of less method is O(1).
     */
    /**
     * insert an element into the array.
     *
     * @param      v     The element
     */
    public void insert(final Key v) {
        pq[++n] = v;
    }
    /**
     * time complexity of less method is O(1).
     */
    /**
     * to compare two elements.
     *
     * @param      i     index i
     * @param      j     index j
     *
     * @return     true or false
     */
    public boolean less(final int i, final int j) {
        return pq[i].compareTo(pq[j]) >= 0;
    }
    /**
     * Time complexity of check method is log(N).
     */
    /**
     * checks if parent element is less than child element.
     *
     * @return     true or false
     */
    public boolean check() {
        int k = n - 1;
        while (k > 0) {
            if (!less(k, (k - 1) / 2)) {
                return false;
            }
            k--;
        }
        return true;
    }
    /**
     * Returns a smallest key on this priority queue.
     * @return a smallest key on this priority queue.
     * time complexity is O(1)
     */
    public Key min() {
        if (isEmpty()) {
            return null;
        }
        return pq[1];
    }
    // /**
    //  * Removes and returns a smallest key on this priority queue.
    //  * @return a smallest key on this priority queue
    //  * time complexity is O(log(n))
    //  */
    // public Key delMin() {
    //     if (isEmpty()) {
    //         return null;
    //     }
    //     Key min = pq[1];
    //     exch(1, n--);
    //     sink(1);
    //     pq[n + 1] = null;
    //     final int four = 4;
    //     if ((n > 0) && (n == (pq.length - 1) / four)) {
    //         resize(pq.length / 2);
    //     }
    //     return min;
    // }
    // /**
    //  * swim method.
    //  * @param      k    index.
    //  * time complexity is O(log(n))
    //  */
    // private void swim(final int k) {
    //     int k1 = k;
    //     while (k1 > 1 && greater(k1 / 2, k1)) {
    //         exch(k1, k1 / 2);
    //         k1 = k1 / 2;
    //     }
    // }
    /**
     * exch method to swap the elements.
     * @param      i     index.
     * @param      j     index.
     * time complexity is O(1)
     */
    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    /**
     * resize method to resize the array.
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    // /**
    //  * greater method.
    //  * @param      i     index.
    //  * @param      j     index.
    //  * @return     true or false.
    //  * time complexity is O(1)
    //  */
    // private boolean greater(final int i, final int j) {
    //     if (comparator == null) {
    //         return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
    //     } else {
    //         return comparator.compare(pq[i], pq[j]) > 0;
    //     }
    // }
    // /**
    //  * sink method.
    //  * @param      k    index.
    //  * time complexity is O(log(n))
    //  */
    // private void sink(final int k) {
    //     int k1 = k;
    //     while (2 * k1 <= n) {
    //         int j = 2 * k1;
    //         if (j < n && greater(j, j + 1)) {
    //             j++;
    //         }
    //         if (!greater(k1, j)) {
    //             break;
    //         }
    //         exch(k1, j);
    //         k1 = j;
    //     }
    // }
}
/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * Method for string parameters.
     *
     * @param      sc    The scanner object
     */
    public static void executeStringArray(final Scanner sc) {
        MinHeap<String> s = new MinHeap<String>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            s = new MinHeap(tokens);
            System.out.println(s.check());
        }
    }
    /**
     * Method for integer parameters.
     *
     * @param      sc    The scanner object
     */
    public static void executeIntegerArray(final Scanner sc) {
        MinHeap<Integer> s = new MinHeap<Integer>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Integer[] inp = new Integer[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                inp[i] = Integer.parseInt(tokens[i]);
            }
            s = new MinHeap(inp);
            System.out.println(s.check());
            }
    }
    /**
     * Method for double parameters.
     *
     * @param      sc    The scanner object
     */
    public static void executeDoubleArray(final Scanner sc) {
        MinHeap<Double> s = new MinHeap<Double>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Double[] inp = new Double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                inp[i] = Double.parseDouble(tokens[i]);
            }
            s = new MinHeap(inp);
            System.out.println(s.check());
        }
    }
    /**
     * Method for float parameters.
     *
     * @param      sc    The scanner object
     */
    public static void executeFloatArray(final Scanner sc) {
        MinHeap<Float> s = new MinHeap<Float>();
        int noOflines = Integer.parseInt(sc.nextLine());
        int count = 0;
        while (sc.hasNext()) {
            count++;
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Float[] inp = new Float[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                inp[i] = Float.parseFloat(tokens[i]);
            }
            s = new MinHeap(inp);
            System.out.println(s.check());
        }
        if (count != noOflines) {
            System.out.println(false);
        }
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String objectType = sc.nextLine();
        switch (objectType) {
            case "String":
            executeStringArray(sc);
            break;
            case "Integer":
            executeIntegerArray(sc);
            break;
            case "Double":
            executeDoubleArray(sc);
            break;
            case "Float":
            executeFloatArray(sc);
            break;
            default:
            break;
        }
    }
}
