import java.util.Scanner;
import java.util.*;
class Node {
	int item;
	Node next;
	Node() {
    }
	Node(int item) {
		this.item = item;
	}
}
class Deque {
	Node start;
	Node tail;
	int size;
	Deque() {
	}
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
    }
	public int size() {
		return size;
    }
	public void pushLeft(int item) {
		Node obj = new Node(item);
        obj.next = start;
        start = obj;
        size++;
	}
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
    }
	public void popLeft() {
		if (size == 0) {
			System.out.println("Deck is Empty");
			return;
		}
		start = start.next;
		size--;
    }
	public void popRight() {
		if (size == 0) {
			System.out.println("Deck is Empty");
			return;
		}
		Node temp = start;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
    }
    public int[] display() {
    	int[] arr = new int[size];
    	Node temp = start;
    	while (temp.next != null) {
    		for (int i = 0; i < size; i++) {
        	    arr[i] = temp.item;
        	}
        }
        arr[size]= temp.item;
        return arr;
    }
}
class Solution {
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