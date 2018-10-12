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
     * @param      i     integer i
     * @param      j     integer j
     */
    public CubeSum(int i, int j) {
        this.sum = i * i * i + j * j * j;
        this.i = i;
        this.j = j;
    }
    /**
     * compares two objects.
     *
     * @param      that  The that
     *
     * @return     integer -1,0,1
     */
    public int compareTo(CubeSum that) {
        if (this.sum < that.getSum()) return -1;
        if (this.sum > that.getSum()) return +1;
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
     * main function.
     *
     * @param      args  The arguments
     */
     public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int m = sc.nextInt();
        int n = 600;
        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 1; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }
        int pair = 1;
        int nth = 0;
        CubeSum previous = new CubeSum(0,0); 
        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum current = pq.delMin();
            if(current.getSum() == previous.getSum()){
                pair++;
                if(pair == m){
                    nth++;
                }
                if (no == nth) {
                    System.out.println(current);
                    break;
                }
            }else {
                pair = 1;
            }
            previous = current;
            if (current.getj() < n) {
                pq.insert(new CubeSum(current.geti(), current.getj() + 1));
            }
        }
    }
} 