import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * Method for string parameters.
     *
     * @param      sc    The scanner object
     */
    public static void executeStringArray(final Scanner sc) {
        MinHeap<String> s = new MinHeap<String>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            s = new MinHeap(tokens);
            System.out.println(s.check());
        }
    }
    /**
     * Method for integer parameters.
     *
     * @param      sc    The scanner object
     */
    public static void executeIntegerArray(final Scanner sc) {
        MinHeap<Integer> s = new MinHeap<Integer>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Integer[] inp = new Integer[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                inp[i] = Integer.parseInt(tokens[i]);
            }
            s = new MinHeap(inp);
            System.out.println(s.check());
            }
    }
    /**
     * Method for double parameters.
     *
     * @param      sc    The scanner object
     */
    public static void executeDoubleArray(final Scanner sc) {
        MinHeap<Double> s = new MinHeap<Double>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Double[] inp = new Double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                inp[i] = Double.parseDouble(tokens[i]);
            }
            s = new MinHeap(inp);
            System.out.println(s.check());
        }
    }
    /**
     * Method for float parameters.
     *
     * @param      sc    The scanner object
     */
    public static void executeFloatArray(final Scanner sc) {
        MinHeap<Float> s = new MinHeap<Float>();
        int noOflines = Integer.parseInt(sc.nextLine());
        int count = 0;
        while (sc.hasNext()) {
            count++;
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Float[] inp = new Float[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                inp[i] = Float.parseFloat(tokens[i]);
            }
            s = new MinHeap(inp);
            System.out.println(s.check());
        }
        if (count != noOflines) {
            System.out.println(false);
        }
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String objectType = sc.nextLine();
        switch (objectType) {
            case "String":
            executeStringArray(sc);
            break;
            case "Integer":
            executeIntegerArray(sc);
            break;
            case "Double":
            executeDoubleArray(sc);
            break;
            case "Float":
            executeFloatArray(sc);
            break;
            default:
            break;
        }
    }
}
