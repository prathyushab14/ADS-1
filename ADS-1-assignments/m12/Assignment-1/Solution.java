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
		return str;
    }
	public void exch(Student[] students, int i, int j) {
		Student stu = students[j];
		students[j] = students[i];
		students[i] = stu;
	}
	public void sort(int noOfvacancies,int noOfunres,int noOfBC,int noOfSC,int noOfST) {
		for (int i = 0; i < noOfvacancies; i++) {
			for (int k = 0; k < size; k++) {
			    while (noOfunres != 0) {
				    students[i++] = students[k]; 
 				    noOfunres--;
			    }
			}
			for (int k = 0; k < size; k++) {
			    while (noOfBC != 0) { 
				    students[i++] = students[k];
				    noOfBC--;
			    }
			}
			for (int k = 0; k < size; k++) {
			    while (noOfSC != 0) {
				    students[i++] = students[k];
				    noOfSC--;
			    }
			}
			for (int k = 0; k < size; k++) {
				while (noOfST != 0) {
				    students[i++] = students[k];
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
        System.out.println();
        m.sort(noOfvacancies,noOfunres,noOfBC,noOfSC,noOfST);
        System.out.println(m);
    }
	
}