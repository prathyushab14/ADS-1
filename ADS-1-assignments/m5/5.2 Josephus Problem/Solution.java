import java.util.Scanner;
/**
 * Queue class.
 *
 */
class Queue {
    /**
     * head Node.
     */
    private Node head = null;
    /**
     * tail Node.
     */
    private Node tail = null;
    /**
     * current Node.
     */
    private Node current = null;
    /**
     * Node class.
     */
    class Node {
        /**
         * data variable.
         */
        private int data;
        /**
         * next node.
         */
        private Node next;
    }
    /**
     * checks whether queue is empty or Not.
     * @return true are flase.
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * enqueue method.
     * @param element which is to be entered in the queue.
     */
    public void enqueue(final int element) {
        if (head == null) {
            head = new Node();
            tail = new Node();
            head.data = element;
            tail = head;
            return;
        }
        current = new Node();
        current.data = element;
        tail.next = current;
        tail = current;
    }

    /**
     * dequeue method.
     * @return the element that is deleted.
     */
    public int dequeue() {
        Node temp = new Node();
        if (head == tail) {
            temp = head;
            head = null;
            tail = null;
            return temp.data;
         }
         temp = head;
         head = head.next;
         return temp.data;
    }
}

/**
 * Solution class.
 */
public final class Solution {
    /**
     * default Solution constructor.
     */
    private Solution() {
    }
    /**
     * main class.
     *
     * @param args arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (sc.hasNext()) {
            Queue n = new Queue();
            int c = sc.nextInt();
            int cut = sc.nextInt();
            for (int i = 0; i < c; i++) {
                n.enqueue(i);
            }
            String res = "";
            while (!n.isEmpty()) {
                int t2 = 0, t1 = 0;
                for (int i = 0; i < cut; i++) {
                    if (i != cut - 1) {
                        t1 = n.dequeue();
                        n.enqueue(t1);
                    } else {
                        t2 = n.dequeue();
                    }
                }
                res += t2 + " ";
            }
            System.out.println(res.trim());
        }
    }
}