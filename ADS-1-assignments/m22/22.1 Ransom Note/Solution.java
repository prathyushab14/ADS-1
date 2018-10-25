import java.util.*;
class RansomNote {
	String[] mag;
	String[] notee;
	RansomNote() {

	}
	RansomNote(int m, int n) {
		mag = new String[m];
		notee = new String[n];
    }
    public boolean check() {
    	for (String s : notee) {
    		for (String st : mag) {
    			if (!s.equals(st)) {
    				return false;
    			}
    		}
    	}
    	return true;
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
			rn = new RansomNote(magdata.length, notedata.length);
		}
		System.out.println(rn.check());
    }
}