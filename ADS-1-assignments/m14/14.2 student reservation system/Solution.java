import java.util.*;
/**
 * Student class.
 */
class Student implements Comparable<Student> {
    /**
     * name of the student.
     */
    String name;
    /**
     * date of birth.
     */
    String dob;
    /**
     * subject1.
     */
    int s1;
    /**
     * subject2.
     */
    int s2;
    /**
     * subject3.
     */
    int s3;
    /**
     * total marks.
     */
    int total;
    /**
     * reservation category.
     */
    String category;
    /**
     * Constructs the object.
     *
     * @param      name      The name
     * @param      dob       The dob
     * @param      s1        The s 1
     * @param      s2        The s 2
     * @param      s3        The s 3
     * @param      total     The total
     * @param      category  The category
     */
    Student(final String name, final String dob, final String s1, final String s2,
     final String s3, final String total, final String category) {
        this.name = name;
        this.dob = dob;
        String[] date = dob.split("-");
        int year = Integer.parseInt(date[2]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[0]);
        this.s1 = Integer.parseInt(s1);
        this.s2 = Integer.parseInt(s2);
        this.s3 = Integer.parseInt(s3);
        this.total = Integer.parseInt(total);
        this.category = category;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public int getTotal() {
        return total;
    }
    /**
     * Gets the category.
     *
     * @return     The category.
     */
    public String getCategory() {
        return category;
    }
    /**
     * Gets the year.
     *
     * @return     The year.
     */
    public int getYear() {
        String[] date = dob.split("-");
        int year = Integer.parseInt(date[2]);
        return year;
    }
    /**
     * Gets the month.
     *
     * @return     The month.
     */
    public int getMonth() {
        String[] date = dob.split("-");
        int month = Integer.parseInt(date[1]);
        return month;
    }
    /**
     * Gets the day.
     *
     * @return     The day.
     */
    public int getDay() {
        String[] date = dob.split("-");
        int day = Integer.parseInt(date[0]);
        return day;
    }
    /**
     * Method to compare two objects.
     *
     * @param      s    student object
     *
     * @return     integer value
     */
    public int compareTo(final Student s) {
        if (this.total > s.total) {
            return 1;
        }
        if (this.total < s.total) {
            return -1;
        }
        if (this.s3 > s.s3) {
            return 1;
        }
        if (this.s3 < s.s3) {
            return -1;
        }
        if (this.s2 > s.s2) {
            return 1;
        }
        if (this.s2 < s.s2) {
            return -1;
        }
        if (this.getYear() > s.getYear()) {
            return 1;
        }
        if (this.getYear() < s.getYear()) {
            return -1;
        }
        if (this.getMonth() > s.getMonth()) {
            return 1;
        }
        if (this.getMonth() < s.getMonth()) {
            return -1;
        }
        if (this.getDay() > s.getDay()) {
            return 1;
        }
        if (this.getDay() < s.getDay()) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name + "," + this.total + "," + this.category;
    }
}
/**
 * Merit class.
 */
class Merit {
    /**
     * students array.
     */
    Student[] students;
    /**
     * students1 array.
     */
    Student[] students1;
    /**
     * size variable.
     */
    int size;
    /**
     * Constructs the object.
     */
    Merit() {
        students = new Student[50];
        students1 = new Student[50];
        size = 0;
    }
    /**
     * Adds a student.
     *
     * @param      st    student object
     */
    public void addStudent(final Student st) {
        students[size++] = st;
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += students[i].name+","+students[i].total+","+students[i].category+"\n";
        }
        return str;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString1() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += students[i].name+","+students[i].total+","+students[i].category+"\n";
        }
        return str;
    }
    /**
     * Method to swap.
     *
     * @param      students  The students
     * @param      i         The index
     * @param      j         The index
     */
    public void exch(final Student[] students, final int i, final int j) {
        Student stu = students[j];
        students[j] = students[i];
        students[i] = stu;
    }
    /**
     * check if it is in the array.
     *
     * @param      obj   The object
     *
     * @return     true or false
     */
    public boolean contains(final Student obj) {
        for (Student stu : students1) {
            try {
                if(stu.equals(obj)) {
                    return true;
                }   
            } catch (Exception e) {

            }
            
        }
        return false;
    }
    /**
     * copy into array based on reservation and vacancies.
     *
     * @param      noOfvacancies  No ofvacancies
     * @param      noOfunres      No ofunres
     * @param      noOfBC         No of bc
     * @param      noOfSC         No of sc
     * @param      noOfST         No of st
     */
    public void sort(final int noOfvacancies,final int noOfunres,final int noOfBC,final int noOfSC,final int noOfST) {
        int z = 0;
        for (int i = 0; i < noOfunres; i++) {
            students1[z++] = students[i];
        }
        int bc = 0;
        if (noOfBC != 0) {
            for (int i = noOfunres; i < students.length; i++ ) {
                try {
                    if (students[i].category.equals("BC")) {
                        students1[z++] = students[i];
                        bc++;
                        if(bc == noOfBC){
                            break;
                        }
                    }   
                } catch(Exception e) {

                }
            }
        }
        int sc = 0;
        if (noOfSC != 0) {
            for (int i = noOfunres ; i < size; i++ ) {
                if (students[i].category.equals("SC")) {
                    students1[z++] = students[i];
                    sc++;
                    if(sc == noOfSC) {
                        break;
                    }
                }
            }
        }
        int st = 0;
        if (noOfST != 0) {
            for (int i = noOfunres ; i < size; i++ ) {
                if (students[i].category.equals("ST")) {
                    students1[z++] = students[i];
                    st++;
                    if (st == noOfST) {
                        break;
                    }
                }
            }
        }
        if (bc != noOfBC) {
            for (int i = noOfunres; i < students.length; i++ ) {
                if (!contains(students[i])) {
                    students1[z++] = students[i];
                    bc++;
                    if (bc == noOfBC) {
                        break;
                    }
                }
            }
        }
        if (sc != noOfSC) {
            for (int i = noOfunres; i < students.length; i++ ) {
                if (!contains(students[i])) {
                    students1[z++] = students[i];
                    sc++;
                    if (sc == noOfSC) {
                        break;
                    }
                }
            }
        }
        if (st != noOfST) {
            for (int i = noOfunres; i < students.length; i++) {
                if (!contains(students[i])) {
                    students1[z++] = students[i];
                    st++;
                    if (st == noOfST) {
                        break;
                    }
                }
            }
        }
        students1 = Arrays.copyOf(students1, z);
        Arrays.sort(students1, Collections.reverseOrder());
    }
    /**
     * Inssertion sort.
     */
    public void Insertionsort() {
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
    /**
     * compare two objects.
     *
     * @param      arr   The arr
     * @param      i     The index
     * @param      j     The index
     *
     * @return     true or false
     */
    public boolean less(final Student[] arr, final int i, final int j) {
        return  arr[i].compareTo(arr[j]) < 0;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Merit m = new Merit();
        final int zero = 0;
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
            int noOfapplied = Integer.parseInt(sc.nextLine());
            int noOfvacancies = Integer.parseInt(sc.nextLine());
            int noOfunres = Integer.parseInt(sc.nextLine());
            int noOfBC = Integer.parseInt(sc.nextLine());
            int noOfSC = Integer.parseInt(sc.nextLine());
            int noOfST = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < noOfapplied; i++) {
                String data = sc.nextLine();
                String[] tokens = data.split(",");
                m.addStudent(new Student(tokens[zero], tokens[one], tokens[two],
                    tokens[three], tokens[four], tokens[five], tokens[six]));
            }
        m.Insertionsort();
        System.out.println(m);
        m.sort(noOfvacancies, noOfunres, noOfBC, noOfSC, noOfST);
        for (int i = 0; i < noOfvacancies; i++) {
            System.out.println(m.students1[i]);
        }
    }
}