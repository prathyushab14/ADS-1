import java.util.*;
class Merit {
	Student[] students;
	Student[] students1;

	int size;
	Merit() {
		students = new Student[50];
		students1 = new Student[50];

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
    	public String toString1() {
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
		for(int i = 0; i<noOfunres; i++){
			students1[i] = students[i];
		}
		for (int i = noOfunres; i<students.length; i++ ) {
			if (students1[i].category.equals("BC")) {
				        students1[i] = students[i];
				         }

		}
		for (int i = noOfunres+noOfBC ; i<size; i++ ) {
			if (students1[i].category.equals("SC")) {
				        students1[i] = students[i];
				         }
			
		}
		//System.out.println("9999999");
		// for (int k = 0; k < size;) {
		// 	for (int i = 0; i < noOfvacancies; i++) {
		// 	    while (noOfunres != 0) {
		// 		    students[i++] = students[k++]; 
 	// 			    noOfunres--;
		// 	    }
		// 	    while (noOfBC != 0) {
		// 	        if (students[k].category.equals("BC")) {
		// 		        students[i++] = students[k++];
		// 		        noOfBC--;
		// 		    }
		// 	    }
		// 	    while (noOfSC != 0) {
		// 	    	 if (students[k].category.equals("SC")) {
		// 		    students[i++] = students[k];
		// 		    noOfSC--;
		// 		}
		// 	    }
		// 		while (noOfST != 0) {
		// 			if (students[k].category.equals("ST")) {
		// 		    students[i++] = students[k++];
		// 		    noOfST--;
		// 		}
		// 	    }
		// 	}
		// 	if (noOfvacancies == 0) {
		// 		break;
		// 	}
		// }

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
        m.InsertionSort();
        System.out.println(m);
        // m.sort(noOfvacancies,noOfunres,noOfBC,noOfSC,noOfST);
        // System.out.println(m);
        for (int i = 0;i<noOfvacancies ;i++ ) {
        	System.out.println(m.students1[i]);
        	
        }
    }
	
}