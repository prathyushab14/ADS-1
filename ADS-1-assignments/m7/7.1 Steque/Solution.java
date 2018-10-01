import java.util.Scanner;
import java.util.Arrays;
class Node {
	int data;
	Node next;
	Node(int data) {
		this.data = data;
	}
}
class Steque {
	Node start;
	int size;
	Steque() {
		start = null;
		size = 0;
	}
	public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = start;
        start = newNode;
        size++;
        display();
    }
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
class Solution {
	Solution() {
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Steque s = new Steque();
		int noofTest = Integer.parseInt(sc.nextLine());
		while (sc.hasNext()) {
			String data = sc.nextLine();
			if (data.equals("") || data.equals(null)) {
				s = new Steque();
				System.out.println();
				continue;
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