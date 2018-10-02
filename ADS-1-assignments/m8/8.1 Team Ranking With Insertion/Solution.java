import java.util.Scanner;
class CricketTeam implements Comparable<CricketTeam>{
	String name;
	int wins;
	int losses;
	int draws;
	CricketTeam(String name, String wins, String losses, String draws) {
		this.name = name;
		this.wins = Integer.parseInt(wins);
		this.losses = Integer.parseInt(losses);
		this.draws = Integer.parseInt(draws);
	}
	public String getName() {
		return name;
	}
	public int getWins() {
		return wins;
	}
	public int getLosses() {
		return losses;
	}
	public int getDraws() {
		return draws;
	}
	public int compareTo(CricketTeam c) {
		if (this.wins > c.wins) {
			return 1;
		}
		if (this.wins < c.wins) {
			return -1;
		}
		if (this.losses > c.losses) {
			return 1;
		}
		if (this.losses < c.losses) {
			return -1;
		}
		if (this.draws > c.draws) {
			return 1;
		}
		if (this.draws < c.draws) {
			return -1;
		}
		return 0;  
	}
	public String toString() {
		return this.name;
	}
}
class Team {
	private CricketTeam[] teams;
	private int size;
	Team() {
		teams = new CricketTeam[10];
		size = 0;
	}
	public void addCricketTeam(CricketTeam t) {
		teams[size++] = t;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += teams[i].name+",";
		}
		return s.substring(0, s.length() - 1);
	}
	public void exch(CricketTeam[] teams, int i, int j) {
		//System.out.println(";;;;;;");
		CricketTeam ct = teams[j];
		teams[j] = teams[i];
		teams[i] = ct; 
	}
	public void selectionSort() {
		//System.out.println("-------");
		for (int i = 0; i < size - 1; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				//System.out.println("[[[[[[");
				if (less(teams, j, min)) {
					min = j;
				} 
			}
			exch(teams, i, min);
			//System.out.println(teams[i]);
        }
	}
	boolean less(CricketTeam[] arr, int i, int j) {
		//System.out.println("0000000");
		return  arr[i].compareTo(arr[j]) > 0;
	}
}
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