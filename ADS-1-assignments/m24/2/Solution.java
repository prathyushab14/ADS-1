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
        BinaryST<Double, String> bs = new BinaryST();
        Student s = new Student();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
             String str = sc.nextLine();
             String[] tokens = str.split(",");
             s = new Student(tokens[0], tokens[1],
                Double.parseDouble(tokens[2]));
             bs.put(Double.parseDouble(tokens[2]), tokens[1]);
            }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String que = sc.nextLine();
            String[] query = que.split(" ");
            switch (query[0]) {
                case "BE":
                Double m1 = Double.parseDouble(query[1]);
                Double m2 = Double.parseDouble(query[2]);
                for (Double stu : bs.keys()) {
                    if (stu >= m1
                        && stu <= m2) {
                        System.out.println(bs.get(stu));
                    }

                }
                break;
                case "LE":
                Double mar1 = Double.parseDouble(query[1]);
                for (Double stu : bs.keys()) {
                    if (stu <= mar1) {
                        System.out.println(bs.get(stu));
                    }
                }
                break;
                case "GE":
                Double mar2 = Double.parseDouble(query[1]);
                for (Double stu : bs.keys()) {
                    if (stu >= mar2) {
                        System.out.println(bs.get(stu));
                    }
                }
                break;
                default:
                break;
            }

        }

    }
}
