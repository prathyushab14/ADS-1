class LinkedList {
    Node head;
    int size;
    LinkedList() {
        head = null;
        size = 0;
    }
    /**
     * inserts the element at given index position
     * time complexity is O(N) in worst case.
     *
     * @param      pos        The position
     * @param      ele        The ele
     *
     * @throws     Exception  { exception_description }
     */
    public void insertAt(int pos, int ele) throws Exception{
        Node newNode = new Node(ele);
        if (pos < 0 || pos > size) {
            throw new Exception();
        }
        head = insertAt(pos, head, newNode, 0);
    }
    public Node insertAt(int pos, Node first, Node obj, int count) {
        if (pos == count) {
            obj.next = first;
            size++;
            return obj;
        }
        first.next = insertAt(pos, first.next, obj, count + 1);
        return first;
    }
    /**
     * reverse method
     * time complexity is O(1)
     */
    public void reverse() {
        reverse(null, head);
    }
    /**
     * time complexity is O(N)
     *
     * @param      previous  The previous
     * @param      current   The current
     */
    void reverse(Node previous, Node current) {
        if (current != null) {
            reverse(current, current.next);
            current.next = previous;
        } else {
            head = previous;
        }
    }
    void display() {
        Node temp = head;
        String str = "";
        while (temp != null) {
            str += temp.data+", ";
            temp = temp.next;
        }
        System.out.println(str.substring(0,str.length()-2));
    }
}