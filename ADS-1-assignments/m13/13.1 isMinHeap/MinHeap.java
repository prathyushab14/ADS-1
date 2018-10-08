/**
 * Class for minimum heap.
 *
 * @param      <Key>  The key
 */
public class MinHeap<Key extends Comparable<Key>> {
    /**
     * Array of key type.
     */
    Key[] pq;
    /**
     * no of elements.
     */
    int n = 0;
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
    public MinHeap(final int maxN) {
        /**
         * Initializing array.
         */
        pq =(Key[]) new Comparable[maxN+1];
    }
    /**
     * Constructs the object.
     *
     * @param      array  The array
     */
    public MinHeap(final Comparable[] array) {
        /**
         * Initializing array.
         */
        this.pq = (Key[]) array;
        /**
         * initialzation of n.
         */
        this.n = array.length;
    }
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
            if (!less(k, (k - 1)/2)) {
                return false;
            }
            k--;
        }
        return true;
    }
}