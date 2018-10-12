import java.util.Scanner;
import java.util.*;
class Cube implements Comparable<Cube> {
	int i,j;
	long sum;
	public Cube(int i, int j) {
        this.sum = (long) i*i*i + (long) j*j*j;
        this.i = i;
        this.j = j;
    }
    public int compareTo(Cube that) {
        if (this.sum < that.sum) {
        	return -1;
        }
        else if (this.sum > that.sum) {
        	return +1;
        }
        else  {
            return  0;
        }
    }
    public String toString() {
        return i + "^3 + " + j + "^3";
    }
}
class Solution {
	Solution() {
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	MinPQ<Cube> pq = new MinPQ<Cube>();
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	for (int i = 1; i <= n; i++) {
            pq.insert(new Cube(i, i));
    	}
    	int pair = 1;
    	int nth = 0;
    	Cube previous = new Cube(0, 0);
    	while (!pq.isEmpty()) {
    		Cube current = pq.delMin();
    		if (current.sum == previous.sum) {
    			pair++;
    			if (pair == m) {
                   nth++;
    			}
    			if (nth == n) {
    				System.out.println(current);
    				break;
    			}
    		} else {
    			pair = 1;
    		}
    		previous = current;
    		System.out.println(current);
    		if (current.j < n) {
    			pq.insert(new Cube(current.i, current.j + 1));
    		}

    	}
    }
} 