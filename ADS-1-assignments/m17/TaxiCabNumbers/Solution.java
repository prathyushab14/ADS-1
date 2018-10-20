import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * sum.
     */
    private long sum;
    /**
     * integer i.
     */
    private int i;
    /**
     * integer j.
     */
    private int j;
    /**
     * Gets the sum.
     *
     * @return     The sum.
     */
    long getSum() {
        return this.sum;
    }
    /**
     * gets i.
     *
     * @return  integer
     */
    int geti() {
        return this.i;
    }
    /**
     * gets j.
     *
     * @return  integer
     */
    int getj() {
        return this.j;
    }
    /**
     * Constructs the object.
     *
     * @param      a     integer i
     * @param      b     integer j
     */
    CubeSum(final int a, final int b) {
        this.sum = a * a * a + b * b * b;
        this.i = a;
        this.j = b;
    }
    /**
     * compares two objects.
     *
     * @param      that  The that
     *
     * @return     integer -1,0,1
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.getSum()) {
            return -1;
        }
        if (this.sum > that.getSum()) {
            return +1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + "";
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
     public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int m = sc.nextInt();
        final int sixhund = 12;
        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 1; i <= sixhund; i++) {
            pq.insert(new CubeSum(i, i));
        }
        int pair = 1;
        int nth = 0;
        CubeSum previous = new CubeSum(0, 0);
        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum current = pq.delMin();
            if (current.getSum() == previous.getSum()) {
                pair++;
                System.out.println(previous);
                if (pair == m) {
                    nth++;
                }
                if (no == nth) {
                    System.out.println(current);
                    break;
                }
            } else {
                pair = 1;
            }
            previous = current;
            if (current.getj() < sixhund) {
                pq.insert(new CubeSum(current.geti(), current.getj() + 1));
            }
        }
    }
}
