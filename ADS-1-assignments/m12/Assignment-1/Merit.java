class Merit {
	Student[] students;
	int size;
	Merit() {
		students = new Student[50];
		size = 0;
	}
	public void addStudent(Student st) {
		students[size++] = st;
	}
	public String toString() {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += students[i].name+","+students[i].total+","+students[i].category+"\n";
		}
		return str;
	}
	public void exch(Student[] students, int i, int j) {
		Student stu = students[j];
		students[j] = students[i];
		students[i] = stu;
	}
	public void InsertionSort() {
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (!less(students, j - 1, j)) {
					break;
				} else {
					exch(students, j - 1, j);
				}
				} 
			}
        }
	public boolean less(Student[] arr, int i, int j) {
		return  arr[i].compareTo(arr[j]) < 0;
	}
}