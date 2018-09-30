import java.util.Arrays;
/**
 * Class for node.
 */
class Node {
    /**
     * item variable.
     */
    int item;
    /**
     * node next.
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
     * start node.
     */
    Node start;
    /**
     * size.
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
        return size == 0;
    }
    /**
     * returns size.
     *
     * @return    size
     */
    public int size() {
        return size;
    }
    /**
     * Pushes a left.
     *
     * @param      item  The item
     */
    public void pushLeft(final int item) {
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
    public void pushRight(final int item) {
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
     * pop left most element.
     */
    public void popLeft() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
        } else {
        start = start.next;
        size--;
        display();
        }
    }
    /**
     * pops right most element.
     */
    public void popRight() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
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
     * display.
     */
    public void display() {
        int[] arr = new int[size];
        if (size == 0) {
            System.out.println("[]");
        } else {
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
}