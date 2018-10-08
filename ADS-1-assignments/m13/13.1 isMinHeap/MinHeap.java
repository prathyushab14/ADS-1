public class MinHeap<Key extends Comparable<Key>> {
	Key[] pq;
	int n = 0;
	MinHeap() {

	}
	public MinHeap(int maxN) {
		pq =(Key[]) new Comparable[maxN+1];
	}

	public MinHeap(Comparable[] array) {
		this.pq = (Key[]) array;
		this.n = array.length;
	}
	public boolean isEmpty() {
		return n == 0;
	}
	public int size() {
		return n;
	}
	public void insert(Key v) {
		pq[++n] = v;
	}
    public boolean less(int i, int j) {
    	return pq[i].compareTo(pq[j]) >= 0;
    }
    public boolean check() {
		int k = n - 1;
		while (k > 0) {
			if (!less(k, (k - 1)/2)) {
				return false;
			}
			k--;
		}
		return true;
	}
}