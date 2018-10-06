import java.util.*;
class Solution {
	Solution() {
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Merit m = new Merit();
        while (sc.hasNext()) {
        	int noOfapplied = sc.nextInt();
        	int noOfvacancies = sc.nextInt();
        	int noOfunres = sc.nextInt();
        	int noOfBC = sc.nextInt();
        	int noOfSC = sc.nextInt();
        	int noOfST = sc.nextInt();
        	String data = sc.nextLine();
        	String[] tokens = data.split(",");
        	Student s = new Student(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
        	m.addStudent(s);
        	int vacancies = noOfvacancies;
        }
        m.InsertionSort();
        System.out.println(m);
    }
}