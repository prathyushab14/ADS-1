import java.util.Scanner;
import java.util.*;
class StringRec {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(pairStar(str));
	}
	public static String pairStar(String s) {
	    if (s.length() == 1 || s.length() == 0) {
	    	return s;
	    }
	    if (s.charAt(0) == s.charAt(1)) {
	    	return s.charAt(0) + "*" + pairStar(s.substring(1, s.length()));
	    }
	    return s.charAt(0) + pairStar(s.substring(1, s.length()));
	}
}