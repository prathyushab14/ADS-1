import java.util.Scanner;
class CubeSum implements Comparable<CubeSum> {
     private long sum;
     private int i;
     private int j;

    long getSum() {
        return this.sum;
    }

    int geti() {
        return this.i;
    }

    int getj() {
        return this.j;
    }

    public CubeSum(int i, int j) {
        this.sum = i*i*i + j*j*j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(CubeSum that) {
        if (this.sum < that.getSum()) return -1;
        if (this.sum > that.getSum()) return +1;
        return 0;
    }

    public String toString() {
        return sum + "";
    }

}
class Solution {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int n = 600;

        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 1; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }

        int pair = 1;
        int nth =0;

        CubeSum previous = new CubeSum(0,0); 

        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum current = pq.delMin();
            if(current.getSum() == previous.getSum()){
                pair++;
                if(pair == M){
                    nth++;
                }
                if (N == nth) {
                    System.out.println(current);
                    break;
                }
            }else {
                pair = 1;
            }

            previous = current;
            if (current.getj() < n)
                pq.insert(new CubeSum(current.geti(), current.getj() + 1));
        }
    }
    
} 