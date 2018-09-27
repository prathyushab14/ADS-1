import java.util.Scanner;
import java.util.*;
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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack();
		while (sc.hasNext()) {
			String str = sc.nextLine();
			if (str.equals("-")) {
				System.out.println(s.pop());
			}
			else {
				s.push(str);
			}
		}
		
	}
}
