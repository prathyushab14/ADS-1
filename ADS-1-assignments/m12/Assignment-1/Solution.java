import java.util.*;
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
	public int getSize() {
		return size;
	}
	public String toString() {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += students[i].name+","+students[i].total+","+students[i].category+"\n";
		}
		System.out.println();
		return str;

    }
	public void exch(Student[] students, int i, int j) {
		Student stu = students[j];
		students[j] = students[i];
		students[i] = stu;
	}
	public void sort(int noOfvacancies,int noOfunres,int noOfBC,int noOfSC,int noOfST) {
		for (int i = 0; i < noOfvacancies; i++) {
			String str = "";
		    while (noOfunres != 0) {
			    for (int k = 0; i < size; i++) {
				    str += students[i].name+","+students[i].total+","+students[i].category+"\n";
				    noOfunres--;
			    }
			}
			while (noOfBC != 0) {
			    for (int k = 0; i < size; i++) {
				    str += students[i].name+","+students[i].total+","+students[i].category+"\n";
				    noOfBC--;
			    }
			}
			while (noOfSC != 0) {
				for (int k = 0; i < size; i++) {
				    str += students[i].name+","+students[i].total+","+students[i].category+"\n";
				    noOfSC--;
			    }
			}
			while (noOfST != 0) {
				for (int k = 0; i < size; i++) {
				    str += students[i].name+","+students[i].total+","+students[i].category+"\n";
				    noOfST--;
			    }
			}
		}

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
class Solution {
	Solution() {
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Merit m = new Merit();
        // while (sc.hasNext()) {
        	int noOfapplied = Integer.parseInt(sc.nextLine());
        	int noOfvacancies = Integer.parseInt(sc.nextLine());
        	int noOfunres = Integer.parseInt(sc.nextLine());
        	int noOfBC = Integer.parseInt(sc.nextLine());
        	int noOfSC = Integer.parseInt(sc.nextLine());
        	int noOfST = Integer.parseInt(sc.nextLine());
        	for (int i = 0; i < noOfapplied; i++) {
        	    String data = sc.nextLine();
        	    String[] tokens = data.split(",");
        	    m.addStudent(new Student(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]));
        	}
        // }
        m.InsertionSort();
        System.out.println(m);
        m.sort(noOfvacancies,noOfunres,noOfBC,noOfSC,noOfST);
        System.out.println(m);
    }
	
}