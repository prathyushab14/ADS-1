import java.util.Scanner;
import java.util.Arrays;

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
        Deque d = new Deque();
        int n = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(" ");
            switch (str[0]) {
                case "isEmpty":
                System.out.println(d.isEmpty());
                break;
                case "size":
                System.out.println(d.size());
                break;
                case "pushLeft":
                d.pushLeft(Integer.parseInt(str[1]));
                break;
                case "pushRight":
                d.pushRight(Integer.parseInt(str[1]));
                break;
                case "popLeft":
                d.popLeft();
                break;
                case "popRight":
                d.popRight();
                break;
                default:
                break;
            }
        }
    }
}