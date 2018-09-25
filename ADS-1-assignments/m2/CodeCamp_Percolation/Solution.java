import java.util.Scanner;
/**
 * Class for percolation.
 */
 class Percolation {
/**
 * grid matrix.
 */
    private boolean[][] grid;
    /**
     * top variable.
     */
    private int top = 0;
    /**
     * bottom variable.
     */
    private int bottom;
    /**
     * size variable.
     */
    private int n;
    /**
     * variable for weighted quick union.
     */
    private WeightedQuickUnionUF quf;

    /**
     * constructor for percolation class.
     * @param n integer variable.
     */
     Percolation(final int m) {
        n = m;
        bottom = n * n + 1;
        quf = new WeightedQuickUnionUF(n * n + 2);
        grid = new boolean[n][n];
    }

    /**
     * @param i integer variable.
     * @param j integer variable.
     * open method for percolation class.
     */
    public void open(final int i, final int j) {
        grid[i - 1][j - 1] = true;
        if (i == 1) {
            quf.union(component(i, j), top);
        }
        if (i == n) {
            quf.union(component(i, j), bottom);
        }

        if (j > 1 && isOpen(i, j - 1)) {
            quf.union(component(i, j), component(i, j - 1));
        }
        if (j < n && isOpen(i, j + 1)) {
            quf.union(component(i, j), component(i, j + 1));
        }
        if (i > 1 && isOpen(i - 1, j)) {
            quf.union(component(i, j), component(i - 1, j));
        }
        if (i < n && isOpen(i + 1, j)) {
            quf.union(component(i, j), component(i + 1, j));
        }
    }

    /**
     * checks if the given block is open or not.
     * @param i integer variable.
     * @param j integer variable.
     * @return returns true if the given block is open.
     */
    public boolean isOpen(final int i, final int j) {
        return grid[i - 1][j - 1];
    }

    /**
     * checks if block is full or not.
     * @param i integer variable.
     * @param j integer variable.
     * @return returns true if the given block is full.
     */
    public boolean isFull(final int i, final int j) {
        if (0 < i && i <= n && 0 < j && j <= n) {
            return quf.connected(top, component(i, j));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * checks for percolation.
     * @return returns true if percolation is possible.
     */
    public boolean percolates() {
        return quf.connected(top, bottom);
    }
    /**
     * method to find the component at given indices.
     *
     * @param      i  integer variable.
     * @param      j  integer variable.
     *
     * @return returns the component value.
     */
    private int component(final int i, final int j) {
        return n * (i - 1) + j;
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * constructor for solution class.
     */
    protected Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Percolation p = new Percolation(n);
        while (sc.hasNext()) {
            p.open(sc.nextInt(), sc.nextInt());
        }
        System.out.println(p.percolates());
    }
}
