// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.Scanner;
import java.util.Arrays;
class Percolation {
	int[][] arr;
	WeightedQuickUnionUF wqu;
	// int[][] sz;
	int count;
	int n;
	Percolation(int n) {
       arr = new int[n][n];
       // sz = new int[n][n];
       count = 0;
       n = n;
       wqu = new WeightedQuickUnionUF((n*n)+2);
    }
    public String toString() {
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = 0; j < arr.length; j++) {
    			System.out.print(arr[i][j]);
    		}
    		System.out.println();
    	}
    	return "";
    }
	public void open(int row, int col) {
		int count = 0;
		row = row - 1;
		col = col - 1;
		arr[row][col] = 1;
			count++;
		if (row == 0) {
			wqu.union(0, component(row, col));
        }
        if (row == n - 1) {
        	wqu.union(((n*n)+1), component(row, col));

        }
        if (row > 0) {
        	if (arr[row + 1][col] == 1) {
        		wqu.union(component(row, col), component(row+1, col));
        	}
        }
        if (row <= n-1) {
        	if (arr[row - 1][col] == 1) {
        		wqu.union(component(row, col), component(row-1, col));
        	}
        }
        if (col > 0) {
        	if (arr[row][col+1] == 1) {
        		wqu.union(component(row, col), component(row, col+1));
        	}
        }
        if (col <= n-1) {
        	if (arr[row][col-1] == 1) {
        		wqu.union(component(row, col), component(row, col-1));
        	}
        }

    }
    public int component(int i, int j) {
    	return ((i*n)+j)+1;
    }
	public boolean isOpen(int row, int col) {
		return arr[row - 1][col - 1] == 1;

	}
	public boolean isFull(int row, int col) {
		return arr[row-1][col-1] == 0;
    }
	public int numberofOpenSites() {
		return count;
    }
	public boolean percolates() {
		return wqu.connected(0,(n*n)+1);

	}
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inp = sc.nextInt();
		Percolation p = new Percolation(inp);
		while (sc.hasNext()) {
			p.open(sc.nextInt(), sc.nextInt());
		}
		System.out.println(p.percolates());
		}
	
}