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
        private int data;
        /**
        * item.
        */
        private Node next;
        /**
        * Constructs the object.
        *
        * @param      dataa  The data
        */
        Node(final int dataa) {
            this.data = dataa;
        }
        /**
         * Gets the next.
         *
         * @return     The next.
         */
        public Node getNext() {
            return next;
        }
        /**
         * Gets the data.
         *
         * @return     The data.
         */
        public int getData() {
            return data;
        }
    }
    /**
     * start node.
     */
    private Node start;
    /**
     * size of steque.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Steque() {
        start = null;
        size = 0;
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * Gets the start.
     *
     * @return     The start.
     */
    public Node getStart() {
        return start;
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