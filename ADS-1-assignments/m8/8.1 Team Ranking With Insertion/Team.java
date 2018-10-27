/**
 * time complexity for selection sort is O(N^2).
 * because of nested for loops
 */
/**
 * Class for team.
 */
class Team {
    /**
     * teams array.
     */
    private CricketTeam[] teams;
    /**
     * size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Team() {
        teams = new CricketTeam[10];
        size = 0;
    }
    /**
     * Adds a cricket team.
     *
     * @param      t     { parameter_description }
     */
    public void addCricketTeam(final CricketTeam t) {
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
            s += teams[i].name+",";
        }
        return s.substring(0, s.length() - 1);
    }
    /**
     * swaps two items.
     * time complexity is O(K)
     *
     * @param      teams  The teams
     * @param      i      { parameter_description }
     * @param      j      { parameter_description }
     */
    public void exch(final CricketTeam[] teams1, final int i, final int j) {
        //System.out.println(";;;;;;");
        CricketTeam ct = teams1[j];
        teams[j] = teams1[i];
        teams[i] = ct;
    }
    /**
     * sorts the given elements.
     * time complexity of selection sort in worst case is O(n^2)
     */
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
    /**
     * compare two items.
     * time complexity is O(1)
     *
     * @param      arr   The arr
     * @param      i     integer
     * @param      j     integer
     *
     * @return     true or false
     */
    boolean less(final CricketTeam[] arr, final int i, final int j) {
        //System.out.println("0000000");
        return  arr[i].compareTo(arr[j]) > 0;
    }
}