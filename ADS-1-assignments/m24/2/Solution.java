import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * rollnum.
     */
    private String rollno;
    /**
     * name.
     */
    private String name;
    /**
     * total marks.
     */
    private double total;
    /**
     * Constructs the object.
     */
    Student() {
    }
    /**
     * Constructs the object.
     *
     * @param      rollno1  The rollno
     * @param      name1    The name
     * @param      total1  The total
     */
    Student(final String rollno1, final String name1, final double total1) {
        rollno = rollno1;
        name = name1;
        total = total1;
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
     * Gets the rollno.
     *
     * @return   The rollno.
     */
    public String gerRoll() {
        return rollno;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public Double getmar() {
        return total;
    }
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryST <String, Student> bs = new BinaryST();
		Student s = new Student();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
        	 String str = sc.nextLine();
             String[] tokens = str.split(",");
             s = new Student(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
             bs.put((tokens[1]), s);
            }
		int m = Integer.parseInt(sc.nextLine());
	    for (int i = 0; i < m; i++) {
            String que = sc.nextLine();
            String[] query = que.split(" ");
            switch (query[0]) {
            	case "BE":
            	Double m1 = Double.parseDouble(query[1]);
            	Double m2 = Double.parseDouble(query[2]);
            	for (String stu : bs.keys()) {
            		if (bs.get(stu).getmar() >= m1 && bs.get(stu).getmar() <= m2) {
            			System.out.println(stu);
            		}

            	}

            	//bs.keys((query[0]), Double.parseDouble(query[2]));
            	break;
            	// case "LE":
            	// break;
            	// case "GE":
            	// break;
            }

		}

	}
}