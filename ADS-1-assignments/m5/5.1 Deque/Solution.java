import java.util.Scanner;
import java.util.*;
/**
 * Class for node.
 */
class Node {
    /**
     * { var_description }
     */
    int item;
    /**
     * { var_description }
     */
    Node next;
    /**
     * Constructs the object.
     */
    Node() {
    }
    /**
     * Constructs the object.
     *
     * @param      item  The item
     */
    Node(int item) {
        this.item = item;
    }
}
/**
 * Class for deque.
 */
class Deque {
    /**
     * { var_description }
     */
    Node start;
    /**
     * { var_description }
     */
    int size;
    /**
     * Constructs the object.
     */
    Deque() {
        start = null;
        size = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * Pushes a left.
     *
     * @param      item  The item
     */
    public void pushLeft(int item) {
        Node obj = new Node(item);
        obj.next = start;
        start = obj;
        size++;
        display();
    }
    /**
     * Pushes a right.
     *
     * @param      item  The item
     */
    public void pushRight(int item) {
        Node obj = new Node(item);
        size++;
        obj.next = null;
        if (start == null) {
            start = obj;
        } else {
            Node temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = obj;
        }
        display();
    }
    /**
     * { function_description }
     */
    public void popLeft() {
        if (size == 0) {
            System.out.println("Deck is empty");
        } else {
        start = start.next;
        size--;
        display();
        }
    }
    /**
     * { function_description }
     */
    public void popRight() {
        if (size == 0) {
            System.out.println("Deck is empty");
        } else {
            Node temp = start;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            size--;
        }
        display();
    }
    /**
     * { function_description }
     */
    public void display() {
        int[] arr = new int[size];
        if (size == 0) {
            System.out.println("[]");
            return;
        }
        Node temp = start;
        int i = 0;
        while (temp.next != null) {
            arr[i] = temp.item;
            temp = temp.next;
            i++;
        }
        arr[size - 1] = temp.item;
        System.out.println(Arrays.toString(arr));
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    Solution() {

    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque d = new Deque();
        int n = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(" ");
            switch(str[0]) {
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