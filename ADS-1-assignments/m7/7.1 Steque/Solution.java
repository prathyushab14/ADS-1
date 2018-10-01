import java.util.Scanner;
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
 * Class for steque.
 */
class Steque {
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
	 * push elemnts.
	 *
	 * @param      data  The data
	 */
	public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = start;
        start = newNode;
        size++;
        display();
    }
    /**
     * pop the element.
     */
    public void pop() {
    	if (size == 0) {
            System.out.println("Steque is empty.");
            return;
        } else {
            start = start.next;
            size--;
        }
        display();
    }
    /**
     * insert element.
     *
     * @param      data  The data
     */
    public void enqueue(int data) {
    	Node newNode = new Node(data);
    	if (size == 0) {
    		start = newNode;
    		size++;
    		display();
    	} else {
    	    Node temp = start;
    	    while (temp.next != null) {
    		    temp = temp.next;
    	    }
    	    temp.next = newNode;
    	    size++;
    	    display();
        }
    }
    /**
     * display.
     */
	public void display() {
		if (size == 0) {
			System.out.println("Steque is empty.");
		} else {
            Node temp = start;
            while (temp.next != null) {
        	System.out.print(temp.data+", ");
            temp = temp.next;
        }
        System.out.println(temp.data);
        }
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