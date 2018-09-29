import java.util.Scanner;
class Node {
	String item;
	Node link;
	Node() {

	}
	Node(String i) { 
		this.item = i;
    }
    public String getData() {
    	return item;
    }
}
class LinkedList {
	Node start = null;
	int size;
	LinkedList() {
		size = 0;
	}
	public void insert(String i) {
		// Node newNode = new Node(i);
  //   	if (size == 0) {
  //   	   first = newNode;
  //   		size++;
  //   		return;
  //   	}
  //   	newNode.link = first;
  //   	first = newNode;
  //   	size++;
		Node prev = start;
        start = new Node();
        start.item = i;
        start.link = prev;
        size++;
    }
    // public String remove() {
    // 	String temp = first.data;
    // 	first = first.link;
    // 	size--;
    // 	return temp;
    // }
    public String getdata() {
    	return start.item;
    }
}
class Stack {
	String[] data;
	int size;
	Stack() {
		data = new String[10];
		size = 0;
	}
	public void push(String item) {
		data[size++] = item;
	}
	public String pop() {
		String s = data[--size];
		data[size] = null;
		return s;
	}
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
class AddLargeNumbers {
	LinkedList list = new LinkedList();
	Stack s = new Stack();
	
    public static LinkedList numberToDigits(String number) {
    	LinkedList list = new LinkedList();
    	    list.insert(number);
        	return list;
    }
    public static String digitsToNumber(LinkedList list) {
    	String s = "";
    	for (int i = 0; i < list.size; i++) {
    		s += list.getdata();
    	}
    	return s;
    }
    // public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    // 	LinkedList res = new LinkedList();
    //     Stack s1 = new Stack();
    //     Stack s2 = new Stack();
    //     while (list1.first != null) {
    //     	s1.push(list1.getdata());
    //     	System.out.println(list1.getdata());
    //     }
    //     while (list2.first != null) {
    //     	s2.push(list2.getdata());
    //     }
    //     s1.pop();
    //     System.out.println(s1.pop());
    //     s2.pop();
    //     System.out.println(s2.pop());
    //     res.insert(s1.pop() + s2.pop());
    //     return res;
    // }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            // case "addLargeNumbers":
            //     pDigits = AddLargeNumbers.numberToDigits(p);
            //     qDigits = AddLargeNumbers.numberToDigits(q);
            //     LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //     System.out.println(AddLargeNumbers.digitsToNumber(result));
            //     break;
        }
    }
    
}
