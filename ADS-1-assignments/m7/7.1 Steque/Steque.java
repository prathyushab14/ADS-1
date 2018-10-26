// /**
//  * Class for node.
//  */
// class Node {
//     /**
//      * data.
//      */
//     int data;
//     /**
//      * item.
//      */
//     Node next;
//     /**
//      * Constructs the object.
//      *
//      * @param      data  The data
//      */
//     Node(int data) {
//         this.data = data;
//     }
// }
/**
 * Class for steque.
 */
class Steque {
	/**
    * Class for node.
    */
    class Node {
        /**
        * data.
        */
        int data;
        /**
        * item.
        */
        Node next;
        /**
        * Constructs the object.
        *
        * @param      data  The data
        */
        Node(int data) {
            this.data = data;
        }
    }
    /**
     * start node.
     */
    Node start;
    /**
     * size of steque.
     */
    int size;
    /**
     * Constructs the object.
     */
    Steque() {
        start = null;
        size = 0;
    }
    /**
     * the operations in the function take constant time.
     * Time complexity is O(1)
     */
    /**
     * push elemnts.
     *
     * @param      data  The data
     */
    public void push(final int data) {
        Node newNode = new Node(data);
        newNode.next = start;
        start = newNode;
        size++;
        try {
           display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
    /**
     * the operations in this function take constant time.
     * Time complexity is O(1)
     */
    /**
     * pop the element.
     *
     *
     * @throws     Exception  { exception_description }
     */
    public void pop() throws Exception {
        if (size == 0) {
            throw new Exception("Steque is empty.");
        } else {
            start = start.next;
            size--;
        }
        try {
           display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * the while loop in the function takes time complexity of N.
     * Time complexity is O(N)
     */
    /**
     * insert element.
     *
     * @param      data  The data
     */
    public void enqueue(final int data) {
        Node newNode = new Node(data);
        if (size == 0) {
            start = newNode;
            size++;
            try {
               display();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            Node temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            size++;
            try {
               display();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /**
    //  * the while loop in the function takes time complexity of N.
    //  * Time complexity is O(N)
     * display.
     *
     * @throws     Exception  { exception_description }
     */
    public void display() throws Exception {
        if (size == 0) {
            throw new Exception("Steque is empty.");
        } else {
            Node temp = start;
            while (temp.next != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println(temp.data);
        }
    }
}