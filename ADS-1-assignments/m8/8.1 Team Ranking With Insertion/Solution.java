import java.util.Scanner;
class Solution {
	Solution() {
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Team team = new Team();
		while (sc.hasNext()) {
			String data = sc.nextLine();
			String[] str = data.split(",");
			CricketTeam cric = new CricketTeam(str[0], str[1], str[2], str[3]);
			team.addCricketTeam(cric);
        }
        team.selectionSort();
        System.out.println(team);
	}
}