import java.util.Scanner;
class Node {
	String data;
	Node link;
	Node() {

	}
	Node(String i) { 
		this.data = i;
    }
    public String getData() {
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
	public void insert(String i) {
		Node newNode = new Node(i);
    	if (size == 0) {
    	   first = newNode;
    		size++;
    		return;
    	}
    	newNode.link = first;
    	size++;
    }
    public String remove() {
    	String temp = first.data;
    	first = first.link;
    	size--;
    	return temp;
    }
    public String getdata() {
    	return first.data;
    }
}
class AddLargeNumbers {
	LinkedList list = new LinkedList();
	Node n = new Node();
	
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

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    	LinkedList res = new LinkedList();
    	for (int i = list1.size-1; i > 0; i--) {
    		for (int j = list2.size - 1; j > 0; j--) {
    			res.insert(list1.getdata() + Integer.parseInt(list2.getdata()));
    		}
        }
        return res;
    }
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

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
