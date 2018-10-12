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
     * Gets the sum.
     *
     * @return     The sum.
     */
    long getSum() {
        return this.sum;
    }

    /**
     * integer i.
     */
    private int i;

    /**
     * getter method for i.
     *
     * @return     i.
     */
    int geti() {
        return this.i;
    }

    /**
     * integer j.
     */
    private int j;

    /**
     * getter for j.
     *
     * @return     j.
     */
    int getj() {
        return this.j;
    }


    /**
     * cubeSum constructor.
     *
     * @param      k     integer
     * @param      l     integer
     */
    CubeSum(final int k, final int l) {
        this.sum = k * k * k + l * l * l;
        this.i = k;
        this.j = l;
    }
    /**
     * compare two objects.
     *
     * @param      that  The that
     *
     * @return     integer values
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
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
        int n = sc.nextInt();
        int m = sc.nextInt();
        final int thousand = 1000;
        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 1; i <= thousand; i++) {
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
                if (pair == m) {
                    nth++;
                }
                if (n == nth) {
                    System.out.println(current);
                    break;
                }
            } else {
                pair = 1;
            }
            previous = current;
            if (current.getj() < n) {
                pq.insert(new CubeSum(current.geti(), current.getj() + 1));
            }
        }
    }
}