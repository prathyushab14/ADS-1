import java.util.Scanner;
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
        Steque s = new Steque();
        int noofTest = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String data = sc.nextLine();
            if (data.equals("") || data.equals(null)) {
                s = new Steque();
                System.out.println();
            } else {
                String[] str = data.split(" ");
                switch (str[0]) {
                    case "push":
                    s.push(Integer.parseInt(str[1]));
                    break;
                    case "pop":
                    s.pop();
                    break;
                    case "enqueue":
                    s.enqueue(Integer.parseInt(str[1]));
                    break;
                    default:
                    break;
                }
            }
        }
    }
}
