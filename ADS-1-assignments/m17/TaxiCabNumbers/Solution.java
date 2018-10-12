import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * sum.
     */
    long sum;
    /**
     * integer i.
     */
    int i;
    /**
     * integer j.
     */
    int j;
    /**
     * cubeSum constructor.
     *
     * @param      i     integer
     * @param      j     integer
     */
    CubeSum(int i, int j) {
        this.sum = i * i * i + j * j * j;
        this.i = i;
        this.j = j;
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
            if (current.sum == previous.sum) {
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
            if (current.j < n) {
                pq.insert(new CubeSum(current.i, current.j + 1));
            }
        }
    }
}