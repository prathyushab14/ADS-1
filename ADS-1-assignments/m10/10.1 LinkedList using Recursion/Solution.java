import java.util.*;
class Node {
	int data;
	Node next;
	Node(int data) {
		this.data = data;
	}
}
class LinkedList {
	Node head;
	int size;
	LinkedList() {
		head = null;
		size = 0;
	}
	public void insertAt(int pos, int ele) {
		Node newNode = new Node(ele);
	try {
		if (pos >= 0 && pos < size - 1) {
			head = insertAt(pos, head, newNode, 0);
		} else throw new Exception("Can't insert at this position");{
        }
    }
    catch (Exception e) {
	    System.out.println(e.getMessage());
    }
}
    public Node insertAt(int pos, Node first, Node obj, int count) {
    	if (pos == count) {
    		obj.next = first;
    		return obj;
        }
    	first.next = insertAt(pos, first.next, obj, count + 1);
    	return first;
    }
	public void reverse() {
		reverse(null, head);
	}
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
class Solution {
	Solution() {
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	LinkedList l = new LinkedList();
    	String data = sc.nextLine();
    	String[] tokens = data.split(" ");
    	switch (tokens[0]) {
    		case "insertAt":
    		l.insertAt(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
    		l.display();
    		break;
    		case "reverse":
    		l.reverse();
    		l.display();
    		break;
    		default:
    		break;
        }
    }
}