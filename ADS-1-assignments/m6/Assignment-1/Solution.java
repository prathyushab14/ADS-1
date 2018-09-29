import java.util.Scanner;
class Node {
	int data;
	Node link;
	Node() {

	}
	Node(int i) { 
		this.data = i;
    }
    public int getData() {
    	return data;
    }
}
class LinkedList {
	Node first;
	int size;
	LinkedList() {
		first = null;
		size = 0;
	}
	public void insert(int i) {
		Node newNode = new Node(i);
    	if (size == 0) {
    	   first = newNode;
    		size++;
    		return;
    	}
    	newNode.link = first;
    	size++;
    }
    public int remove() {
    	int temp = first.data;
    	first = first.link;
    	size--;
    	return temp;
    }
    public int getdata() {
    	return first.data;
    }
}
class AddLargeNumbers {
	LinkedList list = new LinkedList();
	Node n = new Node();
	
    public static LinkedList numberToDigits(String number) {
    	LinkedList list = new LinkedList();
    	list.insert(Integer.parseInt(number));
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
