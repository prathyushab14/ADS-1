import java.util.Arrays;
class Sort {
	int[] aux;
	int[] a;
	public void sort(int[] a) {
		//System.out.println("....");
		aux = new int[a.length];
		sort(a, 0, a.length - 1);
	}
	public void sort(int[] a, int l, int h) {
		//System.out.println("hello");
		if (h <= l) {
			return;
		}
		int mid = l + (h - l) / 2;
		sort(a, l, mid);
		sort(a, mid + 1, h);
		merge(a, l, mid, h);
	}
	public void merge(int[] a, int l, int mid, int h) {
		//System.out.println("Pratuysha");
		int i = l;
		int j = mid + 1;
		System.out.println(j);
		for (int m = 0; m <= h; m++) {
			aux[m] = a[m];
		}
		for (int k = 0; k <= h; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > h) {
				a[k] = aux[i++];
			} else if(less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k]= aux[i++];
			}
		}
	}
	public boolean less(int i, int j) {
		return j > i;
	}
	public String toString() {
		System.out.println(Arrays.toString(a));
		return "";
	}
}