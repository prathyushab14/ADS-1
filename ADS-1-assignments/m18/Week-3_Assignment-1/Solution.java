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
class Query {
	Stock[] stocks;
	String[] keys;
	Float[] values;
	int size;
	Query() {
		stocks = new Stock[200];
		size = 0;
    }
    public void add(Stock st) {
    	stocks[size++] = st;
    }
    public float get(String key) {
    	int i = rank(key);
        if (i < size && stocks[i].getName().compareTo(key) == 0) {
            return stocks[i].getValue();
     	}
     	return 0;
    }
    // public Stock intersection() {
    // 	for (Stock s : minpq) {
    // 		for (Stock st : maxPQ) {
    // 			if (s.equals(st)) {
    // 				return s;
    // 			}
    // 		}
    // 	}
    // 	return null;
    // }
    public int rank(final String key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(stocks[mid].name);
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
    public void insert(final String k, final float v) {
        if (k == null) {
            throw new IllegalArgumentException("Null key");
        }
        int i = rank(k);
        if (i < size && keys[i].compareTo(k) == 0) {
            stocks[i].change = v;
            return;
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = k;
        values[i] = v;
        size++;
    }
}
class Solution {
	Solution() {
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	Query q = new Query();
    	MinPQ<Stock> min = new MinPQ<Stock>();
    	MaxPQ<Stock> max = new MaxPQ<Stock>();
    	int n = Integer.parseInt(sc.nextLine());
    	while (sc.hasNext()) {
    	    for (int i = 0; i < n; i++) {
    		    String data = sc.nextLine();
    		    String[] tokens = data.split(",");
    		    Stock s = new Stock(tokens[0], tokens[1]);
    		    //System.out.println(Arrays.toString(tokens));
    		    q.add(s);
    		}
        }


        int noque = Integer.parseInt(sc.nextLine());
    }
}