import java.util.Scanner;
/**
 * Circular LinkedList.
 *
 * @param      <T>   generic.
 */
class CircularLinkedList<T> {
    /**
     * Constructs the object.
     */
    CircularLinkedList() {
    }
    /**
     * start.
     */
    private Node<T> start = null;
    /**
     * temp.
     */
    private Node<T> temp = null;
    /**
     * ref.
     */
    private Node<T> ref = null;

    /**
     * Class node.
     *
     * @param      <T>   generic.
     */
    class Node<T> {
        /**
         * data.
         */
        private T data;

        /**
         * next.
         */
        private Node<T> next;
    }

    /**
     * check whether stack is empty or not.
     * @return true or false.
     */
    public boolean isEmpty() {
        return start == null;
    }

    /**
     * add the item.
     * @param item element to push.
     */
    public void add(final T item) {
        if (start == null) {
            start = new Node<T>();
            start.data = item;
            temp = start;
            start.next = temp;
        } else {
            Node<T> obj = new Node<T>();
            temp.next = obj;
            obj.data = item;
            obj.next = start;
            temp = obj;
        }

    }
/**
 * Gives next.
 *
 * @return     The next.
 */
    public T getNext() {
        if (ref == null) {
            ref = start;
        }
        Node<T> tmp = ref;
        ref = tmp.next;
        return tmp.data;
    }
/**
 * to remove element.
 *
 * @param      element  The element
 *
 * @return     { description_of_the_return_value }
 */
    public T remove(final T element) {
        //for one element.
        if (start.next.equals(start) && start.data.equals(element)) {
            T tmp = start.data;
            start = null;
            return tmp;
        }

        //delete 1st element.
        if (start.data.equals(element)) {
            start = start.next;
            temp.next = start;
            return element;
        }

        /**
         * to remove last element.
         */
        if (temp.data.equals(element)) {
            Node<T> tempp = start;
            while (!tempp.next.equals(temp)) {
                tempp = tempp.next;
            }
            tempp.next = start;
            temp = tempp;
            return element;
        }

        Node<T> currenttmp = start;
        while (!currenttmp.next.data.equals(element)) {
            currenttmp = currenttmp.next;
        }
        Node<T> tmp2 = currenttmp.next.next;
        currenttmp.next = tmp2;

        return element;

    }
}

/**
 * Solution class.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {
    }

    /**
     * main function.
     *
     * @param      args  arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        for (int j = 0; j < input; j++) {
            int persons = scan.nextInt();
            int mthShift = scan.nextInt();
            CircularLinkedList<Integer> cl = new CircularLinkedList<Integer>();

            for (int i = 0; i < persons; i++) {
                cl.add(i);
            }

            String str = "";
            while (!cl.isEmpty()) {
                int t2 = 0;
                for (int i = 0; i < mthShift; i++) {
                    t2 = cl.getNext();
                }
                str += cl.remove(t2) + " ";
            }
            System.out.println(str.trim());
        }
    }

}