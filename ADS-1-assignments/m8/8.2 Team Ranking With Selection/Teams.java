/**
 * time complexity of the Insertion sort is O(N^2).
 * because of nested for loops
 */
/**
 * Class for teams.
 */
class Teams {
    private CricTeam[] teams;
    private int size;
    Teams() {
        teams = new CricTeam[10];
        size = 0;
    }
    public void addCricketTeam(final CricTeam t) {
        teams[size++] = t;
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += teams[i].name+",";
        }
        return s.substring(0, s.length() - 1);
    }
    public void exch(final CricTeam[] teams1, final int i, final int j) {
        CricTeam ct = teams1[j];
        teams[j] = teams1[i];
        teams[i] = ct; 
    }
    /**
     * sorting the elements.
     * time complexity of insertion sort is O(N^2) in worst case.
     */
    public void InsertionSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (!less(teams, j - 1, j)) {
                    break;
                } else {
                    exch(teams, j - 1, j);
                }
                } 
            }
        }
    public boolean less(final CricTeam[] arr, final int i, final int j) {
        return  arr[i].compareTo(arr[j]) < 0;
    }
}