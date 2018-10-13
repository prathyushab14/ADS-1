import java.util.*;
class Stock implements Comparable<Stock>{
	Stock() {
    }
    String name;
    float change;
    Stock(String name1, String change1) {
    	name = name1;
    	change = Float.parseFloat(change1);
    }
    public String getName() {
    	return name;
    }
    public float getValue() {
    	return change;
    }
    public int compareTo(Stock that) {
    	if (this.change > that.change) {
    		return 1;
    	}
    	if (this.change < that.change) {
    		return -1;
    	}
    	return this.name.compareTo(that.name);
    }
}
class BinarySearchST {
    BinarySearchST() {
    }
}
class Query {
	Stock[] stocks;
	int size;
	Query() {
		stocks = new Stock[200];
		size = 0;
    }
    public float get(Stock key) {
    		int i = rank(key);
            if (i < size && stocks[i].getName().compareTo(key.name) == 0) {
                return stocks[i].getValue();
     	    }
     	    return 0;
        }
    public int rank(final Stock key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(stocks[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
class Solution {
	Solution() {
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	MinPQ<Stock> min = new MinPQ<Stock>();
    	MaxPQ<Stock> max = new MaxPQ<Stock>();
    	int n = Integer.parseInt(sc.nextLine());
    	int j = 1;
    	for (int i = 0; i < j * n; i++) {
    		String data = sc.nextLine();
    		String[] tokens = data.split(",");
    		Stock s = new Stock(tokens[0], tokens[1]);
    		max.insert(s);
    		max.insert(s);
        }
        int noque = Integer.parseInt(sc.nextLine());
    }
}