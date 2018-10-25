import java.util.*;
class RansomNote {
	String[] mag;
	String[] notee;
	RansomNote() {

	}
	RansomNote(String[] m, String[] n) {
		mag = m;
		notee = n;
    }
    public String check() {
    	for (String s : mag) {
    		for (String st : notee) {
    			if (!s.equals(st)) {
    				System.out.println(s);
    				System.out.println(st);
    				return "No";
    			}
    		}
    	}
    	return "Yes";
    }
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RansomNote rn = new RansomNote();
		String num = sc.nextLine();
		String[] no = num.split(" ");
        int m = Integer.parseInt(no[0]);
		int n = Integer.parseInt(no[1]);
		while (sc.hasNextLine()) {
			String magazine = sc.nextLine();
			String[] magdata = magazine.split(" ");
			String note = sc.nextLine();
			String[] notedata = note.split(" ");
			rn = new RansomNote(magdata, notedata);
		}
		System.out.println(rn.check());
    }
}