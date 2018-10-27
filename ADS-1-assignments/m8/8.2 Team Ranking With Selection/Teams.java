/**
 * time complexity of the Insertion sort is O(N^2).
 * because of nested for loops
 */
/**
 * Class for teams.
 */
class Teams {
    /**
     * teams array.
     */
    private CricTeam[] teams;
    /**
     * size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Teams() {
        final int ten = 10;
        teams = new CricTeam[ten];
        size = 0;
    }
    /**
     * Adds a cricket team.
     *
     * @param      t     { parameter_description }
     */
    public void addCricketTeam(final CricTeam t) {
        teams[size++] = t;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += teams[i].name + ",";
        }
        return s.substring(0, s.length() - 1);
    }
    /**
     * swaps two items.
     *
     * @param      teams1  The teams 1
     * @param      i      The integer
     * @param      j      The integer
     */
    public void exch(final CricTeam[] teams1, final int i, final int j) {
        CricTeam ct = teams1[j];
        teams[j] = teams1[i];
        teams[i] = ct;
    }
    /**
     * sorting the elements.
     * time complexity of insertion sort is O(N^2) in worst case.
     */
    public void insertionsort() {
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
    /**
     * compares two items.
     *
     * @param      arr   The arr
     * @param      i     The integer
     * @param      j     The integer
     *
     * @return     true or false
     */
    public boolean less(final CricTeam[] arr, final int i, final int j) {
        return  arr[i].compareTo(arr[j]) < 0;
    }
}
